package hospital;

import javax.swing.*;
import java.sql.*;

public class PatientManagement extends JFrame {


    JTextField nameField;
    JTextField ageField;
    JTextField genderField;
    JTextField phoneField;
    JTextField diseaseField;

    JButton addButton;


    PatientManagement(){


        setTitle("Patient Management");

        setSize(500,500);

        setLayout(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        JLabel title = new JLabel("Patient Management");

        title.setBounds(170,30,200,30);



        JLabel name = new JLabel("Name:");

        name.setBounds(50,80,100,30);


        nameField = new JTextField();

        nameField.setBounds(150,80,200,30);



        JLabel age = new JLabel("Age:");

        age.setBounds(50,130,100,30);


        ageField = new JTextField();

        ageField.setBounds(150,130,200,30);



        JLabel gender = new JLabel("Gender:");

        gender.setBounds(50,180,100,30);


        genderField = new JTextField();

        genderField.setBounds(150,180,200,30);



        JLabel phone = new JLabel("Phone:");

        phone.setBounds(50,230,100,30);


        phoneField = new JTextField();

        phoneField.setBounds(150,230,200,30);



        JLabel disease = new JLabel("Disease:");

        disease.setBounds(50,280,100,30);


        diseaseField = new JTextField();

        diseaseField.setBounds(150,280,200,30);



        addButton = new JButton("Add Patient");

        addButton.setBounds(170,350,150,40);



        add(title);
        add(name);
        add(nameField);

        add(age);
        add(ageField);

        add(gender);
        add(genderField);

        add(phone);
        add(phoneField);

        add(disease);
        add(diseaseField);

        add(addButton);



        addButton.addActionListener(e -> addPatient());



        setVisible(true);

    }



    void addPatient(){


        try{


            Connection con = DBConnection.getConnection();


            String query =
            "INSERT INTO patient(name,age,gender,phone,disease) VALUES(?,?,?,?,?)";


            PreparedStatement ps =
            con.prepareStatement(query);



            ps.setString(1,nameField.getText());

            ps.setInt(2,Integer.parseInt(ageField.getText()));

            ps.setString(3,genderField.getText());

            ps.setString(4,phoneField.getText());

            ps.setString(5,diseaseField.getText());



            int result = ps.executeUpdate();



            if(result>0){

                JOptionPane.showMessageDialog(
                this,
                "Patient Added Successfully"
                );

            }


            con.close();


        }
        catch(Exception e){

            e.printStackTrace();

        }

    }



}