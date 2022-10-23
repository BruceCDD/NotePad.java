package handler;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class FileHandler {
    public static void newFile() {
    }

    public static String openFile(JFrame window, JTextArea area) throws IOException {
        String fileName = null;
        FileDialog fileDialog = new FileDialog(window, "打开文件", FileDialog.LOAD);
        fileDialog.setFile("*.txt");
        fileDialog.setVisible(true);
        if (fileDialog.getFile() != null) {
            fileName = fileDialog.getDirectory() + fileDialog.getFile();// 获得文件名

            // 读取文件

            FileReader file_reader = new FileReader(fileName);// 此处必须要捕获异常
            BufferedReader br = new BufferedReader(file_reader);
            StringBuilder stringBuilder = new StringBuilder();
            while (br.ready())// 判断缓冲区是否为空，非空时返回true
            {
                int c = br.read();
                stringBuilder.append((char) c);
            }
            area.setText(stringBuilder.toString());
            br.close();
            file_reader.close();
            window.setTitle("记事本-" + fileName);
        }
        return fileName;
    }

    public static void save(JFrame window, String fileName, JTextArea area) {
        if (fileName != null) {
            try {
                File file = new File(fileName);
                FileWriter file_writer = new FileWriter(file);
                //将文件输出流包装进缓冲区
                BufferedWriter bw = new BufferedWriter(file_writer);
                PrintWriter pw = new PrintWriter(bw);

                pw.print(area.getText());
                pw.close();
                bw.close();
                file_writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            otherSave(window, area);
        }
    }

    public static void otherSave(JFrame window, JTextArea area) {
        FileDialog fileDialog = new FileDialog(window, "另存为", FileDialog.SAVE);
        fileDialog.setFile("*.txt");
        fileDialog.setVisible(true);
        if (fileDialog.getFile() != null) {
            // 写入文件
            FileWriter fw;
            try {
                fw = new FileWriter(fileDialog.getDirectory() + fileDialog.getFile());
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.print(area.getText());
                pw.close();
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void quit(JFrame window, String fileName, JTextArea area, String textContent) {
        if (!area.getText().equals(textContent)) {
            int result = JOptionPane.showConfirmDialog(null, "文件内容已改变，确认保存退出吗？", "警告", JOptionPane.YES_NO_CANCEL_OPTION);
            switch (result) {
                case JOptionPane.NO_OPTION:
                    window.dispose();
                    break;
                case JOptionPane.YES_OPTION:
                    save(window, fileName, area);
                    window.dispose();
                    break;
                case JOptionPane.CANCEL_OPTION:
                    break;
                default:
                    break;
            }
        } else {
            window.dispose();
        }
    }
}
