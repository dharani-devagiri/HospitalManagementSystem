package hospital;

import javax.swing.*;
import java.sql.*;

public class UpdateBill extends JInternalFrame {


    JTextField idField, doctorFeeField, medicineField;


    UpdateBill(){


        setTitle("Update Bill");

        setSize(450,350);

        setLayout(null);

        setClosable(true);

        setResizable(true);



        JLabel idLabel = new JLabel("Bill ID:");

        idLabel.setBounds(50,50,120,30);


        idField = new JTextField();

        idField.setBounds(180,50,180,30);




        JLabel doctorLabel = new JLabel("Doctor Fee:");

        doctorLabel.setBounds(50,100,120,30);


        doctorFeeField = new JTextField();

        doctorFeeField.setBounds(180,100,180,30);




        JLabel medicineLabel = new JLabel("Medicine Cost:");

        medicineLabel.setBounds(50,150,120,30);


        medicineField = new JTextField();

        medicineField.setBounds(180,150,180,30);




        JButton updateBtn = new JButton("Update");

        updateBtn.setBounds(140,230,150,40);




        add(idLabel);
        add(idField);

        add(doctorLabel);
        add(doctorFeeField);

        add(medicineLabel);
        add(medicineField);

        add(updateBtn);




        updateBtn.addActionListener(e -> updateBill());



        setVisible(true);


    }






    void updateBill(){


        try{


            Connection con =
                    DBConnection.getConnection();



            double doctorFee =
                    Double.parseDouble(
                            doctorFeeField.getText()
                    );


            double medicine =
                    Double.parseDouble(
                            medicineField.getText()
                    );


            double total =
                    doctorFee + medicine;




            String sql =
            "UPDATE bill SET doctor_fee=?, medicine_cost=?, total_amount=? WHERE bill_id=?";



            PreparedStatement ps =
                    con.prepareStatement(sql);



            ps.setDouble(1,doctorFee);

            ps.setDouble(2,medicine);

            ps.setDouble(3,total);

            ps.setInt(4,
                    Integer.parseInt(idField.getText()));




            int result =
                    ps.executeUpdate();




            if(result>0){

                JOptionPane.showMessageDialog(
                        this,
                        "Bill Updated Successfully"
                );

            }
            else{

                JOptionPane.showMessageDialog(
                        this,
                        "Bill ID Not Found"
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