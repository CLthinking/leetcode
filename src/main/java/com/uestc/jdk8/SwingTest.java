package com.uestc.jdk8;

import javax.swing.*;

public class SwingTest {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("my JFrame");
        JButton jButton = new JButton("my JButton");

        jButton.addActionListener(e -> System.out.println("Button Pressed"));

        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
