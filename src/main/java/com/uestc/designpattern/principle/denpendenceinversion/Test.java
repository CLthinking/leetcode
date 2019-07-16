package com.uestc.designpattern.principle.denpendenceinversion;

/**
 * @author CLthinking
 * @date 2019/7/15 下午 07:56
 */
public class Test {
    public static void main(String[] args) {
        CLthinking cl = new CLthinking();
        cl.setiCource(new JavaCource());
        cl.studyCource();
        cl.setiCource(new PythonCource());
        cl.studyCource();

//        cl.studyJavaCource();
//        cl.studyPythonCource();
    }
}
