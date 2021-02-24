package com.itest;


import com.itest.dao.TypeDao;
import org.apache.commons.lang3.reflect.Typed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ItestIndex8003Application.class)
public class ItestIndex8003ApplicationTests {

    @Autowired
    private TypeDao typeDao;

    @Test
    public void contextLoads() {
        System.out.println(this.typeDao.queryPhone(0, 10));
    }

}
