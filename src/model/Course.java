package model;

import java.awt.*;
import java.util.ArrayList;

public class Course extends Component {
    String course_id;
    String course_name;
    String examId;
    int grade;
    Instructor instructor;
    ArrayList<Student> student;
    int registired__exam_grade_num = 0;
    int student_number_counter;
    int student_number_counter_zero =0;


    public Course(String course_id, String course_name) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.instructor = instructor;
        this.student = new ArrayList<Student>();
    }

    public Course(String id) {
        this.course_id = id;
        this.course_name = course_name;
        this.instructor = instructor;
        this.student = new ArrayList<Student>();
    }
    //Prints the student list of a class.
    public void listStudents() {
        System.out.println("Students registered in " + this.course_name + " are:");
        for (int i = 0; i < this.student.size(); i++) {
            System.out.println(this.student.get(i).getName());
        }
    }

    public ArrayList<Student> getStudent() {
        return student;
    }

    public String getExamId() {
        return examId;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void addStudent(Student stdn) {
        this.student.add(stdn);
    }

    public void removeStudent(Student stdn) {
        student.remove(stdn);
    }

    public String getName() {
        return this.course_name;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    // Here, this method return the how much exam registered for a one class.
    public int getRegistired__exam_grade_num() {
        return registired__exam_grade_num;
    }

    public int getStudent_number_counter() {
        return student_number_counter;
    }

    public void setStudent_number_counter() {
        this.student_number_counter += 1;
    }
    public void setStudent_number_counter_special(int i) {
        this.student_number_counter = 0;
    }

    public void setStudent_number_counter_zero() {
        this.student_number_counter_zero +=1;
    }

    public void setStudent_number_counter_zero(int i) {
        this.student_number_counter_zero = 0;
    }

    // When a new exam registered, its automatically increase the total registered exam number.
    public void setRegistired__exam_grade_num() {
        this.registired__exam_grade_num +=1;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id='" + course_id + '\'' +
                ", course_name='" + course_name + '\'' +
                ", examId='" + examId + '\'' +
                ", grade=" + grade +
                ", instructor=" + instructor +
                ", student=" + student +
                '}';
    }
}