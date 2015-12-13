package com.regex;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

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
        
        matchPane.addKeyListener(new myKeyListener());

        JSplitPane SplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                new JScrollPane(patternPane), new JScrollPane(matchPane));

        add(SplitPane,BorderLayout.CENTER);
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