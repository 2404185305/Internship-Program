package com.dyzy.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//主菜单界面的设计
public class MenuWindow extends JFrame {
    //定义ClientContext类（因为要用exit方法）
    private ClientContext clientContext;
    //欢迎xxx同学参加考试的JLabel
    private JLabel info;


    //添加set方法：对clientContent赋值(属性注入)
    public void setClientContext(ClientContext clientContext) {
        this.clientContext = clientContext;
    }


    //构造方法
    public MenuWindow(){
        init();
    }
    //定义init()方法：去初始化主菜单界面
    public void init(){
        //主菜单界面的内容
        JPanel p=createContentPane();
        //将最外层主面板p添加到窗体中 this
        this.add(p);
        //主菜单界面的相关属性
        this.setSize(600,400);
        this.setTitle("主菜单界面");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    //创建主菜单界面的核心面板(北，中，南布局)
    private JPanel createContentPane(){
        JPanel p=new JPanel(); //p是最外层的总面板
        //创建BorderLayout布局管理器
        BorderLayout border=new BorderLayout();
        //将p的布局设置为border布局
        p.setLayout(border);
        //往p的北部放p1面板
        JPanel p1=createNorthPane();
        p.add(BorderLayout.NORTH,p1);
        //往p的中部放p2面板
        JPanel p2=createCenterPane();
        p.add(BorderLayout.CENTER,p2);
        //往p的南部放p3面板
        JPanel p3=createSouthPane();
        p.add(BorderLayout.SOUTH,p3);
        //等价于：修改原因：(BorderLayout默认居中)
        //p.add(BorderLayout.SOUTH,new.JL)
        return p;
    }
    //创建北部p1面板的内容：logo图片
    private JPanel createNorthPane(){
        JPanel p1=new JPanel();
        //设置p1面板中内容的内边距
        p1.setBorder(new EmptyBorder(8,8,30,8));
        JLabel label=new JLabel(new ImageIcon("msg/tarena.png"));
        p1.add(label);
        return p1;
    }

    //创建中部p2面板的内容：欢迎xx参加考试，4个按钮
    private JPanel createCenterPane(){
        JPanel p2=new JPanel();
        //设置p2面板的布局为东，西，南，北，中的布局方式
        BorderLayout border=new BorderLayout();
        p2.setLayout(border);
        //往p2的北部放：欢迎xxx参加考试
        info=new JLabel("欢迎XXX同学参加考试",JLabel.CENTER);
        p2.add(BorderLayout.NORTH,info);
        //往p2的中部放：4个按钮
        //创建一个小面板 pp:先将四个按钮放入pp小面板中，再将pp小面板放入p2中
        //开始按钮
        //JButton start=new JButton("开始",new ImageIcon("msg/exam.png"));
        //设置垂直方向上文字在底部
        //start.setVerticalTextPosition(JButton.BOTTOM);
        //设置水平方向上文字在中间
        //start.setHorizontalTextPosition(JButton.CENTER);
        //分数按钮
        //JButton score=new JButton("分数",new ImageIcon("msg/result.png"));
        //设置垂直方向上文字在底部
        //score.setVerticalTextPosition(JButton.BOTTOM);
        //设置水平方向上文字在中间
        //score.setHorizontalTextPosition(JButton.CENTER);
        JButton start=createBtn("开始","msg/exam.png");
        JButton score=createBtn("分数","msg/result.png");
        JButton rule=createBtn("考试规则","msg/message.png");
        JButton exit=createBtn("退出","msg/exit.png");
        //对退出按钮绑定单击事件
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientContext.exit(MenuWindow.this);
            }
        });
        //创建小面板pp
        JPanel pp=new JPanel();
        //将开始按钮添加到pp中
        pp.add(start);
        //将分数按钮添加到pp中
        pp.add(score);
        //将考试规则按钮添加到pp中
        pp.add(rule);
        //将退出按钮添加到pp中
        pp.add(exit);
        p2.add(BorderLayout.CENTER,pp);
        return p2;
    }
    //定义一个方法：更新主菜单界面欢迎xxx参加考试的内容
    public void updateViewMsg(String name){
        info.setText("欢迎"+name+"同学参加考试");
    }

    //封装一个方法：生成一个按钮(带图片和文字，并设置文字底部居中)
    //代码重复多次，就要考虑封装
    //txt="按钮名"   img="对应图片路径"
    //例:txt="开始"   img="img/exam.png"
    private JButton createBtn(String txt,String img){
        JButton btn=new JButton(txt,new ImageIcon(img));
        //设置垂直方向上文字在底部
        btn.setVerticalTextPosition(JButton.BOTTOM);
        //设置水平方向上文字居中
        btn.setHorizontalTextPosition(JButton.CENTER);
        return btn;
    }

    //创建南部p3面板的内容：版权所有，盗版必究
    private JPanel createSouthPane(){
        JPanel p3=new JPanel();
        //设置p3面板的内边距
        p3.setBorder(new EmptyBorder(8,8,8,8));
        //创建FlowLayout布局管理器
        FlowLayout flow=new FlowLayout(FlowLayout.RIGHT);
        p3.setLayout(flow);
        JLabel label=new JLabel("版权所有 盗版必究");
        p3.add(label);
        return p3;
    }
}
