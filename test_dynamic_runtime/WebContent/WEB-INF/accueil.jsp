<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Accueil</title>
</head>
<body>
	<c:if test="${ !empty nom }"><p><c:out value="Bonjour, vous vous appelez ${ nom }" /></p></c:if>
        
    <form method="post" action="Test"> <!-- nom servlet -->
        <label for="nom">Nom : </label>
        <input type="text" name="nom" id="nom" />
            
        <input type="submit" />
    </form>
    
    
    <br /><br /><br /><br /><br /><br />


	 

	<form method = "POST" action = "Test">
		Login : <input type="text" name="login"><br/>
		Password : <input type="text" name="pwd"><br/>
		<input type="submit" value="Submit">
	</form>
	
	
</body>
</html>