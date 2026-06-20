package com.dyzy.ui;

import com.dyzy.service.ExamService;

//运行在线考试系统的主类
public class Main {
    public static void main(String[] args) {
        //创建客户端上下文ClientContext
        ClientContext clientContext=new ClientContext();

        //创建业务层的ExamService类
        ExamService examService=new ExamService();

        //创建EntityContext类
        EntityContext entityContext=new EntityContext();

        //创建欢迎界面
        WelcomeWindow welcomeWindow=new WelcomeWindow();
        //创建登录界面
        LoginWindow loginWindow=new LoginWindow();
        //创建主菜单界面
        MenuWindow menuWindow=new MenuWindow();

        //调用setXX()方法，将业务层的类注入到ClientContext类中
        clientContext.setExamService(examService);

        //调用setXX()方法，将EntityContext注入到examService中
        examService.setEntityContext(entityContext);

        //调用setXX()方法，将创建的界面注入进来
        clientContext.setWelcomeWindow(welcomeWindow);
        clientContext.setLoginWindow(loginWindow);
        clientContext.setMenuWindow(menuWindow);

        //调用setXX()方法，将clientContext注入到对应的窗体中
        loginWindow.setClientContext(clientContext);
        menuWindow.setClientContext(clientContext);

        //通过ClientContext调用showUI方法
        clientContext.showUI();


    }
}
