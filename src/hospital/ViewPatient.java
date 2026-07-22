package hospital;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewPatient extends JInternalFrame {


    JTable table;
    DefaultTableModel model;


    ViewPatient() {


        setTitle("View Patients");

        setSize(700,400);

        setClosable(true);

        setResizable(true);



        model = new DefaultTableModel();



        model.addColumn("ID");

        model.addColumn("Name");

        model.addColumn("Age");

        model.addColumn("Gender");

        model.addColumn("Phone");

        model.addColumn("Disease");



        table = new JTable(model);



        JScrollPane sp = new JScrollPane(table);


        add(sp);



        loadPatients();



        setVisible(true);

    }





    void loadPatients(){


        try{


            Connection con =
                    DBConnection.getConnection();




            String query =
                    "SELECT * FROM patient";



            PreparedStatement ps =
                    con.prepareStatement(query);



            ResultSet rs =
                    ps.executeQuery();




            while(rs.next()){


                model.addRow(new Object[]{


                        rs.getInt("patient_id"),

                        rs.getString("name"),

                        rs.getInt("age"),

                        rs.getString("gender"),

                        rs.getString("phone"),

                        rs.getString("disease")


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