package com.regex;

import javax.swing.JFrame;

public class RegexTester
{
    public static void main(String[] args)
    {
        initial1();
    }    
  
    public static void initial()
    {
        JFrame frame = new TextPaneFrame();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public static void initial1()
    {
        String pattenString = "\\w+";
        String matcherString = "hello world! this is kitty!";
        
        Regex aRegex = new Regex(pattenString, matcherString);
        
        System.out.println(aRegex);
        
        JFrame frame = new TextPaneFrameForRegex(aRegex.getStyledDocument());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
