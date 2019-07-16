package com.uestc.leetcode;

import java.util.Random;

/**
 * @author CLthinking
 * @date 2019/7/15 下午 12:27
 */
public class Base7 {
    public String convertToBase7_0(int num) {
        return Integer.toString(num, 7);
    }

    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };

    public String convertToBase7(int i) {
        char buf[] = new char[33];  // int 32位

        boolean negative = (i < 0);
        int charPos = 32;

        if (negative) {
            i = -i;
        }

        int radix = 7;

        while (i >= radix) {
            buf[charPos--] = digits[i % radix];
            i = i / radix;
        }
        buf[charPos] = digits[i];

        if (negative) {
            buf[--charPos] = '-';
        }

        return new String(buf, charPos, (33 - charPos));
    }

    private static String convent(int num, int radix) {
        if (radix == 10) return Integer.toString(num);

        char[] buf = new char[33];
        int charPos = 32;

        boolean negative = num < 0;
        num = negative ? -num : num;

        while (num >= radix) {
            buf[charPos--] = digits[num % radix];
            num /= radix;
        }
        buf[charPos] = digits[num];

        if (negative) buf[--charPos] = '-';

        return new String(buf, charPos, 33 - charPos);
    }

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 100000; i++) {
            int radix = random.nextInt(35) + 2;
            int num = random.nextInt(Integer.MAX_VALUE);
            if (!Integer.toString(num, radix).equals(convent(num, radix))) {
                System.out.println(i + " error : " + num + " " + radix + " " + Integer.toString(num, radix) + " " + convent(num, radix));
            }
        }
    }
}
