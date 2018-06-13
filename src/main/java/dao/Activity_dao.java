package dao;

/**
 * Created by Ivelin Stoyanov on 6.6.2018 г..
 */

import entities.Activity;
import entities.Student;
import util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Activity_dao {
    private final Connection conn = ConnectionConfiguration.getConnection();
    private final String SQL_CREATE_ACTIVITY = "INSERT INTO book_activity(student_id, book_id, return_date, is_return) VALUES (?, ?, ?, ?)";
    private final String SQL_GET_ACTIVITY_BY_ID = "SELECT * FROM book_activity WHERE activity_id=?";
    private final String SQL_GET_ALL_NONRETURN_BOOKS = "SELECT book_activity.activity_id, books.BookName, students.name, book_activity.return_date, book_activity.is_return FROM books JOIN book_activity ON books.id = book_activity.book_id and is_return = FALSE JOIN students ON students.id = book_activity.student_id;";
    private final String SQL_GET_WARNING_ACTIVITY = "SELECT * FROM book_activity";
    private final String SQL_RETURN_BOOK = "UPDATE book_activity SET is_return = true WHERE activity_id = ?";
    private final String SQL_GET_DAYS_LEFT = "SELECT DATEDIFF((SELECT book_activity.return_date FROM book_activity WHERE activity_id=?), CURDATE())";
    private final String SQL_GET_NUMB_READ_BOOKS="Select count(name) from books join book_activity\n" +
            "ON books.id = book_activity.book_id and is_return = true\n" +
            "JOIN students ON students.id = book_activity.student_id WHERE name=?";

    public void createActivity(Activity activity) {
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_CREATE_ACTIVITY, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, activity.getStudent_id());
            pstmt.setInt(2, activity.getBook_id());
            pstmt.setString(3, activity.getReturn_date());
            pstmt.setBoolean(4, activity.isIs_return());
            pstmt.executeUpdate();
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    activity.setActivity_id(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Activity_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Activity getActivityById(int activityId) {
        Activity activity = new Activity();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_GET_ACTIVITY_BY_ID)) {
            pstmt.setInt(1, activityId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    activity.setActivity_id(rs.getInt(1));
                    activity.setStudent_name(rs.getString(2));
                    activity.setBook_name(rs.getString(3));
                    activity.setReturn_date(rs.getString(4));
                    activity.setIs_return(rs.getBoolean(5));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Activity_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return activity;
    }

    public ArrayList<Activity> getAllNonReturnBooks() {
        ArrayList<Activity> allNRA = new ArrayList();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_GET_ALL_NONRETURN_BOOKS);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Activity activity = new Activity();
                activity.setActivity_id(rs.getInt(1));
                activity.setBook_name(rs.getString(2));
                activity.setStudent_name(rs.getString(3));
                activity.setReturn_date(rs.getString(4));
                activity.setIs_return(rs.getBoolean(5));
                allNRA.add(activity);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Activity_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allNRA;
    }

    public void returnBookByActivityId(int activityId) {
        Activity activity = new Activity();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_RETURN_BOOK)) {
            pstmt.setInt(1, activityId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Activity_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public boolean returnAct(Activity activity) {
        Activity_dao act_dao = new Activity_dao();
        ArrayList<Activity> nonreturnbooks = act_dao.getAllNonReturnBooks();
        for (int i = 0; i < nonreturnbooks.size(); i++) {
            if (nonreturnbooks.get(i).isIs_return() == false &&
                    nonreturnbooks.get(i).getStudent_name().equals(activity.getStudent_name())  &&
                    nonreturnbooks.get(i).getBook_name().equals( activity.getBook_name())) {
                act_dao.returnBookByActivityId(nonreturnbooks.get(i).getActivity_id());
                return true;
            }
        }
        act_dao.createActivity(activity);
        return false;

    }


    public int getActivityDaysLeft(int activityId) {
        Activity activity = new Activity();
        int DaysLeft = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_GET_DAYS_LEFT)) {
            pstmt.setInt(1, activityId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    DaysLeft = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Activity_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DaysLeft;
    }

    public int CalcGetReadBooks(Student student)
    {
        Student stud1 = new Student();
        int readBook=0;
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_GET_NUMB_READ_BOOKS)) {
            pstmt.setString(1, student.getName());
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    readBook = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Books_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return readBook;
    }
}


