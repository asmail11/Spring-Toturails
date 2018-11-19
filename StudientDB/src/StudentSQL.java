import java.sql.*;
import java.util.ArrayList;

public class StudentSQL {

	public static Connection getConnection() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/ServletDB";
			
			con = DriverManager.getConnection(url, "issam", "issam");
			
		} catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return con;
	}
	
	public static int save(Student s) {
		
		int st = 0;
		Connection con = StudentSQL.getConnection();
		
		String sql = "INSERT INTO `StudentInfo`(`name`, `password`, `email`, `country`) VALUES (?,?,?,?)";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, s.getName());
			preparedStatement.setString(2, s.getPassword());
			preparedStatement.setString(3, s.getEmail());
			preparedStatement.setString(4, s.getCountry());
			
			st = preparedStatement.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return st;	
	}
	
	public static int update(Student s) {
		
		int st = 0;
		Connection con = StudentSQL.getConnection();
		
		String sql = "UPDATE `StudentInfo` SET `name`=?,`password`=?,`email`=?,`country`=? WHERE id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, s.getName());
			preparedStatement.setString(2, s.getPassword());
			preparedStatement.setString(3, s.getEmail());
			preparedStatement.setString(4, s.getCountry());
			preparedStatement.setInt(5, s.getId());
			
			st = preparedStatement.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return st;	
	}
	
	public static int delete(int id) {
		
		int st = 0;
		Connection con = StudentSQL.getConnection();
		
		String sql = "DELETE FROM `StudentInfo` WHERE id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
	
			preparedStatement.setInt(5, id);
			
			st = preparedStatement.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return st;	
	}
	
	public static Student getStudentId(int id) {
		
		Student student = new Student();
		
		Connection con = StudentSQL.getConnection();
		
		String sql = "SELECT `id`, `name`, `password`, `email`, `country` FROM `StudentInfo` WHERE id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				
				student.setId(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
				student.setPassword(resultSet.getString(3));
				student.setEmail(resultSet.getString(4));
				student.setCountry(resultSet.getString(5));
			}
		
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return student;	
	}
	
	public static java.util.List<Student> getStudents() {
		
		java.util.List<Student> list = new ArrayList<Student>();
	
		try {
			String sql = "SELECT * FROM `StudentInfo`";
			Connection con = StudentSQL.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Student student = new Student();
				
				student.setId(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
				student.setPassword(resultSet.getString(3));
				student.setEmail(resultSet.getString(4));
				student.setCountry(resultSet.getString(5));
		
				
				list.add(student);
			}
		
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return list;	
	}
}
