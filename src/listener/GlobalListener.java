package listener;

import component.HelpPage;
import component.Window;
import handler.EditHandler;
import handler.FileHandler;
import handler.ViewHandler;

import javax.swing.*;
import java.awt.event.*;
import java.util.Objects;

public class GlobalListener implements ActionListener {

    public JFrame window;
    public JTextArea textArea;
    public String fileName; // 打开的文件名
    public String textContent = "";// 编辑框中的内容


    public GlobalListener(JFrame window, JTextArea textArea) {
        this.window = window;
        this.textArea = textArea;
//        this.window.addWindowListener(new WindowListener(this));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getActionCommand().equals("新建")) {
//                FileHandler.newFile();
                Window.newWindow();
            } else if (Objects.equals(e.getActionCommand(), "打开")) {
                fileName = FileHandler.openFile(window, textArea);
                textContent = textArea.getText();
            } else if (Objects.equals(e.getActionCommand(), "保存")) {
                FileHandler.save(window, fileName, textArea);
                textContent = textArea.getText();
            } else if (Objects.equals(e.getActionCommand(), "另存为")) {
                FileHandler.otherSave(window, textArea);
            } else if (Objects.equals(e.getActionCommand(), "退出")) {
                FileHandler.quit(window, fileName, textArea, textContent);
            } else if (Objects.equals(e.getActionCommand(), "查找和替换")) {
                ViewHandler.searchAndReplace(window, textArea);
            } else if (Objects.equals(e.getActionCommand(), "暗黑模式")) {
                ViewHandler.changeAppearance(textArea);
            } else if (Objects.equals(e.getActionCommand(), "复制")) {
                EditHandler.copy(textArea);
            } else if (Objects.equals(e.getActionCommand(), "粘贴")) {
                EditHandler.paste(textArea);
            } else if (Objects.equals(e.getActionCommand(), "剪切")) {
                EditHandler.cut(textArea);
            } else if (Objects.equals(e.getActionCommand(), "删除")) {
                EditHandler.delete(textArea);
            } else if (Objects.equals(e.getActionCommand(), "清空")) {
                EditHandler.clear(textArea);
            } else if (Objects.equals(e.getActionCommand(), "查看帮助")) {
                new HelpPage();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
