package hospital;

import javax.swing.*;

public class DoctorMenu extends JInternalFrame {


    DoctorMenu(){


        setTitle("Doctor Management");

        setSize(400,400);

        setLayout(null);

        setClosable(true);

        setResizable(true);



        JButton addBtn = new JButton("Add Doctor");

        addBtn.setBounds(100,50,200,40);



        JButton viewBtn = new JButton("View Doctor");

        viewBtn.setBounds(100,110,200,40);



        JButton updateBtn = new JButton("Update Doctor");

        updateBtn.setBounds(100,170,200,40);



        JButton deleteBtn = new JButton("Delete Doctor");

        deleteBtn.setBounds(100,230,200,40);




        add(addBtn);

        add(viewBtn);

        add(updateBtn);

        add(deleteBtn);




        // Add Doctor

        addBtn.addActionListener(e -> {

    AddDoctor ad = new AddDoctor();

    getDesktopPane().add(ad);

    ad.setVisible(true);

    try {
        ad.setSelected(true);
    }
    catch(Exception ex){
        ex.printStackTrace();
    }

});



        // View Doctor

       viewBtn.addActionListener(e -> {

    ViewDoctor vd = new ViewDoctor();

    getDesktopPane().add(vd);

    vd.setVisible(true);

    try {
        vd.setSelected(true);
    }
    catch(Exception ex){
        ex.printStackTrace();
    }

});




        // Update Doctor

        updateBtn.addActionListener(e -> {

    UpdateDoctor ud = new UpdateDoctor();

    getDesktopPane().add(ud);

    ud.setVisible(true);

    try {
        ud.setSelected(true);
    }
    catch(Exception ex){
        ex.printStackTrace();
    }

});




        // Delete Doctor

        deleteBtn.addActionListener(e -> {

    DeleteDoctor dd = new DeleteDoctor();

    getDesktopPane().add(dd);

    dd.setVisible(true);

    try {
        dd.setSelected(true);
    }
    catch(Exception ex){
        ex.printStackTrace();
    }

});




        setVisible(true);

    }

}