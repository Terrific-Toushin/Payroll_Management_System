package payroll_system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

public class Pay_roll extends JFrame implements ActionListener {
    
   
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    JPanel panel = new JPanel();
    JButton btnemp = new JButton("", new ImageIcon("photo/emp.png"));
    JButton btnall = new JButton("", new ImageIcon("photo/alow.png"));
    JButton btnded = new JButton("", new ImageIcon("photo/ded.png"));
    JButton btnsrc = new JButton("", new ImageIcon("photo/src.png"));
    JButton btnups = new JButton("", new ImageIcon("photo/upd.png"));
    JButton btnpmt = new JButton("", new ImageIcon("photo/pay.png"));
    Connection con=null;
    Statement st;
    ResultSet rs;
    
    JMenu m_employee,m_payroll,m_reports,m_help,m_exit;
    JMenuItem itm_add,itm_update,itm_search;
    JMenuItem itm_allowance,itm_deduction,itm_usalary,itm_payment,itm_upslr;
    JMenuItem itm_empdetails,itm_paids,itm_nets;
    JMenuItem itm_manual,itm_logout;
    
    JMenuBar mb;

    Pay_roll() {
        super("Pay Roll System");
        this.con=con;
        panel.setLayout(null);
        add(panel);
        setSize(dim);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        addcomp();
        
        con=DB.getConnection();
        panel.setBackground(Color.DARK_GRAY);
        addmenu();

    }
     void addmenu(){
        mb=new JMenuBar();
        m_employee=new JMenu("Employee");
        
        itm_add=new JMenuItem("Add",new ImageIcon("image/Regis.png"));
        itm_add.setAccelerator(KeyStroke.getKeyStroke('A',Event.CTRL_MASK));
        itm_add.addActionListener(this);
        m_employee.add(itm_add);
        m_employee.addSeparator();
        
        itm_update=new JMenuItem("Update",new ImageIcon("image/Regis.png"));
        itm_update.setAccelerator(KeyStroke.getKeyStroke('U',Event.CTRL_MASK));
        itm_update.addActionListener(this);
        m_employee.add(itm_update);
        m_employee.addSeparator();
        
        itm_search=new JMenuItem("Search",new ImageIcon("image/Regis.png"));
        itm_search.setAccelerator(KeyStroke.getKeyStroke('S',Event.CTRL_MASK));
        itm_search.addActionListener(this);
        m_employee.add(itm_search);
        m_employee.addSeparator();
        
        m_payroll=new JMenu("Payroll");
        itm_allowance=new JMenuItem("Allowance",new ImageIcon("image/Regis.png"));
        itm_allowance.addActionListener(this);
        itm_deduction=new JMenuItem("Deduction",new ImageIcon("image/Regis.png"));
        itm_deduction.addActionListener(this);
        itm_usalary=new JMenuItem("Update Salary",new ImageIcon("image/Regis.png"));
        itm_usalary.addActionListener(this);
        itm_payment=new JMenuItem("Make Payment",new ImageIcon("image/Regis.png"));
        itm_payment.addActionListener(this);
        itm_upslr=new JMenuItem("Update Salary",new ImageIcon("image/Regis.png"));
        itm_upslr.addActionListener(this);
        
        m_payroll.add(itm_allowance);
        m_payroll.add(itm_deduction);
        m_payroll.add(itm_usalary);
        m_payroll.add(itm_payment);
        m_payroll.add(itm_upslr);
        
        m_reports=new JMenu("Reports");
        itm_empdetails=new JMenuItem("Employee details",new ImageIcon("image/Regis.png"));
        itm_empdetails.addActionListener(this);
        itm_paids=new JMenuItem("Payment",new ImageIcon("image/Regis.png"));
        itm_paids.addActionListener(this);
        itm_nets=new JMenuItem("Net Salary",new ImageIcon("image/Regis.png"));
        itm_nets.addActionListener(this);
        
        m_reports.add(itm_empdetails);
        m_reports.add(itm_paids);
        m_reports.add(itm_nets);
        
        m_help=new JMenu("Help");
        itm_manual=new JMenuItem("User manual",new ImageIcon("image/Regis.png"));
        itm_manual.addActionListener(this);
        
        
        m_help.add(itm_manual);
        
        
        m_exit=new JMenu("Exit");
        itm_logout=new JMenuItem("logout",new ImageIcon("image/Regis.png"));
        itm_logout.addActionListener(this);
        
        m_exit.add(itm_logout);
        
        mb.add(m_employee);
        mb.add(m_payroll);
        mb.add(m_reports);
        mb.add(m_help);
        mb.add(m_exit);
        setJMenuBar(mb);
         

    }

    private void addcomp() {
        
        
        btnemp.setBounds(150, 70, 210, 70);
        panel.add(btnemp);
        btnemp.addActionListener(this);

        btnall.setBounds(150, 280, 210, 70);
        panel.add(btnall);
        btnall.addActionListener(this);

        btnded.setBounds(150, 490, 210, 70);
        panel.add(btnded);
        btnded.addActionListener(this);

        btnsrc.setBounds(960, 70, 210, 70);
        panel.add(btnsrc);
        btnsrc.addActionListener(this);

        btnups.setBounds(960, 280, 210, 70);
        panel.add(btnups);
        btnups.addActionListener(this);

        btnpmt.setBounds(960, 490, 210, 70);
        panel.add(btnpmt);
        btnpmt.addActionListener(this);
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            }
        catch (Exception e){}
        Pay_roll ob = new Pay_roll();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == itm_add) {
            Add_employee ob = new Add_employee();
        }
        if (e.getSource() ==itm_allowance) {
             new Allowance();
        }
        
        if (e.getSource() ==itm_update) {
             new Update_employee();
        }
        if (e.getSource() ==itm_search) {
             new NSearch();
        }
        if (e.getSource() ==itm_deduction) {
             new Deduction();
        }
        if (e.getSource() ==itm_usalary) {
             new Update_salary();
        }
        if (e.getSource() ==itm_payment) {
             new Payment();
        }
        if (e.getSource() ==itm_upslr) {
             new Update_salary();
        }
        if (e.getSource() == btnemp) {
            Add_employee ob = new Add_employee();
        }
        if (e.getSource() ==btnall) {
             new Allowance();
        }
        if (e.getSource() ==btnded) {
             new Deduction();
        }
        if (e.getSource() ==btnsrc) {
             new NSearch();
        }
         if (e.getSource() ==btnups) {
             new Update_salary();
        }
        if (e.getSource() ==btnpmt) {
             new Payment();
        }
        if (e.getSource() ==itm_empdetails) {
             new View_employee();
        }
        if (e.getSource() ==itm_paids) {
             new View_paid_status();
        }
        if (e.getSource() ==itm_nets) {
             new View_net_salary();
        }
        if (e.getSource() ==itm_manual) {
             try{
                 Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"image\\1A.pdf");
             }
             catch(Exception em){
                 JOptionPane.showMessageDialog(null, em.toString());
             }
        }
        if (e.getSource() ==itm_logout) {
             new Login();
             dispose();
        }
    }

}
