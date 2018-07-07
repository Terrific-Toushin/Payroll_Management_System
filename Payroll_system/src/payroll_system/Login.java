package payroll_system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

    String color500_ = " #9e9e9e";
    JPanel panel = new JPanel();
    JLabel usr_name = new JLabel("User Name :");
    JTextField usrtext = new JTextField(25);
    JLabel password = new JLabel("Password :");
    JPasswordField passf = new JPasswordField(25);
    JButton loginb = new JButton("Login");
    Connection con=null;
    Statement st;
    ResultSet rs;

    Login() {
        super("Admin Login");
        panel.setBackground(Color.gray);
        panel.setLayout(null);
        setSize(350, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        setLocationRelativeTo(null);
        setResizable(false);
        addcomp();
        con=DB.getConnection();
    }

    private void addcomp() {
        usr_name.setBounds(30, 60, 120, 30);
        panel.add(usr_name);

        usrtext.setBounds(110, 60, 160, 30);
        panel.add(usrtext);

        password.setBounds(30, 100, 120, 30);
        panel.add(password);

        passf.setBounds(110, 100, 160, 30);
        panel.add(passf);

        loginb.setBounds(180, 150, 70, 30);
        panel.add(loginb);
        loginb.addActionListener(this);

    }

    public static void main(String[] args) {
        Login ob = new Login();

    }

        public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginb) {
            boolean c = false;
            if (usrtext.getText().equals("")) {

                JOptionPane.showMessageDialog(null, "Provide User Name");

            } else if (passf.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Provide User Password");

            } else {

                
                try {
                    
                    String query="select * from registration where username='"+usrtext.getText()+"'"
                      +"&& password='"+passf.getText()+"'";
                    st = con.createStatement();
                    rs = st.executeQuery(query);
                    rs.next();
                    String name = rs.getString("username");
                    String password = rs.getString("password");

                    if (usrtext.getText().equals(name) && passf.getText().equals(password)) {
                        c = true;
                            new Pay_roll();
                            dispose();

                    } 
                    else {

                            JOptionPane.showMessageDialog(null, "Provide correct Name and password");

                    }
                    

                } catch (Exception ae) {
                    JOptionPane.showMessageDialog(null, e.toString());
                }

            }

        }
    }

}
