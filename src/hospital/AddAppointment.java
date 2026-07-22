package hospital;

import javax.swing.*;
import java.sql.*;

public class AddAppointment extends JInternalFrame {


    JTextField patientField, doctorField, dateField, timeField, statusField;



    AddAppointment(){


        setTitle("Add Appointment");

        setSize(450,450);

        setLayout(null);

        setClosable(true);

        setResizable(true);




        JLabel patientLabel = new JLabel("Patient ID:");

        patientLabel.setBounds(50,50,100,30);


        patientField = new JTextField();

        patientField.setBounds(180,50,180,30);




        JLabel doctorLabel = new JLabel("Doctor ID:");

        doctorLabel.setBounds(50,100,100,30);


        doctorField = new JTextField();

        doctorField.setBounds(180,100,180,30);




        JLabel dateLabel = new JLabel("Date:");

        dateLabel.setBounds(50,150,100,30);


        dateField = new JTextField();

        dateField.setBounds(180,150,180,30);




        JLabel timeLabel = new JLabel("Time:");

        timeLabel.setBounds(50,200,100,30);


        timeField = new JTextField();

        timeField.setBounds(180,200,180,30);




        JLabel statusLabel = new JLabel("Status:");

        statusLabel.setBounds(50,250,100,30);


        statusField = new JTextField();

        statusField.setBounds(180,250,180,30);




        JButton addBtn = new JButton("Add Appointment");

        addBtn.setBounds(130,330,180,40);




        add(patientLabel);
        add(patientField);

        add(doctorLabel);
        add(doctorField);

        add(dateLabel);
        add(dateField);

        add(timeLabel);
        add(timeField);

        add(statusLabel);
        add(statusField);

        add(addBtn);





        addBtn.addActionListener(e -> addAppointment());



        setVisible(true);


    }





    void addAppointment(){


        try{


            Connection con =
                    DBConnection.getConnection();




            String sql =
            "INSERT INTO appointment(patient_id,doctor_id,appointment_date,appointment_time,status) VALUES(?,?,?,?,?)";



            PreparedStatement ps =
                    con.prepareStatement(sql);




            ps.setInt(1,
                    Integer.parseInt(patientField.getText()));



            ps.setInt(2,
                    Integer.parseInt(doctorField.getText()));



            ps.setDate(3,
                    Date.valueOf(dateField.getText()));



            ps.setTime(4,
                    Time.valueOf(timeField.getText()));



            ps.setString(5,
                    statusField.getText());




            ps.executeUpdate();




            JOptionPane.showMessageDialog(
                    this,
                    "Appointment Added Successfully"
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