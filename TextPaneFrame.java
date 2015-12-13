package com.regex;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;

class TextPaneFrame extends JFrame
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    
    private static final Color ODD_COLOR = new Color(255,240,0);
    private static final Color EVEN_COLOR = new Color(128,192,255);   
    
    private JTextPane matchPane = new JTextPane();
    private JTextPane patternPane = new JTextPane(); 

    public  TextPaneFrame()
    {
        setTitle("TextPaneTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        

        JSplitPane SplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                RegularExpressionPanel(), TestStringPanel());

        add(SplitPane,BorderLayout.CENTER);
    }
    
    private JPanel RegularExpressionPanel()
    {
        JPanel regularExpressionPanel = new JPanel();
        JLabel egularExpressionLabel = new JLabel("正则表达式：");

        regularExpressionPanel.setLayout(new GridLayout(2,1));
        regularExpressionPanel.add(egularExpressionLabel);
        regularExpressionPanel.add(new JScrollPane(patternPane));
        
        return regularExpressionPanel;
    }
    
    private JPanel TestStringPanel()
    {
        matchPane.addKeyListener(new myKeyListener());
        
        JPanel testStringPanel = new JPanel();
        JLabel testStringLabel = new JLabel("测试字符串：");

        testStringPanel.setLayout(new GridLayout(2,1));
        testStringPanel.add(testStringLabel);
        testStringPanel.add(new JScrollPane(matchPane));
        
        return testStringPanel;
    }
    class myKeyListener implements KeyListener
    {
        @Override
        public void keyReleased(KeyEvent arg0)
        {
            // TODO Auto-generated method stub

        }

        @Override
        public void keyPressed(KeyEvent arg0)
        {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void keyTyped(KeyEvent arg0)
        {
            // TODO Auto-generated method stub
            Regex aRegex = new Regex(patternPane.getText(), matchPane.getText());

            matchPane.setStyledDocument(aRegex.getStyledDocument());
            matchPane.setCaretPosition(matchPane.getText().length());
        }
    }
}