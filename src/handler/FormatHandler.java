package handler;

import javax.swing.*;

public class FormatHandler {
    public static void changeLineWrap(JTextArea textArea) {
        textArea.setLineWrap(!textArea.getLineWrap());
    }
}
