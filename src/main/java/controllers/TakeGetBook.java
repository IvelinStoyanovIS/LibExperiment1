package controllers;

import dao.Activity_dao;
import dao.Books_dao;
import dao.Student_dao;
import entities.Activity;
import entities.Student;
import entities.Books;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.print.Book;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TakeGetBook", value="/TakeGetBook" )
public class TakeGetBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession ses = request.getSession(true);



        Student_dao stud_dao=new Student_dao();
        Books_dao book_dao=new Books_dao();

        Student student1=new Student();
        Books book1=new Books();

        Activity activity = new Activity();


        Activity_dao act_dao=new Activity_dao();

        String barcode=request.getParameter("barcode");
        String returnDate=request.getParameter("date");
        //int studentNumber=Integer.parseInt(request.getParameter("student_number"));
        //int studentNumber=Integer.parseInt(request.getParameter("studentid"));

        int studentNumber = (int) ses.getAttribute("studid");

        book1 = book_dao.getBookByBarcode(barcode);


        student1 = stud_dao.getStudentByCourseNumb(studentNumber);


        activity.setBook_id(book1.getId());
        //activity.setStudent_id(student1.getId());
        activity.setStudent_id(studentNumber);
        activity.setReturn_date(returnDate);
        activity.setIs_return(false);

        act_dao.createActivity(activity);



        PrintWriter out = response.getWriter();
        out.println(barcode);
        out.println(returnDate);
        out.println(studentNumber);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
