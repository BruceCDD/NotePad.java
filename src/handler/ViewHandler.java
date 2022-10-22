package handler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewHandler {
    static int start = 0;// 查找开始位置
    static int end = 0;// 查找结束位置

    public static void searchAndReplace(JFrame window, JTextArea textArea) {
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
        end = textArea.getCaretPosition();
        buttonChange.setEnabled(false);


        // 为查找下一个 按钮绑定监听事件
        buttonFind.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String findText = textField_1.getText();// 查找的字符串
                if (findText == null || findText.equals("")) return;
                String text = textArea.getText();// 当前文本框的内容
                start = text.indexOf(findText, end);
                end = start + findText.length();
                // 没有找到
                if (start == -1) {
                    JOptionPane.showMessageDialog(null, "“" + findText + "”" + "已经查找完毕", "记事本", JOptionPane.WARNING_MESSAGE);
                    buttonChange.setEnabled(false);
                    end = 0;
                    textArea.select(start, end);
                } else {
                    textArea.select(start, end);
                    buttonChange.setEnabled(true);
                }

            }
        });
        // 为替换按钮绑定监听事件
        buttonChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String changeText = textField_2.getText();// 替换的字符串
                textArea.replaceSelection(changeText);
                end = start;
                buttonFind.doClick();
            }
        });
    }

    public static void lineWrap(JFrame window, JTextArea textArea) {
        JMenuItem item = window.getJMenuBar().getMenu(2).getItem(1);
        if (item.getText().endsWith("√")) {
            item.setText("自动换行");
            textArea.setLineWrap(false);
        } else {
            item.setText("自动换行 √");
            textArea.setLineWrap(true);
        }
    }

    public static void setFont(JFrame window, JTextArea textArea) {
        JDialog fontSet = new JDialog(window, "设置字体大小");
        fontSet.setSize(200, 100);
        fontSet.setLocation(450, 350);
        final JTextField textField_1 = new JTextField(5);
        JButton buttonConfirm = new JButton("确定");
        JButton buttonCancel = new JButton("取消");
        JPanel panel = new JPanel(new GridLayout(2, 3));
        panel.add(new JLabel("大小(1~30)"));
        panel.add(textField_1);
        panel.add(new JLabel());
        panel.add(buttonConfirm);
        panel.add(new JLabel());
        panel.add(buttonCancel);
        fontSet.add(panel);
        fontSet.setVisible(true);


        // 为查找下一个 按钮绑定监听事件
        buttonConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int size = Integer.valueOf(textField_1.getText());// 当前文本框的内容
                    if (size <= 0 || size > 30) {
                        JOptionPane.showMessageDialog(null, "请输入正确的字体大小(1~30)", "提示", JOptionPane.WARNING_MESSAGE);
                    } else {
                        textArea.setFont(new Font("Serif", Font.PLAIN, size + 10));
                        fontSet.dispose();
                    }
                } catch (NumberFormatException numberFormatException) {
                    JOptionPane.showMessageDialog(null, "请输入正确的字体大小(1~30)", "提示", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        // 为替换按钮绑定监听事件
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fontSet.dispose();
            }
        });
    }

    public static void changeAppearance(JTextArea textArea){
        if(textArea.getBackground() == Color.BLACK){
            textArea.setBackground(Color.WHITE);
            textArea.setForeground(Color.BLACK);
            textArea.setCaretColor(Color.BLACK);
        }else{
            textArea.setBackground(Color.BLACK);
            textArea.setForeground(Color.WHITE);
            textArea.setCaretColor(Color.WHITE);
        }
    }
}
