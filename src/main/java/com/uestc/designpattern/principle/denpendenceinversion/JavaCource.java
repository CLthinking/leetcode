package com.uestc.designpattern.principle.denpendenceinversion;

/**
 * @author CLthinking
 * @date 2019/7/15 下午 07:59
 */
public class JavaCource implements ICource {
    @Override
    public void studyCource() {
        System.out.println("学习Java课程");
    }
}
