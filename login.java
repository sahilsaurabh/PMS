

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class login extends JFrame implements ActionListener {

    private JLabel lblLogin, lblUserName, lblPassword;
    private JTextField txtUserName;
    private JPasswordField passwordField;
    private JButton btnLogin, btnCancel;
    private String txt, psd, user, passwrd;
    private Font f;

    public login() {

        lblLogin = new JLabel("PMS LOGIN");
        lblUserName = new JLabel("User ID: ");
        lblPassword = new JLabel("Password: ");

        txtUserName = new JTextField();

        passwordField = new JPasswordField();

        f = new Font("Tahoma", Font.BOLD, 12);

        btnLogin = new JButton("Login");
        btnCancel = new JButton("Cancel");
    }

    public void loginpage() {

        setSize(400, 400);
        setLocationRelativeTo(null);
        setTitle("PRISON MANAGEMENT SYSTEM");
        setResizable(false);
        setLayout(null);
        addWindowListener(new WindowAdapterDemo());

        lblLogin.setBounds(100, 50, 200, 50);
        lblLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(lblLogin);

        lblUserName.setBounds(80, 164, 75, 25);
        add(lblUserName);

        txtUserName.setBounds(200, 165, 150, 25);
        add(txtUserName);

        lblPassword.setBounds(80, 215, 75, 25);
        add(lblPassword);

        passwordField.setBounds(200, 215, 150, 25);
        add(passwordField);

        lblUserName.setFont(f);
        lblPassword.setFont(f);

        btnLogin.setBounds(90, 300, 100, 25);
        add(btnLogin);
        btnLogin.setBackground(new Color(59, 89, 182));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnLogin.addActionListener(this);

        btnCancel.setBounds(200, 300, 100, 25);
        add(btnCancel);
        btnCancel.setBackground(new Color(59, 89, 182));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnCancel.addActionListener(this);
        setVisible(true);
    }

    void database() {
        txt = txtUserName.getText();
        psd = passwordField.getText();
        if (txt.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter User ID");
        } else if (psd.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Password");
        } else {
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                System.out.println("Divers loaded successfully");
                Connection connect = DriverManager.getConnection("jdbc:odbc:PMS1");
                System.out.println("Connection established successfully");
                Statement state = connect.createStatement();
                String sql = "SELECT uID,password FROM login WHERE uID=" + txt + "";
                ResultSet rs = state.executeQuery(sql);
                int r = 0;
                while (rs.next()) {
                    passwrd = rs.getString("password");
                    user = rs.getString("uID");
                    if (user.equals(txt)) {
                        r++;
                    }
                }
                if (r == 1) {
                    if (passwrd.equals(psd)) {
                        JOptionPane.showMessageDialog(null, "Login Sucessfull");
                        home h = new home();
                        h.homepage();
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect Password");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "User not found");
                }
                rs.close();
                state.close();
                connect.close();

            } catch (Exception ae) {
                System.out.println("Exception found at " + ae);
            }
        }
    }

    void close() {
        int result = JOptionPane.showConfirmDialog(null, "Are You Sure ?", "EXIT", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else if (result == JOptionPane.NO_OPTION) {
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            database();

        } else if (e.getSource() == btnCancel) {
            close();
        }

    }

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception l) {
            System.out.println("Exception found at " + l);
        }
        login l = new login();
        l.loginpage();
    }

    public class WindowAdapterDemo extends WindowAdapter {

        public void windowClosing(WindowEvent w) {
            close();
        }
    }
}
