
package controllers;

import dao.User_dao;
import entities.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet( name = "LoginController1", urlPatterns={"/LoginController1"})
public class LoginController1 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        User_dao dao = new User_dao();
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        String hashedPass = dao.hash(password);
        PrintWriter out = response.getWriter();
        User user1 = new User(username, password, hashedPass);
        String loginURL = "login.jsp";
        String wrongLoginURL = "wrongLogin.jsp";
        HttpSession session = request.getSession();
        boolean personSelect;


        if (request.getParameter("submit") != null) {

            //dao.insert(user1);
            personSelect = dao.selectByUName(user1);
            if (personSelect) {
                response.sendRedirect(loginURL);
                session.setAttribute("firstname", user1.getUserName());
                request.getSession().setAttribute("username", user1.getUserName());
                request.getSession().setAttribute("password", user1.getPassword());
            } else {
                response.sendRedirect(wrongLoginURL);
                request.getSession().setAttribute("wrong_login", "Wrong username or password");
            }
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}