package com.uestc.designpattern.creational.prototype;

/**
 * @author CLthinking
 * @date 2019/7/16 下午 05:02
 */
public class Mail implements Cloneable{
    private String name;
    private String eamilAddress;
    private String content;

    public Mail() {
        System.out.println("Mail Class Constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEamilAddress() {
        return eamilAddress;
    }

    public void setEamilAddress(String eamilAddress) {
        this.eamilAddress = eamilAddress;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "name='" + name + '\'' +
                ", eamilAddress='" + eamilAddress + '\'' +
                ", content='" + content + '\'' +
                '}' + super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("clone mail object");
        return super.clone();

    }
}
