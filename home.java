

import java.awt.event.*;
import javax.swing.*;

public class home extends JFrame implements ActionListener {

    private JMenuBar menubar;
    private JMenu prisonermenu, wardenmenu, reportmenu;
    private JMenuItem addPrisoner, updatePrisoner, addWarden, updateWarden, prisonerReport, wardenReport;

    public home() {

        menubar = new JMenuBar();
        prisonermenu = new JMenu("Prisoner");
        wardenmenu = new JMenu("Warden");
        reportmenu = new JMenu("Report");
        addPrisoner = new JMenuItem("Add Prisoner");
        updatePrisoner = new JMenuItem("Update Prisoner");
        addWarden = new JMenuItem("Add Warden");
        updateWarden = new JMenuItem("Update Warden");
        prisonerReport = new JMenuItem("Disply All Prisoner");
        wardenReport = new JMenuItem("Disply All Warden");
    }

    public void homepage() {

        setSize(890, 565);
        setLocationRelativeTo(null);
        setTitle("Prisoner Management System");
        setLayout(null);
        setResizable(false);
        setContentPane(new JLabel(new ImageIcon(ClassLoader.getSystemResource("background.jpg"))));
        addWindowListener(new WindowAdapterDemo());

        menubar.setBounds(0, 0, 977, 20);
        add(menubar);

        menubar.add(prisonermenu);
        menubar.add(wardenmenu);
        menubar.add(reportmenu);

        prisonermenu.add(addPrisoner);
        addPrisoner.addActionListener(this);

        prisonermenu.add(updatePrisoner);
        updatePrisoner.addActionListener(this);

        wardenmenu.add(addWarden);
        addWarden.addActionListener(this);

        wardenmenu.add(updateWarden);
        updateWarden.addActionListener(this);

        reportmenu.add(prisonerReport);
        prisonerReport.addActionListener(this);

        reportmenu.add(wardenReport);
        wardenReport.addActionListener(this);

        setVisible(true);
    }

    void close() {
        int result = JOptionPane.showConfirmDialog(null, "Do you want to exit ?", "Exit", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();
            login l = new login();
            l.loginpage();
        } else if (result == JOptionPane.NO_OPTION) {
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addPrisoner) {
            addprisoner p = new addprisoner();
            p.addPrisoner();
            this.setVisible(false);

        } else if (e.getSource() == updatePrisoner) {
            updateprisoner p = new updateprisoner();
            p.updatePrisoner();
            this.setVisible(false);

        } else if (e.getSource() == addWarden) {
            addwarden w = new addwarden();
            w.addWarden();
            this.setVisible(false);
        } else if (e.getSource() == updateWarden) {
            updatewarden w = new updatewarden();
            w.updateWarden();
            this.setVisible(false);

        } else if (e.getSource() == prisonerReport) {
            reportprisoner rp = new reportprisoner();
            rp.reportPrisoner();
            this.setVisible(false);
        } else if (e.getSource() == wardenReport) {
            reportwarden rw = new reportwarden();
            rw.reportWarden();
            this.setVisible(false);
        }
    }

    public class WindowAdapterDemo extends WindowAdapter {

        public void windowClosing(WindowEvent w) {
            close();
        }
    }
}
