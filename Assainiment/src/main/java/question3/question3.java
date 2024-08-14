package question3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responseCode")
public class question3 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String code = request.getParameter("code");

        out.println("<html><body>");
        out.println("<h2>HTTP Response Code Generator</h2>");

        if (code == null) {
            out.println("<form action='responseCode' method='get'>");
            out.println("Enter HTTP response code (404, 500.): ");
            out.println("<input type='text' name='code'><br>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        } else {
            try {
                int statusCode = Integer.parseInt(code);
                switch (statusCode) {
                    case 404:
                        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                        out.println("<h3>404 Not Found</h3>");
                        out.println("The resource you are looking for could not be found.");
                        break;
                    case 500:
                        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                        out.println("<h3>500 Internal Server Error</h3>");
                        out.println("An internal server error occurred. Please try again later.");
                        break;
                    case 400:
                        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                        out.println("<h3>400 Bad Request</h3>");
                        out.println("The request could not be understood by the server due to malformed syntax.");
                        break;
                    default:
                        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                        out.println("<h3>400 Bad Request</h3>");
                        out.println("The provided status code is not supported.");
                        break;
                }
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.println("<h3>400 Bad Request</h3>");
                out.println("Invalid status code. Please enter a valid numeric status code.");
            }
        }

        out.println("</body></html>");
    }
}
