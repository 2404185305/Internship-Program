package com.dyzy.test;

import com.dyzy.ui.WelcomeWindow;

import javax.swing.*;

//窗体界面 JFrame
public class Test01 {
    public static void main(String[] args) {
        /*
        //创建窗体界面 JFrame
        JFrame f=new JFrame();
        //创建面板（小板子）JPanel
        JPanel p=new JPanel();
        //创建一个标签 JLabel
        JLabel label=new JLabel(new ImageIcon("msg/welcome.png"));
        //1、将标签放到面板上
        p.add(label);
        //2、将面板放到窗体上
        f.add(p);
        f.setVisible(true);//窗体可见
        f.setTitle("我的窗体");//设置窗体的标题
        f.setLocation(300,200);
        f.setSize(500,400);
        */
        WelcomeWindow ww=new WelcomeWindow();
    }
}

