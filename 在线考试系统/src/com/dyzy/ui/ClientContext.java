package com.dyzy.ui;

import com.dyzy.entity.User;
import com.dyzy.service.ExamService;
import com.dyzy.service.IdOrPwdException;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

//客服端上下文类：负责客户端不同窗体界面的控制
//欢迎界面 登陆界面 菜单界面 考试界面
public class ClientContext {
    private ExamService examService;        //定义业务层ExamService类
    private WelcomeWindow welcomeWindow;    //欢迎界面
    private LoginWindow loginWindow;        //登录界面
    private MenuWindow menuWindow;          //主菜单界面



    //添加set方法，完成对examService的属性注入
    public void setExamService(ExamService examService) {
        this.examService = examService;
    }
    //添加set方法，可以完成对welcomeWindow的属性注入
    public void setWelcomeWindow(WelcomeWindow welcomeWindow) {
        this.welcomeWindow = welcomeWindow;
    }
    //添加set方法，完成loginWindow的属性注入
    public void setLoginWindow(LoginWindow loginWindow) {
        this.loginWindow = loginWindow;
    }
    //添加set方法，完成对menuWindow的属性注入
    public void setMenuWindow(MenuWindow menuWindow) {
        this.menuWindow = menuWindow;
    }


    //private Timer timer
    //创建一个Timer类，定时器
    Timer timer=new Timer();
    //定义showUI方法:让欢迎界面显示
    public void showUI(){
        //先打开欢迎界面，2s后关闭欢迎界面，打开登陆界面
        //参数2：时间，单位毫秒 1s=1000ms 设置时间去执行参数1的内容
        //参数1：要执行的内容写在run()方法中
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //欢迎界面打开
                welcomeWindow.setVisible(true);
            }
        },0);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //取消之前启动的定时器
                timer.cancel();
                //欢迎界面关闭
                welcomeWindow.setVisible(false);
                //登录界面打开
                loginWindow.setVisible(true);

            }
        }, 2000);
        //menuWindow.setVisible(true);//打开主菜单界面
    }


    //定义登录界面退出按钮的退出功能
    //参数：JFrame frame窗体，表示要关闭的窗体，可能是登录窗体LoginWindow，也可能是
    //主菜单上的窗体MenuWindow
    public void exit(JFrame frame){
        //参数1：当前窗体 参数2：二级消息框的提示内容
        // 参数3：二级消息框的标题 参数4：二级消息框的展示类型(确定，取消)
        int val= JOptionPane.showConfirmDialog(frame, "真的要离开吗？",
                "退出", JOptionPane.YES_NO_OPTION);
        //判断点击是否是二级消息框的是（Yes）
        //通过System.out.println(val);运行得出
        //val=0说明点击的是Yes，val=1说明点击的No
        if(val==JOptionPane.YES_OPTION){
            //结束程序
            System.exit(0);
        }
    }
    //定义登录界面登录按钮执行的方法
    /*
        当点击登录界面按钮时需要做的事情如下
        1、从登录界面获取输入框输入的账号密码
        2、验证账号和密码是否正确（结合user.txt）
        3、如果账号和密码正确，跳转到主菜单界面，登录界面关闭
        4、如果账号密码不正确：在登录界面显示错误信息，不发生界面跳转
    */
    public void login(){
        try {
            //1、从登录界面获取输入框输入的账号密码
            JTextField idMsg=loginWindow.getIdMSg();
            JPasswordField pwdMsg=loginWindow.getPwdMsg();
            int id=Integer.parseInt(idMsg.getText());
            String pwd=new String(pwdMsg.getPassword());
            //测试：System.out.println(id+","+pwd);
            //2、验证账号和密码是否正确(结合user.txt)--交给业务层(service包)完成验证
            User user=examService.isLogin(id,pwd);
            //测试：System.out.println(user);
            //3、如果账号和密码正确，跳转到主菜单界面，登录界面关闭
            menuWindow.updateViewMsg(user.getName());
            loginWindow.setVisible(false);
            menuWindow.setVisible(true);
        } catch (IdOrPwdException e) {
            //e.printStackTrace();
            //System.out.println(e.getMessage());
            loginWindow.updateMessage(e.getMessage());
        } catch (NumberFormatException e){
            loginWindow.updateMessage("账号必须是数字");
        }
    }
}
