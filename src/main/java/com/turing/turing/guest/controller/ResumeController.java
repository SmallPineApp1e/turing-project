package com.turing.turing.guest.controller;

import com.turing.turing.entity.Resume;
import com.turing.turing.guest.service.ResumeService;
import com.turing.turing.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Jack
 * @date 2019-03-23-8:54
 */
@RestController
@RequestMapping(value = "/guestResume")
public class ResumeController {

    @Autowired
    ResumeService resumeService;

    /**
     * 投放简历
     */
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Msg apply(@ModelAttribute("Resume")@Valid Resume resume, BindingResult result){
        if(result.hasErrors()){
            Msg msg = new Msg();
            result.getAllErrors().forEach(error-> msg.add(error.getCode(), error.getDefaultMessage()));
            return msg;
        }else{
            boolean isSuccess = resumeService.setResume(resume);
            if(isSuccess){
                return Msg.success();
            }else{
                return Msg.fail();
            }
        }
    }

}
