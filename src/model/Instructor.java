package model;

import java.util.ArrayList;
import java.util.Random;

public class Instructor extends Person {
    ArrayList<Course> courses;

    public Instructor(String name) {
        super(name);
        this.courses = new ArrayList<Course>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    //Here initEmail function creates unique mail for the each instructor.
    public String initEmail() {
        String email = "";
        String[] words = this.name.split("\\s");
        email += words[0] + "." + words[1] + "@ozyegin.edu.tr";
        setEmail(email.toLowerCase());
        return email.toLowerCase();
    }
    //if there is a such class given by this instructor, it registers the exam grades to the students gradeItem.
    public void registerExamGrades(String courseId, String examId,int grade) {
        if (getCourse(courseId) == null) {
            System.out.println("Instructor " + getName() + " cannot grade the course " + courseId + ".");
        } else {
            GradeItem gradeitem = null;
            Course crs1 = getCourse(courseId);
            gradeitem = new GradeItem(courseId, examId, grade);
            crs1.student.get(crs1.student_number_counter).gradeitem.add(gradeitem);
            crs1.setRegistired__exam_grade_num();
            crs1.setStudent_number_counter();
            }
        }

    public void registerExamGrades_overload(String courseId, String examId,int grade) {
        if (getCourse(courseId) == null) {
            System.out.println("Instructor " + getName() + " cannot grade the course " + courseId + ".");
        } else {
            GradeItem gradeitem = null;
            Course crs1 = getCourse(courseId);
            gradeitem = new GradeItem(courseId, examId, grade);
            crs1.student.get(crs1.student_number_counter_zero).gradeitem.remove(gradeitem);
            crs1.student.get(crs1.student_number_counter_zero).gradeitem.add(gradeitem);
            crs1.setRegistired__exam_grade_num();
            crs1.setStudent_number_counter_zero();
        }
    }

    //Here listGradesForExam method created to show grades of the a course exam.
    public void listGradesForExam(String courseId, String examId) {
        GradeItem gd = null;
        for (int f = 0; f < courses.size(); f++) {
            if (courses.get(f).getCourse_id().equals(courseId)) {
                System.out.println(courseId + " " + examId + " grades are: \n");
                for (int c = 0; c < courses.get(f).student.size(); c++) {
                    gd = courses.get(f).student.get(c).getGradeItem(courseId, examId);
                    System.out.println(courses.get(f).student.get(c).name + ": [" + gd.examId + ": " + gd.grade + "]");
                }
            }
        }
    }
    //This method basically, trying to find course object from the just coursename or courseId then it returns the course object.
    public Course getCourse(String st) {
        Course crs = null;
        for (int c = 0; c < courses.size(); c++) {
            if (courses.get(c).getCourse_id().equals(st) || courses.get(c).course_name.equals(st)) {
                crs = courses.get(c);
            }
        }
        return crs;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    //This method takes each course student size and their grade then it calculates the average point of the exam.
    public void printAverageGradeForExam(String courseId, String examId) {
        GradeItem gd = null;
        int avarage = 0;
        for (int f = 0; f < courses.size(); f++) {
            if (courses.get(f).getCourse_id().equals(courseId)) {
                for (int c = 0; c < courses.get(f).student.size(); c++) {
                    gd = courses.get(f).student.get(c).getGradeItem(courseId, examId);
                    avarage += gd.grade;
                }
                avarage = avarage / courses.get(f).student.size();
            }
        }
        System.out.println(courseId + " " + examId + " avarage grades is: " + avarage);
    }
    //creates random number while assigning a grate to students gradeItem.
    public int rand_grade() {
        Random rand = new Random();
        int rand_grade = rand.nextInt(101);
        return rand_grade;
    }
}