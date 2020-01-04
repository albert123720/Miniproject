import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class adlogin
{
	JFrame f;
	JTextField tf1;
	JTextField tf2;
	adlogin()
	{
		f=new JFrame("ELECTRICITY DEPARTMENT");
		tf1=new JTextField();
		tf2=new JTextField();
		JLabel l1=new JLabel("USER NAME");
		JLabel l2=new JLabel("PASSWORD");
		JButton b1=new JButton("LOGIN");
                b1.addActionListener (new ActionListener ()
	         {	
	                   public void actionPerformed(ActionEvent e)
                                      {
                                   	  String un= tf1.getText();
                                   	  String pw= tf2.getText();
                                         if(un.equals("ebdept")&&pw.equals("eb123"))
                                   	       {
                                    		JOptionPane.showMessageDialog(f,"success"); 
                                                          new cosdetails();		
		                               }
                               	           else
                                             {
                              	                   JOptionPane.showMessageDialog(f,"invalid password");
                              	             } 
		                       }
		 });
                            l1.setBounds(100,100,100,20);
                            l2.setBounds(100,150,100,20);
                            tf1.setBounds(200,100,80,30);
	                    tf2.setBounds(200,150,80,30);
                            b1.setBounds(250,200,80,30);import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class adlogin {

    JFrame f;
    JTextField tf1;
    JTextField tf2;

    adlogin() {
        f = new JFrame("ELECTRICITY DEPARTMENT");
        tf1 = new JTextField();
        tf2 = new JTextField();
        JLabel l1 = new JLabel("USER NAME");
        JLabel l2 = new JLabel("PASSWORD");
        JButton b1 = new JButton("LOGIN");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String un = tf1.getText();
                String pw = tf2.getText();
                if (un.equals("ebdept") && pw.equals("eb123")) {
                    JOptionPane.showMessageDialog(f, "success");
                    new cosdetails();
                } else {
                    JOptionPane.showMessageDialog(f, "invalid password");
                }
            }
        });
        l1.setBounds(100, 100, 100, 20);
        l2.setBounds(100, 150, 100, 20);
        tf1.setBounds(200, 100, 80, 30);
        tf2.setBounds(200, 150, 80, 30);
        b1.setBounds(250, 200, 80, 30);
        f.setLayout(null);
        f.add(l1);
        f.add(l2);
        f.add(tf1);
        f.add(tf2);
        f.add(b1);
        f.setSize(500, 300);
        f.setVisible(true);
    }

    public static void main(String arg[]) {
        new adlogin();
    }
}

                            f.setLayout(null);
                            f.add(l1);
                            f.add(l2);
                            f.add(tf1);
                            f.add(tf2);  
                            f.add(b1); 
                            f.setSize(500,300);
                            f.setVisible(true); 
       }

       public static void main(String arg[])
      { 
             new adlogin();
      }
 }         
                                      
                          
	 
