package controllers;

import entities.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ivelin Stoyanov on 14.5.2018 г..
 */
@WebServlet( name = "StudentController", value="/StudentController" )
public class StudentController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Student student1 = new Student();
        student1.setName("Ивелин Стоянов");
        student1.setFacNum("14116");
        student1.setEmail("ivelin_stoyanov@abv.bg");
        student1.setNumberReadBooks(115);
        student1.setTakenBook(true);

        request.setAttribute("name", student1.getName());
        request.setAttribute("facNum", student1.getFacNum());
        request.setAttribute("email", student1.getEmail());
        request.setAttribute("NumberReadBooks", student1.getNumberReadBooks());
        request.setAttribute("TakenBook", student1.isTakenBook());

        request.getRequestDispatcher("StudentPage.jsp").forward(request, response);
        response.sendRedirect("StudentPage.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
