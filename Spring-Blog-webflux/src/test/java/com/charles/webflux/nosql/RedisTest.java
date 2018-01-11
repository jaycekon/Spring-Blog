package com.charles.webflux.nosql;

import com.charles.webflux.WebfluxApplicationTests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Jaycekon on 2018/1/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    private Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    private RedisComponent redisComponent;


    @Test
    public void test() {
        redisComponent.set("name", "charles");
        String value = redisComponent.get("name");
        logger.info(value);
    }
}
