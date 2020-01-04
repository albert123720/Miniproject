import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class cosdetails {

    JFrame f;
    JTextField tf1;
    JTextField tf2;
    JTextField tf3;
    JTextField tf4;
    JTextField tf5;
    JTextField tf6;
    JTextField tf7;
    JTextField tf8;

    cosdetails() {
        f = new JFrame("CUSTOMER DETAILS");
        JButton b1 = new JButton("ADD CUSTOMER");
        JButton b2 = new JButton("VIEW CUSTOMER");
        JButton b3 = new JButton("DELETE CUSTOMER");
        JButton b4 = new JButton("CALCULATE BILL");
        JButton b5 = new JButton("UPDATE CUSTOMER");
        JButton b6 = new JButton("UPDATE UNITS");
        JLabel l1 = new JLabel("ID:");
        JLabel l2 = new JLabel("NAME:");
        JLabel l3 = new JLabel("PINCODE");
        JLabel l4 = new JLabel("STATE:");
        JLabel l5 = new JLabel("COUNTRY:");
        JLabel l6 = new JLabel("ADDRESS:");
        JLabel l7 = new JLabel("PHONE NO:");
        JLabel l8 = new JLabel("UNIT:");

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        tf8 = new JTextField();

        f.setLayout(null);
        l1.setBounds(150, 100, 100, 20);
        l2.setBounds(150, 150, 100, 20);
        l3.setBounds(150, 200, 100, 20);
        l4.setBounds(150, 250, 100, 20);
        l5.setBounds(150, 300, 100, 20);
        l6.setBounds(150, 350, 300, 20);
        l7.setBounds(150, 400, 100, 20);
        l8.setBounds(150, 450, 100, 20);

        tf1.setBounds(250, 100, 80, 30);
        tf2.setBounds(250, 150, 80, 30);
        tf3.setBounds(250, 200, 80, 30);
        tf4.setBounds(250, 250, 80, 30);
        tf5.setBounds(250, 300, 80, 30);
        tf6.setBounds(250, 350, 210, 40);
        tf7.setBounds(250, 400, 80, 30);
        tf8.setBounds(250, 450, 80, 30);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insert(tf1.getText(), tf2.getText(), tf3.getText(), tf4.getText(), tf5.getText(), tf6.getText(), tf7.getText(), tf8.getText());
            }

        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view();
            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delete(tf1.getText());
            }
        });
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int s = Integer.parseInt(tf8.getText());
                double billpay = 0;

                if (s < 100) {
                    billpay = s * 1.20;
                } else if (s < 300) {
                    billpay = 100 * 1.20 + (s - 100) * 2;
                } else if (s > 300) {
                    billpay = 100 * 1.20 + 200 * 2 + (s - 300) * 3;
                }

                JOptionPane.showMessageDialog(f, "Bill to pay : " + billpay);

            }
        });
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updatecus(tf1.getText(), tf2.getText(), tf3.getText(), tf4.getText(), tf5.getText(), tf6.getText(), tf7.getText(), tf8.getText());
            }
        });
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateunits(tf3.getText());
            }
        });

        b1.setBounds(700, 150, 150, 20);
        b2.setBounds(700, 200, 150, 20);
        b3.setBounds(700, 250, 150, 20);
        b4.setBounds(700, 300, 150, 20);
        b5.setBounds(700, 350, 150, 20);
        b6.setBounds(700, 400, 150, 20);

        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(l6);
        f.add(l7);
        f.add(l8);

        f.add(tf1);
        f.add(tf2);
        f.add(tf3);
        f.add(tf4);
        f.add(tf5);
        f.add(tf6);
        f.add(tf7);
        f.add(tf8);

        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.setSize(1000, 800);
        f.setVisible(true);
    }

    void insert(String sr, String s1, String s2, String s3, String s4, String s5, String s6, String s7) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mit", "root", "root");
            Statement s = con.createStatement();
            int x = s.executeUpdate(" insert into REGISTRATION(id,name,pincode,state,country,residential address,phone no,unit) values('" + sr + "','" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "')");
            if (x > 0) {
                JOptionPane.showMessageDialog(f, "success");
            } else {
                JOptionPane.showMessageDialog(f, "failed");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(f, e.toString());
        }
    }

    void view() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mit", "root", "root");
            Statement s = con.createStatement();
            ResultSet x = s.executeQuery(" select * from REGISTRATION");
            while (x.next()) {
                JOptionPane.showMessageDialog(f, x.getString(1) + " - " + x.getString(2) + " - " + x.getString(3));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(f, e.toString());
        }
    }

    void delete(String sno) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mit", "root", "root");
            Statement s = con.createStatement();
            int x = s.executeUpdate("delete from REGISTRATION");
            if (x > 0) {
                JOptionPane.showMessageDialog(f, "Deleted successfully");
            } else {
                JOptionPane.showMessageDialog(f, "No Data");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(f, e.toString());
        }
    }

    void updatecus(String sr, String s1, String s2, String s3, String s4, String s5, String s6, String s7) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mit", "root", "root");
            Statement s = con.createStatement();
            int x = s.executeUpdate("insert into REGISTRATION(id,name,pincode,state,country,residential address,phone no,unit) values('" + sr + "','" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "')");
            if (x > 0) {
                JOptionPane.showMessageDialog(f, "success");
            } else {
                JOptionPane.showMessageDialog(f, "failed");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(f, e.toString());
        }
    }

    void updateunits(String s7) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mit", "root", "root");
            Statement s = con.createStatement();
            int x = s.executeUpdate("insert into REGISTRATION(unit)values('" + s7 + "')");
            if (x > 0) {
                JOptionPane.showMessageDialog(f, "success");
            } else {
                JOptionPane.showMessageDialog(f, "failed");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(f, e.toString());
        }
    }

    public static void main(String arg[]) {
        new cosdetails();
    }
}
