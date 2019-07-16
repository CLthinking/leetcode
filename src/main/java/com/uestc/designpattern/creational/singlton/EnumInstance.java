package com.uestc.designpattern.creational.singlton;

/**
 * @author CLthinking
 * @date 2019/7/16 下午 03:48
 */
public enum EnumInstance {
    INSTANCE {
        protected void printTest() {
            System.out.println("Test");
        }
    };

    protected abstract void printTest();

    private Object date;

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    public static EnumInstance getInstance() {
        return INSTANCE;
    }
}
