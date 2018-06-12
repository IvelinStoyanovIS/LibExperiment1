package controllers;

import dao.Student_dao;
import entities.Books;
import entities.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import static java.lang.System.out;

/**
 * Created by Ivelin Stoyanov on 14.5.2018 г..
 */
@WebServlet( name = "StudentController", value="/StudentController" )
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
        maxFileSize=1024*1024*10,      // 10MB
        maxRequestSize=1024*1024*50)
public class StudentController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String savePath = "images";
        File fileSaveDir=new File(savePath);
        if(!fileSaveDir.exists()){
            fileSaveDir.mkdir();
        }

        Student_dao daoStudent1 = new Student_dao();
        String studentName=request.getParameter("StudentName");
        int studentCourseNumb=Integer.parseInt(request.getParameter("StudentCourseNumb"));
        String studentEmail=request.getParameter("StudentEmail");

        Student student1=new Student();
        student1.setName(studentName);
        student1.setCourseNumb(studentCourseNumb);
        student1.setEmail(studentEmail);

        OutputStream out_stream = null;
        //final String path = request.getParameter("destination");
        final String path = "/Users/x/IdeaProjects/LibExperiment1Try/web/images";

        Part part=request.getPart("file");
        String fileName=daoStudent1.extractFileName(part);

//        String filePath= savePath + File.separator + fileName ;
//        student1.setPathImage(filePath);


        out_stream = new FileOutputStream(new File(path + File.separator
                + fileName));
        try (PrintWriter out = response.getWriter(); InputStream filecontent = part.getInputStream()) {

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out_stream.write(bytes, 0, read);
            }
            //out.println("New file " + fileName + " created at " + path);
            String filePath= savePath + File.separator + fileName ;
            student1.setPathImage(filePath);

            daoStudent1.createStudent(student1);
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
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
