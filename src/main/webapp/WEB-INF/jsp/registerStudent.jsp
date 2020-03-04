<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<body>

<h1 align="center">Student Registration Screen</h1>

<f:form action="addStudent" method="post" modelAttribute="student">

Enter Student Name:<f:input path="name"/><br><br>

Enter Address:<f:input path="address"/><br><br>

Enter Email:<f:input path="email"/><br><br>

Enter Password:<f:input path="password" type="password"/><br><br>

<input type="submit" value="Register">


</f:form>





</body>
</html>