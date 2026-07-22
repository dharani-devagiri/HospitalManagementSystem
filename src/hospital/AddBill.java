package hospital;

import javax.swing.*;
import java.sql.*;

public class AddBill extends JInternalFrame {


    JTextField patientField, doctorFeeField, medicineField;



    AddBill(){


        setTitle("Generate Bill");

        setSize(450,350);

        setLayout(null);

        setClosable(true);

        setResizable(true);



        JLabel patientLabel = new JLabel("Patient ID:");

        patientLabel.setBounds(50,50,120,30);


        patientField = new JTextField();

        patientField.setBounds(180,50,180,30);




        JLabel doctorLabel = new JLabel("Doctor Fee:");

        doctorLabel.setBounds(50,100,120,30);


        doctorFeeField = new JTextField();

        doctorFeeField.setBounds(180,100,180,30);




        JLabel medicineLabel = new JLabel("Medicine Cost:");

        medicineLabel.setBounds(50,150,120,30);


        medicineField = new JTextField();

        medicineField.setBounds(180,150,180,30);




        JButton addBtn = new JButton("Generate");

        addBtn.setBounds(140,230,150,40);




        add(patientLabel);
        add(patientField);

        add(doctorLabel);
        add(doctorFeeField);

        add(medicineLabel);
        add(medicineField);

        add(addBtn);




        addBtn.addActionListener(e -> addBill());



        setVisible(true);

    }






    void addBill(){


        try{


            Connection con =
                    DBConnection.getConnection();




            double doctorFee =
                    Double.parseDouble(doctorFeeField.getText());


            double medicine =
                    Double.parseDouble(medicineField.getText());


            double total =
                    doctorFee + medicine;




            String sql =
            "INSERT INTO bill(patient_id,doctor_fee,medicine_cost,total_amount,bill_date) VALUES(?,?,?,?,CURDATE())";



            PreparedStatement ps =
                    con.prepareStatement(sql);



            ps.setInt(1,
                    Integer.parseInt(patientField.getText()));

            ps.setDouble(2,doctorFee);

            ps.setDouble(3,medicine);

            ps.setDouble(4,total);



            ps.executeUpdate();



            JOptionPane.showMessageDialog(
                    this,
                    "Bill Generated Successfully"
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