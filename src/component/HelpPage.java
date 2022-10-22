package component;


import javax.swing.*;

public class HelpPage extends JFrame{
    public HelpPage() {
        super("查看帮助");
        JPanel helpPane;
        helpPane=new JPanel();
        this.getContentPane().add(helpPane);

        //垂直显示
        BoxLayout layOut1=new BoxLayout(helpPane,BoxLayout.Y_AXIS);
        helpPane.setLayout(layOut1);

        JLabel label1 = new JLabel("1、文件操作支持：新建、打开、保存、另存为");
        JLabel label2 = new JLabel("2、文本编辑支持：剪切、复制、粘贴、删除、清空（支持快捷键Ctrl + x/c/v）");
        JLabel label3 = new JLabel("3、文本查看支持：查找与替换（支持快捷键Ctrl + f）、暗黑模式");
        JLabel label4 = new JLabel("4、文本格式支持：自动换行");
        JLabel label5 = new JLabel("5、字数统计支持：实时的中英文字数统计");
        JLabel label6 = new JLabel("6、感谢您的使用，祝您使用愉快！");


        helpPane.add(label1);
        helpPane.add(label2);
        helpPane.add(label3);
        helpPane.add(label4);
        helpPane.add(label5);
        helpPane.add(label6);
        this.add(helpPane);
        this.setSize(500, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
