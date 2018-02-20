import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet_redirect")
public class Servlet_redirect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();



        if (request.getParameter("btn1") != null){
            String redirectURL;
            redirectURL = "index.jsp";
            response.sendRedirect(redirectURL);
        }
        else if (request.getParameter("btn2") != null){
            // do something
        }

    }
}
