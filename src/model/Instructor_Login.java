package model;

import GUI.InstructorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instructor_Login {

    Department myDepartment;

    public Instructor_Login(Department myDepartment) {
        this.myDepartment = myDepartment;

        System.out.println(myDepartment.getInstructors());
        init(myDepartment);
    }

    public void init(Department myDepartment) {
        JFrame app = new JFrame();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(800, 600);

        JPanel mainPanel = new JPanel();
        JLabel label = new JLabel("Email");
        JTextField email_Field = new JTextField(21);
        JButton login_button = new JButton("Login");
        login_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mail = email_Field.getText();
                if (myDepartment.check_InstructorByMail(mail)) {
                    new InstructorFrame(myDepartment.getInstructorByMail(mail));
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill the email correctly.");
                }

            }
        });

        mainPanel.add(label);
        mainPanel.add(email_Field);
        mainPanel.add(login_button);

        app.add(mainPanel);
        app.setVisible(true);

    }
}
