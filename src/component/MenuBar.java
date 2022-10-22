package component;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {

    private final String[] FILE_ITEM = {"新建", "打开", "保存", "另存为", "退出"};
    private final String[] EDIT_ITEM = {"编辑", "复制", "剪切", "粘贴", "删除", "清空"};
    private final String[] VIEW_ITEM = {"查找和替换", "自动换行", "字体大小"};
    private static final String wordCountPrefix = "   字数统计：";


    private JLabel wordCount;
    private ActionListener actionListener;

    public MenuBar() {
    }

    public void init(JFrame window, ActionListener actionListener) {
        this.actionListener = actionListener;
        // 将菜单和相应的子菜单添加到菜单栏
        this.add(fileInit());
        this.add(editInit());
        this.add(viewInit());
        this.add(wordCountInit());
        window.setJMenuBar(this);
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

    private JLabel wordCountInit() {
        JLabel wordCount = new JLabel(wordCountPrefix + "0");
        this.wordCount = wordCount;
        return wordCount;
    }

    public void updateWordCount(int num) {
        wordCount.setText(wordCountPrefix + num);
    }

    private void itemBind(JMenu jMenu, String[] items) {
        for (String item : items) {
            JMenuItem jMenuItem = new JMenuItem(item);
            jMenuItem.addActionListener(actionListener);
            jMenu.add(jMenuItem);
        }
    }
}
