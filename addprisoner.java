
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

public class addprisoner extends JFrame implements ActionListener {

    private JPanel pnlHeader, pnlFooter, pnlBody, pnlGender, pnlCellSharing, pnlBirthCal, pnlJoinCal, pnlReleaseCal;
    private JLabel lblHeading, lblId, lblName, lblBirthDate, lblGender, lblCrimeDetails, lblSentenceDetails, lblWardenAssign, lblSecurityLevel, lblCellSharing, lblJoinDate, lblReleaseDate;
    private JTextField txtId, txtName, txtPhone, txtCrimeDetails, txtSentenceDetails;
    private JComboBox cmbWardenAssign, cmbSecurityLevel, cmbBirthDate, cmbBirthMonth, cmbBirthYear, cmbJoinDate, cmbJoinMonth, cmbJoinYear, cmbReleaseDate, cmbReleaseMonth, cmbReleaseYear;
    private ButtonGroup bgGender, bgCellSharing;
    private JRadioButton rdbMale, rdbFemale, rdbYes, rdbNo;
    private JButton btnAdd, btnClear, btnClose;
    private String[] SecurityLevel = {"High Security", "Low Security"};
    private String[] date = {"1", "2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    private String[] year = {"1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015"};
    private String[] month = {"1", "2","3","4","5","6","7","8","9","10","11","12"};
    private String ID, ward, user, prisoner_name, birth, birthdate, birthmonth, birthyear, gender, crime, sentence, warden, security, cell_sharing, join_on, joindate, joinmonth, joinyear, release_on, releasedate, releasemonth, releaseyear, status;
    private Font f;

    public addprisoner() {

        pnlHeader = new JPanel();
        pnlFooter = new JPanel();
        pnlBody = new JPanel();
        pnlGender = new JPanel();
        pnlCellSharing = new JPanel();
        pnlBirthCal = new JPanel();
        pnlJoinCal = new JPanel();
        pnlReleaseCal = new JPanel();

        f = new Font("Tahoma", Font.BOLD, 12);

        lblHeading = new JLabel("ADD PRISONER DETAILS");
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

        btnAdd = new JButton("Add");
        btnClear = new JButton("Clear");
        btnClose = new JButton("Close");
    }

    public void addPrisoner() {

        setSize(700, 600);
        setLocationRelativeTo(null);
        setTitle("Add Prisoner Detail");
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

        lblHeading.setFont(new Font("Arial", Font.BOLD, 30));
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
        call();

        setVisible(true);
    }

    public void add() {

        ID = txtId.getText();
        prisoner_name = txtName.getText();
        birthdate = (String) cmbBirthDate.getSelectedItem();
        birthmonth = (String) cmbBirthMonth.getSelectedItem();
        birthyear = (String) cmbBirthYear.getSelectedItem();
        birth = birthdate + "/" + birthmonth + "/" + birthyear;
        gender = bgGender.getSelection().getActionCommand();
        crime = txtCrimeDetails.getText();
        sentence = txtSentenceDetails.getText();
        warden = (String) cmbWardenAssign.getSelectedItem();
        security = (String) cmbSecurityLevel.getSelectedItem();
        cell_sharing = bgCellSharing.getSelection().getActionCommand();
        joindate = (String) cmbJoinDate.getSelectedItem();
        joinmonth = (String) cmbJoinMonth.getSelectedItem();
        joinyear = (String) cmbJoinYear.getSelectedItem();
        join_on = joindate + "/" + joinmonth + "/" + joinyear;
        releasedate = (String) cmbReleaseDate.getSelectedItem();
        releasemonth = (String) cmbReleaseMonth.getSelectedItem();
        releaseyear = (String) cmbReleaseYear.getSelectedItem();
        release_on = releasedate + "/" + releasemonth + "/" + releaseyear;
        status = ("imprisonment");

        check();

    }

    void check() {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            System.out.println("Divers loaded successfully");
            Connection connect = DriverManager.getConnection("jdbc:odbc:PMS1");
            System.out.println("Connection established successfully");
            Statement state = connect.createStatement();
            String sql = "SELECT ID FROM prisoner WHERE ID=" + ID + "";
            ResultSet rs = state.executeQuery(sql);
            int r = 0;
            while (rs.next()) {
                user = rs.getString("ID");
                if (user.equals(ID)) {
                    r++;
                }
            }
            if (r == 1) {
                JOptionPane.showMessageDialog(null, "Prisoner ID already exist");
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
            String sql1 = "insert into prisoner (ID,prisoner_name,birth,gender,crime,sentence,warden,security,cell_sharing,join_on,release_on,status) values ('" + ID + "','" + prisoner_name + "','" + birth + "','" + gender + "','" + crime + "','" + sentence + "','" + warden + "','" + security + "','" + cell_sharing + "','" + join_on + "','" + release_on + "','" + status + "')";
            state1.execute(sql1);
            JOptionPane.showMessageDialog(null, "Record added Successfully");
            System.out.println("Statement executed successfully");
            state1.close();
            connect1.close();
        } catch (Exception ae) {
            System.out.println("Exception found at " + ae);
        }
    }

    void call() {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            System.out.println("Divers loaded successfully");
            Connection connect = DriverManager.getConnection("jdbc:odbc:PMS1");
            System.out.println("Connection established successfully");
            Statement state = connect.createStatement();
            String sql = "SELECT ID,warden_name,rank FROM warden ORDER BY ID";
            ResultSet rst = state.executeQuery(sql);
            while (rst.next()) {

                ward = (rst.getString("ID") + " : " + rst.getString("warden_name") + " : " + rst.getString("rank"));
                cmbWardenAssign.addItem(ward);

            }
            rst.close();
            state.close();
            connect.close();
        } catch (Exception e) {
            System.out.println("Exception found at " + e);
        }
    }

    void close() {
        int result = JOptionPane.showConfirmDialog(null, "Close Add Prisoner Form ?", "Close", JOptionPane.YES_NO_OPTION);
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
        cmbWardenAssign.setSelectedIndex(0);
        cmbSecurityLevel.setSelectedIndex(0);
        cmbBirthDate.setSelectedIndex(0);
        cmbBirthMonth.setSelectedIndex(0);
        cmbBirthYear.setSelectedIndex(0);
        cmbJoinDate.setSelectedIndex(0);
        cmbJoinMonth.setSelectedIndex(0);
        cmbJoinYear.setSelectedIndex(0);
        cmbReleaseDate.setSelectedIndex(0);
        cmbReleaseMonth.setSelectedIndex(0);
        cmbReleaseYear.setSelectedIndex(0);
        bgGender.clearSelection();
        bgCellSharing.clearSelection();

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
