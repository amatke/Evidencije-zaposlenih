<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <!--     ovogucava nam koriscenje $
 -->    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodavanje projekata</title>
</head>
<body>
	<h1>Dodavanje projekata</h1>
	<hr>
	
    <a href="/">Pocetna</a><br>
    <hr>
    
	
 	<form action="insertProjekat" method="post" >
		Ime projekta: <input type="text" name="projectName"  /> <br>
		Narucilac projekta: <input type="text" name="clientName" /> <br>
		<input type="submit" value="Insert" onclick="myFunction()"/> 
	</form> 
	
	
<script type="text/javascript">
	function myFunction() {	
	    alert("Dodali ste novi projekat.");
	}
</script>
	
	

	 


</body>
</html>