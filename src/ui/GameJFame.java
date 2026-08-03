package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.util.Random;

public class GameJFame extends JFrame {

    //打乱后的数据数组
    int[][] date = new int[4][4];

    public GameJFame(){
        //初始化界面
        initJFame();

        //初始化菜单
        initJMenuBar();

        //初始化数据(打乱数据)
        initDate();

        //初始化图片
        initImage();

        //设置界面显示打开
        this.setVisible(true);
    }

    private void initDate() {
        //创造一维数组打乱
        int[] tempArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        //打乱一维数组
        for (int i = 0; i < tempArr.length; i++) {
            Random random = new Random();
            int tempIndex = random.nextInt(0,16);
            int temp = tempArr[i];
            tempArr[i] = tempArr[tempIndex];
            tempArr[tempIndex] = temp;
        }

        //将一维数组放入二维数组中
        int index = 0;
        for (int i = 0; i < date.length; i++) {
            for(int j = 0; j <date[i].length; j++){
                date[i][j] = tempArr[index];
                index++;
            }
        }
    }

    private void initImage() {
        //双重循环将图片添加
        int count = 0;
        for(int i = 0;i < 4;i++){
            for(int j = 0;j < 4 ;j++){
                //创造Imageicon同时创造JLaber管理容器，存放ImageIcon对象
                JLabel jLabel = new JLabel(new ImageIcon("D:\\JAVA\\project\\006\\image\\animal\\animal3\\"+date[i][j]+".jpg"));
                jLabel.setBounds(j * 105 + 83,i * 105 + 134,105,105);
                //给每个图片添加边框
                jLabel.setBorder(new BevelBorder(1));
                //将管理容器放入主界面
                this.getContentPane().add(jLabel);
            }
        }

        //先添加的图片在上方，所以此处背景图片要后添加
        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("D:\\JAVA\\project\\006\\image\\background.png"));
        background.setBounds(40,40,508,560);
        this.getContentPane().add(background);
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
        //关闭默认居中摆放
        this.setLayout(null);
        //设置画面关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
