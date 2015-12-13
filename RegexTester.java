package com.regex;

import javax.swing.JFrame;

public class RegexTester
{
    public static void main(String[] args)
    {
        initial();
    }    
  
    public static void initial()
    {
        JFrame frame = new TextPaneFrame();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
