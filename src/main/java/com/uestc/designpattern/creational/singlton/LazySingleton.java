package com.uestc.designpattern.creational.singlton;

/**
 * @author CLthinking
 * @date 2019/7/16 上午 11:04
 */
public class LazySingleton {
    private static LazySingleton lazySingleton = null;
//    private static boolean flag = true;

    private LazySingleton() {
//        if (flag) {
//            flag = false;
//        } else {
//            throw new RuntimeException("单例构造器禁止反射调用!");
//        }
        if (lazySingleton != null) {
            throw new RuntimeException("单例构造器禁止反射调用!");
        }
    }

    public synchronized static LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

//    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
//        Class cls = LazySingleton.class;
//        Constructor c = cls.getDeclaredConstructor();
//        c.setAccessible(true);
//
//        LazySingleton o1 = LazySingleton.getInstance();
//        Field flag = cls.getDeclaredField("flag");
//        flag.setAccessible(true);
//        flag.set(null, true);
//
//        LazySingleton o2 = (LazySingleton) c.newInstance();
//
//
//        System.out.println(o1);
//        System.out.println(o2);
//        System.out.println(o1 == o2);
//
//    }
}
