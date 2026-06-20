package com.dyzy.ui;

import javax.swing.*;
import java.awt.*;

//在线考试系统的欢迎界面
//WelcomeWindow继承JFrame后，也是一个窗体界面
public class WelcomeWindow extends JFrame {
    //定义构造方法 --创建WelcomeWindow类自动执行
    public WelcomeWindow(){
        init();
    }

    //定义init方法 --初始化窗体界面
    public void init(){
        //创建面板JPanel类
        JPanel p=new JPanel();
        //创建BorderLayout布局管理器
        BorderLayout border=new BorderLayout();
        //修改面板p的布局方式
        p.setLayout(border);
        //创建一个标签JLabel类
        JLabel label=new JLabel(new ImageIcon("msg/welcome.png"));
        //将标签添加到面板的中部位置
        p.add(BorderLayout.CENTER,label);
        //将面板添加到窗体中
        this.add(p);
        //System.out.println("测试...你进来了");
        //this关键字表示当前类
        //this.setVisible(true);
        this.setSize(430,300);
        //this.setLocation(300,100);
        this.setLocationRelativeTo(null);//窗体居中
        this.setResizable(false);//设置窗体的大小不可改变
        this.setTitle("欢迎");










    }
}
