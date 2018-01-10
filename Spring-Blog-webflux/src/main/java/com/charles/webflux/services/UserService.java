package com.charles.webflux.services;

import com.charles.business.mapper.UserMapper;
import com.charles.business.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jaycekon on 2018/1/10.
 */
@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    public void saveOrUpdate(User user) {
        try {
            User temp = userMapper.selectByIdCard(user.getIdCard());
            if (temp == null) {
                userMapper.insert(user);
            } else {
                user.setId(temp.getId());
                userMapper.updateByPrimaryKeySelective(user);
            }
        } catch (Exception e) {
            logger.error("保存用户异常!{}", e.getMessage(), e);
        }
    }
}
