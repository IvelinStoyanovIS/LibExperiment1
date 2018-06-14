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

        request.setAttribute("allnra", allNRA);
        request.getRequestDispatcher("nra_displ.jsp").forward(request, response);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
