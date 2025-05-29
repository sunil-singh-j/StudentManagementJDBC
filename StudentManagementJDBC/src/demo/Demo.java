package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Demo {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.out.println("welcome to student manegment ");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("press 1 to ADD student");
			System.out.println("press 2 Delete student");
			System.out.println("press 3 to display student");
			System.out.println("press 4 to update student");
			System.out.println("press 5 to exit app");
			
			int c=Integer.parseInt(br.readLine());
			
			if(c==1) {
				System.out.println("Enter user Name :");
				String name=br.readLine();
				
				System.out.println("Enter user phone :");
				String phone=br.readLine();
				
				System.out.println("Enter user city :");
				String city=br.readLine();
				
				Student st= new Student(name,phone,city);
				System.out.println(st);
				
				
				boolean ans=Studentdao.insertStudentToDB(st);
				if(ans) {
					System.out.println("student is added successfully.....");
				}else {
					System.out.println("somethind went wrong........... try again");
				}
				
			}else if(c==2) {
				
				System.out.println("Enter student id  to delete ");
				int id=Integer.parseInt(br.readLine());	
				boolean ans= Studentdao.delteStudent(id);
				if(ans) {
					System.out.println("student is deleted successfully.....");
				}else {
					System.out.println("somethind went wrong........... try again");
				}
			}else if(c==3) {
				
				List<Student> li=Studentdao.showAllStudent();
				
				if(li!=null) {
					System.out.println("student is date fetched  successfully.....  \n "+li);
				}else {
					System.out.println("somethind went wrong........... try again");
				}
				
				
				
				
				
			}else if(c==4) {
				
				System.out.println("Enter student id  to update ");
				
				int id=Integer.parseInt(br.readLine());	
				
				System.out.println("Enter user Name :");
				String name=br.readLine();
				
				System.out.println("Enter user phone :");
				String phone=br.readLine();
				
				System.out.println("Enter user city :");
				String city=br.readLine();
				
				Student st= new Student(id,name,phone,city);
				System.out.println(st);
				
				
				boolean ans=Studentdao.updateStudent(st,id);
				if(ans) {
					System.out.println("student is updated successfully.....");
				}else {
					System.out.println("somethind went wrong........... try again");
				}
				
			}
			else if(c==5) {
				break;
			}
			else {
				
			}
			
			
		}
		System.out.println("Thank you for using my appliction......");
		System.out.println("see you soon .......");
		
	}

}
