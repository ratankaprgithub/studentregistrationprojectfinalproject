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

<h1 align="center">Add New Course Screen</h1>

<f:form action="updateCourse" method="post" modelAttribute="course">

	 Course ID : <f:input path="courseId" readonly="true"/>

	 Course Name :<f:input path="courseName" readonly="true" /><br><br>

	 Course Duration :<f:input path="duration" /><br><br>

	 Course Fee :<f:input path="fee" /><br><br>

	 StartDate :<f:input path="startDate" /><br><br>

	 Seat Capacity :<f:input path="capacity" /><f:errors path="capacity"/> <br><br>

	<input type="submit" value="UpdateCourse">

</f:form>




</body>
</html>