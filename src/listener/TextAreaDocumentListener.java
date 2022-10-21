package listener;

import component.MenuBar;
import utils.StringUtils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextAreaDocumentListener implements DocumentListener {

    private GlobalListener globalListener;

    public TextAreaDocumentListener(GlobalListener globalListener) {
        this.globalListener = globalListener;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        doUpdate();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        doUpdate();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        doUpdate();
    }

    private void doUpdate() {
        JMenuBar jMenuBar = globalListener.window.getJMenuBar();
        if (jMenuBar instanceof MenuBar) {
            MenuBar menuBar = (MenuBar) jMenuBar;
            int length = StringUtils.wordCount(globalListener.textArea.getText());
            menuBar.updateWordCount(length);
        }
    }
}
