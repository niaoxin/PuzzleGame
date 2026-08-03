package ui;

import javax.swing.*;

public class RegisterJFame extends JFrame {
    public RegisterJFame(){
        //设置画面高和宽
        this.setSize(488,500);
        //设置界面标题
        this.setTitle("拼图 注册");
        //设置画面置顶
        this.setAlwaysOnTop(true);
        //设置画面保持居中
        this.setLocationRelativeTo(null);
        //设置画面关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //设置界面显示打开
        this.setVisible(true);
    }
}
