package hospital;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewDoctor extends JInternalFrame {


    JTable table;

    DefaultTableModel model;



    ViewDoctor(){


        setTitle("View Doctors");

        setSize(700,400);

        setClosable(true);

        setResizable(true);



        model = new DefaultTableModel();



        model.addColumn("ID");

        model.addColumn("Doctor Name");

        model.addColumn("Specialization");

        model.addColumn("Phone");

        model.addColumn("Email");



        table = new JTable(model);



        add(new JScrollPane(table));



        loadDoctors();



        setVisible(true);

    }





    void loadDoctors(){


        try{


            Connection con =
                    DBConnection.getConnection();



            ResultSet rs =
            con.createStatement()
            .executeQuery("SELECT * FROM doctor");




            while(rs.next()){


                model.addRow(new Object[]{


                        rs.getInt("doctor_id"),

                        rs.getString("doctor_name"),

                        rs.getString("specialization"),

                        rs.getString("phone"),

                        rs.getString("email")


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