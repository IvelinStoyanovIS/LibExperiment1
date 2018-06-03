package dao;

import entities.Student;
import util.ConnectionConfiguration;

import javax.servlet.http.Part;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student_dao {

    private final Connection conn = ConnectionConfiguration.getConnection();
    private final String SQL_CREATE_STUDENT = "INSERT INTO students (name, readBooks, courseNumb, email, currentbook, file) VALUES (?, ?, ?, ?, ?, ?)";
    private final String SQL_GET_STUDENTS_BY_ID = "SELECT * FROM students WHERE id=?";
    private final String SQL_GET_ALL_STUDENTS = "SELECT * FROM students";
    //private final String SQL_UPDATE_BOOK = "UPDATE books SET BookBarcode=? BookName=?, BookAutor=?, BookGenre=?, BookPublisher=?, BookDescription=?, BookDate=?, BookImage=? WHERE id=?";
    private final String SQL_DELETE_STUDENTS = "DELETE FROM students WHERE id=?";
    private final String SQL_GET_STUDENTS_BY_COURSE = "SELECT * FROM students WHERE courseNumb=?";





    public String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }


    public void createStudent(Student student) {
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_CREATE_STUDENT, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getReadBooks());
            pstmt.setInt(3, student.getCourseNumb());
            pstmt.setString(4,student.getEmail());
            pstmt.setString(5, student.getCurrntBook());
            pstmt.setString(6, student.getPathImage());
            pstmt.executeUpdate();
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    student.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Books_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public Student getStudentByCourseNumb(int courseNumb) {
        Student student = new Student();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_GET_STUDENTS_BY_COURSE)) {
            pstmt.setInt(1, courseNumb);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    student.setId(rs.getInt(1));
                    student.setName(rs.getString(2));
                    student.setReadBooks(rs.getInt(3));
                    student.setCourseNumb(rs.getInt(4));
                    student.setEmail(rs.getString(5));
                    student.setCurrntBook(rs.getString(6));
                    student.setPathImage(rs.getString(7));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student;
    }



    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> allStudents = new ArrayList();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_GET_ALL_STUDENTS);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setReadBooks(rs.getInt(3));
                student.setCourseNumb(rs.getInt(4));
                student.setEmail(rs.getString(5));
                student.setCurrntBook(rs.getString(6));
                student.setPathImage(rs.getString(7));
                allStudents.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Books_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allStudents;
    }


}

