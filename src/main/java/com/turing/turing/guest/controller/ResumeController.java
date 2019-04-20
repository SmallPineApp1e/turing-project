package com.turing.turing.guest.controller;

import com.turing.turing.entity.Resume;
import com.turing.turing.guest.service.ResumeService;
import com.turing.turing.util.DateFormat;
import com.turing.turing.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Api(tags = "前台投递简历接口")
@RestController
@RequestMapping(value = "/guestResume")
public class ResumeController {

    @Autowired
    ResumeService resumeService;

    private static Logger logger = LoggerFactory.getLogger(LiveController.class);

    @ApiOperation(value = "前台投递简历", notes = "正确码200,错误码100,出现错误时在extends中可以取出\"error\"的值;")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "resuId", value = "简历人Id(后台自动生成)", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "resuName", value = "简历人名字", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "resuStudentid", value = "简历人学号", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "resuNumber", value = "联系方式", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "resuMajor", value = "专业班级", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "resuWechat", value = "微信号/QQ号", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "resuDirect", value = "面试方向", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "resuEvaluation", value = "自我评价", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "resuSkills", value = "掌握技能", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "resuExp", value = "项目经验", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "resuExpect", value = "未来期望", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "resuOther", value = "其它优势", dataType = "String", paramType = "query", required = true)
    })
    /**
     * 投放简历
     */
    @RequestMapping(value = "",method = RequestMethod.POST)
    public Msg apply(@ModelAttribute("Resume")@Valid Resume resume, BindingResult result){
        if(result.hasErrors()){
            Msg msg = new Msg();
            result.getAllErrors().forEach(error-> msg.add(error.getCode(), error.getDefaultMessage()));
            msg.setCode(100);
            msg.setMsg("处理失败!");
            return msg;
        }else{
            logger.info(DateFormat.getNowTime()+":"+resume.getResuName()+"投放简历");
            boolean isSuccess = resumeService.setResume(resume);
            return isSuccess ? Msg.success() : Msg.fail().add("error", "发生未知错误!请重试!");
        }
    }

}
