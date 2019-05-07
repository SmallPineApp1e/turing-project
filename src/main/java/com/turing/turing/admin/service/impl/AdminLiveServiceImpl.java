package com.turing.turing.admin.service.impl;

import com.turing.turing.admin.service.AdminLiveService;
import com.turing.turing.dao.LiveMapper;
import com.turing.turing.dao.PhotoMapper;
import com.turing.turing.entity.Live;
import com.turing.turing.entity.Photo;
import com.turing.turing.entity.PhotoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-19:23
 */
@Service
public class AdminLiveServiceImpl implements AdminLiveService {

    @Autowired
    LiveMapper liveMapper;
    @Autowired
    PhotoMapper photoMapper;

    @Override
    public boolean addLive(Live live) {

        Integer isLiveSuccess = liveMapper.insert(live);
        return isLiveSuccess != 0 ;

    }

    @Override
    public boolean addLivePhoto(String photoLocate, Live live){

        Integer isPhotoSuccess = photoMapper.insert(new Photo(null, photoLocate, live.getLiveName()));
        return isPhotoSuccess != 0;

    }

    @Override
    public List<Live> getLive() {

        List<Live> lives = liveMapper.selectByExampleWithPhotos(null);
        return lives;

    }

    @Override
    public boolean deleteLive(Integer liveId, String realPath) {

        //查询出生活名称
        Live live = liveMapper.selectByPrimaryKeyWithPhotos(liveId);
        if (live==null){
            return false;
        }
        String liveName = live.getLiveName();
        int deleteLive = liveMapper.deleteByPrimaryKey(liveId);

        PhotoExample photoExample = new PhotoExample();
        photoExample.createCriteria().andPhotoTypeEqualTo(liveName);
        List<Photo> photos = photoMapper.selectByExample(photoExample);
        //删除本地磁盘的生活照
        for (Photo photo :
                photos) {
            //获取数据库中文件的路径名
            String photoLoc = photo.getPhotoLoc();
            //获取文件名字
            String fileName = photoLoc.substring(photoLoc.lastIndexOf("/") + 1);
            new File(realPath + fileName).delete();
        }
        //删除数据库中的照片
        int deletePhoto = photoMapper.deleteByExample(photoExample);
        return (deleteLive != 0 && deletePhoto != 0);

    }

    @Override
    public Live getLiveById(Integer liveId) {

        Live live = liveMapper.selectByPrimaryKeyWithPhotos(liveId);
        return live;

    }

    @Override
    public boolean updateLive(Integer liveId, Live live) {

        live.setLiveId(liveId);
        int row = liveMapper.updateByPrimaryKey(live);
        return row != 0;

    }

    @Override
    public List<Photo> getLivePhoto(Integer liveId) {

        //获取生活名称
        Live live = liveMapper.selectByPrimaryKey(liveId);
        String liveName = live.getLiveName();
        //获取生活照
        PhotoExample photoExample = new PhotoExample();
        photoExample.createCriteria().andPhotoTypeEqualTo(liveName);
        List<Photo> photos = photoMapper.selectByExample(photoExample);
        return photos;


    }

    @Override
    public boolean deletePhoto(Integer liveId, String photoLoc) {

        Live live = liveMapper.selectByPrimaryKey(liveId);
        String photoType = live.getLiveName();
        PhotoExample photoExample = new PhotoExample();
        photoExample.createCriteria().andPhotoTypeEqualTo(photoType);
        List<Photo> photos = photoMapper.selectByExample(photoExample);
        //删除本地的照片
        for (Photo photo :
                photos) {
            String fileName = photo.getPhotoLoc().substring(photo.getPhotoLoc().lastIndexOf("/")+1);
            System.out.println(fileName);
            new File(photoLoc + fileName).delete();
        }
        //删除数据库中的照片
        int row = photoMapper.deleteByExample(photoExample);
        return row != 0;
    }
}
