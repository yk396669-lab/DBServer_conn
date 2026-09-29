package college.dao;

import college.model.Student;
import college.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public boolean addStudent(Student s) {
        String sql = "INSERT INTO students (name, email, department, cgpa) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getDepartment());
            ps.setDouble(4, s.getCgpa());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateStudent(Student s) {
        String sql = "UPDATE students SET name = ?, email = ?, department = ?, cgpa = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getDepartment());
            ps.setDouble(4, s.getCgpa());
            ps.setInt(5, s.getId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List getAllStudents() {
        List list = new ArrayList<>();
        String sql = "SELECT id, name, email, department, cgpa FROM students";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("department"),
                    rs.getDouble("cgpa")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}