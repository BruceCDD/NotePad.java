import javax.swing.*;
import java.awt.event.ActionListener;

public class MenuBar {

    private final String[] FILE_ITEM = {"新建", "打开", "保存", "另存为", "退出"};
    private final String[] EDIT_ITEM = {"编辑", "复制", "剪切", "粘贴", "删除", "清空"};
    private final String[] VIEW_ITEM = {"查找和替换"};


    // 菜单栏
    private JMenuBar mb;
    private ActionListener actionListener;

    public MenuBar() {
        this.mb = new JMenuBar();
    }

    public void init(JFrame window, ActionListener actionListener) {
        this.actionListener = actionListener;
        // 将菜单和相应的子菜单添加到菜单栏
        mb.add(fileInit());
        mb.add(editInit());
        mb.add(viewInit());
        window.setJMenuBar(mb);
    }

    private JMenu fileInit() {
        JMenu file = new JMenu("文件");
        itemBind(file, FILE_ITEM);
        return file;
    }

    private JMenu editInit() {
        JMenu edit = new JMenu("编辑");
        itemBind(edit, EDIT_ITEM);
        return edit;
    }

    private JMenu viewInit() {
        JMenu view = new JMenu("查看");
        itemBind(view, VIEW_ITEM);
        return view;
    }

    private void itemBind(JMenu jMenu, String[] items) {
        for (String item : items) {
            JMenuItem jMenuItem = new JMenuItem(item);
            jMenuItem.addActionListener(actionListener);
            jMenu.add(jMenuItem);
        }
    }
}
