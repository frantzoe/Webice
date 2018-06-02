<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="m_package.Test_bean" %>
<%@ page import="m_package.Admin" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Identification</title>
</head>
<body>
	<% Admin a = (Admin) session.getAttribute("admin"); %>
	<h1>Infos user</h1>
	<ul>
		<li>Login : <%=a.getAddr()%></li>
		<li>Mdp : <%=a.getMdp()%></li>
	</ul>
</body>
</html>