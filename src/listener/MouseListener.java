package listener;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {

    private JPopupMenu popupMenu;

    public MouseListener(JPopupMenu popupMenu) {
        this.popupMenu = popupMenu;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mods = e.getModifiersEx();
        // 鼠标右键
        if ((mods & InputEvent.BUTTON3_DOWN_MASK) != 0) {
            // 弹出菜单
            popupMenu.show(e.getComponent(), e.getX(), e.getY());
        }
    }
}
