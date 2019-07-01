package com.uestc.designpattern.adapter.delegation;

import com.uestc.designpattern.adapter.extend.Print;
import com.uestc.designpattern.adapter.extend.PrintBanner;

public class Main {

    public static void main(String[] args) {
        Print print = new PrintBanner("Hello");
        print.printWeak();
        print.printStrong();
    }
}
