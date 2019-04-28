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
<title>Zaposleni</title>
</head>
<body>
	<h1>Zaposleni</h1>
	<hr>
	
	<a href="/">Pocetna</a><br>
	<a href="/zaposleniForm">Dodaj zaposlenog</a><br>
	<hr>
	
	<form action="/findByName" method="post">
		<input type="text" name="firstName" placeholder="pretraga po imenu" />
		<br>
	</form>
	<hr>
	
 	 Zaposleni: 	 
 	  <table border="1" >
			<tr>
				<th>ID</th>
				<th>Ime</th>
				<th>Prezime</th>
				<th>JMBG</th>
				<th>Pozicija zaposlenog</th>
				<th>TIM name</th>
				<th>Project name</th>
				<th>Client name</th>
			</tr>
		<c:forEach items="${zaposleniAll}" var="z">
		    <tr>
		    	<td>${z.id}</td>
 		    	<td>${z.firstName}</td>
 		    	<td>${z.lastName}</td>
		    	<td>${z.JMBG}</td>
 		    	<td>${z.position.positionName}</td>
		        <td>${z.team.teamName}</td>
		        <td>${z.project.projectName}</td>
		        <td>${z.project.clientName}</td>
		    </tr>
		</c:forEach>
</table>



</body>
</html>