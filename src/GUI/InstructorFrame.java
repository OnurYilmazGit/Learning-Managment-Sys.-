package GUI;
import model.Instructor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class InstructorFrame extends JFrame {
    private final Instructor instructor;

    public InstructorFrame(Instructor instructor) {
        this.instructor = instructor;
        init();
    }

    public void init() {
        JFrame app = new JFrame();
        //app.add(new InstructorFrameController());
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel panel1 = new JPanel();
        for (int i = 0; i < this.instructor.getCourses().size(); i++) {
            tabbedPane.addTab(this.instructor.getCourses().get(i).getCourse_id(), createNewPanel(i));
        }

        app.add(tabbedPane);
        app.setVisible(true);


    }

    private JPanel createNewPanel(int f) {
        String[] grade_id_ = {""};
        JPanel panel = new JPanel();

        ArrayList<JLabel> label_list = new ArrayList<JLabel>();
        ArrayList<Object> textFields_list_of_r_e_button = new ArrayList<Object>();
        ArrayList<Object> textField_list_of_list_grades_button = new ArrayList<Object>();

        ArrayList<String> exam_text_id_list = new ArrayList<String>();

        JButton list_student_button = new JButton("List Students");
        list_student_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                panel.updateUI();
                panel.setLayout(null);

                for (int l = 0; l < textFields_list_of_r_e_button.size(); l++) {
                    panel.remove((Component) textFields_list_of_r_e_button.get(l));
                }

                for (int l = 0; l < textField_list_of_list_grades_button.size(); l++) {
                    panel.remove((Component) textField_list_of_list_grades_button.get(l));
                }

                JLabel id = new JLabel("ID");
                id.setBounds(40, 50, 85, 20);
                id.setForeground(Color.red);

                panel.add(id);
                label_list.add(id);
                for (int i = 0; i < instructor.getCourses().get(f).getStudent().size(); i++) {
                    final JLabel label_id = new JLabel();
                    label_id.setText(instructor.getCourses().get(f).getStudent().get(i).getId());
                    label_id.setBounds(40, 70 + (30 * i), 85, 20);
                    panel.add(label_id);
                    label_list.add(label_id);
                }

                JLabel name = new JLabel("Name");
                name.setForeground(Color.red);
                name.setBounds(270, 50, 95, 20);
                panel.add(name);
                label_list.add(name);
                for (int i = 0; i < instructor.getCourses().get(f).getStudent().size(); i++) {
                    JLabel label_name = new JLabel();
                    label_name.setText(instructor.getCourses().get(f).getStudent().get(i).getName());
                    label_name.setBounds(270, 70 + (30 * i), 130, 20);
                    label_list.add(label_name);
                    panel.add(label_name);
                }
                JLabel email = new JLabel("Email");
                email.setForeground(Color.red);
                email.setBounds(510, 50, 200, 20);
                panel.add(email);
                label_list.add(email);
                for (int i = 0; i < instructor.getCourses().get(f).getStudent().size(); i++) {
                    JLabel label_mail = new JLabel();
                    label_mail.setText(instructor.getCourses().get(f).getStudent().get(i).getEmail());
                    label_mail.setBounds(510, 70 + (30 * i), 340, 20);
                    panel.add(label_mail);
                    label_list.add(label_mail);
                }
            }
        });

        ArrayList<JTextField> jTextFields_list_exam_Id = new ArrayList<JTextField>();

        JButton register_e_g_button = new JButton("Register Exam Grades");
        register_e_g_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.updateUI();
                panel.setLayout(null);

                for (int s = 0; s < label_list.size(); s++) {
                    panel.remove(label_list.get(s));
                }

                for (int l = 0; l < textField_list_of_list_grades_button.size(); l++) {
                    panel.remove((Component) textField_list_of_list_grades_button.get(l));
                }

                exam_text_id_list.clear();

                JLabel enter_exam_id = new JLabel("Enter Exam Id:");
                enter_exam_id.setBounds(40, 80, 140, 25);
                panel.add(enter_exam_id);
                textFields_list_of_r_e_button.add(enter_exam_id);

                grade_id_[0] = enter_exam_id.getText();
                JTextField exam_text_id = new JTextField(80);
                exam_text_id.setBounds(500, 80, 140, 25);
                panel.add(exam_text_id);

                jTextFields_list_exam_Id.add(exam_text_id);
                textFields_list_of_r_e_button.add(exam_text_id);// for removing when clicked the other button.


                JLabel id = new JLabel("ID");
                id.setForeground(Color.red);
                id.setBounds(40, 130, 85, 20);
                panel.add(id);
                textFields_list_of_r_e_button.add(id);

                for (int i = 0; i < instructor.getCourses().get(f).getStudent().size(); i++) {
                    JLabel label_id = new JLabel();
                    label_id.setText(instructor.getCourses().get(f).getStudent().get(i).getId());
                    label_id.setBounds(40, 150 + (30 * i), 85, 20);
                    panel.add(label_id);
                    textFields_list_of_r_e_button.add(label_id);
                }

                JLabel name = new JLabel("Name");
                name.setBounds(270, 130, 140, 20);
                name.setForeground(Color.red);
                textFields_list_of_r_e_button.add(name);
                panel.add(name);

                for (int i = 0; i < instructor.getCourses().get(f).getStudent().size(); i++) {
                    JLabel label_name = new JLabel();
                    label_name.setText(instructor.getCourses().get(f).getStudent().get(i).getName());
                    label_name.setBounds(270, 150 + (30 * i), 130, 20);
                    panel.add(label_name);
                    textFields_list_of_r_e_button.add(label_name);
                }

                JLabel grade = new JLabel("Grade");
                grade.setForeground(Color.red);
                grade.setBounds(500, 130, 85, 20);
                panel.add(grade);
                textFields_list_of_r_e_button.add(grade);
                ArrayList<JTextField> textFieldsList = new ArrayList<>();

                for (int i = 0; i < instructor.getCourses().get(f).getStudent().size(); i++) {
                    JTextField enter_grade = new JTextField(10);
                    enter_grade.setBounds(500, 150 + (30 * i), 130, 20);
                    panel.add(enter_grade);
                    textFieldsList.add(enter_grade);
                    textFields_list_of_r_e_button.add(enter_grade);
                }

                JButton save = new JButton("Save");
                save.setBounds(545, 300, 85, 20);
                save.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            for (int i = 0; i < instructor.getCourses().get(f).getStudent().size(); i++) {
                                //exam_text_id_list.add(exam_text_id.getText().toString());
                                try {
                                    instructor.registerExamGrades(instructor.getCourses().get(f).getCourse_id(), exam_text_id.getText(), Integer.parseInt(textFieldsList.get(i).getText()));
                                    System.out.println(instructor.getCourses().get(f).getStudent().get(i).getGradeItem(instructor.getCourses().get(f).getCourse_id(), exam_text_id.getText()).getGrade());
                                } catch (Exception exception1) {
                                    try {
                                        instructor.registerExamGrades_overload(instructor.getCourses().get(f).getCourse_id(), exam_text_id.getText(), Integer.parseInt(textFieldsList.get(i).getText()));
                                    } catch (Exception exception) {
                                        instructor.getCourses().get(f).setStudent_number_counter_zero(0);
                                        instructor.registerExamGrades_overload(instructor.getCourses().get(f).getCourse_id(), exam_text_id.getText(), Integer.parseInt(textFieldsList.get(i).getText()));
                                    }
                                }
                            }

                        } catch (InputMismatchException inputMismatchException) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid input. ");
                            init();
                        } catch (NumberFormatException numberFormatException) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid input. ");
                            init();
                        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                            JOptionPane.showMessageDialog(null, "Out of Bound");
                            init();
                        } catch (NullPointerException nullPointerException) {
                            JOptionPane.showMessageDialog(null, "Null");
                            init();
                        }
                        exam_text_id_list.add(exam_text_id.getText());
                    }

                });
                panel.add(save);
                textFields_list_of_r_e_button.add(save);
            }
        });

        JButton list_grades_button = new JButton("List Grades");
        list_grades_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.updateUI();
                panel.setLayout(null);

                for (int l = 0; l < textFields_list_of_r_e_button.size(); l++) {
                    panel.remove((Component) textFields_list_of_r_e_button.get(l));
                }

                for (int l = 0; l < label_list.size(); l++) {
                    panel.remove(label_list.get(l));
                }

                JLabel id = new JLabel("ID");
                id.setBounds(40, 50, 85, 20);
                id.setForeground(Color.red);
                panel.add(id);
                textField_list_of_list_grades_button.add(id);
                for (int i = 0; i < instructor.getCourses().get(f).getStudent().size(); i++) {
                    JLabel label_id = new JLabel();
                    label_id.setText(instructor.getCourses().get(f).getStudent().get(i).getId());
                    label_id.setBounds(40, 70 + (30 * i), 85, 20);
                    panel.add(label_id);
                    textField_list_of_list_grades_button.add(label_id);
                }

                JLabel name = new JLabel("Name");
                name.setForeground(Color.red);
                name.setBounds(270, 50, 95, 20);
                panel.add(name);
                textField_list_of_list_grades_button.add(name);
                for (int i = 0; i < instructor.getCourses().get(f).getStudent().size(); i++) {
                    JLabel label_name = new JLabel();
                    label_name.setText(instructor.getCourses().get(f).getStudent().get(i).getName());
                    label_name.setBounds(270, 70 + (30 * i), 130, 20);
                    panel.add(label_name);
                    textField_list_of_list_grades_button.add(label_name);
                }

                JLabel average = new JLabel("Average");
                average.setForeground(Color.red);
                average.setBounds(40, 240, 85, 20);
                panel.add(average);
                textField_list_of_list_grades_button.add(average);

                try {
                    JLabel grades = new JLabel(exam_text_id_list.get(0));
                    grades.setForeground(Color.red);
                    grades.setBounds(510, 50, 200, 20);
                    System.out.println(grade_id_[0]);
                    panel.add(grades);
                    textField_list_of_list_grades_button.add(grades);

                    double total = 0;
                    double avarage_point = 0;
                    for (int i = 0; i < instructor.getCourses().get(f).getStudent().size(); i++) {
                        JLabel grades_list = new JLabel();
                        grades_list.setBounds(510, 70 + (30 * i), 340, 20);
                        //System.out.println("ok:" + String.valueOf(instructor.getCourses().get(f).getStudent().get(i).getGradeItem(instructor.getCourses().get(f).getCourse_id(),jTextFields_list_exam_Id.get(f).getText()).getGrade()));
                        grades_list.setText(String.valueOf(instructor.getCourses().get(f).getStudent().get(i).getGradeItem(instructor.getCourses().get(f).getCourse_id(), String.valueOf(exam_text_id_list.get(0))).getGrade()));
                        total += instructor.getCourses().get(f).getStudent().get(i).getGradeItem(instructor.getCourses().get(f).getCourse_id(), String.valueOf(exam_text_id_list.get(0))).getGrade();
                        panel.add(grades_list);
                        textField_list_of_list_grades_button.add(grades_list);
                    }
                    avarage_point = total / instructor.getCourses().get(f).getStudent().size();
                    JLabel average_pointt = new JLabel(String.valueOf(avarage_point));
                    average_pointt.setForeground(Color.red);
                    average_pointt.setBounds(510, 240, 340, 20);
                    panel.add(average_pointt);
                    textField_list_of_list_grades_button.add(average_pointt);
                    System.out.println(avarage_point);
                } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    JOptionPane.showMessageDialog(null, "Please first register the grades.");
                }
            }
        });

        panel.add(list_student_button);
        panel.add(register_e_g_button);
        panel.add(list_grades_button);
        return panel;
    }
}
