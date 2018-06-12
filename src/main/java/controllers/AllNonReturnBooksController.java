package controllers;

import dao.Activity_dao;
import entities.Activity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Ivelin Stoyanov on 6.6.2018 г..
 */
@WebServlet( name = "AllNonReturnBooksController" , value="/AllNonReturnBooksController" )
public class AllNonReturnBooksController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        Activity_dao activitydao = new Activity_dao();
        activitydao.getAllNonReturnBooks();
        ArrayList<Activity> allNRA = activitydao.getAllNonReturnBooks();
        RequestDispatcher rd;
        //activitydao.returnBookByActivityId(5);


        for (int i = 0; i < allNRA.size(); i++) {
            out.println("Recording : " + i + ": ");
            out.print(allNRA.get(i).getActivity_id());
            out.print(" | " + allNRA.get(i).getBook_name());
           // request.setAttribute("book_name", allNRA.get(i).getBook_name());
            out.print(" | " + allNRA.get(i).getStudent_name());
           // request.setAttribute("student_name", allNRA.get(i).getStudent_name());
            out.print(" | " + allNRA.get(i).getReturn_date());
            //request.setAttribute("return_date", allNRA.get(i).getReturn_date());
            out.println(" | " + allNRA.get(i).isIs_return());
            //request.setAttribute("is_return", allNRA.get(i).isIs_return());
            //rd = request.getRequestDispatcher("NRA.jsp");
           // rd.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
