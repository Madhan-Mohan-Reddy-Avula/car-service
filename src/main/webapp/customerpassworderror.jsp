<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .login-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #3498db;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            width: 100%;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #2980b9;
        }

        .error-message {
            color: red;
            font-size: 14px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

<div class="login-container">
    <form action="/car-service-system/CustomeLogin" method="POST">
        <label for="username">User Name:</label><br>
        <input type="text" name="username" id="username" placeholder="Enter your username"><br>
        
        <label for="password">Password:</label><br>
        <input type="password" name="password" id="password" placeholder="Enter your password"><br>

        <% 
            // Check if the password or login failed
            String loginError = (String) request.getAttribute("loginError");
            if (loginError != null && loginError.equals("failed")) {
        %>
            <p class="error-message">Incorrect  password, please try again.</p>
        <% } %>
        
        <input type="submit" value="Login">
    </form>
</div>

</body>
</html>
