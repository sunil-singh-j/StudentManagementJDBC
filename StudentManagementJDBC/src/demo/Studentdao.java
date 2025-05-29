package demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class Studentdao {
	
	static int id=1;
	public static boolean insertStudentToDB(Student st) {
		
		boolean f=false;
		
		Connection con=ConnectionProvider.creatC();
		String query="insert into students (sid,sname,sphone,scity) values(?,?,?,?)";
		
		try {
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1,id);
			pstmt.setString(2,st.getStudentName());
			pstmt.setString(3, st.getStudentPhone());
			pstmt.setString(4,st.getStudentCity());
			
			pstmt.executeUpdate();
			f=true;
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		id=id+1;
		return f;
		
		
	}

	public static boolean delteStudent(int id) {
		// TODO Auto-generated method stub
		
		boolean f=false;
		
		Connection con=ConnectionProvider.creatC();
		String query="delete from students where sid=?";
		
		try {
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1,id);
			
			pstmt.executeUpdate();
			f=true;
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
		
		
	}
	public static List<Student> showAllStudent() {
boolean f=false;
		
		Connection con=ConnectionProvider.creatC();
		String query="select * from students;";
		List<Student> li=new ArrayList<Student>();
		
		
		
		try {
			Statement stmt=con.createStatement();
			ResultSet set=stmt.executeQuery(query);
			while(set.next()) {
				int id=set.getInt(1);
				String name=set.getString(2);
				String phone=set.getString(3);
				String city=set.getString(4);
				li.add(new Student(id,name,phone,city));
				
			}
			f=true;
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return li;
	}
	
	public static boolean updateStudent(Student st,int id) {
		boolean f=false;
		Connection con=ConnectionProvider.creatC();
		
		String query="UPDATE students  SET sname = ?, sphone = ?, scity = ? WHERE sid = ?;";
		try {
			PreparedStatement ptmt=con.prepareStatement(query);
			ptmt.setString(1, st.getStudentName());
			ptmt.setString(2, st.getStudentPhone());
			ptmt.setString(3, st.getStudentCity());
			
			ptmt.setInt(4
					, id);
			
			ptmt.executeUpdate();
			
			f=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

}
