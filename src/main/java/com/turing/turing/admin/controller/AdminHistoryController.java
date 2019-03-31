package com.turing.turing.admin.controller;

import com.turing.turing.admin.service.AdminHistoryService;
import com.turing.turing.entity.History;
import com.turing.turing.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Jack
 * @date 2019-03-23-23:08
 */
@Api(tags = {"后台管理历史内容接口"})
@RestController
@RequestMapping("/adminHistory")
public class AdminHistoryController {

    @Autowired
    AdminHistoryService adminHistoryService;

    @ApiOperation(value = "修改团队历史内容", notes = "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hisId", value = "历史内容Id号", paramType = "path", dataType = "int",
            required = true),
            @ApiImplicitParam(name = "hisInfo", value = "历史内容", paramType = "query", dataType = "String",
                    required = true),
            @ApiImplicitParam(name = "editName", value = "修改人名字", paramType = "query", dataType = "String",
                    required = true),
            @ApiImplicitParam(name = "editTime", value = "修改时间(后台自动生成)", paramType = "query", dataType = "date-time")
    })
    /**
     * 修改团队历史内容
     * @param history 团队历史实体类
     * @param hisId id号
     * @return
     */
    @RequestMapping(value = "/{hisId}", method = RequestMethod.PUT)
    public Msg updateHistory(@ModelAttribute(value = "history") @Valid History history, BindingResult result,
                             @PathVariable Integer hisId){

        if(result.hasErrors()){
            Msg msg = new Msg();
            msg.setMsg("修改失败!");
            msg.setCode(100);
            result.getAllErrors().forEach(objectError -> msg.add(objectError.getCode()
                    , objectError.getDefaultMessage()));
            return msg;
        }else{
            boolean isSuccess = adminHistoryService.updateHistory(hisId, history);
            return isSuccess ? Msg.success() : Msg.fail().add("error", "修改失败!未知错误!");
        }
    }

    @ApiOperation(value = "获取团队历史内容",notes = "")
    /**
     * 获取团队历史内容
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Msg getHistory(){

        History history = adminHistoryService.getHistory();
        return Msg.success().add("history", history);

    }

    @ApiOperation(value = "根据id查询团队历史内容", notes = "进入可执行修改操作的页面;" +
            "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值")
    /**
     * 根据id查询团队历史内容(来到修改页面)
     * @param hisId
     * @return
     */
    @RequestMapping(value = "/{hisId}", method = RequestMethod.GET)
    public Msg getHistoryById(@PathVariable Integer hisId){

        History history = adminHistoryService.getHistoryById(hisId);
        return history != null ? Msg.success().add("history", history) : Msg.fail().add("error", "查询失败!请重试!");

    }

}
