package com.regex;

import java.awt.Color;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

class Regex
{    
    private StyledDocument styledDocument;
    
    private static ArrayList<FindMark> findMarks = new ArrayList<FindMark>();
    
    private String pattern = "";
    private String matcher = "";
    
    private static final Color ODD_COLOR = new Color(255,240,0);
    private static final Color EVEN_COLOR = new Color(128,192,255);   
    
    /**
     * 构造函数
     * @param aPatten
     * @param aMatcher
     */
    public Regex(String aPatten, String aMatcher)
    {
        pattern = aPatten;
        matcher = aMatcher;
        setFindMark();
        setStyleDocument();
    }
    
    public StyledDocument getStyledDocument()
    {
        return styledDocument;
    }

    /**
     * 遍历字符串，查找符合正则表达式的字符串，并存储在一个列表中
     */
    private void setFindMark()
    {
        try
        {
            Pattern aPattern = Pattern.compile(pattern);
            Matcher aMatcher = aPattern.matcher(matcher);
            
            while(aMatcher.find())
            {
                int start = aMatcher.start();
                int end  = aMatcher.end();
                
                findMarks.add(new FindMark(start,end));
            }
        }
        catch (PatternSyntaxException e)
        {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    
    /**
     * 将文本根据正则表达式的值转化为带格式文本
     */
    private void setStyleDocument()
    {
        styledDocument = new DefaultStyledDocument();
        SimpleAttributeSet set = new SimpleAttributeSet();
//        set.addAttributes( SimpleAttributeSet.EMPTY );
        
        try
        {
            styledDocument.insertString(0, matcher, set);
            
            int count = 0;
            for (FindMark findMark : findMarks)
            {
                String str = styledDocument.getText(findMark.getPaStart(), findMark.length());
                styledDocument.remove(findMark.getPaStart(), findMark.length());
                
                boolean isOdd = (count % 2 == 1) ? true:false;
                
                if(isOdd)
                {
                    StyleConstants.setBackground(set, ODD_COLOR);
                    styledDocument.insertString(findMark.getPaStart(), str, set);
                }
                else 
                {
                    StyleConstants.setBackground(set, EVEN_COLOR);
                    styledDocument.insertString(findMark.getPaStart(), str, set);
                }
                count++;
            }
        }
        catch (BadLocationException e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
    
    public String toString()
    {
        String str = "";
        
        str += "input: " + matcher + "\n";
        str += "pattern: " + pattern + "\n";
        
        for (FindMark findMark : findMarks)
        {
            str += findMark.toString() + "\n";
        }
        
        return str;
    }
}

