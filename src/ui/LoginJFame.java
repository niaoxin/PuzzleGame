package ui;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class LoginJFame extends JFrame implements MouseListener {

    //随机验证码
    String CodeCode = RandomCode();
    String user = "niaoxin";
    String possworduser = "147258369";

    public LoginJFame(){
        //初始化界面
        initJFame();
        
        //初始化图片
        iniImgae();
        
        //设置界面显示打开
        this.setVisible(true);
    }

    private void iniImgae() {
        //清除之前图片
        this.getContentPane().removeAll();

        //用户名功能
        JLabel name = new JLabel(new ImageIcon("image\\login\\用户名.png"));
        name.setBounds(120,140,47,17);
        this.getContentPane().add(name);
        JTextField usetname = new JTextField();
        usetname.setBounds(200,135,200,35);
        this.getContentPane().add(usetname);

        //密码功能
        JLabel password = new JLabel(new ImageIcon("image\\login\\密码.png"));
        password.setBounds(120,190,32,16);
        this.getContentPane().add(password);
        JPasswordField userpassword = new JPasswordField();
        userpassword.setBounds(200,185,200,35);
        this.getContentPane().add(userpassword);

        //验证码功能
        JLabel code = new JLabel(new ImageIcon("image\\login\\验证码.png"));
        code.setBounds(120,240,56,21);
        this.getContentPane().add(code);
        JTextField usercode = new JTextField();
        usercode.setBounds(200,235,110,35);
        this.getContentPane().add(usercode);

        //添加随机验证码
        JLabel RandomCode = new JLabel(CodeCode);
        RandomCode.setBounds(330,235,55,35);
        this.getContentPane().add(RandomCode);

        //添加鼠标刷新验证码功能
        RandomCode.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CodeCode = RandomCode();
                RandomCode.setText(CodeCode);
                usercode.setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //添加登录和注册按钮
        JLabel loginbutton = new JLabel(new ImageIcon("image\\login\\登录按钮.png"));
        loginbutton.setBounds(110,300,128,47);
        this.getContentPane().add(loginbutton);
        //添加登录监听
        loginbutton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                loginbutton.setIcon(new ImageIcon("image\\login\\登录按下.png"));
                if(user.equals(usetname.getText()) && possworduser.equals(new String(userpassword.getPassword())) &&
                usercode.getText().equalsIgnoreCase(CodeCode)){
                    new GameJFame();
                    setVisible(false);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                loginbutton.setIcon(new ImageIcon("image\\login\\登录按钮.png"));
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JLabel registerbutton = new JLabel(new ImageIcon("image\\login\\注册按钮.png"));
        registerbutton.setBounds(270,300,128,47);
        this.getContentPane().add(registerbutton);
        //添加注册监听
        registerbutton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                registerbutton.setIcon(new ImageIcon("image\\login\\注册按下.png"));
                new RegisterJFame();
                setVisible(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                registerbutton.setIcon(new ImageIcon("image\\login\\注册按钮.png"));
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("image\\login\\background.png"));
        background.setBounds(0,0,470,390);
        this.getContentPane().add(background);

        //刷新图片
        this.getContentPane().repaint();
    }

    private void initJFame() {
        //设置画面高和宽
        this.setSize(488,430);
        //设置界面标题
        this.setTitle("拼图 登录");
        //设置画面置顶
        this.setAlwaysOnTop(true);
        //设置画面保持居中
        this.setLocationRelativeTo(null);
        //设置画面关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private String RandomCode() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            code.append(chars.charAt(random.nextInt(chars.length())));
        }
        return code.toString();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
