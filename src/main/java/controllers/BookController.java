package controllers;

import dao.Books_dao;
import entities.Books;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Ivelin Stoyanov on 9.5.2018 г..
 */
@WebServlet( name = "BookController", urlPatterns={"/BookController"} )
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
        maxFileSize=1024*1024*10,      // 10MB
        maxRequestSize=1024*1024*50)
public class BookController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");


        String SAVE_DIR="images";

        String savePath = "home/biba/IdeaProjects/lib2/LibExperiment1/web" + File.separator + SAVE_DIR;
        File fileSaveDir=new File(savePath);
        if(!fileSaveDir.exists()){
            fileSaveDir.mkdir();
        }


        Books_dao daobook=new Books_dao();
        String BookBarcode = request.getParameter("BookBarcode");
        String BookName = request.getParameter("BookName");
        String BookAutor = request.getParameter("BookAutor");
        String BookGenre = request.getParameter("BookGenre");
        String BookPublisher = request.getParameter("BookPublisher");
        String BookDescription = request.getParameter("BookDescription");
        String BookDate = request.getParameter("BookDate");
        String BookImage = request.getParameter("BookImage");
        PrintWriter out = response.getWriter();
        Books book1 = new Books();
        book1.setBookBarcode(BookBarcode);
        book1.setBookName(BookName);
        book1.setBookAutor(BookAutor);
        book1.setBookGenre(BookGenre);
        book1.setBookPublisher(BookPublisher);
        book1.setBookDescription(BookDescription);
        book1.setBookDate(BookDate);
        book1.setBookImage(BookImage);
        String addBookURL = "addBook.jsp";
        String showBookURL = "ShowBook.jsp";

        Part part=request.getPart("file");
        String fileName=daobook.extractFileName(part);


       /* out.println(book1.getId());
        out.println(book1.getBookName());
        out.println(book1.getBookAutor());
        out.println(book1.getBookGenre());
        out.println(book1.getBookPublisher());
        out.println(book1.getBookDescription());
        out.println(book1.getBookDate());
        out.println(book1.getBookImage()); */


        daobook.createBook(book1, savePath, fileName);

        daobook.getAllBooks();
        ArrayList<Books> allBooks = daobook.getAllBooks();


        for (int i = 0; i < allBooks.size(); i++) {
            out.println("Book " + i + ": ");
            out.print(allBooks.get(i).getBookBarcode());
            out.print(" | " + allBooks.get(i).getBookName());
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
