package com.w.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 继承jPanel
 */
public class GamePanel extends JPanel {


    int foodX;
    int foodY;

//    蛇的坐标

//    List<Integer> snakeX = new ArrayList<Integer>();
//
//    List<Integer> snakeY = new ArrayList<Integer>();


    int[] snakeX = new int[100000];
    int[] snakeY = new int[100000];


    //    是否开始
    boolean isStart = false;

    //    方向
    String direction;

    //    蛇的长度
    int length;

    //    定时器
    Timer timer;

    public void init() {


        length = 3;

//        初始化蛇头坐标
        snakeX[0]=175;
        snakeY[0]=275;
        //初始化第一节身体的坐标
        //初始化第二节身体的坐标
        snakeX[1]=150;
        snakeY[1]=275;

        snakeX[2]=125;
        snakeY[2]=275;

        direction = "R"; // U L D R

        foodX = 300;
        foodY = 200;

    }

    public GamePanel() {
        init();

//        将焦点定位在当前操作的面板上
        this.setFocusable(true);
//        加入监听
        this.addKeyListener(new KeyAdapter() {
            //监听键盘按下方法
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int keyCode = e.getKeyCode();
//                System.out.println(keyCode);
                if (keyCode == 32) {
                    isStart = !isStart;
                    repaint();//重绘
                }
//                上错下游

                if (keyCode == 38 || keyCode == 87) {
                    direction = "U";
                    snakeY[0]=snakeY[0] - 25;
                }
                if (keyCode == 37 || keyCode == 65) {
                    direction = "L";
                    snakeX[0]=snakeX[0] - 25;
                }
                if (keyCode == 40 || keyCode == 83) {
                    direction = "D";
                    snakeY[0]=snakeY[0] + 25;
                }
                if (keyCode == 39 || keyCode == 68) {
                    direction = "R";
                    snakeX[0]=snakeX[0] + 25;
                }

            }
        });

//定时器操作
        timer = new Timer(100, new ActionListener() {
            /**
             * 事件监听
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
//                执行的动作

//                游戏开始  蛇动
                if (isStart) {


                    for (int i = length - 1; i > 0; i--) {


                        snakeX[i]=snakeX[i-1];
                        snakeY[i]=snakeY[i-1];
                    }
//                    头
                    if ("R".equals(direction)) {
                        snakeX[0] = snakeX[0] + 25;
                    }
                    if ("L".equals(direction)) {
                        snakeX[0] = snakeX[0] - 25;
                    }
                    if ("U".equals(direction)) {
                        snakeY[0] = snakeY[0] - 25;
                    }
                    if ("D".equals(direction)) {
                        snakeY[0] = snakeY[0] + 25;
                    }


                    if (snakeX[0] >= 750) {
                        snakeX[0]= 25;
                    }
                    if (snakeX[0] < 25) {
                        snakeX[0]= 750;
                    }
                    if (snakeY[0] <= 100) {
                        snakeY[0]= 700;
                    }
                    if (snakeY[0] >= 725) {
                        snakeY[0]= 100;
                    }


//                    蛇头触碰食物
                    if (snakeY[0] == foodY && snakeX[0] == foodX) {
                        length++;
//                        随机


//                        25-725

                        foodX = ((int) Math.random() * 30) * 25;
//                        100-725
                        foodY = (new Random().nextInt(27) + 4) * 25;
                    }

                    repaint();

                }

            }
        });
//启动定时器
        timer.start();
    }

    /**
     * paintComponent
     * 属于无形的main
     * 自动调用
     */

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new Color(220, 214, 214));

        g.setColor(new Color(116, 114, 114));
        g.fillRect(25, 75, 800, 750);

//        画蛇


        if ("R".equals(direction)) {
            Images.rightImg.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        if ("D".equals(direction)) {
            Images.downImg.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        if ("U".equals(direction)) {
            Images.upImg.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        if ("L".equals(direction)) {
            Images.leftImg.paintIcon(this, g, snakeX[0], snakeY[0]);
        }


//        Images.bodyImg.paintIcon(this,g,snakeX.get(1),snakeY.get(1));
//
//        Images.bodyImg.paintIcon(this,g,snakeX.get(2),snakeY.get(2));
        System.out.println(length);
        for (int i = 1; i < length; i++) {
            Images.bodyImg.paintIcon(this, g, snakeX[i], snakeY[i]);
        }

//    食物

        Images.foodImg.paintIcon(this, g, foodX, foodY);

//        如果游戏是暂停的
//        界面中间就来个提示
        if (!isStart) {
            g.setColor(new Color(70, 213, 18));
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("点击空格开始游戏", 250, 330);
        } else {

        }


    }
}
