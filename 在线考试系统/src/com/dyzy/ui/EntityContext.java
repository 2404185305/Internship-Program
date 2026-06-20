package com.dyzy.ui;

import com.dyzy.entity.User;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//负责user.txt和corejava.txt文件的读取IO操作
public class EntityContext {
    Map<Integer,User> users=new HashMap<Integer, User>();

    //构造方法：调用loadUser方法
    public EntityContext(){
        loadUser();
    }
    //创建loadUser()方法：读取user.txt的内容
    public void loadUser(){
        //使用IO流对文件进行读写操作
        /* IO流（站在程序的角度）
        输入流：读的操作 FileInputStream(字节输入流) InputStreamReader BufferedReader
        输出流：写的操作 FileOutputStream(字节输出流) InputOutputWriter BufferedWriter
         */
        try {
            //创建字节输入流 FileInputStream
            FileInputStream fis=new FileInputStream("msg/user.txt");
            //创建字符输入流 InputStreamReader
            InputStreamReader isr=new InputStreamReader(fis,"utf-8");
            //创建缓冲字符输入流 BufferedReader
            BufferedReader br=new BufferedReader(isr);
            String str;
            while((str=br.readLine())!=null){
                //去掉字符串两端空格
                str=str.trim();
                //过滤掉空白行和#开头的行
                if (str.equals("") || str.startsWith("#")){
                    continue; //跳过本次循环，继续下一次循环
                }
                String[] data=str.split(":");
                //创建User类
                User user=new User();
                user.setId(Integer.parseInt(data[0]));
                user.setName(data[1]);
                user.setPwd(data[2]);
                user.setPhone(data[3]);
                user.setEmail(data[4]);
                //将user存储到集合users
                users.put(user.getId(),user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //根据id从users集合中获取User对象的方法
    public User findUserById(int id){
        User user=users.get(id);
        return user;
    }

}
