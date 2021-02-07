package model;

import java.util.ArrayList;

public class Department {
    String name;
    ArrayList<Course> courses;
    ArrayList<Instructor> instructors;
    ArrayList<Student> students;

    public Department(String name) {
        this.name = name;
        this.courses = new ArrayList<Course>();
        this.instructors = new ArrayList<Instructor>();
        this.students = new ArrayList<Student>();
    }
    //this methods, takes instructor information and add to instructor list of the department object.
    public void addInstructor(String instructor) {
        Instructor inst = new Instructor(instructor);
        inst.setId(inst.Id_Generator());
        inst.setEmail(inst.initEmail());
        instructors.add(inst);
    }

    public void addStudent(String stdn) {
        if (stdn != null) {
            Student stdnt = new Student(stdn);
            stdnt.setId(stdnt.Id_Generator());
            stdnt.setEmail(stdnt.initEmail());
            students.add(stdnt);
        }
    }
    // It first tries to find course and intructor object, then,if there is a instructor and course on the same time. It adds this instructor to the course list and initialize new student list.
    public void assignInstructorToCourse(String insturctorName, String courseId) {
        Course n_c = getCourse(courseId);
        Instructor instruct = getInstructorByName(insturctorName);
        if (n_c == null && instruct == null) {
            System.out.println("Course not found: " + courseId);
            System.out.println("Insturctor not found: " + insturctorName);
        } else if (n_c == null) {
            System.out.println("Course not found: " + courseId);
        } else if (instruct == null) {
            System.out.println("Insturctor not found: " + insturctorName);
        } else {
            n_c.setInstructor(getInstructorByName(insturctorName));
            instruct.courses.add(n_c);
            n_c.student = new ArrayList<Student>();
        }
    }
    //initializing new course.
    public void createCourse(String courseId, String courseName) {
        Course n_course = new Course(courseId, courseName);
        courses.add(n_course);
    }
    //initializing new course. Overloading.
    public void createCourse(String courseId) {
        Course n_course = new Course(courseId);
        courses.add(n_course);
    }

    //This methods aims to return course object that given its name.
    public Course getCourse(String st) {
        Course crs = null;
        for (int c = 0; c < courses.size(); c++) {
            if (courses.get(c).getCourse_id().equals(st) || courses.get(c).course_name.equals(st)) {
                crs = courses.get(c);
            }
        }
        return crs;
    }
    //this methods aims to return Instructor object that given its name.
    public Instructor getInstructorByName(String inst_name) {
        Instructor instrc = null;
        for (int g = 0; g < instructors.size(); g++) {
            if (instructors.get(g).getName().equals(inst_name)) {
                instrc = instructors.get(g);
            }
        }
        return instrc;
    }

    public Instructor getInstructorByMail(String mail_inst) {
        Instructor instrc = null;
        for (int g = 0; g < instructors.size(); g++) {
            if (instructors.get(g).getEmail().equals(mail_inst)) {
                instrc = instructors.get(g);
            }
        }
        return instrc;
    }

    //this methods aims to return Instructor object that given its mail.
    public boolean check_InstructorByMail(String mail_name) {
        boolean flag = false;
        for (int g = 0; g < instructors.size(); g++) {
            if (instructors.get(g).getEmail().equals(mail_name)) {
                flag = true;
            }
        }
        return flag;
    }

    //Course list printer
    public void listCourses() {
        String emp = "";
        String namee = null;
        System.out.println("\nCourses given by this department are:");
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getInstructor() == null) {
                emp += courses.get(i).course_id + " " + courses.get(i).getName() + "\n";
            } else {
                emp += courses.get(i).course_id + " " + courses.get(i).getName() + " by " + courses.get(i).getInstructor().getName() + "\n";
            }
        }
        System.out.println(emp);
    }
    //Instructor list printer
    public void listInstructors() {
        String emp1 = "";
        System.out.println("Instructors registered in this department are:");
        for (int i = 0; i < instructors.size(); i++) {
            emp1 += instructors.get(i).Id_Generator() + " " + instructors.get(i).getName() + " " + instructors.get(i).initEmail() + "\n";
        }
        System.out.println(emp1);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    //Student List Printer
    public void listStudents() {
        String emp2 = "";
        System.out.println("Students registered in this department are:");
        for (int i = 0; i < students.size(); i++) {
            emp2 += students.get(i).Id_Generator() + " " + students.get(i).getName() + " " + students.get(i).initEmail() + "\n";
        }
        System.out.println(emp2);
    }

}