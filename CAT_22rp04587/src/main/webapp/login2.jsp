<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String email=request.getParameter("email");
String password=request.getParameter("password");
String jdbcURL="jdbc:mysql://localhost:3306/emp_22rp04587";
String dbUser="root";
String dbPassword = "";
Connection connection = null;
PreparedStatement statement = null;
ResultSet resultSet = null;

try {
    Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL JDBC driver
    connection = emp_22rp04587.getConnection(jdbcURL, dbUser, dbPassword);

    // Check if the user exists
    String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
    statement = connection.prepareStatement(sql);
    statement.setString(1, email);
    statement.setString(2, password); // In a real app, hash the password before checking
    resultSet = statement.executeQuery();

    if (resultSet.next()) {
    	response.sendRedirect("navigation.jsp");
        out.println("<h3>Login successful!</h3>");
        out.println("<p>Welcome, " + email+ "!</p>");
        // You can redirect to another page or set session attributes here
    } else {
        out.println("<h3>Login failed!</h3>");
        out.println("<p>Invalid registration number or password.</p>");
        out.println("<a href='login.jsp'>Try again</a>");
    }
} catch (SQLException e) {
    out.println("<h3>Error: " + e.getMessage() + "</h3>");
} catch (Exception e) {
    e.printStackTrace();
    out.println("<h3>Error: " + e.getMessage() + "</h3>");
} finally {
    // Clean up JDBC resources
    try {
        if (resultSet != null) resultSet.close();
        if (statement != null) statement.close();
        if (connection != null) connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
%>


</body>
</html>