package controllers;

import dao.Activity_dao;
import entities.Activity;

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
@WebServlet( name = "AllNonReturnBooksController" )
public class AllNonReturnBooksController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        Activity_dao activitydao = new Activity_dao();
        activitydao.getAllNonReturnBooks();
        ArrayList<Activity> allNRA = activitydao.getAllNonReturnBooks();


        for (int i = 0; i < allNRA.size(); i++) {
            out.println("Recording : " + i + ": ");
            out.print(allNRA.get(i).getActivity_id());
            out.print(" | " + allNRA.get(i).getBook_name());
            out.print(" | " + allNRA.get(i).getStudent_name());
            out.print(" | " + allNRA.get(i).getReturn_date());
            out.println(" | " + allNRA.get(i).isIs_return());
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
