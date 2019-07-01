package com.uestc.leetcode;

import java.io.*;
import java.util.Scanner;

public class FileUtil {

    public static double[] readDoubleNumsFromFile(String filename) throws IOException {
        DataInputStream inputStream = new DataInputStream(
                new BufferedInputStream(new FileInputStream(filename)));
        Scanner scanner = new Scanner(new FileInputStream(filename));
        scanner.nextDouble();
        return null;
    }
}
