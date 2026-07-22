package hospital;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewBill extends JInternalFrame {


    JTable table;

    DefaultTableModel model;



    ViewBill(){


        setTitle("View Bills");

        setSize(750,400);

        setClosable(true);

        setResizable(true);




        model = new DefaultTableModel();


        model.addColumn("Bill ID");

        model.addColumn("Patient ID");

        model.addColumn("Doctor Fee");

        model.addColumn("Medicine Cost");

        model.addColumn("Total");

        model.addColumn("Date");




        table = new JTable(model);



        add(new JScrollPane(table));



        loadBills();



        setVisible(true);


    }






    void loadBills(){


        try{


            Connection con =
                    DBConnection.getConnection();




            ResultSet rs =
            con.createStatement()
            .executeQuery("SELECT * FROM bill");




            while(rs.next()){


                model.addRow(new Object[]{


                    rs.getInt("bill_id"),

                    rs.getInt("patient_id"),

                    rs.getDouble("doctor_fee"),

                    rs.getDouble("medicine_cost"),

                    rs.getDouble("total_amount"),

                    rs.getDate("bill_date")


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