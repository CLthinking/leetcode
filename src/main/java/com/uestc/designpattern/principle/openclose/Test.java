package com.uestc.designpattern.principle.openclose;

/**
 * @author CLthinking
 * @date 2019/7/15 下午 07:14
 */
public class Test {

    public static void main(String[] args) {
        ICourse javaCource = new JavaDiscountCourse(1, "CLthinking", 100.0);
        JavaDiscountCourse javaDiscountCourse = (JavaDiscountCourse)javaCource;
        System.out.println("课程ID: " + javaDiscountCourse.getId() + "课程名称：" + javaDiscountCourse.getName()
                            + "课程原价：" + javaDiscountCourse.getOriginPrice() + "折后价：" + javaDiscountCourse.getPrice());
    }
}
