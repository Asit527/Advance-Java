<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Amazon Search</title>

<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f3f3f3;
    margin: 0;
}

.container {
    width: 400px;
    margin: 100px auto;
    background: white;
    padding: 25px;
    border: 1px solid #ddd;
}

h2 {
    color: #131921;
    margin-top: 0;
}

input[type="text"] {
    width: 100%;
    padding: 10px;
    box-sizing: border-box;
    margin-bottom: 12px;
}

input[type="submit"] {
    background-color: #ffd814;
    border: 1px solid #fcd200;
    padding: 10px 20px;
    cursor: pointer;
}
</style>

</head>
<body>

<div class="container">
    <h2>Amazon Search</h2>

    <form action="searchProduct" method="get">
        <input type="text" name="searchText" placeholder="Search Products">
        <input type="submit" value="Search">
    </form>
</div>

</body>
</html>