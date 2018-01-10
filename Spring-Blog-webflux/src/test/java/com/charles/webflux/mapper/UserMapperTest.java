package com.charles.webflux.mapper;

import com.charles.business.mapper.UserMapper;
import com.charles.business.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Jaycekon on 2018/1/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.charles.business.mapper")
public class UserMapperTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void test() {
        User user = mapper.selectByIdCard("440182199512042311");
        Assert.assertNotNull(user);
    }
}
