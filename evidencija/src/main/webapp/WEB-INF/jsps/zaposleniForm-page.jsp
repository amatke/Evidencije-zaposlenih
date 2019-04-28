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
<title>Dodavanje zaposlenog</title>
</head>
<body>
	<h1>Dodavanje zaposlenog</h1>
	<hr>
	
    <a href="/">Pocetna</a><br>
    <hr>
	
 	<form action="insertZaposleni" method="post" >
		Ime: <input type="text" name="firstName" id="firstName" /> <br>
		Prezime: <input type="text" name="lastName" /> <br>
		JMBG: <input type="text" name="JMBG" /> <br>
		
		Pozicija zaposlenog: 
		<select name="position">
		    <c:forEach items="${listaPozicija}" var="pozicija">
		        <option value="${pozicija.id}">${pozicija.positionName}</option>
		    </c:forEach>
		</select>
		  
		<br>  		  
		 Dodeli tim: 
		 <select name="team">
		    <c:forEach items="${listaTimova}" var="tim">
		        <option value="${tim.id}">${tim.teamName}</option>
		    </c:forEach>
		</select>
		
		<br>  		  
		 Dodeli projekat: 
		 <select name="project">
		    <c:forEach items="${listaProjekata}" var="p">
		        <option value="${p.id}">${p.projectName}</option>
		    </c:forEach>
		</select>
   
		<br>
		<input type="submit" value="Insert" onclick="myFunction(this.form)"/> 
	</form> 
	
	
<script type="text/javascript">
	function myFunction(form) {	
	    alert("Dodali ste novog zaposlenog.");
	}
</script>
	
	

	 


</body>
</html>