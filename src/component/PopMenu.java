package component;

import listener.GlobalListener;
import listener.MouseListener;

import javax.swing.*;

public class PopMenu {

    private final String[] POP_ITEM = {"复制", "剪切", "粘贴", "删除", "清空"};

    public void init(JTextArea textArea, GlobalListener globalListener) {
        JPopupMenu popupMenu = new JPopupMenu();
        for (String item : POP_ITEM) {
            JMenuItem jMenuItem = new JMenuItem(item);
            popupMenu.add(jMenuItem);
            jMenuItem.addActionListener(globalListener);
        }
        textArea.add(popupMenu);
        textArea.addMouseListener(new MouseListener(popupMenu));
    }
}
