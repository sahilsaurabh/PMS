

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.*;

public class updateprisoner extends JFrame implements ActionListener {

    private JPanel pnlHeader, pnlFooter, pnlBody, pnlGender, pnlCellSharing, pnlBirthCal, pnlJoinCal, pnlReleaseCal;
    private JLabel lblHeading, lblId, lblName, lblBirthDate, lblGender, lblCrimeDetails, lblSentenceDetails, lblWardenAssign, lblSecurityLevel, lblCellSharing, lblJoinDate, lblReleaseDate;
    private JTextField txtId, txtName, txtCrimeDetails, txtSentenceDetails;
    private JComboBox cmbWardenAssign, cmbSecurityLevel, cmbBirthDate, cmbBirthMonth, cmbBirthYear, cmbJoinDate, cmbJoinMonth, cmbJoinYear, cmbReleaseDate, cmbReleaseMonth, cmbReleaseYear;
    private ButtonGroup bgGender, bgCellSharing;
    private JRadioButton rdbMale, rdbFemale, rdbYes, rdbNo;
    private JButton btnFind, btnEdit, btnUpdate, btnDelete, btnRelease, btnClear, btnCancel, btnClose;
    private String[] SecurityLevel = {"High Security", "Low Security"};
    private String[] date = {"1", "2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    private String[] year = {"1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015"};
    private String[] month = {"1", "2","3","4","5","6","7","8","9","10","11","12"};
    private String ID, ward, user, prisoner_name, birthdate, birthmonth, birthyear, gender, crime, sentence, warden, security, cell_sharing, joindate, joinmonth, joinyear, release_on, releasedate, releasemonth, releaseyear;
    private Font f;

    public updateprisoner() {

        pnlHeader = new JPanel();
        pnlFooter = new JPanel();
        pnlBody = new JPanel();
        pnlGender = new JPanel();
        pnlCellSharing = new JPanel();
        pnlBirthCal = new JPanel();
        pnlJoinCal = new JPanel();
        pnlReleaseCal = new JPanel();

        f = new Font("Tahoma", Font.BOLD, 12);

        lblHeading = new JLabel("UPDATE PRISONER DETAILS");
        lblId = new JLabel("Prisoner ID: ");
        lblName = new JLabel("Name: ");
        lblBirthDate = new JLabel("Birthdate: ");
        lblGender = new JLabel("Gender: ");
        lblCrimeDetails = new JLabel("Crime Details: ");
        lblSentenceDetails = new JLabel("Sentence Details: ");
        lblWardenAssign = new JLabel("Warden Assign: ");
        lblSecurityLevel = new JLabel("Security Level: ");
        lblCellSharing = new JLabel("Cell Sharing: ");
        lblJoinDate = new JLabel("Joining Date: ");
        lblReleaseDate = new JLabel("Release Date: ");

        txtId = new JTextField();
        txtName = new JTextField();
        txtCrimeDetails = new JTextField();
        txtSentenceDetails = new JTextField();

        cmbWardenAssign = new JComboBox();
        cmbSecurityLevel = new JComboBox(SecurityLevel);
        cmbBirthDate = new JComboBox(date);
        cmbBirthMonth = new JComboBox(month);
        cmbBirthYear = new JComboBox(year);
        cmbJoinDate = new JComboBox(date);
        cmbJoinMonth = new JComboBox(month);
        cmbJoinYear = new JComboBox(year);
        cmbReleaseDate = new JComboBox(date);
        cmbReleaseMonth = new JComboBox(month);
        cmbReleaseYear = new JComboBox(year);

        bgGender = new ButtonGroup();
        bgCellSharing = new ButtonGroup();
        rdbMale = new JRadioButton("Male");
        rdbFemale = new JRadioButton("Female");
        rdbYes = new JRadioButton("Yes");
        rdbNo = new JRadioButton("No");

        btnFind = new JButton("Find");
        btnEdit = new JButton("Edit");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnRelease = new JButton("Release");
        btnClear = new JButton("Clear");
        btnCancel = new JButton("Cancel");
        btnClose = new JButton("Close");
    }

    public void updatePrisoner() {

        setSize(700, 600);
        setLocationRelativeTo(null);
        setTitle("Update Prisoner Detail");
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

        pnlReleaseCal.add(cmbReleaseDate);
        pnlReleaseCal.add(cmbReleaseMonth);
        pnlReleaseCal.add(cmbReleaseYear);

        bgGender.add(rdbMale);
        bgGender.add(rdbFemale);
        bgCellSharing.add(rdbYes);
        bgCellSharing.add(rdbNo);

        pnlGender.add(rdbMale);
        pnlGender.add(rdbFemale);
        pnlCellSharing.add(rdbYes);
        pnlCellSharing.add(rdbNo);

        rdbMale.setActionCommand("Male");
        rdbFemale.setActionCommand("Female");
        rdbYes.setActionCommand("Yes");
        rdbNo.setActionCommand("No");

        pnlBody.add(lblId);
        pnlBody.add(txtId);
        pnlBody.add(lblName);
        pnlBody.add(txtName);
        pnlBody.add(lblBirthDate);
        pnlBody.add(pnlBirthCal);
        pnlBody.add(lblGender);
        pnlBody.add(pnlGender);
        pnlBody.add(lblCrimeDetails);
        pnlBody.add(txtCrimeDetails);
        pnlBody.add(lblSentenceDetails);
        pnlBody.add(txtSentenceDetails);
        pnlBody.add(lblWardenAssign);
        pnlBody.add(cmbWardenAssign);
        pnlBody.add(lblSecurityLevel);
        pnlBody.add(cmbSecurityLevel);
        pnlBody.add(lblCellSharing);
        pnlBody.add(pnlCellSharing);
        pnlBody.add(lblJoinDate);
        pnlBody.add(pnlJoinCal);
        pnlBody.add(lblReleaseDate);
        pnlBody.add(pnlReleaseCal);

        lblId.setFont(f);
        lblName.setFont(f);
        lblBirthDate.setFont(f);
        lblGender.setFont(f);
        lblCrimeDetails.setFont(f);
        lblSentenceDetails.setFont(f);
        lblWardenAssign.setFont(f);
        lblSecurityLevel.setFont(f);
        lblCellSharing.setFont(f);
        lblJoinDate.setFont(f);
        lblReleaseDate.setFont(f);

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
        pnlFooter.add(btnRelease);
        btnRelease.setBackground(new Color(59, 89, 182));
        btnRelease.setForeground(Color.WHITE);
        btnRelease.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnRelease.addActionListener(this);
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
        txtCrimeDetails.setEnabled(false);
        txtSentenceDetails.setEnabled(false);

        cmbWardenAssign.setEnabled(false);
        cmbSecurityLevel.setEnabled(false);
        cmbBirthDate.setEnabled(false);
        cmbBirthMonth.setEnabled(false);
        cmbBirthYear.setEnabled(false);
        cmbJoinDate.setEnabled(false);
        cmbJoinMonth.setEnabled(false);
        cmbJoinYear.setEnabled(false);
        cmbReleaseDate.setEnabled(false);
        cmbReleaseMonth.setEnabled(false);
        cmbReleaseYear.setEnabled(false);

        rdbMale.setEnabled(false);
        rdbFemale.setEnabled(false);
        rdbYes.setEnabled(false);
        rdbNo.setEnabled(false);

        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        btnRelease.setEnabled(false);
        btnCancel.setEnabled(false);

    }

    void enabled() {

        txtId.setEnabled(false);
        txtCrimeDetails.setEnabled(true);
        txtSentenceDetails.setEnabled(true);
        cmbWardenAssign.setEnabled(true);
        cmbSecurityLevel.setEnabled(true);
        cmbReleaseDate.setEnabled(true);
        cmbReleaseMonth.setEnabled(true);
        cmbReleaseYear.setEnabled(true);
        rdbYes.setEnabled(true);
        rdbNo.setEnabled(true);
        btnUpdate.setEnabled(true);
        btnCancel.setEnabled(true);
        call();

    }

    void find() {
        ID = txtId.getText();
        if (ID.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Prisoner ID");
        } else {
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                System.out.println("Divers loaded successfully");
                Connection connect = DriverManager.getConnection("jdbc:odbc:PMS1");
                System.out.println("Connection established successfully");
                Statement state = connect.createStatement();
                String sql = "SELECT * FROM prisoner WHERE ID=" + ID + "";
                ResultSet rs = state.executeQuery(sql);
                int r = 0;
                while (rs.next()) {

                    user = rs.getString("ID");
                    if (user.equals(ID)) {
                        r++;

                        txtName.setText(rs.getString("prisoner_name"));
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
                        txtCrimeDetails.setText(rs.getString("crime"));
                        txtSentenceDetails.setText(rs.getString("sentence"));
                        cmbWardenAssign.setSelectedItem(rs.getString("warden"));
                        cmbSecurityLevel.setSelectedItem(rs.getString("security"));
                        String dateofjoin = rs.getString("join_on");
                        String joindate = dateofjoin.substring(8, 10);
                        String joinmonth = dateofjoin.substring(5, 7);
                        String joinyear = dateofjoin.substring(0, 4);
                        cmbJoinDate.setSelectedItem(joindate);
                        cmbJoinMonth.setSelectedItem(joinmonth);
                        cmbJoinYear.setSelectedItem(joinyear);
                        String dateofrelease = rs.getString("release_on");
                        String releasedate = dateofrelease.substring(8, 10);
                        String releasemonth = dateofrelease.substring(5, 7);
                        String releaseyear = dateofrelease.substring(0, 4);
                        cmbJoinDate.setSelectedItem(releasedate);
                        cmbJoinMonth.setSelectedItem(releasemonth);
                        cmbJoinYear.setSelectedItem(releaseyear);
                        String cell = rs.getString("cell_sharing");
                        if (cell.equals("Yes")) {
                            rdbYes.setSelected(true);
                        } else {
                            rdbNo.setSelected(true);
                        }
                        btnEdit.setEnabled(true);
                        btnDelete.setEnabled(true);
                        btnRelease.setEnabled(true);

                    }
                }
                if (r == 1) {
                    JOptionPane.showMessageDialog(null, "Prisoner found");
                } else {
                    JOptionPane.showMessageDialog(null, "Prisoner ID does not exist");
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

        crime = txtCrimeDetails.getText();
        sentence = txtSentenceDetails.getText();
        warden = (String) cmbWardenAssign.getSelectedItem();
        security = (String) cmbSecurityLevel.getSelectedItem();
        cell_sharing = bgCellSharing.getSelection().getActionCommand();
        releasedate = (String) cmbReleaseDate.getSelectedItem();
        releasemonth = (String) cmbReleaseMonth.getSelectedItem();
        releaseyear = (String) cmbReleaseYear.getSelectedItem();
        release_on = releasedate + "/" + releasemonth + "/" + releaseyear;

        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            System.out.println("Divers loaded successfully");
            Connection connect = DriverManager.getConnection("jdbc:odbc:PMS1");
            System.out.println("Connection established successfully");
            Statement state = connect.createStatement();
            String sql = "UPDATE prisoner SET crime= '" + crime + "', sentence= '" + sentence + "', warden= '" + warden + "', security= '" + security + "', release_on= '" + release_on + "' WHERE ID= '" + ID + "'";
            state.executeUpdate(sql);
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
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            System.out.println("Divers loaded successfully");
            Connection connect = DriverManager.getConnection("jdbc:odbc:PMS1");
            System.out.println("Connection established successfully");
            Statement state = connect.createStatement();
            String sql = "delete from prisoner where ID=" + ID + "";
            state.execute(sql);
            JOptionPane.showMessageDialog(null, "Record deleted Successfully");
            System.out.println("Statement executed successfully");
            state.close();
            connect.close();
        } catch (Exception d) {
            System.out.println("Exception found at " + d);
        }

        clear();

    }

    void release() {
        String status = "released";
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            System.out.println("Divers loaded successfully");
            Connection connect = DriverManager.getConnection("jdbc:odbc:PMS1");
            System.out.println("Connection established successfully");
            Statement state = connect.createStatement();
            int i = Integer.parseInt(ID);
            String sql = "UPDATE prisoner SET status= '" + status + "' WHERE ID= '" + i + "'";
            state.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Prisoner Released");
            System.out.println("Statement executed successfully");
            state.close();
            connect.close();
        } catch (Exception r) {
            System.out.println("Exception found at " + r);
        }
    }

    void call() {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            System.out.println("Divers loaded successfully");
            Connection connect = DriverManager.getConnection("jdbc:odbc:PMS1");
            System.out.println("Connection established successfully");
            Statement state = connect.createStatement();
            String sql = "SELECT ID,warden_name,rank FROM warden order by id";
            ResultSet rst = state.executeQuery(sql);
            while (rst.next()) {
                ward = (rst.getString("ID") + " : " + rst.getString("warden_name") + " : " + rst.getString("rank"));
                cmbWardenAssign.addItem(ward);

            }
            rst.close();
            state.close();
            connect.close();
        } catch (Exception c) {
            System.out.println("Exception found at " + c);
        }
    }

    void close() {
        int result = JOptionPane.showConfirmDialog(null, "Close Update Prisoner Form ?", "Close", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();
            home h = new home();
            h.homepage();

        } else if (result == JOptionPane.NO_OPTION) {
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }

    void clear() {
        txtId.setText("");
        txtName.setText("");
        txtCrimeDetails.setText("");
        txtSentenceDetails.setText("");
        cmbWardenAssign.setSelectedItem("");
        cmbSecurityLevel.setSelectedItem("Select Security Level");
        cmbBirthDate.setSelectedItem("Select Date");
        cmbBirthMonth.setSelectedItem("Select Month");
        cmbBirthYear.setSelectedItem("Select Year");
        cmbJoinDate.setSelectedItem("Select Date");
        cmbJoinMonth.setSelectedItem("Select Month");
        cmbJoinYear.setSelectedItem("Select Year");
        cmbReleaseDate.setSelectedItem("Select Date");
        cmbReleaseMonth.setSelectedItem("Select Month");
        cmbReleaseYear.setSelectedItem("Select Year");
        bgGender.clearSelection();
        bgCellSharing.clearSelection();
        disabled();

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnFind) {
            find();
        } else if (e.getSource() == btnEdit) {
            enabled();
            btnFind.setEnabled(false);
            btnDelete.setEnabled(false);
            btnRelease.setEnabled(false);
            btnEdit.setEnabled(false);
        } else if (e.getSource() == btnUpdate) {
            update();
        } else if (e.getSource() == btnDelete) {
            delete();
        } else if (e.getSource() == btnRelease) {
            release();
        } else if (e.getSource() == btnClose) {
            close();
        } else if (e.getSource() == btnClear) {
            clear();
        } else if (e.getSource() == btnCancel) {
            disabled();
            btnFind.setEnabled(true);
            btnDelete.setEnabled(true);
            btnRelease.setEnabled(true);
        }

    }

    public class WindowAdapterDemo extends WindowAdapter {

        public void windowClosing(WindowEvent w) {
            close();
        }
    }
}
