package dao;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import entities.Books;
import util.ConnectionConfiguration;


/**
 * Created by Ivelin Stoyanov on 9.5.2018 г..
 */

public class Books_dao {
        private final Connection conn = ConnectionConfiguration.getConnection();
        private final String SQL_CREATE_BOOK = "INSERT INTO books (BookName, BookAutor, BookGenre, BookPublisher, BookDescription, BookDate, BookImage) VALUES (?, ?, ?, ?, ?, ?, ?)";
        private final String SQL_GET_BOOK_BY_ID = "SELECT * FROM books WHERE id=?";
        private final String SQL_GET_ALL_BOOK = "SELECT * FROM books";
        private final String SQL_UPDATE_BOOK = "UPDATE books SET BookName=?, BookAutor=?, BookGenre=?, BookPublisher=?, BookDescription=?, BookDate=?, BookImage=? WHERE id=?";
        private final String SQL_DELETE_BOOK = "DELETE FROM books WHERE id=?";


        public void createBook(Books book) {
            try (PreparedStatement pstmt = conn.prepareStatement(SQL_CREATE_BOOK, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, book.getBookName());
                pstmt.setString(2, book.getBookAutor());
                pstmt.setString(3, book.getBookGenre());
                pstmt.setString(4, book.getBookPublisher());
                pstmt.setString(5, book.getBookDescription());
                pstmt.setString(6, book.getBookDate());
                pstmt.setString(7, book.getBookImage());
                pstmt.executeUpdate();
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                       book.setId(generatedKeys.getInt(1));
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Books_dao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public Books getBookById(int bookId) {
            Books book = new Books();
            try (PreparedStatement pstmt = conn.prepareStatement(SQL_GET_BOOK_BY_ID)) {
                pstmt.setInt(1, bookId);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        book.setId(rs.getInt(1));
                        book.setBookName(rs.getString(2));
                        book.setBookAutor(rs.getString(3));
                        book.setBookGenre(rs.getString(4));
                        book.setBookPublisher(rs.getString(5));
                        book.setBookDescription(rs.getString(6));
                        book.setBookDate(rs.getString(7));
                        book.setBookImage(rs.getString(8));
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Books_dao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return book;
        }

        public ArrayList<Books> getAllBooks() {
            ArrayList<Books> allBooks = new ArrayList();
            try (PreparedStatement pstmt = conn.prepareStatement(SQL_GET_ALL_BOOK);
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Books book = new Books();
                    book.setId(rs.getInt(1));
                    book.setBookName(rs.getString(2));
                    book.setBookAutor(rs.getString(3));
                    book.setBookGenre(rs.getString(4));
                    book.setBookPublisher(rs.getString(5));
                    book.setBookDescription(rs.getString(6));
                    book.setBookDate(rs.getString(7));
                    book.setBookImage(rs.getString(8));
                    allBooks.add(book);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Books_dao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return allBooks;
        }

        public void updateBook(Books book) {
            try (PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE_BOOK)) {
                pstmt.setString(1, book.getBookName());
                pstmt.setString(2, book.getBookAutor());
                pstmt.setString(3, book.getBookGenre());
                pstmt.setString(4, book.getBookPublisher());
                pstmt.setString(5, book.getBookDescription());
                pstmt.setString(6, book.getBookDate());
                pstmt.setString(7, book.getBookImage());
                pstmt.setInt(8, book.getId());
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Books_dao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void deleteBook(int bookId) {
            try (PreparedStatement pstmt = conn.prepareStatement(SQL_DELETE_BOOK)) {
                pstmt.setInt(1, bookId);
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Books_dao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
