package com.dyzy.service;

import com.dyzy.entity.User;
import com.dyzy.ui.EntityContext;

//业务层代码
/*
1、登陆界面的登录验证
2、
 */
public class ExamService {
    //定义EntityContext类
    private EntityContext entityContext;
    //添加set方法，完成对entityContext的属性注入（赋值）
    public void setEntityContext(EntityContext entityContext) {
        this.entityContext = entityContext;
    }
    //定义方法：登录界面的登录验证
    //参数：id和pwd，表示要登录验证和账号密码
    //返回值：布尔类型，如果返回true表示账号和密码是正确的，否则是错误的。
    /*
        if (user==null){
            System.out.println("没有此ID用户");
            return false;
        }else { //user不为空，ID正确，判断密码
            if(user.getPwd().equals(pwd)){ //密码正确的情况
                System.out.println("登录成功");
                return true;
            }else{ //密码不正确的情况
                System.out.println("密码不正确");
                return false;
            }
         }
    */
    //返回值：User对象，如果账号密码正确，返回User对象；如果账号密码不正确，抛异常
    public User isLogin(int id,String pwd) throws IdOrPwdException{
        User user=entityContext.findUserById(id);
        if(user==null){
            IdOrPwdException iop=new IdOrPwdException("没有ID用户");
            throw iop;
        }
        if(user.getPwd().equals(pwd)){
            return user;     //返回user对象，主菜单界面：要显示欢迎xxx参加考试
        }
        //密码不正确--抛异常
        throw new IdOrPwdException("密码不正确");

    }
}
