import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

@WebServlet(name = "Servlet_redirect")
public class Servlet_redirect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        String redirectURL;
        String redirectURL_jstl;
        redirectURL = "index.jsp";
        redirectURL_jstl = "index_jstl_try.jsp";
        //String name=null;

        if (request.getParameter("btn1") != null) {
            response.sendRedirect(redirectURL);
        }
        else if (request.getParameter("btn2") != null){
            response.sendRedirect(redirectURL_jstl);
          //  request.setAttribute("name", "tom");
           // request.getRequestDispatcher(redirectURL_jstl).forward(request, response);

        }

    }
}