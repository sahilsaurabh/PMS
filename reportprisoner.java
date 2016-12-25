

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class reportprisoner extends JFrame implements ActionListener {

    private JPanel pnlHeader, pnlFooter, pnlBody;
    private JLabel lblHeading;
    private JButton btnClose;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scroll;
    private String ID, prisoner_name, birthdate, gender, crime, sentence, warden, security, cell_sharing, joindate, releasedate, status;
    private String[] columnNames = {"Prisoner ID", "Prisoner Name", "Birthdate", "Gender", "Crime Details", "Sentence Details", "Warden Assign", "Security Level", "Cell Sharing", "Joining Date", "Release Date", "Status"};

    public reportprisoner() {

        pnlHeader = new JPanel();
        pnlFooter = new JPanel();
        pnlBody = new JPanel();
        lblHeading = new JLabel("ALL PRISONER DETAILS");
        btnClose = new JButton("Close");
        table = new JTable(10, 10);
        model = new DefaultTableModel();
        scroll = new JScrollPane(table);

    }

    public void reportPrisoner() {

        setSize(1350, 600);
        setLocationRelativeTo(null);
        setTitle("Prisoner Report");
        setResizable(false);
        setLayout(new BorderLayout(0, 0));
        addWindowListener(new WindowAdapterDemo());

        add(pnlHeader, BorderLayout.PAGE_START);
        add(pnlFooter, BorderLayout.PAGE_END);
        add(pnlBody, BorderLayout.CENTER);

        lblHeading.setFont(new Font("Tahoma", Font.BOLD, 30));
        pnlHeader.add(lblHeading);

        model.setColumnIdentifiers(columnNames);

        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);

        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        pnlBody.add(scroll);
        scroll.setPreferredSize(new Dimension(1275, 500));

        pnlFooter.add(btnClose);
        btnClose.setBackground(new Color(59, 89, 182));
        btnClose.setForeground(Color.WHITE);
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnClose.addActionListener(this);

        setVisible(true);
        database();
    }

    void database() {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            System.out.println("Divers loaded successfully");
            Connection connect = DriverManager.getConnection("jdbc:odbc:PMS1");
            System.out.println("Connection established successfully");
            Statement state = connect.createStatement();
            ResultSet rs = state.executeQuery("SELECT * FROM prisoner");
            while (rs.next()) {

                ID = rs.getString("ID");
                prisoner_name = rs.getString("prisoner_name");
                birthdate = rs.getString("birth");
                gender = rs.getString("gender");
                crime = rs.getString("crime");
                sentence = rs.getString("sentence");
                warden = rs.getString("warden");
                security = rs.getString("security");
                cell_sharing = rs.getString("cell_sharing");
                joindate = rs.getString("join_on");
                releasedate = rs.getString("release_on");
                status = rs.getString("status");
                model.addRow(new Object[]{ID, prisoner_name, birthdate, gender, crime, sentence, warden, security, cell_sharing, joindate, releasedate, status});
            }

            System.out.println("Statement executed successfully");
            rs.close();
            state.close();
            connect.close();
        } catch (Exception r) {
            System.out.println("Exception found at " + r);
        }
    }

    void close() {
        int result = JOptionPane.showConfirmDialog(null, "Close Prisoner Report ?", "Close", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();
            home h = new home();
            h.homepage();
        } else if (result == JOptionPane.NO_OPTION) {
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnClose) {
            close();
        }

    }

    public class WindowAdapterDemo extends WindowAdapter {

        public void windowClosing(WindowEvent w) {
            close();
        }
    }
}
