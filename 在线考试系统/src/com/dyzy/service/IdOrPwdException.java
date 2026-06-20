package com.dyzy.service;
//自定义异常：账号或密码错误的异常
//让IdOrPwdException成为异常类
//
public class IdOrPwdException extends Exception{
    //添加一个无参构造
    public IdOrPwdException() {
    }
    //添加有参构造
    public IdOrPwdException(String message) {
        super(message);
    }


}
