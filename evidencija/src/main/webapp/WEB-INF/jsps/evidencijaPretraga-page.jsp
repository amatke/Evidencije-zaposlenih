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
<title>Evidencija pretraga</title>
</head>
<body>
	<h1>Evidentiranje pretraga</h1>
	<hr>
	
    <a href="/">Povratak na pocetnu</a>
    <hr>
  
  <h1> ${notFound} </h1>

	<br>
	Rezultat pretrage:
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
				<th>Utroseno vreme</th>
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
		        <td> <a href="/evidentirajVreme?zaposleniID=${z.id}">Evidentiraj</a> </td>
		    </tr>
		</c:forEach>  
</table>


</body>
</html>