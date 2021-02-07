package model;

public class GradeItem{
    String courseId;
    String examId;
    int grade;

    public GradeItem(String courseId, String examId, int grade){
        this.courseId=courseId;
        this.examId=examId;
        this.grade=grade;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getExamId() {
        return examId;
    }

    public int getGrade() {
        return grade;
    }
}