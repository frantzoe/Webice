<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>

  
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Test</title>
    </head>
    <body>
	    <!-- <p>Bonjour ${ admin.addr } ${ admin.mdp }</p> -->
	    <c:if test="${ !empty sessionScope.addr && !empty sessionScope.mdp }">
	        <p>Voici :  ${ sessionScope.addr } ${ sessionScope.mdp } !</p>
	    </c:if>
	    <form method="post" action="bonjour">
	        <p>
	            <label for="nom">Addr : </label>
	            <input type="text" name="addr" id="addr" />
	        </p>
	        <p>
	            <label for="prenom">Mdp : </label>
	            <input type="text" name="mdp" id="mdp" />
	        </p>        
	        <input type="submit" />
	    </form>
    </body>
</html>