<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Panel admin</title>
</head>
<body>
	<h1>Vous êtes sur le panel admin</h1>
	<c:if test="${ !empty nom }"><p><c:out value="Bienvenue ${ nom }" /></p></c:if>
</body>
</html>