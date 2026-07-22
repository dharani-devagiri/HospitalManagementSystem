package hospital;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewAppointment extends JInternalFrame {


    JTable table;

    DefaultTableModel model;



    ViewAppointment(){


        setTitle("View Appointments");

        setSize(750,400);

        setClosable(true);

        setResizable(true);




        model = new DefaultTableModel();



        model.addColumn("Appointment ID");

        model.addColumn("Patient ID");

        model.addColumn("Doctor ID");

        model.addColumn("Date");

        model.addColumn("Time");

        model.addColumn("Status");




        table = new JTable(model);



        add(new JScrollPane(table));



        loadAppointments();



        setVisible(true);


    }






    void loadAppointments(){


        try{


            Connection con =
                    DBConnection.getConnection();




            String query =
                    "SELECT * FROM appointment";



            PreparedStatement ps =
                    con.prepareStatement(query);



            ResultSet rs =
                    ps.executeQuery();




            while(rs.next()){



                model.addRow(new Object[]{


                        rs.getInt("appointment_id"),

                        rs.getInt("patient_id"),

                        rs.getInt("doctor_id"),

                        rs.getDate("appointment_date"),

                        rs.getTime("appointment_time"),

                        rs.getString("status")


                });


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