package com.turing.turing.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.turing.admin.service.AdminCollectResumeService;
import com.turing.turing.entity.CollectResume;
import com.turing.turing.util.DateFormat;
import com.turing.turing.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(AdminCollectResumeController.class);

    @ApiOperation(value = "获取所有第一轮通过的简历", notes = "分页, 每页显示5条,分页条连续显示3页")
    /**
     * 获取所有第一轮通过的简历
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    public Msg getCollectResumes(@RequestParam(value = "pn",defaultValue = "1", required = false) Integer pn){
        PageHelper.startPage(pn, 5);
        List<CollectResume> collectResumes = adminCollectResumeService.getCollectResumes();
        System.out.println(collectResumes);
        PageInfo pageInfo = new PageInfo(collectResumes, 3);
        return Msg.success().add("pageInfo", pageInfo);

    }

    @ApiOperation(value = "面试通过(添加团队成员)", notes = "加入到成员通讯录!" +
            "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "colResuName", value = "收藏简历的名字",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "colResuStudentid", value = "收藏简历的学号",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "colResuMajor", value = "收藏简历的专业班级",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "colResuNumber", value = "收藏简历的手机号码",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "colResuDirect", value = "收藏简历的学习方向",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "colResuId", value = "收藏简历的Id号",
                    paramType = "path", dataType = "int", required = true),
    })
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
                                @RequestParam(value = "colResuStudentid") String colResuStudentId,
                                @RequestParam(value = "colResuMajor") String colResuMajor,
                                @RequestParam(value = "colResuNumber")String colResuNumber,
                                @RequestParam(value = "colResuDirect")String colResuDirect,
                                @PathVariable Integer colResuId){
        logger.info(DateFormat.getNowTime()+"访问了二轮面试通过API，添加团队成员");
        boolean isSuccess = adminCollectResumeService.setPassInterview(colResuName, colResuMajor, colResuStudentId,
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

        logger.info(DateFormat.getNowTime()+"查询"+colResuName+"的简历");
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

        logger.info(DateFormat.getNowTime()+"删除简历");
        boolean isSuccess = adminCollectResumeService.deleteResume(colResuId);
        return isSuccess ? Msg.success(): Msg.fail().add("error", "删除失败!");

    }

}
