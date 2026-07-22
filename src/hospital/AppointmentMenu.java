package hospital;

import javax.swing.*;

public class AppointmentMenu extends JInternalFrame {


    AppointmentMenu(){


        setTitle("Appointment Management");

        setSize(400,400);

        setLayout(null);

        setClosable(true);

        setResizable(true);



        JButton addBtn = new JButton("Add Appointment");

        addBtn.setBounds(100,50,200,40);



        JButton viewBtn = new JButton("View Appointment");

        viewBtn.setBounds(100,110,200,40);



        JButton updateBtn = new JButton("Update Appointment");

        updateBtn.setBounds(100,170,200,40);



        JButton deleteBtn = new JButton("Delete Appointment");

        deleteBtn.setBounds(100,230,200,40);




        add(addBtn);

        add(viewBtn);

        add(updateBtn);

        add(deleteBtn);





        // Add Appointment

        addBtn.addActionListener(e -> {


            AddAppointment aa = new AddAppointment();


            getDesktopPane().add(aa);


            aa.setVisible(true);


            try{

                aa.setSelected(true);

            }
            catch(Exception ex){

                ex.printStackTrace();

            }


        });






        // View Appointment

        viewBtn.addActionListener(e -> {


            ViewAppointment va = new ViewAppointment();


            getDesktopPane().add(va);


            va.setVisible(true);


            try{

                va.setSelected(true);

            }
            catch(Exception ex){

                ex.printStackTrace();

            }


        });







        // Update Appointment

        updateBtn.addActionListener(e -> {


            UpdateAppointment ua = new UpdateAppointment();


            getDesktopPane().add(ua);


            ua.setVisible(true);


            try{

                ua.setSelected(true);

            }
            catch(Exception ex){

                ex.printStackTrace();

            }


        });







        // Delete Appointment

        deleteBtn.addActionListener(e -> {


            DeleteAppointment da = new DeleteAppointment();


            getDesktopPane().add(da);


            da.setVisible(true);


            try{

                da.setSelected(true);

            }
            catch(Exception ex){

                ex.printStackTrace();

            }


        });




        setVisible(true);

    }

}