package handler;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;

public class EditHandler {

    public static void copy(JTextArea textArea){
        if (textArea.getSelectedText() == null) {
            JOptionPane.showMessageDialog(null, "你没有选中任何文字！", "记事本", JOptionPane.WARNING_MESSAGE);
        }
        Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(textArea.getSelectedText());
        clipBoard.setContents(stringSelection, null);
    }

    public static void paste(JTextArea textArea) throws IOException, UnsupportedFlavorException {
        String content_copy = "";
        // 构造系统剪切板
        Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();

        // 获取剪切板内容
        Transferable content = clipBoard.getContents(null);

        if (content != null) {
            // 检查是否是文本类型
            if (content.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                content_copy = (String) content.getTransferData(DataFlavor.stringFlavor);

                // 判断文本框中有无文字选中
                if (textArea.getSelectedText() != null) {
                    textArea.replaceSelection(content_copy);
                } else {
                    textArea.insert(content_copy, textArea.getSelectionStart());
                }
            }
        }
    }

    public static void cut(JTextArea textArea) {
        copy(textArea);
        delete(textArea);
    }

    public static void delete(JTextArea textArea) {
        textArea.replaceSelection("");
    }

    public static void clear(JTextArea textArea) {
        int result = JOptionPane.showConfirmDialog(null, "确认清空所有文字吗？", "警告", 1);
        if (result == JOptionPane.OK_OPTION) {
//						myarea.replaceRange(null,0,textContent.length());
            textArea.setText(null);
        }
    }
}
