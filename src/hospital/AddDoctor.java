package hospital;

import javax.swing.*;
import java.sql.*;

public class AddDoctor extends JInternalFrame {


    JTextField nameField, specializationField, phoneField, emailField;


    AddDoctor(){


        setTitle("Add Doctor");

        setSize(450,400);

        setLayout(null);

        setClosable(true);

        setResizable(true);



        JLabel nameLabel = new JLabel("Doctor Name:");

        nameLabel.setBounds(40,50,120,30);


        nameField = new JTextField();

        nameField.setBounds(180,50,180,30);




        JLabel specLabel = new JLabel("Specialization:");

        specLabel.setBounds(40,100,120,30);


        specializationField = new JTextField();

        specializationField.setBounds(180,100,180,30);




        JLabel phoneLabel = new JLabel("Phone:");

        phoneLabel.setBounds(40,150,120,30);


        phoneField = new JTextField();

        phoneField.setBounds(180,150,180,30);




        JLabel emailLabel = new JLabel("Email:");

        emailLabel.setBounds(40,200,120,30);


        emailField = new JTextField();

        emailField.setBounds(180,200,180,30);




        JButton addBtn = new JButton("Add Doctor");

        addBtn.setBounds(140,280,150,40);




        add(nameLabel);
        add(nameField);

        add(specLabel);
        add(specializationField);

        add(phoneLabel);
        add(phoneField);

        add(emailLabel);
        add(emailField);

        add(addBtn);




        addBtn.addActionListener(e -> addDoctor());



        setVisible(true);

    }





    void addDoctor(){


        try{


            Connection con =
                    DBConnection.getConnection();



            String sql =
            "INSERT INTO doctor(doctor_name,specialization,phone,email) VALUES(?,?,?,?)";



            PreparedStatement ps =
                    con.prepareStatement(sql);



            ps.setString(1,nameField.getText());

            ps.setString(2,specializationField.getText());

            ps.setString(3,phoneField.getText());

            ps.setString(4,emailField.getText());



            ps.executeUpdate();



            JOptionPane.showMessageDialog(
                    this,
                    "Doctor Added Successfully"
            );



            con.close();


        }
        catch(Exception e){

            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage()
            );

        }


    }


}