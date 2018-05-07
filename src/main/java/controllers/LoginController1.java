
package controllers;

import dao.User_dao;
import entities.User;

import javax.naming.Name;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginController1 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        User_dao dao=new User_dao();
        User person1 = new User(username, password);
        String loginURL = "login.jsp";
        HttpSession session = request.getSession();



        if(request.getParameter("submit")!= null)
        {
            session.setAttribute("firstname", person1.getFirstName());
            response.sendRedirect(loginURL);

            request.getSession().setAttribute("username", person1.getFirstName());
            request.getSession().setAttribute("password", person1.getLastName());


            boolean personSelect = dao.selectByUName(person1);


        }
    }
}