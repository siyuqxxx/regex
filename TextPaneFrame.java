package com.regex;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;

class TextPaneFrame extends JFrame
{
    private static final long serialVersionUID = 1L;
    
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 300;
    
    private static final String REGULAR_EXPRESSION_LABEL = "正则表达式：";
    private static final String TEST_STRING_LABEL = "测试字符串：";
    
    private JTextPane matchPane = new JTextPane();
    private JTextPane patternPane = new JTextPane(); 

    public  TextPaneFrame()
    {
        setTitle("TextPaneTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        matchPane.addKeyListener(new myKeyListener());

        JSplitPane SplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                textAndLabelPanel(REGULAR_EXPRESSION_LABEL, patternPane),
                textAndLabelPanel(TEST_STRING_LABEL, matchPane));

        add(SplitPane,BorderLayout.CENTER);
    }
    
    /**
     * 采用 GridBagLayout 布局的带标签面板
     * 面板采用上下布局
     * 
     * @param name 标签名称
     * @param component 交互控件
     * @return
     */
    private JPanel textAndLabelPanel(String name, JComponent component)
    {
        JPanel panel = new JPanel();
        JLabel label = new JLabel(name);
        JScrollPane scrollPane = new JScrollPane(component);

        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        panel.setLayout(gridBag);

        c.gridwidth = GridBagConstraints.REMAINDER;
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(0, 0, 6, 0);
        gridBag.setConstraints(label, c);

        c.weighty = 1.0;
        c.insets = new Insets(0, 0, 0, 0);
        gridBag.setConstraints(scrollPane, c);

        panel.add(label);
        panel.add(scrollPane);

        panel.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));

        return panel;
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