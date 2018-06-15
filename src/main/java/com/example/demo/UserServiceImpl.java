package com.example.demo;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class UserServiceImpl {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(UserServiceImpl.class);
        annotationConfigApplicationContext.refresh();
        InjectClass injectClass = annotationConfigApplicationContext.getBean(InjectClass.class);
        injectClass.print();
    }



    public static class InjectClass {

        public void print() {
            System.out.println("hello world");
        }
    }


    //key名字自定义  fieldKey可以看Spring EL表达
    public User getUser(User user) {
        System.out.println("CacheAspect--getUser进来了");
        User x=new User();
        x.setName("陈平安");
        x.setSex("男");

        User y=new User();
        y.setName("阮秀");
        y.setSex("女");

        List<User> users = new ArrayList<>();
        users.add(x);
        users.add(y);

        if (!users.isEmpty() && users.size() > 0) {
            user=users.get(0);
            return user;
        } else {
            return null;
        }
    }
}
