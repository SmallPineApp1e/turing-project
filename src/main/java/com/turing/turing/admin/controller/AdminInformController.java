package com.turing.turing.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.turing.admin.service.AdminInformService;
import com.turing.turing.entity.Inform;
import com.turing.turing.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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

    @ApiOperation(value = "发布通告", notes = "参数传递不能缺,日期和id会在后台生成,不用传这两个参数,发布人应该从当前登陆" +
            "的用户进行自动传递,而不是让用户自己输入")
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
            msg.setCode(200);
            msg.setMsg("添加失败!");
            result.getAllErrors().forEach(objectError -> msg.add(objectError.getCode()
                    , objectError.getDefaultMessage()));
            return msg;
        }else{
            //判断发布通告是否成功
            boolean isSuccess = adminInformService.addInform(inform);
            if (isSuccess){
                return Msg.success().add("Info", "发布成功!");
            }else {
                return Msg.fail().add("Info", "发生未知错误!请重试!");
            }
        }
    }

    @ApiOperation(value = "获得所有通告", notes = "采用分页形式, 每页显示5条, 分页条显示3页(1,2,3),(2,3,4)")
    @ApiImplicitParam(name = "pn", value = "分页参数", paramType = "query", dataType = "integer")
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

    @ApiOperation(value = "根据id删除通告")
    @ApiImplicitParam(name = "informId", value = "通告id", paramType = "query", dataType = "integer")
    /**
     * 根据id删除通告
     * @param informId
     * @return
     */
    @RequestMapping(value = "/{informId}", method = RequestMethod.DELETE)
    public Msg deleteInform(@PathVariable Integer informId){

        boolean isSuccess = adminInformService.deleteInform(informId);
        return isSuccess ? Msg.success():Msg.fail().add("error", "数据库不存在这条通告");

    }

    @ApiOperation(value = "按照id查询通告", notes = "在此路径下可以进行修改和删除操作")
    @ApiImplicitParam(name = "informId", value = "通告id", paramType = "query", dataType = "integer")
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

    @ApiOperation(value = "按照id查询通告", notes = "参数传递不能缺,否则会报错,自行测试")
    @ApiImplicitParam(name = "informId", value = "通告id", paramType = "query", dataType = "integer")
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


}
