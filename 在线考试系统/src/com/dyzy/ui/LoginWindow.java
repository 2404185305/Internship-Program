package com.dyzy.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//登陆界面
public class LoginWindow extends JFrame {
    //定义ClientContext类
    private ClientContext clientContext;
    //账号对应的输入框
    private JTextField idMsg;
    //密码输入框
    private JPasswordField pwdMsg;
    //登录界面中用来显示错误信息的JLabel
    private JLabel message;

    //添加set方法，完成对clientContext的属性注入
    public void setClientContext(ClientContext clientContext) {
        this.clientContext = clientContext;
    }
    //添加get方法：方便获取idMsg和pwdMsg的
    public JTextField getIdMSg() {
        return idMsg;
    }
    public JPasswordField getPwdMsg() {
        return pwdMsg;
    }

    //构造方法：调用init()方法
    public LoginWindow(){
        init();
    }
    //init()方法：初始化登陆界面
    public void init(){
        //设置登录界面的相关内容(输入框，按钮，文字)
        //添加往窗体this核心面板
        JPanel p=createContentPane();
        this.add(p);
        //设置登录界面的相关属性
        this.setTitle("登陆系统");
        this.setSize(280,200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    //创建核心面板
    private JPanel createContentPane(){
        //创建最外层总面板 p
        JPanel p=new JPanel();
        //设置p的内边距 参数1：顶部内边距 参数2：左内边距 参数3：底内边距 参数4：右内边距
        p.setBorder(new EmptyBorder(8,0,8,0));
        //创建BorderLayout布局管理器
        BorderLayout border=new BorderLayout();
        //将p的布局设置为border布局
        p.setLayout(border);
        //往p的北部放(登陆系统文字)
        JPanel p1=createNorthPane();
        p.add(BorderLayout.NORTH,p1);
        //往的p中部放(账号密码以及对应的两个输入框)
        JPanel p2=createCenterPane();
        p.add(BorderLayout.CENTER,p2);
        //往的p南部放(登录取消两个按钮)
        JPanel p3=createSouthPane();
        p.add(BorderLayout.SOUTH,p3);

        return p;
    }
    //创建北部小面板 p1 (登陆系统文字)
    private JPanel createNorthPane(){
        JPanel p1=new JPanel();
        //创建标签--显示登录系统文字
        JLabel label=new JLabel("登陆系统");
        //将标签添加到p1中
        p1.add(label);
        return p1;
    }
    //创建中部小面板 p2
    private JPanel createCenterPane(){
        JPanel p2=new JPanel();
        //创建BorderLayout布局老师器
        BorderLayout border=new BorderLayout();
        //将p2面板设置为border布局
        p2.setLayout(border);

        //往p2的北部放账号，密码及输入框
        JPanel pp=new JPanel();
        p2.add(BorderLayout.NORTH,pp);

        //往p2的中部放错误信息
        message=new JLabel("",JLabel.CENTER);
        //创建GirdLayout布局管理器
        GridLayout grid=new GridLayout(2,1);//2行1列
        //将pp设置为grid布局
        pp.setLayout(grid);
        //创建账号标签
        JLabel id=new JLabel("账号：");
        //创建账号对应的输入框
        idMsg=new JTextField(15);
        JPanel ppp1=new JPanel();
        //将id和idMsg放入ppp1中
        ppp1.add(id);
        ppp1.add(idMsg);

        //创建密码标签
        JLabel pwd=new JLabel("密码：");
        //创建密码输入框
        pwdMsg= new JPasswordField(15);
        JPanel ppp2=new JPanel();
        //将pwd和pwdMsg放入ppp2
        ppp2.add(pwd);
        ppp2.add(pwdMsg);
        //ppp1面板中有id和id输入框
        //ppp2面板中有pwd和pwd输入框
        //pp面板的布局中是2行1列的表格布局
        pp.add(ppp1);
        pp.add(ppp2);

        p2.add(BorderLayout.NORTH,pp);//将pp添加到p2中
        //设置文字的颜色-红色
        message.setForeground(Color.RED);
        p2.add(BorderLayout.CENTER,message);

        return p2;
    }
    //定义一个方法：修改JLabel message标签上的内容
    //参数：msg表示要修改的内容
    public void updateMessage(String msg){
        message.setText(msg);
    }





    //创建南部小面板 p3
    private JPanel createSouthPane(){
        JPanel p3=new JPanel();
        //创建登录按钮和取消按钮
        JButton login=new JButton("登录");
        JButton cancel=new JButton("取消");
        //对取消按钮绑定事件监听
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //调用ClientContext类中定义的exit()方法
                clientContext.exit(LoginWindow.this);
            }
        });
        //对登录按钮绑定时间监听
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientContext.login();
            }
        });

        //将登录按钮和取消按钮添加到p3中
        p3.add(login);
        p3.add(cancel);
        return p3;
    }
}
