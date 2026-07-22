package hospital;

import javax.swing.*;
import java.sql.*;

public class UpdateAppointment extends JInternalFrame {


    JTextField idField, patientField, doctorField, dateField, timeField, statusField;



    UpdateAppointment(){


        setTitle("Update Appointment");

        setSize(450,500);

        setLayout(null);

        setClosable(true);

        setResizable(true);




        JLabel idLabel=new JLabel("Appointment ID:");

        idLabel.setBounds(40,40,120,30);


        idField=new JTextField();

        idField.setBounds(180,40,180,30);




        JLabel patientLabel=new JLabel("Patient ID:");

        patientLabel.setBounds(40,90,120,30);


        patientField=new JTextField();

        patientField.setBounds(180,90,180,30);




        JLabel doctorLabel=new JLabel("Doctor ID:");

        doctorLabel.setBounds(40,140,120,30);


        doctorField=new JTextField();

        doctorField.setBounds(180,140,180,30);




        JLabel dateLabel=new JLabel("Date:");

        dateLabel.setBounds(40,190,120,30);


        dateField=new JTextField();

        dateField.setBounds(180,190,180,30);




        JLabel timeLabel=new JLabel("Time:");

        timeLabel.setBounds(40,240,120,30);


        timeField=new JTextField();

        timeField.setBounds(180,240,180,30);




        JLabel statusLabel=new JLabel("Status:");

        statusLabel.setBounds(40,290,120,30);


        statusField=new JTextField();

        statusField.setBounds(180,290,180,30);




        JButton updateBtn=new JButton("Update");

        updateBtn.setBounds(150,370,120,40);




        add(idLabel);
        add(idField);

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

        add(updateBtn);




        updateBtn.addActionListener(e->updateAppointment());



        setVisible(true);

    }






    void updateAppointment(){


        try{


            Connection con =
                    DBConnection.getConnection();



            String sql =
            "UPDATE appointment SET patient_id=?,doctor_id=?,appointment_date=?,appointment_time=?,status=? WHERE appointment_id=?";



            PreparedStatement ps =
                    con.prepareStatement(sql);



            ps.setInt(1,Integer.parseInt(patientField.getText()));

            ps.setInt(2,Integer.parseInt(doctorField.getText()));

            ps.setDate(3,Date.valueOf(dateField.getText()));

            ps.setTime(4,Time.valueOf(timeField.getText()));

            ps.setString(5,statusField.getText());

            ps.setInt(6,Integer.parseInt(idField.getText()));



            ps.executeUpdate();



            JOptionPane.showMessageDialog(
                    this,
                    "Appointment Updated Successfully"
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