package hospital;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame {

    JTextField username;
    JPasswordField password;
    JButton loginButton;


    Login() {

        setTitle("Hospital Management System");

        setSize(400,300);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel title = new JLabel("Hospital Management System");
        title.setBounds(90,30,250,30);


        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50,80,100,30);


        username = new JTextField();
        username.setBounds(150,80,150,30);


        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50,120,100,30);


        password = new JPasswordField();
        password.setBounds(150,120,150,30);


        loginButton = new JButton("LOGIN");
        loginButton.setBounds(150,180,100,30);


        add(title);
        add(userLabel);
        add(username);
        add(passLabel);
        add(password);
        add(loginButton);


        loginButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                loginCheck();

            }
        });


        setVisible(true);
    }



    void loginCheck(){

        String user = username.getText();

        String pass = String.valueOf(password.getPassword());


        try{

            Connection con = DBConnection.getConnection();


            String query =
            "SELECT * FROM admin WHERE username=? AND password=?";


            PreparedStatement ps =
            con.prepareStatement(query);


            ps.setString(1,user);
            ps.setString(2,pass);


            ResultSet rs = ps.executeQuery();


            if(rs.next()){

                JOptionPane.showMessageDialog(
                this,
                "Login Successful"
                );

                new Dashboard();

                dispose();

            }
            else{

                JOptionPane.showMessageDialog(
                this,
                "Invalid Username or Password"
                );

            }


        }
        catch(Exception ex){

            ex.printStackTrace();

        }

    }



    public static void main(String args[]){

        new Login();

    }
}