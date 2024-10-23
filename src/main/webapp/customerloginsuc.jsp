<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome to Car Service</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            text-align: center;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }

        h1 {
            color: #3498db;
        }

        a {
            display: block;
            color: #3498db;
            margin: 10px 0;
            text-decoration: none;
            font-size: 16px;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <%
            String susername = (String) session.getAttribute("susername");
            if (susername != null) {
                out.println("<h1>Hi " + susername + ", welcome to Car Service</h1>");
            } else {
                out.println("<h1>Welcome to Car Service</h1>");
            }
        %>
        
        <a href="carDetails.html">Enter Your Car Details</a>
        <a href="#editcardetails.html">Edit Car Details</a>
        <a href="requstforservice.html">Request for Service</a>
        <a href="#">Check Service Status</a>
    </div>
</body>
</html>
