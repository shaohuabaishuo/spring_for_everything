package com.example.demo.identity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/url")
public class URLController {
    @RequestLimit(count=10,time=5000)
    @RequestMapping(value = "/urltest",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String test(HttpServletRequest request, ModelMap modelMap) {
        return request.getParameter("name");
    }
}
