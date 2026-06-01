
package dao;

import model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Database connection details
    private String url = "jdbc:mysql://localhost:3306/student_db";
    private String user = "root";
    private String password = "1234";

    // Method to get connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // 1. ADD Student
    public void addStudent(Student s) {
        String sql = "INSERT INTO student(name, age, email, phone, course) VALUES(?,?,?,?,?)";
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setString(3, s.getEmail());
            ps.setString(4, s.getPhone());
            ps.setString(5, s.getCourse());
            ps.executeUpdate();
            System.out.println("Student Added Successfully!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 2. VIEW All Students
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Student s = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("course")
                );
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return list;
    }

    // 3. UPDATE Student
    public void updateStudent(Student s) {
        String sql = "UPDATE student SET name=?, age=?, email=?, phone=?, course=? WHERE id=?";
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setString(3, s.getEmail());
            ps.setString(4, s.getPhone());
            ps.setString(5, s.getCourse());
            ps.setInt(6, s.getId());
            ps.executeUpdate();
            System.out.println("Student Updated Successfully!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 4. DELETE Student
    public void deleteStudent(int id) {
        String sql = "DELETE FROM student WHERE id=?";
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Student Deleted Successfully!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
