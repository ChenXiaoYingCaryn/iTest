package com.itest;


import com.itest.dao.UserDao;
import com.itest.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ItestLogin8001Application.class)
public class ItestLogin8001ApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void contextLoads() {
        User user = this.userDao.userLogin("123", "123");
        System.out.println(user);
    }

}
