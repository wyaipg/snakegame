package com.w.test;

import com.w.game.Images;

import java.net.URL;

public class MyTest {
    public static void main(String[] args) {
        URL bodyURL = Images.class.getResource("/images/body.png");
        System.out.println(bodyURL);
    }
}
