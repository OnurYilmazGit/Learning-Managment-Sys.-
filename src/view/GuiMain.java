package view;

import java.util.Random;

import javax.swing.UIManager;

import model.Course;
import model.Department;
import model.Instructor_Login;
import model.Student;

public class GuiMain {

	public static void main(String[] args) throws Exception {
		
		// do not worry about this line
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		Department myDepartment = createDepartment();
		
		//This is where you instantiate an object from login screen class
		new Instructor_Login(myDepartment);
		
	}
	
	private static Department createDepartment() {
		
		Department department = new Department("Computer Science");
		
		department.addInstructor("Reyyan Yeniterzi");
		department.addInstructor("Reyhan Aydogan");
		department.addInstructor("Murat Sensoy");

		
		department.createCourse("CS102", "Object Oriented Programming");
		department.createCourse("CS201", "Data Structures");
		department.createCourse("CS101", "Introduction to CS");
		department.createCourse("CS404", "Digital Image Processing");
		department.createCourse("CS560", "Information Retrieval");
		
		department.assignInstructorToCourse("Reyyan Yeniterzi", "CS102");
		department.assignInstructorToCourse("Reyyan Yeniterzi", "CS560");
		department.assignInstructorToCourse("Reyhan Aydogan", "CS101");
		
		for (int i = 0; i < 10; i++)
			department.addStudent(createRandomName());
		
		Course oop = department.getCourse("CS102");
		for (int i = 0; i < 5; i++) {
			Student student = department.getStudents().get(i);
			student.registerToCourse(oop);
		}

		Course ir = department.getCourse("CS560");
		for (int i = 4; i < 8; i++) {
			Student student = department.getStudents().get(i);
			student.registerToCourse(ir);
		}
		
		return department;
	}

	
	private static String createRandomName() {
		String[] firstNames = { "Ali", "Ayse", "Ahmet", "Mehmet", "Mustafa", "Gizem", "Sibel", "Burak", "Bahar" };
		String[] lastNames = { "Yilmaz", "Caliskan", "Korkmaz", "Kaya", "Akar", "Sonmez", "Celikoglu" };

		Random random = new Random();

		String firstName = firstNames[random.nextInt(firstNames.length)];
		String lastName = lastNames[random.nextInt(lastNames.length)];
		String name = firstName + " " + lastName;

		return name;
	}
	
}
