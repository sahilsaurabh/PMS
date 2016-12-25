
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.*;

public class addwarden extends JFrame implements ActionListener {

    private JPanel pnlHeader, pnlFooter, pnlBody, pnlGender, pnlBirthCal, pnlJoinCal;
    private JLabel lblHeading, lblId, lblName, lblBirthDate, lblGender, lblWardenRank, lblJoinDate, lblAddress, lblPhone;
    private JTextField txtId, txtName, txtAddress, txtPhone;
    private JComboBox cmbWardenRank, cmbBirthDate, cmbBirthMonth, cmbBirthYear, cmbJoinDate, cmbJoinMonth, cmbJoinYear;
    private ButtonGroup bgGender;
    private JRadioButton rdbMale, rdbFemale;
    private JButton btnAdd, btnClear, btnClose;
    private String[] WardenRank = {"Rank 5", "Rank 4", "Rank 3", "Rank 2", "Rank 1"};
    private String[] date = {"1", "2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    private String[] year = {"1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015"};
    private String[] month = {"1", "2","3","4","5","6","7","8","9","10","11","12"};
    private String ID, user, warden_name, gender, phone, address, rank, birth, birthdate, birthmonth, birthyear, join_on, joindate, joinmonth, joinyear;
    private Font f;

    public addwarden() {

        pnlHeader = new JPanel();
        pnlFooter = new JPanel();
        pnlBody = new JPanel();
        pnlGender = new JPanel();
        pnlBirthCal = new JPanel();
        pnlJoinCal = new JPanel();

        f = new Font("Tahoma", Font.BOLD, 12);

        lblHeading = new JLabel("ADD WARDEN DETAILS");
        lblId = new JLabel("Warden ID: ");
        lblName = new JLabel("Name: ");
        lblBirthDate = new JLabel("Birthdate: ");
        lblGender = new JLabel("Gender: ");
        lblWardenRank = new JLabel("Warden Rank: ");
        lblJoinDate = new JLabel("Joining Date: ");
        lblPhone = new JLabel("Phone: ");
        lblAddress = new JLabel("Address: ");

        txtId = new JTextField();
        txtName = new JTextField();
        txtPhone = new JTextField();
        txtAddress = new JTextField();

        cmbWardenRank = new JComboBox(WardenRank);
        cmbBirthDate = new JComboBox(date);
        cmbBirthMonth = new JComboBox(month);
        cmbBirthYear = new JComboBox(year);
        cmbJoinDate = new JComboBox(date);
        cmbJoinMonth = new JComboBox(month);
        cmbJoinYear = new JComboBox(year);

        bgGender = new ButtonGroup();
        rdbMale = new JRadioButton("Male");
        rdbFemale = new JRadioButton("Female");

        btnAdd = new JButton("Add");
        btnClear = new JButton("Clear");
        btnClose = new JButton("Close");
    }

    public void addWarden() {

        setSize(700, 600);
        setLocationRelativeTo(null);
        setTitle("Add Warden Detail");
        setResizable(false);
        setLayout(new BorderLayout(0, 0));
        addWindowListener(new WindowAdapterDemo());

        add(pnlHeader, BorderLayout.PAGE_START);
        add(pnlFooter, BorderLayout.PAGE_END);
        add(pnlBody, BorderLayout.CENTER);

        pnlBody.setLayout(new GridLayout(12, 2, 0, 5));
        pnlHeader.setBorder(new EmptyBorder(15, 10, 10, 15));
        pnlBody.setBorder(new EmptyBorder(10, 20, 20, 10));
        pnlFooter.setBorder(new EmptyBorder(15, 10, 10, 15));

        lblHeading.setFont(new Font("Tahoma", Font.BOLD, 30));
        pnlHeader.add(lblHeading);

        pnlBirthCal.add(cmbBirthDate);
        pnlBirthCal.add(cmbBirthMonth);
        pnlBirthCal.add(cmbBirthYear);

        pnlJoinCal.add(cmbJoinDate);
        pnlJoinCal.add(cmbJoinMonth);
        pnlJoinCal.add(cmbJoinYear);

        bgGender.add(rdbMale);
        bgGender.add(rdbFemale);

        pnlGender.add(rdbMale);
        pnlGender.add(rdbFemale);

        rdbMale.setActionCommand("Male");
        rdbFemale.setActionCommand("Female");

        pnlBody.add(lblId);
        pnlBody.add(txtId);
        pnlBody.add(lblName);
        pnlBody.add(txtName);
        pnlBody.add(lblBirthDate);
        pnlBody.add(pnlBirthCal);
        pnlBody.add(lblGender);
        pnlBody.add(pnlGender);
        pnlBody.add(lblPhone);
        pnlBody.add(txtPhone);
        pnlBody.add(lblAddress);
        pnlBody.add(txtAddress);
        pnlBody.add(lblWardenRank);
        pnlBody.add(cmbWardenRank);
        pnlBody.add(lblJoinDate);
        pnlBody.add(pnlJoinCal);

        lblId.setFont(f);
        lblName.setFont(f);
        lblBirthDate.setFont(f);
        lblGender.setFont(f);
        lblPhone.setFont(f);
        lblAddress.setFont(f);
        lblWardenRank.setFont(f);
        lblJoinDate.setFont(f);

        pnlFooter.add(btnAdd);
        btnAdd.setBackground(new Color(59, 89, 182));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnAdd.addActionListener(this);
        pnlFooter.add(btnClose);
        btnClose.setBackground(new Color(59, 89, 182));
        btnClose.setForeground(Color.WHITE);
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnClose.addActionListener(this);
        pnlFooter.add(btnClear);
        btnClear.setBackground(new Color(59, 89, 182));
        btnClear.setForeground(Color.WHITE);
        btnClear.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnClear.addActionListener(this);

        setVisible(true);
    }

    public void add() {

        ID = txtId.getText();
        warden_name = txtName.getText();
        birthdate = (String) cmbBirthDate.getSelectedItem();
        birthmonth = (String) cmbBirthMonth.getSelectedItem();
        birthyear = (String) cmbBirthYear.getSelectedItem();
        birth = birthdate + "/" + birthmonth + "/" + birthyear;
        gender = bgGender.getSelection().getActionCommand();
        rank = (String) cmbWardenRank.getSelectedItem();
        phone = txtPhone.getText();
        address = txtAddress.getText();
        joindate = (String) cmbJoinDate.getSelectedItem();
        joinmonth = (String) cmbJoinMonth.getSelectedItem();
        joinyear = (String) cmbJoinYear.getSelectedItem();
        join_on = joindate + "/" + joinmonth + "/" + joinyear;
        check();
    }

    void check() {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            System.out.println("Divers loaded successfully");
            Connection connect = DriverManager.getConnection("jdbc:odbc:PMS1");
            System.out.println("Connection established successfully");
            Statement state = connect.createStatement();
            String sql = "SELECT ID FROM warden WHERE ID=" + ID + "";
            ResultSet rs = state.executeQuery(sql);
            int r = 0;
            while (rs.next()) {
                user = rs.getString("ID");
                if (user.equals(ID)) {
                    r++;
                }
            }
            if (r == 1) {
                JOptionPane.showMessageDialog(null, "Warden ID already exist");
            } else {
                database();
            }
            rs.close();
            state.close();
            connect.close();

        } catch (Exception ae) {
            System.out.println("Exception found at " + ae);
        }

    }

    void database() {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            System.out.println("Divers loaded successfully");
            Connection connect1 = DriverManager.getConnection("jdbc:odbc:PMS1");
            System.out.println("Connection established successfully");
            Statement state1 = connect1.createStatement();
            String sql1 = "insert into warden (ID,warden_name,birth,gender,phone,address,rank,join_on) values ('" + ID + "','" + warden_name + "','" + birth + "','" + gender + "','" + phone + "','" + address + "','" + rank + "','" + join_on + "')";
            state1.execute(sql1);
            JOptionPane.showMessageDialog(null, "Record added Successfully");
            System.out.println("Statement executed successfully");
            state1.close();
            connect1.close();
        } catch (Exception ae) {
            System.out.println("Exception found at " + ae);
        }
    }

    void clear() {
        txtId.setText("");
        txtName.setText("");
        txtPhone.setText("");
        txtAddress.setText("");
        cmbWardenRank.setSelectedIndex(0);
        cmbBirthDate.setSelectedIndex(0);
        cmbBirthMonth.setSelectedIndex(0);
        cmbBirthYear.setSelectedIndex(0);
        cmbJoinDate.setSelectedIndex(0);
        cmbJoinMonth.setSelectedIndex(0);
        cmbJoinYear.setSelectedIndex(0);
        bgGender.clearSelection();
    }

    void close() {
        int result = JOptionPane.showConfirmDialog(null, "Close Add Warden Form ?", "Close", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();
            home h = new home();
            h.homepage();
        } else if (result == JOptionPane.NO_OPTION) {
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            add();
        } else if (e.getSource() == btnClose) {
            close();
        } else if (e.getSource() == btnClear) {
            clear();
        }

    }

    public class WindowAdapterDemo extends WindowAdapter {

        public void windowClosing(WindowEvent w) {
            close();
        }
    }

}
