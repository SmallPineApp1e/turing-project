package com.turing.turing.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.turing.admin.service.AdminProjectService;
import com.turing.turing.entity.Project;
import com.turing.turing.util.ImageUtil;
import com.turing.turing.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-15:28
 */
@Api(tags = {"后台团队项目管理接口"})
@RestController
@RequestMapping("/adminProject")
public class AdminProjectController {

    @Autowired
    AdminProjectService adminProjectService;

    @ApiOperation(value = "项目及图片上传", notes = "图片只允许上传一张,不可不上传;" +
            "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "photo.photoId", value = "忽略", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "photo.photoType", value = "忽略", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "photo.photoLoc", value = "忽略", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "proId", value = "项目id(后台自动生成)", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "file", value = "项目图片",
                    dataType = "file", paramType = "form", required = true),
            @ApiImplicitParam(name = "proName", value = "项目名字",
                    dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "proUsername", value = "发布人名称",
                    dataType = "string", paramType = "query", required = true),
    })
    /**
     * 项目及图片上传
     * @param file      图片
     * @param project   项目
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Msg addProject(@RequestParam(value = "file",required = false) MultipartFile file,
                          @ModelAttribute(value = "project") @Valid Project project,
                          BindingResult result, HttpServletRequest request)
            throws Exception {

        //判断项目名字和文件是否为空
        if(result.hasErrors()||file == null){
            Msg msg = new Msg();
            result.getAllErrors().forEach(objectError -> msg.add(objectError.getCode()
                    , objectError.getDefaultMessage()));
            msg.setMsg("添加失败!");
            msg.setCode(100);
            return file == null ? msg.add("error","必须上传图片!") : msg;
        }else{
            boolean isSuccess = false;
            if(ImageUtil.isPhoto(file)){
                //获取项目在容器中发布出去的根路径
                String realPath = request.getSession().getServletContext().getRealPath("/");
                //发送图片到指定/webapp/static/img目录
                String photoLocate = realPath +System.getProperty("file.separator")+"static"
                        +System.getProperty("file.separator")+"img"+System.getProperty("file.separator");
                //上传图片
                ImageUtil.uploadPhoto(photoLocate, file);
                //获得图片后缀名
                String type = ImageUtil.getSuffix(file);
                //定义图片保存到数据库的路径
                String locPath = System.getProperty("file.separator")+"static"+System.getProperty("file.separator")
                        +"img"+System.getProperty("file.separator")+project.getProName()+type;
                isSuccess = adminProjectService.addProject(locPath, project);
                return isSuccess? Msg.success():Msg.fail();
            }else {
                return Msg.fail().add("error", "不好意思, 仅支持jpg, jpeg, png格式的照片哦");
            }
        }

    }
    @ApiOperation(value = "删除一个项目", notes = "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值"
            ,httpMethod = "DELETE")
    @ApiImplicitParam(name = "proId",value = "项目id", paramType = "path", dataType = "int", required = true)
    /**
     * 根据Id删除一个项目
     * @param proId
     * @return
     */
    @RequestMapping(value = "/{proId}",method = RequestMethod.DELETE)
    public Msg deleteProjectById(@PathVariable Integer proId, HttpServletRequest request){

        String realPath = request.getSession().getServletContext().getRealPath("/");
        boolean isSuccess = adminProjectService.deleteProject(proId, realPath);
        return isSuccess ? Msg.success() : Msg.fail().add("error", "删除失败!请重试");

    }

    @ApiOperation(value = "查询所有项目", notes = "分页查询, 每页显示3条,连续显示3页", httpMethod = "GET")
    @ApiImplicitParam(name = "pn", value = "分页参数", paramType = "query", dataType = "int", defaultValue = "1")
    /**
     * 查询所有项目(分页)
     * @param pn
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    public Msg getProject(@RequestParam(value = "pn", defaultValue = "1") Integer pn){

        PageHelper.startPage(pn, 3);
        List<Project> projects = adminProjectService.getProject();
        PageInfo pageInfo = new PageInfo(projects, 3);
        return Msg.success().add("pageInfo", pageInfo);
    }

    @ApiOperation(value = "获取一个项目及它的图片",notes = "来到可以执行项目的删除和修改操作页面;" +
            "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值",httpMethod = "GET")
    @ApiImplicitParam(name = "proId", value = "项目id", paramType = "path", dataType = "int", required = true)
    /**
     *  根据id获取一个项目及图片(来到删除页面)
     * @param proId
     * @return
     */
    @RequestMapping(value = "/{proId}", method = RequestMethod.GET)
    public Msg getProjectById(@PathVariable Integer proId){

        Project project = adminProjectService.getProjectById(proId);
        return project != null ? Msg.success().add("project", project) : Msg.fail().add("error", "查询失败, 请重试!");

    }


}
