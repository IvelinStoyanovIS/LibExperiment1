

import entities.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Ivelin Stoyanov on 15.2.2018 г..
 */
@WebServlet(name = "LoginController")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fname = request.getParameter("firstname");
        String lname = request.getParameter("lastname");
        PrintWriter out = response.getWriter();
        User person1 = new User(fname, lname);
        out.print("<p>" + "Name: " + person1.firstName + "</p>");
        out.println("<p>" + "Surname: " + "<b>" + person1.lastName + "</b></p>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
