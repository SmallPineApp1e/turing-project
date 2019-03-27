package com.turing.turing.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.turing.admin.service.AdminResumeService;
import com.turing.turing.entity.Resume;
import com.turing.turing.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-22:59
 */
@RestController
@RequestMapping(value = "/adminResume")
public class AdminResumeController {

    @Autowired
    AdminResumeService adminResumeService;

    /**
     * 按照id删除简历
     * @param resuId
     * @return
     */
    @RequestMapping(value = "/{resuId}",method = RequestMethod.DELETE)
    public Msg deleteResume(@PathVariable Integer resuId){

        boolean isSuccess = adminResumeService.deleteResume(resuId);
        return isSuccess ? Msg.success().add("Info", "删除成功!"): Msg.fail().add("Info", "删除失败!");

    }

    /**
     * 获取所有简历(分页)
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Msg getResume(@RequestParam(value = "pn", defaultValue = "1") Integer pn){

        PageHelper.startPage(pn,1);
        List<Resume> resumes = adminResumeService.getResumes();
        PageInfo pageInfo = new PageInfo(resumes, 5);
        return Msg.success().add("pageInfo", pageInfo);

    }

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
            return Msg.fail().add("Info", "抱歉,未能查询到这名同学的简历!");
        }
    }

    /**
     * 收藏简历(第一轮通过)
     * @param resume
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Msg collectResume(@ModelAttribute(value = "resume") Resume resume){

        boolean isSuccess = adminResumeService.collectResume(resume);
        return isSuccess ? Msg.success().add("Info", "收藏成功!") : Msg.fail().add("Info", "收藏失败!");

    }

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

    /**
     * 面试通过
     * @param resuName 面试者姓名
     * @param resuMajor 面试者专业班级
     * @param resuNumber 面试者手机号码
     * @param resuDirect 面试者学习方向
     * @return
     */
    @RequestMapping(value = "/passInterview",method = RequestMethod.POST)
    public Msg setPassInterView(@RequestParam(value = "resuName") String resuName,
                                @RequestParam(value = "resuMajor") String resuMajor,
                                @RequestParam(value = "resuNumber")String resuNumber,
                                @RequestParam(value = "resuDirect")String resuDirect){

        boolean isSuccess = adminResumeService.setPassInterview(resuName, resuMajor, resuNumber, resuDirect);
        return isSuccess ? Msg.success().add("Info","添加成功!") : Msg.fail().add("Error", "添加失败!");

    }

}
