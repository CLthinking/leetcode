package com.uestc.vivo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author CLthinking
 * @date 2019/7/13 下午 06:16
 */
public class Main {

    /**
     * 对字符串排序，字符串由大小写与数字组成，比较规则
     *     1、长度不同时，长度排在前面
     *     2、长度相同时，按照字典序排列。(AaBb...Zz, 0-9顺序)，即大写字母在小写字母前，数字排在字母后
     */
    public static String[] sort(String[] strs) {

        // 下面实现了根据字典序排序的规则
        Comparator<String> comp = (s1, s2) -> {
            for (int i = 0; i < s1.length(); i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if (c1 != c2) {
                    if (Character.isLowerCase(c1) && Character.isLowerCase(c2)  // 均是小写字母
                            || Character.isUpperCase(c1) && Character.isUpperCase(c2)  // 均是大写字母
                            || Character.isDigit(c1) && Character.isDigit(c2)) {   // 均是数字
                        return c1 - c2;
                    } else if (Character.isLetter(c1) && Character.isLetter(c2)){  // 均是字母，但是大小写不同
                        char c11 = Character.toLowerCase(c1); char c22 = Character.toLowerCase(c2);
                        if (c11 == c22) {  // 如果是大小写关系，如 A, a, 那么大写字母排在前面
                            return Character.isUpperCase(c1) ? -1 : 1;
                        }
                        return c11 - c22;
                    } else {  // 一个是字母，一个是数字， 字母均排在数字前面
                        return Character.isDigit(c1) ? 1 : -1;
                    }
                }
            }
            return 0;
        };
        return Arrays.stream(strs)
                .sorted(Comparator.comparing(String::length).thenComparing(comp))
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
//        System.out.println(Character.isLetter('a'));
//        System.out.println(Character.isLetter('A'));
//        System.out.println(Character.isLetter('1'));
//        System.out.println(Character.isDigit('1'));
//        System.out.println(Character.isDigit('a'));
//        System.out.println(Character.isDigit('A'));
        String[] strs = {"abc", "Abc", "123", "1", "1bc", "CBD", "abcd", "a"};
        System.out.println(Arrays.toString(sort(strs)));
//        System.out.println(Arrays.toString(strs));  // 使用流不能原址排序


    }

}
