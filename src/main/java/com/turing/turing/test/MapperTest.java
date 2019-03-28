package com.turing.turing.test;

import com.turing.turing.dao.*;
import com.turing.turing.entity.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;


@RunWith(value = SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class MapperTest {

    @Autowired
    HistoryMapper historyMapper;
    @Autowired
    ResumeMapper resumeMapper;
    @Autowired
    AwardMapper awardMapper;
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    LiveMapper liveMapper;

    @Test
    public void CRUD(){
/*        //测试插入团队历史信息
  historyMapper.insert(new History(null,"兴趣的读者，如果想了解更多，欢迎关注我们！" ,new Date()));
        //测试提交简历
        Resume resume = resumeMapper.selectByPrimaryKey(1);
        System.out.println(resume);

        //测试获奖展示及照片
List<Award> awards = awardMapper.selectByExampleWithPhoto(null);
        System.out.println(awards);


 Award award = awardMapper.selectByPrimaryKeyWithPhoto(1);
        System.out.println(award);*/
        //测试查询项目展示及照片
        List<Project> projects = projectMapper.selectByExampleWithPhoto(null);
        System.out.println(projects);

        Project project = projectMapper.selectByPrimaryKeyWithPhoto(1);
        System.out.println(project);

 /*       //测试查询团队活动及照片
List<Live> lives = liveMapper.selectByExampleWithPhotos(null);
        System.out.println(lives);

        Live live = liveMapper.selectByPrimaryKeyWithPhotos(2);
        System.out.println(live);


        //测试查询简历
        List<Resume> resumes = resumeMapper.selectByExample(null);
        System.out.println(resumes);*/
    }

}
