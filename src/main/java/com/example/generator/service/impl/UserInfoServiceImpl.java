
package com.example.generator.service.impl;


import com.alibaba.fastjson.JSON;
import com.example.generator.entity.UserInfoExample;
import com.example.generator.mapper.UserInfoMapper;
import com.example.generator.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private UserInfoMapper userMapper;

    @Override
    public String selectByExample() {
        UserInfoExample example=new UserInfoExample();
        example.createCriteria().andIdEqualTo(1);
        String result= JSON.toJSONString(userMapper.selectByExample(example));
        return result;
    }
}