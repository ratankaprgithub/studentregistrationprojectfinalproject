<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">

	<h1 align="center">Add New Course Screen</h1>

<f:form action="createCourse" method="post" modelAttribute="course">

	Enter Course Name :<f:input path="courseName" /><br><br>

	Enter Course Duration :<f:input path="duration" /><br><br>

	Enter Course Fee :<f:input path="fee" /><br><br>

	Enter StartDate :<f:input path="startDate" /><br><br>

	Enter Seat Capacity :<f:input path="capacity" /><br><br>

	<input type="submit" value="AddCourse">

</f:form>


</body>
</html>