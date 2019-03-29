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
        //删除项目路径下的生活照
        PhotoExample photoExample = new PhotoExample();
        photoExample.createCriteria().andPhotoTypeEqualTo(liveName);
        List<Photo> photos = photoMapper.selectByExample(photoExample);
        for (Photo photo :
                photos) {
            String photoLoc = photo.getPhotoLoc();
            new File(realPath + photoLoc).delete();
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
}
