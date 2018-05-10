package controllers;

import dao.Books_dao;
import entities.Books;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Ivelin Stoyanov on 9.5.2018 г..
 */
@WebServlet( name = "BookController" )
public class BookController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Books_dao daobook=new Books_dao();
        String BookName = request.getParameter("BookName");
        String BookAutor = request.getParameter("BookAutor");
        String BookGenre = request.getParameter("BookGenre");
        String BookPublisher = request.getParameter("BookPublisher");
        String BookDescription = request.getParameter("BookDescription");
        String BookDate = request.getParameter("BookDate");
        String BookImage = request.getParameter("BookImage");
        PrintWriter out = response.getWriter();
        Books book1 = new Books();
        book1.setBookName(BookName);
        book1.setBookAutor(BookAutor);
        book1.setBookGenre(BookGenre);
        book1.setBookPublisher(BookPublisher);
        book1.setBookDescription(BookDescription);
        book1.setBookDate(BookDate);
        book1.setBookImage(BookImage);
        String addBookURL = "addBook.jsp";
        String showBookURL = "ShowBook.jsp";

       /* out.println(book1.getId());
        out.println(book1.getBookName());
        out.println(book1.getBookAutor());
        out.println(book1.getBookGenre());
        out.println(book1.getBookPublisher());
        out.println(book1.getBookDescription());
        out.println(book1.getBookDate());
        out.println(book1.getBookImage()); */


        daobook.createBook(book1);

        daobook.getAllBooks();
        ArrayList<Books> allBooks = daobook.getAllBooks();


        for (int i = 0; i < allBooks.size(); i++) {
            out.println("Book " + i + ": ");
            out.print(allBooks.get(i).getBookName());
            out.print(" | " + allBooks.get(i).getBookAutor());
            out.print(" | " + allBooks.get(i).getBookGenre());
            out.print(" | " + allBooks.get(i).getBookPublisher());
            out.print(" | " + allBooks.get(i).getBookDescription());
            out.print(" | " + allBooks.get(i).getBookDate());
            out.println(" | " + allBooks.get(i).getBookImage());
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
