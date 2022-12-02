import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.studentmanage.Student;
import com.studentmanage.StudentDao;



public class Start {

	public static void main(String[] args)throws IOException {
		System.out.println("Welcome to Student management app");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("Press 1 to add student");
			System.out.println("Press 2 to delete student");
			System.out.println("Press 3 to display students");
			System.out.println("Press 4 to update info");
			System.out.println("Press 5 to exit");
			
			int c  = Integer.parseInt(br.readLine());
			
			if (c == 1) {
				//add student
				
				System.out.println("Enter User Name");
				String name =br.readLine();
				
				System.out.println("Enter user Phone");
				String phone = br.readLine();
				
				System.out.println("Enter the City");
				String city = br.readLine();
				
				Student st =new Student( name, phone, city);
				boolean answer = StudentDao.InsertStudentToDb(st);
				if(answer) {
					System.out.println("Student is added succesfully");
				}else {
					System.out.println("Something went wrong......Please try again");
				}
				
				System.out.println(st);
				
				
			}else if(c==2){
				//delete student
				
				System.out.println("Enter students Id to delete");
				
				int userId = Integer.parseInt(br.readLine());
				
				boolean f=StudentDao.deleteStudent(userId);
				if (f) {
					System.out.println("Student deleted successfully");
				}else {
					System.out.println("Something went wrong");
				}
			}else if (c==3) {
				//display students
				
				StudentDao.showAllStudents();
			}else if(c==4){
				//update the student
				
				System.out.println("Enter Student Id ");
				
				int userId = Integer.parseInt(br.readLine());
				
				System.out.println("Enter new Name ");
				String name = br.readLine();
				
				System.out.println("Enter new Phone");
				String phone = br.readLine();
				
				System.out.println("Enter new City");
				String city =br.readLine();
				
				boolean u=StudentDao.updateStudent(userId,name,phone,city);
				if(u) {
					System.out.println("Info Updated successfully");
				}else {
					System.out.println("Something went wrong");
				}
				
				
				
			}else if(c==5){
				break;
			}else {
				
			}
		}
		System.out.println("Thankyou for using my application");
		System.out.println("See you soon......");

	}

}
