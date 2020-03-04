<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 align="center">Hi ${student.name }</h1>


<h2>Please Confirm your Order</h2>

<h3>Course Name : ${course.courseName }</h3>

<h3>Amount is : ${course.fee }</h3>


<h4><a href="confirm?cid=${course.courseId }&sid=${student.email} ">Pay</a></h4>







</body>
</html>