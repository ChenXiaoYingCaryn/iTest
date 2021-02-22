package com.itest;


import com.itest.dao.SlideshowDao;
import com.itest.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ItestManagement8002Application.class)
public class ItestManagement8002ApplicationTests {

    @Autowired
    private SlideshowDao slideshowDao;
    @Autowired
    private UserDao userDao;

    @Test
    public void contextLoads() {
        //this.slideshowDao.addSlideshow("4", "4");
        this.slideshowDao.updateSlideshow("4", "4");
        this.slideshowDao.updateSlideshowImage("4", "4");
        System.out.println(this.slideshowDao.querySlideshow(0, 2));
    }

}
