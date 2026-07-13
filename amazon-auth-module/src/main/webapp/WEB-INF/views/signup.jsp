<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Signup Page</title>
</head>
<body>
    <h2>User Registration (Sign Up)</h2>
    
    <%-- Displays an error if registration fails --%>
    <p style="color:red;">${error}</p>

    <form action="registerUser" method="post">
        <label>Full Name:</label><br>
        <input type="text" name="name" required><br><br>

        <label>Email:</label><br>
        <input type="email" name="email" required><br><br>

        <label>Mobile Number:</label><br>
        <input type="text" name="mobile" required><br><br>

        <label>Password:</label><br>
        <input type="password" name="password" required><br><br>

        <button type="submit">Register</button>
    </form>
    
    <br>
    <a href="login">Already have an account? Login here</a>
</body>
</html>