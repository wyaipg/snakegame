package com.w.test;

import com.w.game.GamePanel;

import javax.swing.*;
import java.awt.*;

public class StartGame {

    public static void main(String[] args) {

//        创建一个窗体
        JFrame jFrame = new JFrame();
//        标题
        jFrame.setTitle("修罗吃东西");
        //大小

        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;


        jFrame.setBounds((width-800)/2, (height-800)/2, 800, 800);
//        设置窗体不可调节
        jFrame.setResizable(false);
//        关闭窗口的同时关闭程序
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        面板
        GamePanel gamePanel = new GamePanel();
        jFrame.add(gamePanel);

        //        默认窗体是隐藏的，设置方法放最后
        jFrame.setVisible(true);


    }


}
