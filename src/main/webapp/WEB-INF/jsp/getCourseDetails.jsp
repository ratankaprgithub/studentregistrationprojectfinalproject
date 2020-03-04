<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<body>

<h2>The Result is :</h2>


<h2>Course ID is :${course.courseId}</h2>
<h2>Course Name is :${course.courseName}</h2>
<h2>Course Fee is : ${course.fee}</h2>
<h2>Duration is :${course.duration}</h2>


<h2>StartDate is <fmt:formatDate value="${course.startDate }"  pattern="dd-MM-yyyy"/> </h2>


<h2>Course Capacity is ${course.capacity}</h2>
<h2>Course Availability is ${course.availability}</h2>






</body>
</html>