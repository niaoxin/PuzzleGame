package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFame extends JFrame implements KeyListener {

    //打乱后的数据数组
    int[][] date = new int[4][4];
    //记录空白图片的位置
    int nullx,nully;
    //胜利的数组
    int[][] win = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};

    String path = "image\\animal\\animal3\\";

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

        Random random = new Random();
        // 循环打乱，直到产生有解的排列
        do {
            for (int i = 0; i < tempArr.length; i++) {
                int tempIndex = random.nextInt(16);
                int temp = tempArr[i];
                tempArr[i] = tempArr[tempIndex];
                tempArr[tempIndex] = temp;
            }
        } while (!isSolvable(tempArr));  // 判断是否有解，无解则重新打乱

        //将一维数组放入二维数组中
        int index = 0;
        for (int i = 0; i < date.length; i++) {
            for(int j = 0; j <date[i].length; j++){
                if(tempArr[index] == 0){
                    nullx = i;
                    nully = j;
                }
                date[i][j] = tempArr[index];
                index++;
            }
        }
    }

    private void initImage() {
        //清除之前加载图片
        this.getContentPane().removeAll();

        if(Win()){
            //如果胜利将胜利图片放上面
            JLabel winjLabel = new JLabel(new ImageIcon("image\\win.png"));
            winjLabel.setBounds(203,283,197,73);
            this.getContentPane().add(winjLabel);
        }

        //双重循环将图片添加
        int count = 0;
        for(int i = 0;i < 4;i++){
            for(int j = 0;j < 4 ;j++){
                //创造Imageicon同时创造JLaber管理容器，存放ImageIcon对象
                JLabel jLabel = new JLabel(new ImageIcon(path + date[i][j] + ".jpg"));
                jLabel.setBounds(j * 105 + 83,i * 105 + 134,105,105);
                //给每个图片添加边框
                jLabel.setBorder(new BevelBorder(1));
                //将管理容器放入主界面
                this.getContentPane().add(jLabel);
            }
        }

        //先添加的图片在上方，所以此处背景图片要后添加
        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("image\\background.png"));
        background.setBounds(40,40,508,560);
        this.getContentPane().add(background);

        //刷新加载图片
        this.getContentPane().repaint();
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
        //设置在游戏画面中监听键盘
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //重写按键按下不松
    @Override
    public void keyPressed(KeyEvent e) {
        // 如果胜利要关闭功能
        if(Win()){
            return;
        }

        //按下a查看完整图片功能
        int code = e.getKeyCode();
        if(code == 65){
            //清除图片
            this.getContentPane().removeAll();

            //添加完整图片
            JLabel jLabel = new JLabel(new ImageIcon(path + "all.jpg"));
            jLabel.setBounds(83,134,420,420);
            this.getContentPane().add(jLabel);
            //添加背景图片
            JLabel background = new JLabel(new ImageIcon("image\\background.png"));
            background.setBounds(40,40,508,560);
            this.getContentPane().add(background);

            //刷新界面
            this.getContentPane().repaint();
        }
    }

    //重写按键松开，来控制方向
    @Override
    public void keyReleased(KeyEvent e) {
        //如果获胜则要立即停止操作
        if(Win()){
            return;
        }

        //用code来接受监听
        int code = e.getKeyCode();
        //左 37 上. 38 右 39 下 40
        //移动就是空白图片相反移动,要注意边界情况
        if(code == 37){
            if(nully - 1 >= 0 ){
                date[nullx][nully] = date[nullx][nully-1];
                date[nullx][nully-1] = 0;
                nully = nully - 1;
                initImage();
            }
        }else if(code == 38){
            if(nullx - 1 >= 0 ){
                date[nullx][nully] = date[nullx-1][nully];
                date[nullx-1][nully] = 0;
                nullx = nullx - 1;
                initImage();
            }
        }else if(code == 39){
            if(nully + 1 < 4){
                date[nullx][nully] = date[nullx][nully+1];
                date[nullx][nully+1] = 0;
                nully = nully + 1;
                initImage();
            }
        }else if(code == 40){
            if(nullx + 1 < 4){
                date[nullx][nully] = date[nullx+1][nully];
                date[nullx+1][nully] = 0;
                nullx = nullx + 1;
                initImage();
            }
        }else if(code == 65){
            //松开a恢复原来图片
            initImage();
        }else if(code == 87){
            //作弊码按下 w 即可一键通关
            date = new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
            initImage();
        }
    }

    /**
     * 判断当前排列是否有解
     * 规则：(逆序对数量 + 空白块从下往上数的行号) 为偶数则有解
     */
    private boolean isSolvable(int[] arr) {
        // 1. 计算逆序对数量（排除0）
        int inversions = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) continue;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == 0) continue;
                if (arr[i] > arr[j]) {
                    inversions++;
                }
            }
        }

        // 2. 找到空白块(0)的位置，计算从下往上的行号(1~4)
        int blankIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                blankIndex = i;
                break;
            }
        }
        int blankRow = 4 - (blankIndex / 4);  // 从下往上数，最下面是第1行

        // 3. 和为偶数则有解
        return (inversions + blankRow) % 2 == 0;
    }

    //检查排序正确
    private boolean Win(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(win[i][j] != date[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
