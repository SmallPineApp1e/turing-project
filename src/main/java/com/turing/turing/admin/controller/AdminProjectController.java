package com.turing.turing.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.turing.admin.service.AdminProjectService;
import com.turing.turing.entity.Project;
import com.turing.turing.util.ImageUtil;
import com.turing.turing.util.Msg;
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
@RestController
@RequestMapping("/adminProject")
public class AdminProjectController {

    @Autowired
    AdminProjectService adminProjectService;

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
            msg.setCode(200);
            return file == null ? msg.add("FileError","必须上传图片!") : msg;
        }else{
            boolean isSuccess = false;
            if(ImageUtil.isPhoto(file)){
                //获取项目在容器中发布出去的根路径
                String realPath = request.getSession().getServletContext().getRealPath("/");
                //发送图片到指定/webapp/static/img目录
                String photoLocate = realPath + "/static/img/";
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
                return Msg.fail().add("Info", "不好意思, 仅支持jpg, jpeg, png格式的照片哦");
            }
        }

    }

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
        return projects.size() != 0 ? Msg.success().add("pageInfo", pageInfo) :
                Msg.fail().add("error", "查询不到任何项目");
    }

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
