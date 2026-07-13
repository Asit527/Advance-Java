<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Reset Password Page</title>
</head>
<body>
    <h2>Reset Password</h2>
    
    <%-- Displays an error if the email doesn't exist --%>
    <p style="color:red;">${error}</p>

    <form action="resetPassword" method="post">
        <label>Email:</label><br>
        <input type="email" name="email" required><br><br>

        <label>New Password:</label><br>
        <input type="password" name="newPassword" required><br><br>

        <button type="submit">Update Password</button>
    </form>
    
    <br>
    <a href="login">Back to Login</a>
</body>
</html>