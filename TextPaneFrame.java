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
            Document document = matchPane.getDocument();
            StyledDocument styledDocument = new DefaultStyledDocument();
            
            try
            {
                SimpleAttributeSet setOdd=new SimpleAttributeSet();
                StyleConstants.setBackground(setOdd, ODD_COLOR);
                
                SimpleAttributeSet setEven=new SimpleAttributeSet();
                StyleConstants.setBackground(setEven, EVEN_COLOR);
                

                int len = document.getLength();
                StringBuffer strBuffer = new StringBuffer(document.getText(0, len));                              

                document.remove(0, len);
                
                for (int start = 0; start < len; start++)
                {
                    String strSub = strBuffer.substring(start, start + 1);                       
                    
                    boolean isOdd = (start % 2 == 1) ? true:false;
                    
                    if(isOdd)
                    {
                        styledDocument.insertString(start, strSub, setOdd);
                    }
                    else {
                        styledDocument.insertString(start, strSub, setEven);
                    }
                }
                
                matchPane.setStyledDocument(styledDocument);
                matchPane.setCaretPosition(len);
                
            }
            catch (BadLocationException e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        
        private void getStyle()
        {
            Document document = matchPane.getDocument();
            
            int len = document.getLength();
            
            try
            {
                String matcherString = document.getText(0, len);
                Regex regex = new Regex("\\w+", matcherString);
                
                System.out.println(regex);
                
                matchPane.setStyledDocument(regex.getStyledDocument());
                matchPane.setCaretPosition(len);
            }
            catch (BadLocationException e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
}

class TextPaneFrameForRegex extends JFrame
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    
    private JTextPane matchPane;
    
    public TextPaneFrameForRegex(StyledDocument doc)
    {
        setTitle("TextPaneFrameForRegex");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        matchPane = new JTextPane(doc);
        add(new JScrollPane(matchPane),BorderLayout.CENTER);
    }
}
