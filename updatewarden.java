

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.*;

public class updatewarden extends JFrame implements ActionListener {

    private JPanel pnlHeader, pnlFooter, pnlBody, pnlGender, pnlBirthCal, pnlJoinCal;
    private JLabel lblHeading, lblId, lblName, lblBirthDate, lblGender, lblWardenRank, lblJoinDate, lblAddress, lblPhone;
    private JTextField txtId, txtName, txtAddress, txtPhone;
    private JComboBox cmbWardenRank, cmbBirthDate, cmbBirthMonth, cmbBirthYear, cmbJoinDate, cmbJoinMonth, cmbJoinYear;
    private ButtonGroup bgGender;
    private JRadioButton rdbMale, rdbFemale;
    private JButton btnFind, btnEdit, btnUpdate, btnDelete, btnClear, btnCancel, btnClose;
    private String[] WardenRank = {"Rank 5", "Rank 4", "Rank 3", "Rank 2", "Rank 1"};
    private String[] date = {"1", "2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    private String[] year = {"1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015"};
    private String[] month = {"1", "2","3","4","5","6","7","8","9","10","11","12"};
    private String ID, user, warden_name, gender, phone, address, rank, birth, birthdate, birthmonth, birthyear, join_on, joindate, joinmonth, joinyear;
    private Font f;

    public updatewarden() {
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

        btnFind = new JButton("Find");
        btnEdit = new JButton("Edit");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnClear = new JButton("Clear");
        btnCancel = new JButton("Cancel");
        btnClose = new JButton("Close");
    }

    public void updateWarden() {

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

        pnlFooter.add(btnFind);
        btnFind.setBackground(new Color(59, 89, 182));
        btnFind.setForeground(Color.WHITE);
        btnFind.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnFind.addActionListener(this);
        pnlFooter.add(btnEdit);
        btnEdit.setBackground(new Color(59, 89, 182));
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnEdit.addActionListener(this);
        pnlFooter.add(btnUpdate);
        btnUpdate.setBackground(new Color(59, 89, 182));
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnUpdate.addActionListener(this);
        pnlFooter.add(btnDelete);
        btnDelete.setBackground(new Color(59, 89, 182));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnDelete.addActionListener(this);
        pnlFooter.add(btnCancel);
        btnCancel.setBackground(new Color(59, 89, 182));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnCancel.addActionListener(this);
        pnlFooter.add(btnClear);
        btnClear.setBackground(new Color(59, 89, 182));
        btnClear.setForeground(Color.WHITE);
        btnClear.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnClear.addActionListener(this);
        pnlFooter.add(btnClose);
        btnClose.setBackground(new Color(59, 89, 182));
        btnClose.setForeground(Color.WHITE);
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnClose.addActionListener(this);
        disabled();
        setVisible(true);
    }

    void disabled() {

        txtId.setEnabled(true);
        txtName.setEnabled(false);
        txtPhone.setEnabled(false);
        txtAddress.setEnabled(false);

        cmbWardenRank.setEnabled(false);
        cmbBirthDate.setEnabled(false);
        cmbBirthMonth.setEnabled(false);
        cmbBirthYear.setEnabled(false);
        cmbJoinDate.setEnabled(false);
        cmbJoinMonth.setEnabled(false);
        cmbJoinYear.setEnabled(false);

        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        btnCancel.setEnabled(false);

    }

    void enabled() {

        txtId.setEnabled(false);
        txtAddress.setEnabled(true);
        txtPhone.setEnabled(true);
        cmbWardenRank.setEnabled(true);
        btnUpdate.setEnabled(true);
        btnCancel.setEnabled(true);

    }

    void find() {
        ID = txtId.getText();
        if (ID.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Warden ID");
        } else {
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); // Load JDBC Driver
                System.out.println("Divers loaded successfully");
                Connection connect = DriverManager.getConnection("jdbc:odbc:PMS1"); //Connect to databse through ODBC Data Source
                System.out.println("Connection established successfully"); //Create MySQL Statement
                Statement state = connect.createStatement();
                String sql = "SELECT * FROM warden WHERE ID=" + ID + "";
                ResultSet rs = state.executeQuery(sql);    //Execute MySQL Statement
                int r = 0;
                while (rs.next()) {

                    user = rs.getString("ID");
                    if (user.equals(ID)) {
                        r++;

						//retrive the data and show in the form
                        txtName.setText(rs.getString("warden_name"));
                        String dateofbirth = rs.getString("birth");
                        String birthdate = dateofbirth.substring(8, 10);
                        String birthmonth = dateofbirth.substring(5, 7);
                        String birthyear = dateofbirth.substring(0, 4);
                        cmbBirthDate.setSelectedItem(birthdate);
                        cmbBirthMonth.setSelectedItem(birthmonth);
                        cmbBirthYear.setSelectedItem(birthyear);
                        String gen = rs.getString("gender");
                        if (gen.equals("Male")) {
                            rdbMale.setSelected(true);
                        } else {
                            rdbFemale.setSelected(true);
                        }
                        txtPhone.setText(rs.getString("phone"));
                        txtAddress.setText(rs.getString("address"));
                        cmbWardenRank.setSelectedItem(rs.getString("rank"));
                        String dateofjoin = rs.getString("join_on");
                        String joindate = dateofjoin.substring(8, 10);
                        String joinmonth = dateofjoin.substring(5, 7);
                        String joinyear = dateofjoin.substring(0, 4);
                        cmbJoinDate.setSelectedItem(joindate);
                        cmbJoinMonth.setSelectedItem(joinmonth);
                        cmbJoinYear.setSelectedItem(joinyear);
                        btnEdit.setEnabled(true);
                        btnDelete.setEnabled(true);

                    }
                }
                if (r == 1) {
                    JOptionPane.showMessageDialog(null, "Warden found");
                } else {
                    JOptionPane.showMessageDialog(null, "Warden ID does not exist");
                }
                rs.close();
                state.close();
                connect.close();

            } catch (Exception f) {
                System.out.println("Exception found at " + f);
            }
        }
    }

    void update() {

		//get text from input fields and store it into a string
        phone = txtPhone.getText();
        address = txtAddress.getText();
        rank = (String) cmbWardenRank.getSelectedItem();

        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); // Load JDBC Driver
            System.out.println("Divers loaded successfully");
            Connection connect = DriverManager.getConnection("jdbc:odbc:PMS1"); //Connect to databse through ODBC Data Source
            System.out.println("Connection established successfully");
            Statement state = connect.createStatement();//Create MySQL Statement
            String sql = "UPDATE warden SET phone= '" + phone + "', address= '" + address + "', rank= '" + rank + "' WHERE ID= '" + ID + "'";  //Set MySQL Command
            state.executeUpdate(sql);    //Execute MySQL Statement
            JOptionPane.showMessageDialog(null, "Record updated Successfully");
            System.out.println("Statement executed successfully");
            state.close();
            connect.close();
        } catch (Exception u) {
            System.out.println("Exception found at " + u);
        }
        disabled();

    }

    void delete() {

        ID = txtId.getText();
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); // Load JDBC Driver
            System.out.println("Divers loaded successfully");
            Connection connect = DriverManager.getConnection("jdbc:odbc:PMS1"); //Connect to databse through ODBC Data Source
            System.out.println("Connection established successfully");
            Statement state = connect.createStatement(); //Create MySQL Statement
            String sql = "delete from warden where ID=" + ID + ""; //Set MySQL Command
            state.execute(sql);                                    //Execute MySQL Statement
            JOptionPane.showMessageDialog(null, "Record deleted Successfully");
            System.out.println("Statement executed successfully");
            state.close();
            connect.close();
        } catch (Exception d) {
            System.out.println("Exception found at " + d);
        }

        clear();

    }

    void close() {
        int result = JOptionPane.showConfirmDialog(null, "Close Update Prisoner Form ?", "Close", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();      // Dispose this frame and go to main page.
            home h = new home();
            h.homepage();

        } else if (result == JOptionPane.NO_OPTION) {
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }

    void clear() {
        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtPhone.setText("");
        cmbWardenRank.setSelectedIndex(0);
        cmbBirthDate.setSelectedItem("Select Date");
        cmbBirthMonth.setSelectedItem("Select Month");
        cmbBirthYear.setSelectedItem("Select Year");
        cmbJoinDate.setSelectedItem("Select Date");
        cmbJoinMonth.setSelectedItem("Select Month");
        cmbJoinYear.setSelectedItem("Select Year");
        disabled();

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnFind) {
            find();
        } else if (e.getSource() == btnEdit) {
            enabled();
            btnFind.setEnabled(false);
            btnDelete.setEnabled(false);
            btnEdit.setEnabled(false);
        } else if (e.getSource() == btnUpdate) {
            update();
        } else if (e.getSource() == btnDelete) {
            delete();
        } else if (e.getSource() == btnClose) {
            close();
        } else if (e.getSource() == btnClear) {
            clear();
        } else if (e.getSource() == btnCancel) {
            disabled();
            btnFind.setEnabled(true);
            btnDelete.setEnabled(true);
        }

    }

    public class WindowAdapterDemo extends WindowAdapter {

        public void windowClosing(WindowEvent w) {
            close();
        }
    }
}
