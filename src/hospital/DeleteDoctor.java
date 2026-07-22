package hospital;

import javax.swing.*;
import java.sql.*;

public class DeleteDoctor extends JInternalFrame {


    JTextField idField;



    DeleteDoctor(){


        setTitle("Delete Doctor");

        setSize(400,250);

        setLayout(null);

        setClosable(true);

        setResizable(true);




        JLabel idLabel = new JLabel("Doctor ID:");

        idLabel.setBounds(50,50,100,30);



        idField = new JTextField();

        idField.setBounds(160,50,150,30);




        JButton deleteBtn = new JButton("Delete");

        deleteBtn.setBounds(130,120,120,40);




        add(idLabel);

        add(idField);

        add(deleteBtn);




        deleteBtn.addActionListener(e -> deleteDoctor());



        setVisible(true);

    }






    void deleteDoctor(){


        try{


            Connection con =
                    DBConnection.getConnection();



            String sql =
            "DELETE FROM doctor WHERE doctor_id=?";



            PreparedStatement ps =
                    con.prepareStatement(sql);



            ps.setInt(1,
                    Integer.parseInt(idField.getText()));




            int result =
                    ps.executeUpdate();




            if(result>0){


                JOptionPane.showMessageDialog(
                        this,
                        "Doctor Deleted Successfully"
                );


            }
            else{


                JOptionPane.showMessageDialog(
                        this,
                        "Doctor ID Not Found"
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