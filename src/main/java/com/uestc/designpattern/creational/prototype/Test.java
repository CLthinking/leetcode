package com.uestc.designpattern.creational.prototype;

/**
 * @author CLthinking
 * @date 2019/7/16 下午 05:08
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Mail mail = new Mail();
        mail.setContent("初始化模板");
        System.out.println("初始化mail:" + mail);
        for (int i = 0; i < 10; i++) {
            Mail mailTemp = (Mail) mail.clone();
            mailTemp.setName("姓名" + i);
            mailTemp.setEamilAddress("姓名" + i + "@imooc.com");
            mailTemp.setContent("恭喜您中奖");
            MailUtil.sendMail(mailTemp);
            System.out.println("克隆的mail" + mailTemp);
        }
        MailUtil.saveOriginMailRecord(mail);
    }
}
