package hospital;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {


    JDesktopPane desktop;


    Dashboard() {


        setTitle("Hospital Management System");

        ImageIcon icon = new ImageIcon(
        "images/hospital.png"
);

setIconImage(icon.getImage());

        setSize(1100,650);

        setLayout(new BorderLayout());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        // ================= TOP HEADER =================

        JPanel topPanel = new JPanel();

        topPanel.setBackground(new Color(0,90,160));

        topPanel.setPreferredSize(new Dimension(0,70));



        ImageIcon logo = new ImageIcon(
        "images/hospital.png"
);

JLabel title = new JLabel(
        "Hospital Management System",
        logo,
        JLabel.CENTER
);


        title.setForeground(Color.WHITE);

        title.setFont(
                new Font("Arial",Font.BOLD,30)
        );


        topPanel.add(title);



        add(topPanel,BorderLayout.NORTH);





        // ================= LEFT MENU =================


        JPanel menuPanel = new JPanel();


        menuPanel.setBackground(
                new Color(230,240,250)
        );


        menuPanel.setLayout(
                new GridLayout(7,1,15,15)
        );


        menuPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        20,15,20,15
                )
        );


        menuPanel.setPreferredSize(
                new Dimension(220,0)
        );




        JButton patientBtn =
                new JButton("Patients");


        JButton doctorBtn =
                new JButton("Doctors");


        JButton appointmentBtn =
                new JButton("Appointments");


        JButton billingBtn =
                new JButton("Billing");


        JButton statisticsBtn =
                new JButton("Statistics");


        JButton logoutBtn =
                new JButton("Logout");




        JButton buttons[] =
        {
                patientBtn,
                doctorBtn,
                appointmentBtn,
                billingBtn,
                statisticsBtn,
                logoutBtn
        };



        for(JButton b:buttons){


            b.setFont(
                    new Font(
                            "Arial",
                            Font.BOLD,
                            16
                    )
            );


            b.setBackground(
                    Color.WHITE
            );


            b.setForeground(
                    new Color(0,90,160)
            );


            b.setFocusPainted(false);


        }





        menuPanel.add(patientBtn);

        menuPanel.add(doctorBtn);

        menuPanel.add(appointmentBtn);

        menuPanel.add(billingBtn);

        menuPanel.add(statisticsBtn);

        menuPanel.add(logoutBtn);



        add(menuPanel,BorderLayout.WEST);







        // ================= DESKTOP AREA =================


        desktop = new JDesktopPane();


        desktop.setBackground(
                new Color(245,250,255)
        );



        JLabel welcome = new JLabel(
                "Welcome to Hospital Management System"
        );


        welcome.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        26
                )
        );


        welcome.setForeground(
                new Color(0,90,160)
        );


        welcome.setBounds(
                250,
                200,
                600,
                50
        );


        desktop.add(welcome);



        add(desktop,BorderLayout.CENTER);







        // ================= BUTTON ACTIONS =================




        patientBtn.addActionListener(e -> {


            PatientMenu pm = new PatientMenu();

            desktop.add(pm);

            pm.setVisible(true);

            try{
                pm.setSelected(true);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }

        });







        doctorBtn.addActionListener(e -> {


            DoctorMenu dm = new DoctorMenu();

            desktop.add(dm);

            dm.setVisible(true);


            try{
                dm.setSelected(true);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }

        });







        appointmentBtn.addActionListener(e -> {


            AppointmentMenu am = new AppointmentMenu();


            desktop.add(am);


            am.setVisible(true);



            try{
                am.setSelected(true);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }

        });







        billingBtn.addActionListener(e -> {


            BillingMenu bm = new BillingMenu();


            desktop.add(bm);


            bm.setVisible(true);



            try{
                bm.setSelected(true);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }


        });







        statisticsBtn.addActionListener(e -> {


            Statistics s = new Statistics();


            desktop.add(s);


            s.setVisible(true);



            try{
                s.setSelected(true);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }


        });








        logoutBtn.addActionListener(e -> {


            int choice =
            JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to logout?",
                    "Logout",
                    JOptionPane.YES_NO_OPTION
            );



            if(choice == JOptionPane.YES_OPTION){


                dispose();

                new Login();


            }


        });






        setLocationRelativeTo(null);


        setVisible(true);


    }


}