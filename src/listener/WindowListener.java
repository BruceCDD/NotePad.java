package listener;

import handler.FileHandler;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowListener extends WindowAdapter {

    private GlobalListener globalListener;

    public WindowListener(GlobalListener globalListener) {
        this.globalListener = globalListener;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (!globalListener.textArea.getText().equals(globalListener.textContent)) {
            int result = JOptionPane.showConfirmDialog(null, "文件内容已改变，确认保存退出吗？", "警告", JOptionPane.YES_NO_OPTION);
            switch (result) {
                case JOptionPane.NO_OPTION:
                    System.exit(0);
                    break;
                case JOptionPane.YES_OPTION:
                    FileHandler.save(globalListener.window, globalListener.fileName, globalListener.textArea);
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } else {
            System.exit(0);
        }
    }
}
