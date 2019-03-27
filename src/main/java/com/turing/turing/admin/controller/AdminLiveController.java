package com.turing.turing.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.turing.admin.service.AdminLiveService;
import com.turing.turing.entity.Live;
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
 * @date 2019-03-23-18:22
 */
@RestController
@RequestMapping("/adminLive")
public class AdminLiveController {

    @Autowired
    AdminLiveService adminLiveService;

    /**
     * 团队生活及上传图片
     * @param files
     * @param live
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Msg addLivePhoto(@RequestParam(value = "files",required = false) MultipartFile[] files,
                            @ModelAttribute("live")@Valid Live live,
                            BindingResult result, HttpServletRequest request) throws Exception {

        //只添加一次生活名称
        Integer count = 0;
        if(result.hasErrors()||files.length==0){
            Msg msg = new Msg();
            result.getAllErrors().forEach(objectError -> msg.add(objectError.getCode()
                    , objectError.getDefaultMessage()));
            msg.setCode(200);
            msg.setMsg("添加失败!");
            return files.length==0 ? msg.add("FileError", "必须上传图片!") : msg;
        }else{
            //判断是否全部都是照片
            for (MultipartFile file : files){
                if(ImageUtil.isPhoto(file)){
                    continue;
                }else{
                    return Msg.fail().add("Info", "不好意思, 仅支持jpg, jpeg, png格式的照片哦!");
                }
            }
            for (MultipartFile file : files) {
                //生活表只添加一次
                if (count == 0) {
                    adminLiveService.addLive(live);
                    count++;
                }
                //取出图片的名字
                String fileName = file.getOriginalFilename();
                //将图片添加到项目指定目录下
                String realPath = request.getSession().getServletContext().getRealPath("/");
                System.out.println(realPath);
                String photoLocation = realPath + "static\\img\\";
                System.out.println(photoLocation);
                //上传图片到指定目录下
                ImageUtil.uploadPhoto(photoLocation, file);
                //保存图片路径到数据库
                String saveLocate = "\\static\\img\\" + fileName;
                boolean isSuccess = adminLiveService.addLivePhoto(saveLocate, live);
                if (isSuccess){
                    continue;
                }else{
                    return Msg.fail().add("error", "发生未知错误");
                }
            }
        }
        return Msg.success();
    }

    /**
     * 查询所有生活照(分页)
     * @param pn
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Msg getLive(@RequestParam(value = "pn", defaultValue = "1") Integer pn){

        PageHelper.startPage(pn, 3);
        List<Live> lives = adminLiveService.getLive();
        PageInfo pageInfo = new PageInfo(lives, 3);
        return lives.size()!=0 ? Msg.success().add("pageInfo", pageInfo) :
                Msg.fail().add("error", "无法查询到生活记录");

    }

    /**
     * 删除生活及对应照片
     * @param liveId
     * @param request
     * @return
     */
    @RequestMapping(value = "/{liveId}",method = RequestMethod.DELETE)
    public Msg deleteLive(@PathVariable Integer liveId, HttpServletRequest request) {

        String realPath = request.getSession().getServletContext().getRealPath("/");
        boolean isSuccess = adminLiveService.deleteLive(liveId, realPath);
        return isSuccess ? Msg.success() : Msg.fail().add("error", "删除失败!请重试!");

    }

    @RequestMapping(value = "/{liveId}",method = RequestMethod.GET)
    public Msg getLiveById(@PathVariable Integer liveId){

        Live live = adminLiveService.getLiveById(liveId);
        return live != null ? Msg.success().add("live", live) : Msg.fail().add("error", "查询失败!请重试!");

    }

}
