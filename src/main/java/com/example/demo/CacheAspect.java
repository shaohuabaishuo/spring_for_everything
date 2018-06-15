package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

@Aspect
public class CacheAspect {
    private Logger logger = LoggerFactory.getLogger(CacheAspect.class);

    public CacheAspect() {
    }


    @Pointcut(value = "execution(@Cacheable * *.*(..))")
    public void setCacheRedis() {
        System.out.println("CacheAspect--setCacheRedis进来了");
    }

    /**
     * aop实现自定缓存注解
     *
     * @param joinPoint
     * @return
     */

    //@Around("@annotation(com.manage.annotations.Cacheable)")  不知道为什么这么写不行<br>　　//这个里面的值要上面的方法名一致
    @Around("setCacheRedis()")
    public Object setCache(ProceedingJoinPoint joinPoint) {
        System.out.println("CacheAspect--setCache进来了");
        Object result = null;

        Method method = getMethod(joinPoint);//自定义注解类
        Cacheable cacheable = method.getAnnotation(Cacheable.class);//获取key值
        //获取方法的返回类型,让缓存可以返回正确的类型
        Class returnType = ((MethodSignature) joinPoint.getSignature()).getReturnType();
        return result;
    }

    public Method getMethod(ProceedingJoinPoint pjp) {
        System.out.println("CacheAspect--getMethod进来了");
        //获取参数的类型
        Object[] args = pjp.getArgs();
        Class[] argTypes = new Class[pjp.getArgs().length];
        for (int i = 0; i < args.length; i++) {
            argTypes[i] = args[i].getClass();
        }
        Method method = null;
        try {
            method = pjp.getTarget().getClass().getMethod(pjp.getSignature().getName(), argTypes);
        } catch (NoSuchMethodException e) {
            logger.error("annotation no sucheMehtod", e);
        } catch (SecurityException e) {
            logger.error("annotation SecurityException", e);
        }
        return method;

    }
}
