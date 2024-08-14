package question4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HeaderInfoServlet")
public class question4 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Retrieve header information
        String userAgent = request.getHeader("User-Agent");
        String host = request.getHeader("Host");
        String acceptLanguage = request.getHeader("Accept-Language");

        // Prepare response
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Client Header Information</h1>");
        response.getWriter().println("<p><strong>User-Agent:</strong> " + userAgent + "</p>");
        response.getWriter().println("<p><strong>Host:</strong> " + host + "</p>");
        response.getWriter().println("<p><strong>Accept-Language:</strong> " + acceptLanguage + "</p>");
        response.getWriter().println("</body></html>");
    }
}
