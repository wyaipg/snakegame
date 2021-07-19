package com.w.game;

import javax.swing.*;
import java.net.URL;

public class Images {


    //    封装对象
    public static URL bodyUrl = Images.class.getResource("/images/body.png");

    public static ImageIcon bodyImg = new ImageIcon(bodyUrl);

    public static URL foodUrl = Images.class.getResource("/images/food.png");

    public static ImageIcon foodImg = new ImageIcon(foodUrl);

    public static URL upUrl = Images.class.getResource("/images/up.png");

    public static ImageIcon upImg = new ImageIcon(upUrl);

    public static URL downUrl = Images.class.getResource("/images/down.png");

    public static ImageIcon downImg = new ImageIcon(downUrl);

    public static URL rightUrl = Images.class.getResource("/images/right.png");

    public static ImageIcon rightImg = new ImageIcon(rightUrl);

    public static URL leftUrl = Images.class.getResource("/images/left.png");

    public static ImageIcon leftImg = new ImageIcon(leftUrl);

}
