package controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "MainRedirectLibrerian", value="/MainRedirectingLibrerian")
public class MainRedirectLibrerian extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String logoutcontroller="/LogoutController";
        String addingbookcontroller="addBook.jsp";
        String serchingbookcontroller="SearchBook.jsp";
        String searchstudent = "SearchStudent.jsp";
        String indexURL = "index.jsp";
        String NRA = "NRA.jsp";
        String GetTakeBook = "GetTakeBook.jsp";
        RequestDispatcher rd;
        HttpSession ses = request.getSession();

        if(ses.getAttribute("username") != null) {
            if (request.getParameter("logout_lib") != null) {
                rd = request.getRequestDispatcher(logoutcontroller);
                rd.forward(request, response);
            }
            if (request.getParameter("addbook_lib") != null) {
                response.sendRedirect(addingbookcontroller);
            }

            if (request.getParameter("serchbook_lib") != null) {
                response.sendRedirect(serchingbookcontroller);
            }
            if (request.getParameter("searchstudent_lib") != null) {
                response.sendRedirect(searchstudent);
            }
            if (request.getParameter("showNRA_lib") != null) {
                response.sendRedirect(NRA);
            }
        }
        else
        {
            response.sendRedirect(indexURL);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
