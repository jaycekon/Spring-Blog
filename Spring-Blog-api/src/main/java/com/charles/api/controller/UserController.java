package com.charles.api.controller;

import com.charles.business.mapper.UserMapper;
import com.charles.business.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 获取用户基本信息类，用于测试读写分离
 * <p>
 * 2018/1/17 14:08
 */
@RequestMapping("/users")
@Api(tags = "用户数据API")
@Controller
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper userMapper;


    @ApiOperation(value = "查找用户", notes = "根据 IdCard 获取用户")
    @RequestMapping(value = "/lists", method = RequestMethod.GET)
    @ResponseBody
    public User findByIdCard(String idCard) {
        User u = userMapper.selectByIdCard(idCard);
        logger.info("获取结果：{}", u);
        return u;
    }


    @ApiOperation(value = "保存用户", notes = "保存用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        userMapper.insert(user);
        logger.info("保存结果：{}", user);
        return user;
    }


    @ApiIgnore
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<User> users = userMapper.selectAll();
        model.addAttribute("users", users);
        model.addAttribute("title", "用户管理");
        return "user/list";
    }

    @ApiIgnore
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String query(@PathVariable String id, Model model) {
        User user = userMapper.selectByPrimaryKey(Integer.valueOf(id));
        model.addAttribute("user", user);
        model.addAttribute("title", "查看用户");
        return "user/view";
    }


    @ApiIgnore
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public String saveOrUpdate(User user) {
        User temp = userMapper.selectByPrimaryKey(user.getId());
        if (temp == null) {
            userMapper.insert(user);
        } else {
            user.setId(temp.getId());
            userMapper.updateByPrimaryKeySelective(user);
        }
        return "redirect:list";
    }


    @ApiIgnore
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable Integer id) {
        userMapper.deleteByPrimaryKey(id);
        return  new ModelAndView("redirect:/users/list");
    }


    @ApiIgnore
    @RequestMapping(value = "modify/{id}")
    public String modify(@PathVariable Integer id, Model model) {
        User user = userMapper.selectByPrimaryKey(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return "user/form";
    }


    @ApiIgnore
    @RequestMapping(value = "form")
    public String form(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return "user/form";
    }

}
