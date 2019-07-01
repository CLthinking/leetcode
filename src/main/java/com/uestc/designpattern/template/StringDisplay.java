package com.uestc.designpattern.template;

public class StringDisplay extends AbstractDisplay {
    private String string;
    private int width;

    public StringDisplay(String string) {
        this.string = string;
        this.width = string.getBytes().length;
    }

    @Override
    protected void open() {
        printLine();
    }

    @Override
    protected void print() {
        System.out.println("|" + string + "|");
    }

    @Override
    protected void close() {
        printLine();
    }

    private void printLine() {
        StringBuilder sb = new StringBuilder();
        sb.append('+');
        for (int i = 0; i < width; i++) {
            sb.append('-');
        }
        sb.append('+');
        System.out.println(sb.toString());
    }
}
