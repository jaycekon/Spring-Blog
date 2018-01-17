package com.charles.api.controller;

import com.charles.business.mapper.UserMapper;
import com.charles.business.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取用户基本信息类，用于测试读写分离
 *
 * @author <a href="mailto:weijie_huang@sui.com"> weijie_huang </a>
 * 2018/1/17 14:08
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户数据API")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "查找用户", notes = "根据 IdCard 获取用户")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public User findByIdCard(String idCard) {
        User u = userMapper.selectByIdCard(idCard);
        logger.info("获取结果：{}", u);
        return u;
    }


    @ApiOperation(value = "保存用户", notes = "保存用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        int id = userMapper.insert(user);
        logger.info("保存结果：{}", user);
        return user;
    }
}
