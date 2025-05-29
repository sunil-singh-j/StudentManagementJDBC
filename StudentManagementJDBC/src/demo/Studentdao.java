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
	static PreparedStatement pstmt=null;
	static Connection con=null;
	 static Statement stmt=null;
	public static boolean insertStudentToDB(Student st) {
		
		boolean f=false;
		
		 con=ConnectionProvider.creatC();
		String query="insert into students (sid,sname,sphone,scity) values(?,?,?,?)";
		
		try {
			 pstmt=con.prepareStatement(query);
			pstmt.setInt(1,id);
			pstmt.setString(2,st.getStudentName());
			pstmt.setString(3, st.getStudentPhone());
			pstmt.setString(4,st.getStudentCity());
			
			pstmt.executeUpdate();
			f=true;
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
					System.out.println("statement closed");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
					System.out.println("connection closed");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		id=id+1;
		return f;
		
		
	}

	public static boolean delteStudent(int id) {
		// TODO Auto-generated method stub
		
		boolean f=false;
		
		 con=ConnectionProvider.creatC();
		String query="delete from students where sid=?";
		
		try {
		 pstmt=con.prepareStatement(query);
			pstmt.setInt(1,id);
			
			pstmt.executeUpdate();
			f=true;
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
					System.out.println("statement closed");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
					System.out.println("connection closed");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return f;
		
		
	}
	public static List<Student> showAllStudent() {
boolean f=false;
		
		 con=ConnectionProvider.creatC();
		String query="select * from students;";
		List<Student> li=new ArrayList<Student>();
		
		
		
		try {
			 stmt=con.createStatement();
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
		}finally {
			if(stmt!=null) {
				try {
					stmt.close();
					System.out.println("statement closed");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
					System.out.println("connection closed");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return li;
	}
	
	public static boolean updateStudent(Student st,int id) {
		boolean f=false;
		con=ConnectionProvider.creatC();
		
		String query="UPDATE students  SET sname = ?, sphone = ?, scity = ? WHERE sid = ?;";
		try {
		 pstmt=con.prepareStatement(query);
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			pstmt.setInt(4
					, id);
			
			pstmt.executeUpdate();
			
			f=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
					System.out.println("statement closed");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
					System.out.println("connection closed");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return f;
	}

}
