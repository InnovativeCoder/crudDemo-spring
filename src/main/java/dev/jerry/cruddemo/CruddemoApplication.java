package dev.jerry.cruddemo;

import dev.jerry.cruddemo.dao.StudentDAO;
import dev.jerry.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
//			createStudent(studentDAO);

			createMultipleStudents(studentDAO);

//			readStudent(studentDAO);

//			queryForStudents(studentDAO);

//			queryForStudentsByLastName(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);

//			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all the Students");
		int numRowsDeleted  = studentDAO.deleteAll();
		System.out.println("Deleted row count "+ numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student with id "+ studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id: primary key
		int theId = 1;
		Student myStudent = studentDAO.findById(theId);

		//change first name to "Scooby"
		myStudent.setFirstname("Scooby");

		//update the student
		studentDAO.updateStudent(myStudent);

		//display the updated student
		System.out.println("Updated student: "+ myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student>  theStudents = studentDAO.findByLastName("Doe");

		//display the list of students
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findAll();

		//display the list of students
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student
		System.out.println("Creating a new student object ...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@gmail.com");

		//save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);
		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: "+ theId);

		//retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("Found the student: " + myStudent );
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create multiple students
		System.out.println("Creating 3 new student objects....");
		Student tempStudent1 = new Student("John", "Doe", "john@dev.com");
		Student tempStudent2 = new Student("Mary", "lee", "Mary@dev.com");
		Student tempStudent3 = new Student("James", "Derick", "james@dev.com");

		//save the student objects
		System.out.println("Saving the student....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO){
		//create the student object
		System.out.println("Creating new student object....");
		Student tempStudent = new Student("Paul", "Doe", "paul@dev.com");

		//save the student object
		System.out.println("Saving the student....");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated id: "+ tempStudent.getId());
	}
}
