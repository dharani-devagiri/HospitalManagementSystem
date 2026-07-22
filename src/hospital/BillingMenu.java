package hospital;

import javax.swing.*;

public class BillingMenu extends JInternalFrame {


    BillingMenu(){


        setTitle("Billing Management");

        setSize(400,400);

        setLayout(null);

        setClosable(true);

        setResizable(true);



        JButton addBtn = new JButton("Generate Bill");

        addBtn.setBounds(100,50,200,40);



        JButton viewBtn = new JButton("View Bills");

        viewBtn.setBounds(100,110,200,40);



        JButton updateBtn = new JButton("Update Bill");

        updateBtn.setBounds(100,170,200,40);



        JButton deleteBtn = new JButton("Delete Bill");

        deleteBtn.setBounds(100,230,200,40);




        add(addBtn);

        add(viewBtn);

        add(updateBtn);

        add(deleteBtn);





        // Generate Bill

        addBtn.addActionListener(e -> {


            AddBill ab = new AddBill();


            getDesktopPane().add(ab);


            ab.setVisible(true);


            try{

                ab.setSelected(true);

            }
            catch(Exception ex){

                ex.printStackTrace();

            }


        });







        // View Bills

        viewBtn.addActionListener(e -> {


            ViewBill vb = new ViewBill();


            getDesktopPane().add(vb);


            vb.setVisible(true);


            try{

                vb.setSelected(true);

            }
            catch(Exception ex){

                ex.printStackTrace();

            }


        });







        // Update Bill

        updateBtn.addActionListener(e -> {


            UpdateBill ub = new UpdateBill();


            getDesktopPane().add(ub);


            ub.setVisible(true);


            try{

                ub.setSelected(true);

            }
            catch(Exception ex){

                ex.printStackTrace();

            }


        });







        // Delete Bill

        deleteBtn.addActionListener(e -> {


            DeleteBill db = new DeleteBill();


            getDesktopPane().add(db);


            db.setVisible(true);


            try{

                db.setSelected(true);

            }
            catch(Exception ex){

                ex.printStackTrace();

            }


        });





        setVisible(true);


    }


}