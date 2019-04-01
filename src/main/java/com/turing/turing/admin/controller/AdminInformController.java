package com.turing.turing.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.turing.admin.service.AdminInformService;
import com.turing.turing.entity.Inform;
import com.turing.turing.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-10:22
 */
@Api(tags = "后台通告管理接口")
@RestController
@RequestMapping("/adminInform")
public class AdminInformController {

    @Autowired
    AdminInformService adminInformService;

    @ApiOperation(value = "发布通告", notes = "用户名自动填入参数" +
            "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值",
            httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "informInfo",value = "通告内容", required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "createTime",value = "发布时间(后台自动生成)", paramType = "query", dataType = "date-time"),
            @ApiImplicitParam(name = "informId", value = "通告id(后台自动生成)", paramType = "query", dataType = "int")
    })
    /**
     * 发布通告
     * @param inform
     * @param result
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Msg addInform(@ModelAttribute(value = "inform")@Valid Inform inform, BindingResult result){

        //判断是否输入格式有误
        if(result.hasErrors()){
            Msg msg = new Msg();
            msg.setCode(100);
            msg.setMsg("添加失败!");
            result.getAllErrors().forEach(objectError -> msg.add(objectError.getCode()
                    , objectError.getDefaultMessage()));
            return msg;
        }else{
            //判断发布通告是否成功
            boolean isSuccess = adminInformService.addInform(inform);
            if (isSuccess){
                return Msg.success();
            }else {
                return Msg.fail().add("error", "发生未知错误!请重试!");
            }
        }
    }

    @ApiOperation(value = "获得所有通告", notes = "采用分页形式, 每页显示5条, 分页条显示3页(1,2,3),(2,3,4);" +
            "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值"
            ,httpMethod = "GET")
    @ApiImplicitParam(name = "pn", value = "分页参数", paramType = "query", dataType = "integer", defaultValue = "1")
    /**
     * 获得所有通告(分页)
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Msg getAllInform(@RequestParam(value = "pn", defaultValue = "1") Integer pn){
        PageHelper.startPage(pn, 5);
        List<Inform> informs = adminInformService.getInforms();
        PageInfo pageInfo = new PageInfo(informs, 3);
        return Msg.success().add("pageInfo", pageInfo);

    }

    @ApiOperation(value = "根据id删除通告",
            notes = "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值",
            httpMethod = "DELETE")
    @ApiImplicitParam(name = "informId", value = "通告id", paramType = "path", dataType = "integer",required = true)
    /**
     * 根据id删除通告
     * @param informId
     * @return
     */
    @RequestMapping(value = "/{informId}", method = RequestMethod.DELETE)
    public Msg deleteInform(@PathVariable Integer informId){

        boolean isSuccess = adminInformService.deleteInform(informId);
        return isSuccess ? Msg.success() : Msg.fail().add("error", "无法查询到这条通告!");

    }

    @ApiOperation(value = "按照id修改通告",
            notes = "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值",
            httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "informId", value = "通告id",
                    paramType = "path", dataType = "integer",required = true),
            @ApiImplicitParam(name = "username", value = "发布人",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "informInfo", value = "发布信息",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "createTime", value = "发布时间(后台自动生成)",
                    paramType = "query", dataType = "date-time")
    })
    /**
     * 修改通告
     * @param inform
     * @param result
     * @return
     */
    @RequestMapping(value = "/{informId}", method = RequestMethod.PUT)
    public Msg updateInform(@ModelAttribute(value = "inform") @Valid Inform inform, BindingResult result,
                            @PathVariable Integer informId){

        if (result.hasErrors()){
            Msg msg = new Msg();
            result.getAllErrors().forEach(objectError -> msg.add(objectError.getCode(),
                    objectError.getDefaultMessage()));
            msg.setCode(100);
            msg.setMsg("修改失败");
            return msg;
        }else{
            inform.setCreateTime(new Date());
            boolean isSuccess = adminInformService.updateInform(inform, informId);
            return isSuccess ? Msg.success() : Msg.fail().add("error", "修改失败,请重试!");
        }

    }

    @ApiOperation(value = "按照id查询通告", notes = "进入可执行修改和删除操作的页面;" +
            "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值",
            httpMethod = "GET")
    @ApiImplicitParam(name = "informId", value = "通告id", paramType = "path", dataType = "integer",required = true)
    /**
     * 按照id查询通告(来到修改页面)
     * @param informId
     * @return
     */
    @RequestMapping(value = "/{informId}",method = RequestMethod.GET)
    public Msg getInformById(@PathVariable Integer informId){

        Inform inform = adminInformService.getInformById(informId);
        return inform != null ? Msg.success().add("inform", inform) : Msg.fail().add("error", "查询失败");
    }


}
