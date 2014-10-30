<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8080/journey/lugar" method="post">
			<label for="nome">Nome: </label>
			<input name="nome" />
			<label for="latitude">Latitude: </label>
			<input name="latitude" />
			<label for="longitude">Longitude: </label>
			<input name="longitude" />
	</form>
</body>
</html>