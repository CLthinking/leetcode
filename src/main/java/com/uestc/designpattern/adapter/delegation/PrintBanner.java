package com.uestc.designpattern.adapter.delegation;

import com.uestc.designpattern.adapter.extend.Banner;

public class PrintBanner extends Print{
    private Banner banner;

    public PrintBanner(String name) {
        this.banner = new Banner(name);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
