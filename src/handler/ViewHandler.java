package handler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewHandler {
    static int start = 0;// 查找开始位置
    static int end = 0;// 查找结束位置
    public static void searchAndReplace(JFrame window, JTextArea textArea){
        // 查找对话框
        JDialog search = new JDialog(window, "查找和替换");
        search.setSize(200, 100);
        search.setLocation(450, 350);
        JLabel label_1 = new JLabel("查找的内容");
        JLabel label_2 = new JLabel("替换的内容");
        final JTextField textField_1 = new JTextField(5);
        final JTextField textField_2 = new JTextField(5);
        JButton buttonFind = new JButton("查找");
        JButton buttonChange = new JButton("替换");
        JPanel panel = new JPanel(new GridLayout(2, 3));
        panel.add(label_1);
        panel.add(textField_1);
        panel.add(buttonFind);
        panel.add(label_2);
        panel.add(textField_2);
        panel.add(buttonChange);
        search.add(panel);
        search.setVisible(true);


        // 为查找下一个 按钮绑定监听事件
        buttonFind.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String findText = textField_1.getText();// 查找的字符串

                String text = textArea.getText();// 当前文本框的内容
                start = text.indexOf(findText, end);
                end = start + findText.length();
                // 没有找到
                if (start == -1) {
                    JOptionPane.showMessageDialog(null, "“" + findText + "”" + "已经查找完毕", "记事本", JOptionPane.WARNING_MESSAGE);
                    textArea.select(start, end);
                } else {
                    textArea.select(start, end);
                }

            }
        });
        // 为替换按钮绑定监听事件
        buttonChange.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String changeText = textField_2.getText();// 替换的字符串
                textArea.select(start, end);
                textArea.replaceSelection(changeText);
                textArea.select(start, end);
            }
        });
    }
}
