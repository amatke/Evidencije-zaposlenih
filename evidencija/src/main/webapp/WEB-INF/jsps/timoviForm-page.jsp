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
<title>Dodavanje timova</title>
</head>
<body>
	<h1>Dodavanje timova</h1>
	<hr>
	
    <a href="/">Pocetna</a><br>
    <hr>
    
	
 	<form action="insertTim" method="post" >
		Ime tima: <input type="text" name="teamName"  /> <br>
		<input type="submit" value="Insert" onclick="myFunction()"/> 
	</form> 
	
	
<script type="text/javascript">
	function myFunction() {	
	    alert("Dodali ste novi tim.");
	}
</script>
	
	

	 


</body>
</html>