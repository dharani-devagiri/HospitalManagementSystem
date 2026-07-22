package hospital;

import javax.swing.*;
import java.sql.*;

public class UpdatePatient extends JInternalFrame {


    JTextField idField, nameField, ageField, phoneField, diseaseField;

    JComboBox<String> genderBox;



    UpdatePatient(){


        setTitle("Update Patient");

        setSize(450,450);

        setLayout(null);


        setClosable(true);

        setResizable(true);




        JLabel idLabel = new JLabel("Patient ID:");

        idLabel.setBounds(50,40,100,30);


        idField = new JTextField();

        idField.setBounds(180,40,180,30);




        JLabel nameLabel = new JLabel("Name:");

        nameLabel.setBounds(50,90,100,30);


        nameField = new JTextField();

        nameField.setBounds(180,90,180,30);





        JLabel ageLabel = new JLabel("Age:");

        ageLabel.setBounds(50,140,100,30);


        ageField = new JTextField();

        ageField.setBounds(180,140,180,30);





        JLabel genderLabel = new JLabel("Gender:");

        genderLabel.setBounds(50,190,100,30);



        genderBox = new JComboBox<>(
                new String[]{"Male","Female","Other"}
        );


        genderBox.setBounds(180,190,180,30);





        JLabel phoneLabel = new JLabel("Phone:");

        phoneLabel.setBounds(50,240,100,30);


        phoneField = new JTextField();

        phoneField.setBounds(180,240,180,30);





        JLabel diseaseLabel = new JLabel("Disease:");

        diseaseLabel.setBounds(50,290,100,30);


        diseaseField = new JTextField();

        diseaseField.setBounds(180,290,180,30);





        JButton updateBtn = new JButton("Update");


        updateBtn.setBounds(150,350,120,40);





        add(idLabel);
        add(idField);

        add(nameLabel);
        add(nameField);

        add(ageLabel);
        add(ageField);

        add(genderLabel);
        add(genderBox);

        add(phoneLabel);
        add(phoneField);

        add(diseaseLabel);
        add(diseaseField);

        add(updateBtn);





        updateBtn.addActionListener(e -> updatePatient());



        setVisible(true);

    }






    void updatePatient(){


        try{


            Connection con =
                    DBConnection.getConnection();




            String sql =
            "UPDATE patient SET name=?,age=?,gender=?,phone=?,disease=? WHERE patient_id=?";




            PreparedStatement ps =
                    con.prepareStatement(sql);




            ps.setString(1,nameField.getText());


            ps.setInt(2,
                    Integer.parseInt(ageField.getText()));



            ps.setString(3,
                    genderBox.getSelectedItem().toString());



            ps.setString(4,
                    phoneField.getText());



            ps.setString(5,
                    diseaseField.getText());



            ps.setInt(6,
                    Integer.parseInt(idField.getText()));




            int result =
                    ps.executeUpdate();




            if(result>0){

                JOptionPane.showMessageDialog(
                        this,
                        "Patient Updated Successfully"
                );

            }
            else{

                JOptionPane.showMessageDialog(
                        this,
                        "Patient ID Not Found"
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