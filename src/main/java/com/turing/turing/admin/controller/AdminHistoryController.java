package com.turing.turing.admin.controller;

import com.turing.turing.admin.service.AdminHistoryService;
import com.turing.turing.entity.History;
import com.turing.turing.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Jack
 * @date 2019-03-23-23:08
 */
@RestController
@RequestMapping("/adminHistory")
public class AdminHistoryController {

    @Autowired
    AdminHistoryService adminHistoryService;

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
            msg.setCode(200);
            result.getAllErrors().forEach(objectError -> msg.add(objectError.getCode()
                    , objectError.getDefaultMessage()));
            return msg;
        }else{
            boolean isSuccess = adminHistoryService.updateHistory(hisId, history);
            return isSuccess ? Msg.success().add("Info", "修改成功!"):Msg.fail().add("Info", "修改失败!未知错误!");
        }
    }

    /**
     * 获取团队历史内容
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Msg getHistory(){

        History history = adminHistoryService.getHistory();
        return Msg.success().add("history", history);

    }

    /**
     * 根据id查询团队历史内容(来到修改页面)
     * @param hisId
     * @return
     */
    @RequestMapping(value = "/{hisId}", method = RequestMethod.GET)
    public Msg getHistoryById(@PathVariable Integer hisId){

        History history = adminHistoryService.getHistoryById(hisId);
        return history != null ? Msg.success().add("history", history) : Msg.fail().add("error", "查询失败!");

    }

}
