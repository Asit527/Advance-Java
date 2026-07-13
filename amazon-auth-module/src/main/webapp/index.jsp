<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>E-Commerce Portal</title>
    <style>
        .container { text-align: center; margin-top: 100px; }
        .btn { 
            display: inline-block; 
            padding: 10px 20px; 
            margin: 10px; 
            font-size: 16px; 
            color: white; 
            background-color: #007bff; 
            text-decoration: none; 
            border-radius: 5px; 
        }
        .btn:hover { background-color: #0056b3; }
    </style>
</head>
<body>

    <div class="container">
        <h1>Welcome to the E-Commerce Platform</h1>
        <p>Please select an option below to proceed:</p>
        
        <a href="login" class="btn">Go to Login</a>
        <a href="signup" class="btn">Go to Signup</a>
        <a href="reset" class="btn">Reset Password</a>
    </div>

</body>
</html>