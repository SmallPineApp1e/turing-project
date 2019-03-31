package com.turing.turing.admin.controller;

import com.turing.turing.admin.service.AdminCollectResumeService;
import com.turing.turing.entity.CollectResume;
import com.turing.turing.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-30-19:00
 */
@Api(tags = "后台管理通过第一轮面试的简历接口")
@RestController
@RequestMapping(value = "/collectResume")
public class AdminCollectResumeController {

    @Autowired
    AdminCollectResumeService adminCollectResumeService;

    @ApiOperation(value = "获取所有第一轮通过的简历")
    /**
     * 获取所有第一轮通过的简历
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    public Msg getCollectResumes(){

        List<CollectResume> collectResumes = adminCollectResumeService.getCollectResumes();
        return Msg.success().add("collectResumes", collectResumes);

    }

    @ApiOperation(value = "面试通过", notes = "加入到成员通讯录!" +
            "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值")
    /**
     * 面试通过
     * @param resuName 面试者姓名
     * @param resuMajor 面试者专业班级
     * @param resuNumber 面试者手机号码
     * @param resuDirect 面试者学习方向
     * @return
     */
    @RequestMapping(value = "/{colResuId}",method = RequestMethod.POST)
    public Msg setPassInterView(@RequestParam(value = "colResuName") String colResuName,
                                @RequestParam(value = "colResuMajor") String colResuMajor,
                                @RequestParam(value = "colResuNumber")String colResuNumber,
                                @RequestParam(value = "colResuDirect")String colResuDirect,
                                @PathVariable Integer colResuId){

        boolean isSuccess = adminCollectResumeService.setPassInterview(colResuName, colResuMajor,
                colResuNumber, colResuDirect);
        return isSuccess ? Msg.success() : Msg.fail().add("error", "添加失败!请重试");

    }

    @ApiOperation(value = "根据名字查询简历", notes = "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值")
    @ApiImplicitParam(name = "colResuName", value = "简历名字", paramType = "query", dataType = "string",required = true)
    /**
     * 根据名字查询简历
     * @param resuName 名字
     * @return
     */
    @RequestMapping(value = "/colResuName", method = RequestMethod.GET)
    public Msg getResumeByName(@RequestParam(value = "colResuName") String colResuName){

        List<CollectResume> resumeByName = adminCollectResumeService.getResumeByName(colResuName);
        if(resumeByName.size()!=0){
            CollectResume collectResume = resumeByName.get(0);
            return Msg.success().add("collectResume", collectResume);
        }else{
            return Msg.fail().add("error", "抱歉,未能查询到这名同学的简历!");
        }
    }

    @ApiOperation(value = "查看某一份收藏简历的详情",
            notes = "来到了可以执行添加成员或丢弃简历操作的页面;" +
                    "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值")
    @ApiImplicitParam(name = "colResuId", value = "收藏的简历id", paramType = "path", dataType = "int", required = true)
    /**
     * 根据id查询简历(分页查询提交参数)
     * @param resuId
     * @return
     */
    @RequestMapping(value = "/{colResuId}", method = RequestMethod.GET)
    public Msg getResumeById(@PathVariable Integer colResuId){

        CollectResume resume = adminCollectResumeService.getColResumeById(colResuId);
        return resume != null ? Msg.success().add("resume", resume) : Msg.fail().add("error", "无法查询到该同学的简历");

    }

    @ApiOperation(value = "删除不通过的简历", notes = "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值")
    @ApiImplicitParam(name = "colResuId", value = "简历id", paramType = "path", dataType = "int", required = true)
    /**
     * 按照id删除不通过的简历
     * @param colResuId
     * @return
     */
    @RequestMapping(value = "/{colResuId}",method = RequestMethod.DELETE)
    public Msg deleteResume(@PathVariable Integer colResuId){

        boolean isSuccess = adminCollectResumeService.deleteResume(colResuId);
        return isSuccess ? Msg.success(): Msg.fail().add("error", "删除失败!");

    }

}
