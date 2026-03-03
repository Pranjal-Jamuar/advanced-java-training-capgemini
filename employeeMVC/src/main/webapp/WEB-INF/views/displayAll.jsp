<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
<head>
    <title>All Employees</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<div class = "page-container">

<h2>Employee List</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Phone</th>
    <th>Email</th>
    <th>Actions</th>
</tr>

<c:forEach var="emp" items="${employees}">
<tr>
    <td>${emp.id}</td>
    <td>${emp.name}</td>
    <td>${emp.phone}</td> 
    <td>${emp.email}</td>
    <td>
        <a href="edit?id=${emp.id}">Update</a>
        <a href="delete?id=${emp.id}">Delete</a>
    </td>
</tr>
</c:forEach>

</table>

<br/>
<a href="${pageContext.request.contextPath}/">Add New Employee</a>

</div>

</body>
</html>