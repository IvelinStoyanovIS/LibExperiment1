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

/**
 * Created by Ivelin Stoyanov on 10.5.2018 г..
 */
@WebServlet( name = "SearchBookController", value="/SearchBookController" )
public class SearchBookController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Barcode = request.getParameter("barcode");
        PrintWriter out = response.getWriter();
        Books_dao daobook=new Books_dao();
        Books book1 = new Books();
        book1 = daobook.getBookByBarcode(Barcode);
        HttpSession session = request.getSession();
        String indexURL = "index.jsp";

            out.println("DB id: " + book1.getId());
            out.println("----------------------");
            out.println("Name: " + book1.getBookName());
            out.println("----------------------");
            out.println("Autor: " + book1.getBookAutor());
            out.println("----------------------");
            out.println("Genre: " + book1.getBookGenre());
            out.println("----------------------");
            out.println("Publisher: " + book1.getBookPublisher());
            out.println("----------------------");
            out.println("Description: " + book1.getBookDescription());
            out.println("----------------------");
            out.println("Date: " + book1.getBookDate());
            out.println("----------------------");
            out.println("Image: " + book1.getBookImage());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
