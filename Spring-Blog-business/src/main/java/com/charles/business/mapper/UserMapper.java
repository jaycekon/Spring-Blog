package com.charles.business.mapper;

import com.charles.business.MyMapper;
import com.charles.business.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author <a href="mailto:weijie_huang@sui.com"> weijie_huang </a>
 * 2018/1/9 16:58
 */
@Mapper
public interface UserMapper extends MyMapper<User> {

    @Select("select * from user where username=#{username}")
    User selectByName(String username);
}
