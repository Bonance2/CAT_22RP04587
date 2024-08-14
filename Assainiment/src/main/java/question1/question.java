package question1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class question
 */
@WebServlet("/question")
public class question extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Retrieve coefficients from the form
        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));
        double c = Double.parseDouble(request.getParameter("c"));
        
        // Calculate the discriminant
        double discriminant = b * b - 4 * a * c;
        
        // Prepare response
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Quadratic Equation Roots</h1>");
        
        if (a == 0) {
            response.getWriter().println("<p>Coefficient 'a' cannot be zero.</p>");
        } else if (discriminant > 0) {
            // Two real and distinct roots
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            response.getWriter().println("<p>Root 1: " + root1 + "</p>");
            response.getWriter().println("<p>Root 2: " + root2 + "</p>");
        } else if (discriminant == 0) {
            // One real root
            double root = -b / (2 * a);
            response.getWriter().println("<p>Root: " + root + "</p>");
        } else {
            // No real roots
            response.getWriter().println("<p>No real roots.</p>");
        }
        
        response.getWriter().println("</body></html>");
    }
}
