package jdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.Entity.Student;
import jdbc.StudentDaoImpl.StudentImple;


public class App 
{
    public static void main( String[] args )
    {
       
    	
    	
    	ApplicationContext con=new ClassPathXmlApplicationContext("config.xml");
    	StudentImple s1=(StudentImple) con.getBean("stuimpl");
    	Student stu1=new Student();
    	
    	Scanner sc=new Scanner (System.in);
		boolean start=true;
		while (start) {
			System.out.println("1] Inserting new details");
			System.out.println("2] Updating a details of Students");
			System.out.println("3] deleteing Information");
			System.out.println("4] Getting a single data of  Student");
			System.out.println("5] Getting all data of Student");
			System.out.println("6] exit");
			
			int choice =sc.nextInt();
			
			switch (choice) {
			case 1:
			       System.out.println("Enter name of Student");
			       String name=sc.next();
			       System.out.println("Enter id of Student");
			       int id=sc.nextInt();
			       System.out.println("Enter marks of Student");
			       double marks=sc.nextDouble();
			       Student stu2=new Student(name,id,marks);
			       s1.insert(stu2);
			       System.out.println("Data inserted successfully");
			break;
			
			case 2: 
				System.out.println("Enter id that you want to update");
                int id1=sc.nextInt();
				 boolean flag=true;
				 while(flag) {
					 
                   
					 System.out.println("1:Update name");
					 System.out.println("2:Update Marks");
					 System.out.println("3:Exit");
					 int c=sc.nextInt();
					 switch (c) {
					case 1:
						System.out.println("Enter the Updated name");
						String name1=sc.next();
					     stu1.setName(name1);
					     s1.update(stu1, id1);
						break;
					case 2:
						System.out.println("Enter the Updated marks");
						double m=sc.nextDouble();
						stu1.setMarks(m);
						s1.update(stu1, id1);
						break;
					case 3:
						flag=false;
						System.out.println("Updated successfully");
						break;
						
					}
					 } 
				
			break;
			
			case 3: System.out.println("Enter id that you want to delete");
		       int id3=sc.nextInt();
				s1.delete(id3);
			System.out.println("Deleted successfully");
			break;
			
			case 4: 
				System.out.println("Enter id that you want");
			       int id2=sc.nextInt();
				s1.getById(id2);
			break;
			
			case 5:List<Student> students = s1.select();
		       for (Student student : students) {
		           System.out.println("ID: " + student.getId() + ", Name: " + student.getName() + ", Marks: " + student.getMarks());
		       }
			break;
			
			case 6:start=false;
		          System.out.println("THANK YOU:)");
			break;			
			
		}
		
		}	       
    }
}
