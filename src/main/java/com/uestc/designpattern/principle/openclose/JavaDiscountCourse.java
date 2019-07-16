package com.uestc.designpattern.principle.openclose;

/**
 * @author CLthinking
 * @date 2019/7/15 下午 07:42
 */
public class JavaDiscountCourse extends JavaCource {
    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }


    public Double getOriginPrice() {
        return super.getPrice();
    }


    @Override
    public Double getPrice() {
        return super.getPrice() * 0.8;
    }
}
