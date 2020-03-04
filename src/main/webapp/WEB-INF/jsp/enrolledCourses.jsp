<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<body>

<h1>Hello ${student.name }</h1>


<table border="2" align="center" cellspacing="10"  cellpadding="10">

<tr>
	<th>CourseId</th>
	<th>CourseName</th>
	<th>CourseFee</th>
	<th>Duration</th>
	<th>StartDate</th>
	
</tr>

<c:forEach var="cr" items="${courses }" >

<tr>
	<th>${cr.courseId }</th>
	
	<th>${cr.courseName }</th>
	
	<th>${cr.fee }</th>
	
	<th>${cr.duration }</th>
	
	<th><fmt:formatDate value="${cr.startDate }" pattern="dd-MM-yyyy"/> </th>
	
</tr>


<c:set var="courses" value="${courses }" scope="session" />




</c:forEach>









</table>


<br><br>

<a href="#">Download in PDF</a>

<br><br>

<a href="generateExcel">Download in Excel</a>


</body>
</html>