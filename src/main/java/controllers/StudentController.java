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
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
//        Student student1 = new Student();
//        student1.setName("Ивелин Стоянов");
//        student1.setFacNum("14116");
//        student1.setEmail("ivelin_stoyanov@abv.bg");
//        student1.setNumberReadBooks(115);
//        student1.setTakenBook(true);
//
//        request.setAttribute("name", student1.getName());
//        request.setAttribute("facNum", student1.getFacNum());
//        request.setAttribute("email", student1.getEmail());
//        request.setAttribute("NumberReadBooks", student1.getNumberReadBooks());
//        request.setAttribute("TakenBook", student1.isTakenBook());
//
//        request.getRequestDispatcher("StudentPage.jsp").forward(request, response);
//        response.sendRedirect("StudentPage.jsp");

        PrintWriter out = response.getWriter();
        String savePath = "images";
        File fileSaveDir=new File(savePath);
        if(!fileSaveDir.exists()){
            fileSaveDir.mkdir();
        }

        Student_dao daoStudent1 = new Student_dao();
        String studentName=request.getParameter("StudentName");
        String studentCourseNumb=request.getParameter("StudentCourseNumb");
        String studentEmail=request.getParameter("StudentEmail");

        Student student1=new Student();
        student1.setName(studentName);
        student1.setCourseNumb(studentCourseNumb);
        student1.setEmail(studentEmail);

        Part part=request.getPart("file");
        String fileName=daoStudent1.extractFileName(part);
        String filePath= savePath + File.separator + fileName ;
        student1.setPathImage(filePath);

        daoStudent1.createStudent(student1);


        daoStudent1.getAllStudents();
        ArrayList<Student> allStudents = daoStudent1.getAllStudents();


        for (int i = 0; i < allStudents.size(); i++) {
            out.println("Students " + i + ": ");
            out.print(allStudents.get(i).getId());
            out.print(" | " + allStudents.get(i).getName());
            out.print(" | " + allStudents.get(i).getReadBooks());
            out.print(" | " + allStudents.get(i).getCourseNumb());
            out.print(" | " + allStudents.get(i).getEmail());
            out.print(" | " + allStudents.get(i).getCurrntBook());
            out.println(" | " + allStudents.get(i).getPathImage());
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
