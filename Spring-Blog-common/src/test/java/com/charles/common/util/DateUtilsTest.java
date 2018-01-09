package com.charles.common.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author <a href="mailto:weijie_huang@sui.com"> weijie_huang </a>
 * 2018/1/9 16:34
 */
public class DateUtilsTest {

    private static Logger logger = LoggerFactory.getLogger(DateUtilsTest.class);

    @Test
    public void testDateUtils() {
        String date = DateUtils.format(new Date());
        logger.info("DateUtils测试类 运行结果：{}",date);
    }

}
