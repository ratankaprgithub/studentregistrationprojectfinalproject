<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:if test="${flag==1 }">

<h2>Invalid Username or Password</h2>

</c:if>


<f:form action="login" method="post" modelAttribute="login">

Enter Username :<f:input path="username"/><f:errors path="username"/>
<br><br>
Enter Password :<f:input path="password"/><f:errors path="password"/>
<br><br>
Login As :
<f:select path="loginAs">

<option>Admin</option>
<option>Student</option>
<option>Clerk</option>

</f:select>

<br><br>

<input type="submit" value="Login">



</f:form>
<br><br>


<a href="registerStudent">New Student ? SignUp.</a>

</body>
</html>