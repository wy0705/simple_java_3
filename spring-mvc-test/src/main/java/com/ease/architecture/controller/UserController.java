package com.ease.architecture.controller;


import com.ease.architecture.entity.User;
import com.ease.architecture.service.UserServiceImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        return "aaaaa";
    }

    @RequestMapping(value = "registryPage", method = RequestMethod.GET)
    public String registryPage() {
        return "registry";
    }


    @RequestMapping(value = "login", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String login(String username, String password) {
        User user = userService.findUserByNameAndPassword(username, DigestUtils.md5Hex(password));
        if (user == null || user.getName() == null) {
            return "用户不存在或用户名、密码错误";
        }
        return "hello" + user.getName();
    }

    @RequestMapping(value = "registry", method = RequestMethod.POST)
    @ResponseBody
    public String registry(User user) {
        boolean register = userService.register(user);
        if (register) {
            return "hello" + user.getName();
        }
        return "注册失败";
    }


}
