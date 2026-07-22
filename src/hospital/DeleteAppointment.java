package hospital;

import javax.swing.*;
import java.sql.*;

public class DeleteAppointment extends JInternalFrame {


    JTextField idField;



    DeleteAppointment(){


        setTitle("Delete Appointment");

        setSize(400,250);

        setLayout(null);

        setClosable(true);

        setResizable(true);




        JLabel idLabel = new JLabel("Appointment ID:");

        idLabel.setBounds(40,50,120,30);



        idField = new JTextField();

        idField.setBounds(170,50,150,30);




        JButton deleteBtn = new JButton("Delete");

        deleteBtn.setBounds(130,120,120,40);




        add(idLabel);

        add(idField);

        add(deleteBtn);





        deleteBtn.addActionListener(e -> deleteAppointment());



        setVisible(true);


    }







    void deleteAppointment(){


        try{


            Connection con =
                    DBConnection.getConnection();




            String sql =
            "DELETE FROM appointment WHERE appointment_id=?";



            PreparedStatement ps =
                    con.prepareStatement(sql);



            ps.setInt(1,
                    Integer.parseInt(idField.getText()));




            int result =
                    ps.executeUpdate();





            if(result > 0){


                JOptionPane.showMessageDialog(
                        this,
                        "Appointment Deleted Successfully"
                );


            }
            else{


                JOptionPane.showMessageDialog(
                        this,
                        "Appointment ID Not Found"
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