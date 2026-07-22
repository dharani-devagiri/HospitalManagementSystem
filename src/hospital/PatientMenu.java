package hospital;

import javax.swing.*;

public class PatientMenu extends JInternalFrame {


    PatientMenu(){

        setTitle("Patient Management");

        setSize(400,400);

        setLayout(null);

        setClosable(true);

        setResizable(true);



        JButton addBtn = new JButton("Add Patient");

        addBtn.setBounds(100,50,200,40);



        JButton viewBtn = new JButton("View Patient");

        viewBtn.setBounds(100,110,200,40);



        JButton updateBtn = new JButton("Update Patient");

        updateBtn.setBounds(100,170,200,40);



        JButton deleteBtn = new JButton("Delete Patient");

        deleteBtn.setBounds(100,230,200,40);



        add(addBtn);

        add(viewBtn);

        add(updateBtn);

        add(deleteBtn);




      addBtn.addActionListener(e -> {

    AddPatient ap = new AddPatient();

    getDesktopPane().add(ap);

    ap.setVisible(true);

    try {
        ap.setSelected(true);
    }
    catch(Exception ex){
        ex.printStackTrace();
    }

});




     viewBtn.addActionListener(e -> {

    ViewPatient vp = new ViewPatient();

    getDesktopPane().add(vp);

    vp.setVisible(true);

    try {
        vp.setSelected(true);
    }
    catch(Exception ex){
        ex.printStackTrace();
    }

});




       updateBtn.addActionListener(e -> {

    UpdatePatient up = new UpdatePatient();

    getDesktopPane().add(up);

    up.setVisible(true);

    try {
        up.setSelected(true);
    }
    catch(Exception ex){
        ex.printStackTrace();
    }

});



deleteBtn.addActionListener(e -> {

    DeletePatient dp = new DeletePatient();

    getDesktopPane().add(dp);

    dp.setVisible(true);

    try {
        dp.setSelected(true);
    }
    catch(Exception ex){
        ex.printStackTrace();
    }

});



        setVisible(true);

    }

}