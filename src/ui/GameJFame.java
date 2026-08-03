package ui;

import javax.swing.*;

public class GameJFame extends JFrame {

    public GameJFame(){
        //初始化界面
        initJFame();

        //初始化菜单
        initJMenuBar();

        //初始化图片
        initImage();

        //设置界面显示打开
        this.setVisible(true);
    }

    private void initImage() {

        //创造图片ImageIcon对象
        ImageIcon icon = new ImageIcon("D:\\JAVA\\project\\006\\image\\animal\\animal3\\3.jpg");
        //创造JLaber容器，存放ImageIcon对象
        JLabel jLabel = new JLabel(icon);

        this.add(jLabel);

    }


    private void initJMenuBar() {
        //初始化菜单界面
        JMenuBar jMenuBar = new JMenuBar();

        //菜单的两个选项
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        //每个选项下的菜单
        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reloginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem accountItem = new JMenuItem("公众号");

        //每个选项添加菜单
        functionJMenu.add(replayItem);
        functionJMenu.add(reloginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        //将两个选项添加到总菜单
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //把总界面里添加总菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFame() {
        //设置界面高和宽
        this.setSize(603,680);
        //设置界面标题
        this.setTitle("拼图小游戏 v0.1");
        //设置画面置顶
        this.setAlwaysOnTop(true);
        //设置画面保持居中
        this.setLocationRelativeTo(null);
        //设置画面关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
