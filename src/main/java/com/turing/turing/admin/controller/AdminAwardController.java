package com.turing.turing.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.turing.admin.service.AdminAwardService;
import com.turing.turing.entity.Award;
import com.turing.turing.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-11:13
 */
@RestController
@RequestMapping(value = "/adminAward")
public class AdminAwardController {

    @Autowired
    AdminAwardService adminAwardService;

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
            msg.setCode(200);
            msg.setMsg("添加失败!");
            return msg;
        }else {
            boolean isSuccess = adminAwardService.addAward(award);
            return isSuccess ? Msg.success() : Msg.fail().add("info", "发生未知错误!程序猿哥哥正在路上!");
        }

    }

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
            return msg;
        }else{
            boolean isSuccess = adminAwardService.updateAward(award, awardId);
            return isSuccess ? Msg.success() : Msg.fail().add("error", "发生未知错误!请重试!");
        }

    }

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

    /**
     * 获取所有获奖情况
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Msg getAward(@RequestParam(value = "pn", defaultValue = "1") Integer pn){

        PageHelper.startPage(pn,5);
        List<Award> awards = adminAwardService.getAwards();
        PageInfo pageInfo = new PageInfo(awards, 3);
        return Msg.success().add("pageInfo", pageInfo);

    }

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
