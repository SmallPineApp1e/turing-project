package com.turing.turing.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.turing.admin.service.AdminResumeService;
import com.turing.turing.entity.Resume;
import com.turing.turing.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-22:59
 */
@Api(tags = "后台管理投递简历接口")
@RestController
@RequestMapping(value = "/adminResume")
public class AdminResumeController {

    @Autowired
    AdminResumeService adminResumeService;

    @ApiOperation(value = "删除不通过的简历", notes = "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值")
    @ApiImplicitParam(name = "resuId", value = "简历id", paramType = "path", dataType = "int", required = true)
    /**
     * 按照id删除简历
     * @param resuId
     * @return
     */
    @RequestMapping(value = "/{resuId}",method = RequestMethod.DELETE)
    public Msg deleteResume(@PathVariable Integer resuId){

        boolean isSuccess = adminResumeService.deleteResume(resuId);
        return isSuccess ? Msg.success(): Msg.fail().add("error", "删除失败!");

    }

    @ApiOperation(value = "获取所有简历", notes = "每页显示5条信息;")
    @ApiImplicitParam(name = "pn", value = "分页参数", paramType = "query", dataType = "int")
    /**
     * 获取所有简历(分页)
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Msg getResume(@RequestParam(value = "pn", defaultValue = "1") Integer pn){

        PageHelper.startPage(pn,5);
        List<Resume> resumes = adminResumeService.getResumes();
        PageInfo pageInfo = new PageInfo(resumes, 5);
        return Msg.success().add("pageInfo", pageInfo);

    }

    @ApiOperation(value = "根据名字查询id", notes = "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值")
    @ApiImplicitParam(name = "resuName", value = "简历名字", paramType = "query", dataType = "string",required = true)
    /**
     * 根据名字查询简历
     * @param resuName 名字
     * @return
     */
    @RequestMapping(value = "/resuName", method = RequestMethod.GET)
    public Msg getResumeByName(@RequestParam(value = "resuName") String resuName){

        List<Resume> resumeByName = adminResumeService.getResumeByName(resuName);
        if(resumeByName.size()!=0){
            Resume resume = resumeByName.get(0);
            return Msg.success().add("resume", resume);
        }else{
            return Msg.fail().add("error", "抱歉,未能查询到这名同学的简历!");
        }
    }

    @ApiOperation(value = "收藏简历", notes = "意思就是这份简历通过了第一轮面试;" +
            "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "resuId", value = "简历id",
                    paramType = "path", dataType = "int", required = true),
            @ApiImplicitParam(name = "resuName", value = "简历名字",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "resuNumber", value = "简历手机号码",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "resuMajor", value = "简历专业班级",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "resuWechat", value = "简历微信/QQ号",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "resuDirect", value = "简历面试方向",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "resuEvaluation", value = "简历自我评价",
                    paramType = "query", dataType = "int", required = true),
            @ApiImplicitParam(name = "resuSkills", value = "掌握的技能",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "resuExp", value = "简历项目经验",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "resuExpect", value = "简历未来期望",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "resuOther", value = "其它优势",
                    paramType = "query", dataType = "string", required = true)
    })
    /**
     * 收藏简历(第一轮通过)
     * @param resume
     * @return
     */
    @RequestMapping(value = "/{resuId}", method = RequestMethod.POST)
    public Msg collectResume(@ModelAttribute(value = "resume") Resume resume, @PathVariable Integer resuId){

        boolean isSuccess = adminResumeService.collectResume(resume, resuId);
        return isSuccess ? Msg.success() : Msg.fail().add("error", "收藏失败!程序猿马上绝望处理!");

    }

    @ApiOperation(value = "查看某一份简历的详情",
            notes = "来到了可以收藏简历或丢弃简历的操作页面;" +
                    "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值")
    @ApiImplicitParam(name = "resuId", value = "简历id", paramType = "path", dataType = "int", required = true)
    /**
     * 根据id查询简历(分页查询提交参数)
     * @param resuId
     * @return
     */
    @RequestMapping(value = "/{resuId}", method = RequestMethod.GET)
    public Msg getResumeById(@PathVariable Integer resuId){

        Resume resume = adminResumeService.getResumeById(resuId);
        return resume != null ? Msg.success().add("resume", resume) : Msg.fail().add("error", "无法查询到该同学的简历");

    }

}
