package com.charles.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBlogApiApplicationTests {

    private static Logger logger = LoggerFactory.getLogger(SpringBlogApiApplicationTests.class);

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Test
    public void contextLoads() {
        logger.info("hello");
        logger.info(dataSourceProperties.getUrl());
        logger.info(dataSourceProperties.getUsername());
        logger.info("end");
    }

}
