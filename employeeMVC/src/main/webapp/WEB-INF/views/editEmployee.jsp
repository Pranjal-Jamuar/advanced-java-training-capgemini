<html>
<head>
    <title>Edit Employee</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<h2>Edit Employee</h2>

<form action="updateEmployee" method="post">
    ID: <input type="number" name="id" value="${employee.id}" readonly/><br/><br/>
    Name: <input type="text" name="name" value="${employee.name}" required/><br/><br/>
    Phone: <input type="text" name="phone" value="${employee.phone}" required/><br/><br/>
    Email: <input type="email" name="email" value="${employee.email}" required/><br/><br/>
    <input type="submit" value="Update"/>
</form>

</body>
</html>