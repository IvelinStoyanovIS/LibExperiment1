package controllers;

import dao.Books_dao;
import entities.Books;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

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


        String savePath = "images_books";
        File fileSaveDir=new File(savePath);
        if(!fileSaveDir.exists()){
            fileSaveDir.mkdir();
        }

        PrintWriter out = response.getWriter();
        Books_dao daobook=new Books_dao();
        String BookBarcode = request.getParameter("BookBarcode");
        String BookName = request.getParameter("BookName");
        String BookAutor = request.getParameter("BookAutor");
        String BookGenre = request.getParameter("BookGenre");
        String BookPublisher = request.getParameter("BookPublisher");
        String BookDescription = request.getParameter("BookDescription");
        String BookDate = request.getParameter("BookDate");
        String BookImage = request.getParameter("BookImage");

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


        OutputStream out_stream = null;
        InputStream filecontent = null;

        final String path = "/Users/x/IdeaProjects/LibExperiment1Try/web/images";

        Part part=request.getPart("file");
        String fileName=daobook.extractFileName(part);


        try {
            out_stream = new FileOutputStream(new File(path + File.separator
                    + fileName));
            filecontent = part.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out_stream.write(bytes, 0, read);
            }
            //out.println("New file " + fileName + " created at " + path);

            String filePath= savePath + File.separator + fileName ;
            book1.setPathImage(filePath);

            daobook.createBook(book1);

            response.sendRedirect("login.jsp");

            LOGGER.log(Level.INFO, "File{0}being uploaded to {1}",
                    new Object[]{fileName, path});
        } catch (FileNotFoundException fne) {
//            out.println("You either did not specify a file to upload or are "
//                    + "trying to upload a file to a protected or nonexistent "
//                    + "location.");
//            out.println("<br/> ERROR: " + fne.getMessage());
            LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}",
                    new Object[]{fne.getMessage()});
        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
            if (out != null) {
                out.close();
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}