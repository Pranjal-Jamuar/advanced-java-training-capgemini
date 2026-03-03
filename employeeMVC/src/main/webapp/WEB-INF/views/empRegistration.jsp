<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register Employee</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body class = "center-page">

<div class="container">
    <h2>Register Employee</h2>

    <form action="${pageContext.request.contextPath}/saveEmployee" method="post">

        <div class="form-group">
            <label>ID:</label>
            <input type="number" name="id" required />
        </div>

        <div class="form-group">
            <label>Name:</label>
            <input type="text" name="name" required />
        </div>

        <div class="form-group">
            <label>Phone:</label>
            <input type="text" name="phone" required />
        </div>

        <div class="form-group">
            <label>Email:</label>
            <input type="email" name="email" required />
        </div>

        <input type="submit" value="Register" />

    </form>
</div>

</body>
</html>