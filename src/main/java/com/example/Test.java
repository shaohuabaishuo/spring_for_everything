package com.example;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        System.out.println(LocalDate.now().toString());
        try {
            HttpClient httpClient = new HttpClient();
            PostMethod post = new UTF8PostMethod("http://localhost:8080/web/url/urltest");
            String ch = post.getRequestCharSet();
            System.out.println("编码" + ch);
            post.setParameter("name", "小明");
            int code = httpClient.executeMethod(post);
            String res = post.getResponseBodyAsString();
            System.out.println("返回码:" + code);
            System.out.println("返回结果:" + new String(res));
            post.releaseConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static class UTF8PostMethod extends PostMethod {
        public UTF8PostMethod(String uri) {
            super(uri);
        }

        @Override
        public String getRequestCharSet() {
            return "utf-8";
        }
    }
}
