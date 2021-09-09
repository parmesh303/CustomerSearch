<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type = "text/css">
	h2{
		color:red;
	}
	body{
	text-align:center;}
</style>
</head>
<body>
	<h1>Admin Page</h1><br/>
	<form:form action="store" method="post" modelAttribute="bean">
		Enter Movie Nmae: <form:input path="movieName"/> <br/><br/>
		Enter Cinema Hall: <form:input path="cinemaHall"/> <br/><br/>
		Enter Price: <form:input path="price"/> <br/><br/>
		
		  Language:<form:select path="language" name="search"> 
                	<form:option value="Hindi" label="Hindi"/>
                <form:option value="Kannada" label="Kannada"/>
                <form:option value="Telugu" label="Telugu"/>
                <form:option value="Marati" label="Marati"/>
                 <form:option value="English" label="English"/>
                </form:select> <br/><br/>
		
		Location:<form:select path="location" name="search">
                <form:option value="Bangalore" label="Bangalore"/>
                <form:option value="Delhi" label="Delhi"/>
                <form:option value="AP" label="AP"/>
                <form:option value="Pune" label="Pune"/>
                </form:select> <br/><br/>
		
		<input type="submit" value="Register">
	</form:form>
	<br/>
	<h2> ${msg} </h2>
</body>
</html>