package model;

import java.util.ArrayList;

public class Student extends Person {
    ArrayList<Course> entrolledCourse;
    ArrayList<GradeItem> gradeitem;

    public Student(String name) {
        super(name);
        this.entrolledCourse = new ArrayList<Course>();
        this.gradeitem = new ArrayList<GradeItem>(1000);
    }
    //this method assign uniuqe mail for a each student.
    public String initEmail(){
        String email = "";
        String[] words = this.name.split("\\s");
        email += words[0] + "." + words[1] + "@ozu.edu.tr";
        setEmail(email);
        return  email.toLowerCase();
    }
    //Student register a course using this method.
    public void registerToCourse(Course course) {
        if(course.getInstructor() == null) {
            System.out.println("Course not available");
        }else if(this == null) {
            System.out.println("Null name");
        }else
            course.addStudent(this);
        this.entrolledCourse.add(course);
    }

    public void dropCourse(Course course) {
        entrolledCourse.remove(course);
    }

    //getGradeItem method use to return gradeitem of student.
    public GradeItem getGradeItem(String courseId, String examId) {
        GradeItem gradeitem1 = null;
        for (int i = 0; i < gradeitem.size(); i++) {
            if (gradeitem.get(i).getCourseId().equals(courseId) && gradeitem.get(i).getExamId().equals(examId)) {
                gradeitem1 = gradeitem.get(i);
            }
        }
        return gradeitem1;
    }

    public ArrayList<GradeItem> getGradeitem() {
        return gradeitem;
    }

    //print student grade about the some specific course.
    public void listGrades() {
        String strr = "";
        for (int c = 0; c < entrolledCourse.size(); c++) {
            for(int f = 0; f<entrolledCourse.get(c).getRegistired__exam_grade_num(); f++) {
                strr ="[" + gradeitem.get(f).getExamId() + ": " + gradeitem.get(f).getGrade() + "] ";
                System.out.print(entrolledCourse.get(c).getCourse_id() + " grades of " + this.name + ":" + strr);
                System.out.println('\n');
            }

        }
    }
}
