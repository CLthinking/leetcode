package com.uestc.designpattern.creational.abstractfactory;

/**
 * @author CLthinking
 * @date 2019/7/15 下午 10:35
 */
public class PythonArticle extends Article {
    @Override
    public void produce() {
        System.out.println("录制Python手记");
    }
}
