package hospital;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Statistics extends JInternalFrame {


    JLabel patientCount;
    JLabel doctorCount;
    JLabel appointmentCount;
    JLabel billCount;



    Statistics(){


        setTitle("Hospital Statistics");

        setSize(500,400);

        setLayout(null);

        setClosable(true);

        setResizable(true);



        JLabel title = new JLabel(
                "Hospital Statistics"
        );

        title.setBounds(120,30,300,40);

        title.setFont(
                new Font("Arial",Font.BOLD,24)
        );

        add(title);




        JLabel pLabel = new JLabel("Total Patients:");

        pLabel.setBounds(80,100,150,30);



        patientCount = new JLabel("0");

        patientCount.setBounds(280,100,100,30);




        JLabel dLabel = new JLabel("Total Doctors:");

        dLabel.setBounds(80,150,150,30);



        doctorCount = new JLabel("0");

        doctorCount.setBounds(280,150,100,30);




        JLabel aLabel = new JLabel("Total Appointments:");

        aLabel.setBounds(80,200,150,30);



        appointmentCount = new JLabel("0");

        appointmentCount.setBounds(280,200,100,30);




        JLabel bLabel = new JLabel("Total Bills:");

        bLabel.setBounds(80,250,150,30);



        billCount = new JLabel("0");

        billCount.setBounds(280,250,100,30);




        add(pLabel);
        add(patientCount);

        add(dLabel);
        add(doctorCount);

        add(aLabel);
        add(appointmentCount);

        add(bLabel);
        add(billCount);




        loadStatistics();



        setVisible(true);


    }







    void loadStatistics(){


        try{


            Connection con =
                    DBConnection.getConnection();



            Statement st =
                    con.createStatement();




            ResultSet rs;



            rs = st.executeQuery(
                    "SELECT COUNT(*) FROM patient"
            );

            if(rs.next())
                patientCount.setText(
                        rs.getString(1)
                );




            rs = st.executeQuery(
                    "SELECT COUNT(*) FROM doctor"
            );

            if(rs.next())
                doctorCount.setText(
                        rs.getString(1)
                );




            rs = st.executeQuery(
                    "SELECT COUNT(*) FROM appointment"
            );

            if(rs.next())
                appointmentCount.setText(
                        rs.getString(1)
                );




            rs = st.executeQuery(
                    "SELECT COUNT(*) FROM bill"
            );

            if(rs.next())
                billCount.setText(
                        rs.getString(1)
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