import listener.GlobalListener;
import listener.KeyListener;
import listener.WindowListener;

import javax.swing.*;

public class Note {
    public static void main(String[] args) {
        JFrame window = new JFrame("文本编辑器");
        JTextArea textArea = new JTextArea();
        GlobalListener globalListener = new GlobalListener(window, textArea);

        PopMenu popMenu = new PopMenu();
        popMenu.init(textArea, globalListener);

        MenuBar menuBar = new MenuBar();
        menuBar.init(window, globalListener);

        window.addWindowListener(new WindowListener(globalListener));
        textArea.addKeyListener(new KeyListener(globalListener));

        JScrollPane scrollPane = new JScrollPane(textArea);
        window.add(scrollPane);
        window.setSize(600, 500);
        window.setLocation(250, 250);
        window.setVisible(true);
    }
}
