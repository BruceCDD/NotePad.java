package listener;

import handler.FileHandler;
import handler.ViewHandler;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

    private GlobalListener globalListener;

    public KeyListener(GlobalListener globalListener) {
        this.globalListener = globalListener;
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        //ctrl+f实现查找功能
        if ((ke.getKeyCode() == KeyEvent.VK_F) && (ke.isControlDown())) {
            ViewHandler.searchAndReplace(globalListener.window, globalListener.textArea);
        }
        //esc退出
        if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (!globalListener.textArea.getText().equals(globalListener.textContent)) {
                int result = JOptionPane.showConfirmDialog(null, "文件内容已改变，确认保存退出吗？", "警告", 1);
                switch (result) {
                    case JOptionPane.NO_OPTION:
                        System.exit(0);
                        break;
                    case JOptionPane.YES_OPTION:
                        FileHandler.save(globalListener.window, globalListener.fileName, globalListener.textArea);
                        System.exit(0);
                        break;
                    case JOptionPane.CANCEL_OPTION:
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
