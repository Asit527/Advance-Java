<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h2>User Login</h2>
    
    <%-- Displays success message from registration or password reset --%>
    <p style="color:green;">${msg}</p>
    <%-- Displays error message if login credentials are wrong --%>
    <p style="color:red;">${error}</p>

    <form action="loginUser" method="post">
        <label>Email:</label><br>
        <input type="email" name="email" required><br><br>

        <label>Password:</label><br>
        <input type="password" name="password" required><br><br>

        <button type="submit">Login</button>
    </form>
    
    <br>
    <a href="signup">Don't have an account? Sign up</a> | 
    <a href="reset">Forgot Password?</a>
</body>
</html>