package com.example.login;

import com.example.demo.Cacheable;
import com.example.demo.User;
import com.example.demo.UserServiceImpl;
import com.example.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserServiceImpl service;

    @Autowired
    private IUserInfoService userInfoService;

    @RequestMapping(value = "/userLogin")
    @ResponseBody
    @Cacheable
    public String userLogin(){
        System.out.println("CacheAspect--userLogin进来了");
        User y=new User();
        y.setName("阮秀");
        y.setSex("女");
        System.out.println("返回值-----"+y.toString());

        return y.toString();
    }

    @RequestMapping(value = "/queryUserInfo")
    @ResponseBody
    public String queryUserInfo(){
        return userInfoService.selectByExample();
    }
}
