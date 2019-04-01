package com.turing.turing.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.turing.admin.service.AdminAwardService;
import com.turing.turing.entity.Award;
import com.turing.turing.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-11:13
 */
@Api(tags = "后台管理获奖情况接口")
@RestController
@RequestMapping(value = "/adminAward")
public class AdminAwardController {

    @Autowired
    AdminAwardService adminAwardService;

    @ApiOperation(value = "添加获奖情况",
            notes = "正确码200,错误码100,出现错误时在extends中可以取出\"error\"的值;",
            httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "awardName", value = "获奖名称", paramType = "query",
                    required = true, dataType = "string"),
            @ApiImplicitParam(name = "awardTime", value = "获奖时间(格式:yyyy-MM-dd)", paramType = "query",
                    required = true, dataType = "date"),
            @ApiImplicitParam(name = "awardUsername", value = "获奖名称", paramType = "query",
                    required = true, dataType = "string"),
            @ApiImplicitParam(name = "awardId", value = "获奖id(后台自动生成)", paramType = "query",
                    dataType = "int")
    })
    /**
     * 添加获奖情况
     * @param award
     * @param result
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Msg addAward(@ModelAttribute(value = "award")@Valid Award award, BindingResult result){

        //判断是否有错误信息
        if (result.hasErrors()) {
            //定制错误信息
            Msg msg = new Msg();
            result.getAllErrors().forEach(objectError -> msg.add(objectError.getCode()
                    , objectError.getDefaultMessage()));
            //设置错误码和消息
            msg.setCode(100);
            msg.setMsg("添加失败!");
            msg.add("error","发生错误!");
            return msg;
        }else {
            boolean isSuccess = adminAwardService.addAward(award);
            return isSuccess ? Msg.success() : Msg.fail().add("error", "发生未知错误!程序猿哥哥正在路上!");
        }

    }

    @ApiOperation(value = "修改获奖情况",
            notes = "正确码200,错误码100,出现错误时在extends中可以取出\"error\"的值",
            httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "awardName", value = "获奖名称", paramType = "query",
                    required = true, dataType = "string"),
            @ApiImplicitParam(name = "awardTime", value = "获奖时间(格式:yyyy-MM-dd)", paramType = "query",
                    required = true, dataType = "date"),
            @ApiImplicitParam(name = "awardUsername", value = "获奖名称", paramType = "query",
                    required = true, dataType = "string"),
            @ApiImplicitParam(name = "awardId", value = "获奖id", paramType = "path",
                    required = true, dataType = "int")
    })
    /**
     * 修改获奖情况
     * @param award
     * @param result
     * @param awardId
     * @return
     */
    @RequestMapping(value = "/{awardId}", method = RequestMethod.PUT)
    public Msg updateAward(@ModelAttribute(value = "award") @Valid Award award, BindingResult result,
                           @PathVariable Integer awardId){

        //判断修改后的信息是否符合规范
        if(result.hasErrors()) {
            Msg msg = new Msg();
            result.getAllErrors().forEach(objectError -> msg.add(objectError.getCode()
                    , objectError.getDefaultMessage()));
            msg.setCode(100);
            msg.setMsg("修改失败");
            msg.add("error","发生错误!");
            return msg;
        }else{
            boolean isSuccess = adminAwardService.updateAward(award, awardId);
            return isSuccess ? Msg.success() : Msg.fail().add("error", "发生未知错误!请重试!");
        }

    }

    @ApiOperation(value = "根据id删除获奖情况",
            notes = "正确码200,错误码100,出现错误时在extends中可以取出\"error\"的值;",
            httpMethod = "DELETE")
    @ApiImplicitParam(name = "awardId", value = "获奖id", paramType = "path",
            required = true, dataType = "int")
    /**
     * 根据id删除获奖情况
     * @param awardId
     * @return
     */
    @RequestMapping(value = "/{awardId}",method = RequestMethod.DELETE)
    public Msg deleteAward(@PathVariable Integer awardId){

        boolean isSuccess = adminAwardService.deleteAward(awardId);
        return isSuccess ? Msg.success() : Msg.fail().add("error", "删除失败!");

    }

    @ApiOperation(value = "获取所有获奖情况",
            notes = "正确码200,错误码100,出现错误时在extends中可以取出\"error\"的值;",
            httpMethod = "GET")
    @ApiImplicitParam(name = "pn", value = "分页参数",
            dataType = "int", paramType = "query", defaultValue = "1")
    /**
     * 获取所有获奖情况
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Msg getAward(@RequestParam(value = "pn", defaultValue = "1") Integer pn){

        PageHelper.startPage(pn,5);
        List<Award> awards = adminAwardService.getAwards();
        PageInfo pageInfo = new PageInfo(awards, 3);
        return awards.size()!=0 ? Msg.success().add("pageInfo", pageInfo) :
                Msg.fail().add("error","暂时查询不到任何奖项!");

    }

    @ApiOperation(value = "根据id查询获奖情况", notes = "来到修改删除页面;" +
            "正确码200,错误码100,出现错误时在extends中可以取出\"error\"的值;",
            httpMethod = "GET")
    @ApiImplicitParam(name = "awardId", value = "获奖id", paramType = "path",
            required = true, dataType = "int")
    /**
     * 根据id查询获奖情况(来到修改删除页面)
     * @param awardId
     * @return
     */
    @RequestMapping(value = "/{awardId}",method = RequestMethod.GET)
    public Msg getAwardById(@PathVariable Integer awardId){

        Award award = adminAwardService.getAwardById(awardId);
        return award != null ? Msg.success().add("award", award) : Msg.fail().add("error", "查询失败!请重试!");

    }

}
