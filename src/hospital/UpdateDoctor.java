package hospital;

import javax.swing.*;
import java.sql.*;

public class UpdateDoctor extends JInternalFrame {


    JTextField idField, nameField, specializationField, phoneField, emailField;



    UpdateDoctor(){


        setTitle("Update Doctor");

        setSize(450,450);

        setLayout(null);

        setClosable(true);

        setResizable(true);



        JLabel idLabel = new JLabel("Doctor ID:");

        idLabel.setBounds(50,40,100,30);


        idField = new JTextField();

        idField.setBounds(180,40,180,30);




        JLabel nameLabel = new JLabel("Doctor Name:");

        nameLabel.setBounds(50,90,100,30);


        nameField = new JTextField();

        nameField.setBounds(180,90,180,30);




        JLabel specLabel = new JLabel("Specialization:");

        specLabel.setBounds(50,140,120,30);


        specializationField = new JTextField();

        specializationField.setBounds(180,140,180,30);




        JLabel phoneLabel = new JLabel("Phone:");

        phoneLabel.setBounds(50,190,100,30);


        phoneField = new JTextField();

        phoneField.setBounds(180,190,180,30);




        JLabel emailLabel = new JLabel("Email:");

        emailLabel.setBounds(50,240,100,30);


        emailField = new JTextField();

        emailField.setBounds(180,240,180,30);




        JButton updateBtn = new JButton("Update");

        updateBtn.setBounds(150,320,120,40);





        add(idLabel);
        add(idField);

        add(nameLabel);
        add(nameField);

        add(specLabel);
        add(specializationField);

        add(phoneLabel);
        add(phoneField);

        add(emailLabel);
        add(emailField);

        add(updateBtn);




        updateBtn.addActionListener(e -> updateDoctor());



        setVisible(true);

    }






    void updateDoctor(){


        try{


            Connection con =
                    DBConnection.getConnection();



            String sql =
            "UPDATE doctor SET doctor_name=?,specialization=?,phone=?,email=? WHERE doctor_id=?";



            PreparedStatement ps =
                    con.prepareStatement(sql);



            ps.setString(1,nameField.getText());

            ps.setString(2,specializationField.getText());

            ps.setString(3,phoneField.getText());

            ps.setString(4,emailField.getText());

            ps.setInt(5,
                    Integer.parseInt(idField.getText()));



            int result =
                    ps.executeUpdate();




            if(result>0){

                JOptionPane.showMessageDialog(
                        this,
                        "Doctor Updated Successfully"
                );

            }
            else{

                JOptionPane.showMessageDialog(
                        this,
                        "Doctor ID Not Found"
                );

            }


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