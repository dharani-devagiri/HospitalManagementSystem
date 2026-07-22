package hospital;

import javax.swing.*;
import java.sql.*;

public class AddPatient extends JInternalFrame {


    JTextField nameField, ageField, phoneField, diseaseField;

    JComboBox<String> genderBox;



    AddPatient() {


        setTitle("Add Patient");

        setSize(450,450);

        setLayout(null);


        setClosable(true);

        setResizable(true);




        JLabel nameLabel = new JLabel("Name:");

        nameLabel.setBounds(50,50,100,30);


        nameField = new JTextField();

        nameField.setBounds(180,50,180,30);




        JLabel ageLabel = new JLabel("Age:");

        ageLabel.setBounds(50,100,100,30);


        ageField = new JTextField();

        ageField.setBounds(180,100,180,30);




        JLabel genderLabel = new JLabel("Gender:");

        genderLabel.setBounds(50,150,100,30);



        String gender[] =
        {
                "Male",
                "Female",
                "Other"
        };


        genderBox = new JComboBox<>(gender);

        genderBox.setBounds(180,150,180,30);





        JLabel phoneLabel = new JLabel("Phone:");

        phoneLabel.setBounds(50,200,100,30);


        phoneField = new JTextField();

        phoneField.setBounds(180,200,180,30);





        JLabel diseaseLabel = new JLabel("Disease:");

        diseaseLabel.setBounds(50,250,100,30);


        diseaseField = new JTextField();

        diseaseField.setBounds(180,250,180,30);





        JButton addButton = new JButton("Add Patient");

        addButton.setBounds(140,320,150,40);






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


        add(addButton);





        addButton.addActionListener(e -> addPatient());



        setVisible(true);

    }






    void addPatient(){


        try{


            Connection con =
                    DBConnection.getConnection();




            String sql =
            "INSERT INTO patient(name,age,gender,phone,disease) VALUES(?,?,?,?,?)";



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



            ps.executeUpdate();




            JOptionPane.showMessageDialog(
                    this,
                    "Patient Added Successfully"
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