
package controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginController1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("userName");
        String lname = request.getParameter("password");
        String a;
        PrintWriter out = response.getWriter();
        User person1 = new User(fname, lname);
        String loginURL = "login.jsp";
        //out.print("<p>" + "Name: " + person1.firstName + "</p>");
        //out.println("<p>" + "Surname: " + "<b>" + person1.lastName + "</b></p>");

        if(request.getParameter("submit")!= null)
        {

            response.sendRedirect(loginURL);

            out.print("<p>" + "Name: " + person1.firstName + "</p>");
            out.println("<p>" + "Surname: " + "<b>" + person1.lastName + "</b></p>");
        }
    }
}
