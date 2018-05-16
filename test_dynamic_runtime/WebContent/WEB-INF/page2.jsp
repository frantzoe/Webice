<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<c:if test="${ sessionScope.admin.getAddr() == 'admin@admin' && sessionScope.admin.getMdp() == '1234'}">
		<title>Panel admin</title>
	</c:if>
	<c:if test="${ sessionScope.admin.getAddr() != 'admin@admin' && sessionScope.admin.getMdp() != '1234'}">
		<title>Acces refuse</title>
	</c:if>
</head>
<body>
	<h1>Vous êtes sur le panel admin</h1>
	<c:if test="${ sessionScope.admin.getAddr() == 'admin@admin' && sessionScope.admin.getMdp() == '1234'}">
		<p>Bienvenue ma gueule !</p>
	</c:if>
	<c:if test="${ sessionScope.admin.getAddr() != 'admin@admin' && sessionScope.admin.getMdp() != '1234'}">
		<p>J'ai : ${ sessionScope.admin.getAddr() } && ${ sessionScope.admin.getMdp() }</p>
	</c:if>
</body>
</html>