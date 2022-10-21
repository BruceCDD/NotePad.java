package listener;

import component.Window;
import handler.EditHandler;
import handler.FileHandler;
import handler.ViewHandler;

import javax.swing.*;
import java.awt.event.*;

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
            } else if (e.getActionCommand().equals("打开")) {
                fileName = FileHandler.openFile(window, textArea);
                textContent = textArea.getText();
            } else if (e.getActionCommand() == "保存") {
                FileHandler.save(window, fileName, textArea);
                textContent = textArea.getText();
            } else if (e.getActionCommand() == "另存为") {
                FileHandler.otherSave(window, textArea);
            } else if (e.getActionCommand() == "退出") {
                FileHandler.quit(window, fileName, textArea, textContent);
            } else if (e.getActionCommand() == "查找和替换") {
                ViewHandler.searchAndReplace(window, textArea);
            } else if (e.getActionCommand().equals("复制")) {
                EditHandler.copy(textArea);
            } else if (e.getActionCommand() == "粘贴") {
                EditHandler.paste(textArea);
            } else if (e.getActionCommand() == "剪切") {
                EditHandler.cut(textArea);
            } else if (e.getActionCommand() == "删除") {
                EditHandler.delete(textArea);
            } else if (e.getActionCommand() == "清空") {
                EditHandler.clear(textArea);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
