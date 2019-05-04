package com.turing.turing.admin.controller;

import com.turing.turing.admin.service.AdminLiveService;
import com.turing.turing.entity.Live;
import com.turing.turing.entity.Member;
import com.turing.turing.util.DateFormat;
import com.turing.turing.util.ImageUtil;
import com.turing.turing.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-18:22
 */
@Api(tags = "后台管理团队日常生活接口")
@RestController
@RequestMapping("/adminLive")
public class AdminLiveController {

    @Autowired
    AdminLiveService adminLiveService;

    private static Logger logger = LoggerFactory.getLogger(AdminLiveController.class);

    @ApiOperation(value = "上传团队生活及图片",
            notes = "必须上传至少一张图片, 上传人名字应该自动写入, 而不是让用户自己填写",
            httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "liveId", value = "生活id(后台自动生成)", paramType = "query",
                    dataType = "int"),
            @ApiImplicitParam(name = "liveName", value = "本次团队生活名称", paramType = "query",
                    dataType = "String", required = true),
            @ApiImplicitParam(name = "liveUsername", value = "上传人名字", paramType = "query",
                    dataType = "String", required = true),
            @ApiImplicitParam(name = "photos", value = "生活照片类(不用传参)"),
            @ApiImplicitParam(name = "  ", value = "多张图片(至少一张生活照)", paramType = "form",
                    dataType = "file", allowMultiple = true),
            @ApiImplicitParam(name = "photos[0].photoId", value = "忽略", paramType = "query",
                    dataType = "int"),
            @ApiImplicitParam(name = "photos[0].photoLoc", value = "忽略", paramType = "query",
                    dataType = "String"),
            @ApiImplicitParam(name = "photos[0].photoType", value = "忽略", paramType = "query",
                    dataType = "String")
    })
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
                            BindingResult result,
                            HttpServletRequest request) throws Exception {

        Member member = (Member) request.getSession().getAttribute("member");

        if(files == null){
            return Msg.fail().add("error","必须上传照片哦!");
        }

        //只添加一次生活名称
        Integer count = 0;
        if(result.hasErrors()||files.length==0){
            Msg msg = new Msg();
            result.getAllErrors().forEach(objectError -> msg.add(objectError.getCode()
                    , objectError.getDefaultMessage()));
            msg.setCode(200);
            msg.setMsg("添加失败!");
            logger.error(msg.toString());
            return files.length==0 ? msg.add("error", "必须上传图片!") : msg;
        }else{
            //判断是否全部都是照片
            for (MultipartFile file : files){
                if(ImageUtil.isPhoto(file)){
                    continue;
                }else{
                    return Msg.fail().add("error", "不好意思, 仅支持jpg, jpeg, png格式的照片哦!");
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
                String realPath = ResourceUtils.getURL("classpath:").getPath();
                System.out.println(realPath);
                //图片所在目录
                String photoLocation = realPath + "static" +System.getProperty("file.separator")
                        +"img"+System.getProperty("file.separator");
                //上传图片到指定目录下
                ImageUtil.uploadPhoto(photoLocation, file);
                //保存图片路径到数据库
                String saveLocate = System.getProperty("file.separator")+ "static"+System.getProperty("file.separator")
                        +"img"+ System.getProperty("file.separator") + fileName;
                boolean isSuccess = adminLiveService.addLivePhoto(saveLocate, live);
                if (isSuccess){
                    continue;
                }else{
                    return Msg.fail().add("error", "发生未知错误,程序猿小哥哥马上绝望处理!");
                }
            }
        }
        logger.info(DateFormat.getNowTime()+member.getMemberName()+"上传团队生活及照片");
        return Msg.success();
    }


    @ApiOperation(value = "查询所有生活照",notes = "没有进行分页", httpMethod = "GET")
    /**
     * 查询所有生活照
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Msg getLive(){

        List<Live> lives = adminLiveService.getLive();
        return Msg.success().add("lives", lives);

    }

    @ApiOperation(value = "删除团队生活",
            notes = "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值",
            httpMethod = "DELETE")
    /**
     * 删除生活及对应照片
     * @param liveId
     * @param request
     * @return
     */
    @RequestMapping(value = "/{liveId}",method = RequestMethod.DELETE)
    public Msg deleteLive(@PathVariable Integer liveId, HttpServletRequest request) {

        Member member = (Member) request.getSession().getAttribute("member");
        logger.info(DateFormat.getNowTime()+member.getMemberName()+"删除团队生活及照片");
        String realPath = request.getSession().getServletContext().getRealPath("/");
        boolean isSuccess = adminLiveService.deleteLive(liveId, realPath);
        return isSuccess ? Msg.success() : Msg.fail().add("error", "删除失败!请重试!");

    }

    @ApiOperation(value = "根据id查询团队生活", notes = "进入可执行修改和删除操作的页面;" +
            "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值",
                httpMethod = "GET")
    /**
     * 根据id查询团队生活(来到修改和删除操作)
     * @param liveId
     * @return
     */
    @RequestMapping(value = "/{liveId}",method = RequestMethod.GET)
    public Msg getLiveById(@PathVariable Integer liveId){

        Live live = adminLiveService.getLiveById(liveId);
        return live != null ? Msg.success().add("live", live) : Msg.fail().add("error", "无法查询到生活记录!");

    }

    @ApiOperation(value = "修改团队生活",
            notes = "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值",
            httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "liveName", value = "生活名称", paramType = "query",
                    required = true, dataType = "string"),
            @ApiImplicitParam(name = "liveUsername", value = "发布人", paramType = "query",
                    required = true, dataType = "string"),
            @ApiImplicitParam(name = "liveId", value = "生活id", paramType = "path",
                    required = true, dataType = "int"),
            @ApiImplicitParam(name = "files", value = "多张图片(至少上传一张)",
                    paramType = "form", dataType = "file", allowMultiple = true ),
            @ApiImplicitParam(name = "photos[0].photoId", value = "忽略", paramType = "query",
                    dataType = "int"),
            @ApiImplicitParam(name = "photos[0].photoLoc", value = "忽略", paramType = "query",
                    dataType = "String"),
            @ApiImplicitParam(name = "photos[0].photoType", value = "忽略", paramType = "query",
                    dataType = "String")
    })
    /**
     * 修改团队生活
     * @param liveId
     * @param files
     * @param request
     * @return
     */
    @RequestMapping(value = "/{liveId}", method = RequestMethod.PUT)
    public Msg updateLive(@PathVariable Integer liveId,
                          @RequestParam(value = "files",required = false) MultipartFile[] files,
                          @ModelAttribute(value = "live") @Valid Live live,
                          BindingResult result,
                          HttpServletRequest request){

        if (files.length == 0) {
            return Msg.fail().add("error", "必须上传至少一张图片哦!");
        }
        //后端校验生活参数是否齐全
        if(result.hasErrors()){
            Msg msg = new Msg();
            result.getAllErrors().forEach(objectError -> msg.add(objectError.getCode(), objectError.getDefaultMessage()));
            return msg;
        }
        //判断是否全部都是图片
        for (MultipartFile file :
                files) {
            if(ImageUtil.isPhoto(file)){
                continue;
            } else {
                return Msg.fail().add("error", "不好意思, 仅支持jpg, jpeg, png格式的照片哦!");
            }
        }

        //项目的绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/");
        //删除照片
        boolean deletePhoto = adminLiveService.deletePhoto(liveId, realPath);
        if (!deletePhoto)
            return Msg.fail().add("error", "发生未知错误!请重试");
        boolean updateLive = adminLiveService.updateLive(liveId, live);
        if (!updateLive)
            return Msg.fail().add("error", "发生未知错误!请重试");
        //图片的数据库存储路径
        String photoLoc = System.getProperty("file.separator")
                + "static" + System.getProperty("file.separator")
                + "img" + System.getProperty("file.separator");
        //图片的本地存储路径
        String savePath = realPath + photoLoc;
        for (MultipartFile file :
                files) {
            try {
                //上传图片到存储路径下
                ImageUtil.uploadPhoto(savePath, file);
                //上传图片到数据库
                boolean addLivePhoto = adminLiveService.addLivePhoto(photoLoc + file.getOriginalFilename(), live);
                if (addLivePhoto){
                    continue;
                }else {
                    return Msg.fail().add("error", "发生未知错误,程序猿小哥哥马上绝望处理!");
                }
            } catch (IOException e) {
                return Msg.fail().add("error", "发生未知错误!程序猿马上绝望处理!");
            }
        }
        logger.info(DateFormat.getNowTime()+"修改团队生活及照片");
        return Msg.success();
    }

}
