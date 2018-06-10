package controllers;

import dao.Student_dao;
import entities.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SearchStudent", value="/SearchStudent")
public class SearchStudent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession ses = request.getSession(true);


        String courseNumber=request.getParameter("courseNumb");
        //System.out.println(courseNumb);
        int courseNumb=0;
        if(courseNumber !=null || courseNumber !="")
        {
            courseNumb = Integer.parseInt(courseNumber);
        }
        //System.out.println(courseNumb);
        Student_dao daoStudent=new Student_dao();
        Student student1=new Student();
        student1 = daoStudent.getStudentByCourseNumb(courseNumb);
        RequestDispatcher rd;
        RequestDispatcher rd1;


        if(student1.getCourseNumb()!=0) {
            request.setAttribute("studentid", student1.getId());
            request.setAttribute("studentname", student1.getName());
            request.setAttribute("coursenumb", student1.getCourseNumb());
            request.setAttribute("email", student1.getEmail());
            request.setAttribute("currentbook", student1.getCurrntBook());
            request.setAttribute("readbooks", student1.getReadBooks());
            request.setAttribute("path", student1.getPathImage());
            ses.setAttribute("studid", student1.getId());
            rd = request.getRequestDispatcher("StudentPage.jsp");
            rd.forward(request, response);
        }
        else
        {

            response.sendRedirect("WrongCourseNumber.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
