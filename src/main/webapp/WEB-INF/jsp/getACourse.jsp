<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>


<c:choose>

<c:when test="${courses eq null }">

<h2>No Course Found</h2>

</c:when>

<c:otherwise>

<f:form method="get" action="getCourseDetails" modelAttribute="course">

Select Course :

<f:select path="courseName">
<f:options items="${courses }"/>

</f:select>

<input type="submit" value="Get">

</f:form>

</c:otherwise>

</c:choose>


</body>
</html>