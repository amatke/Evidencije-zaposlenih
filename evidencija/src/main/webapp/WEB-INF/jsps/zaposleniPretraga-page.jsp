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
	<h1>Zaposleni pretraga</h1>
	<hr>
	
	Povratak na pocetnu - <a href="/">Pocetna</a>
	
	<hr>
	
	<h1>${notFound}</h1>
	
	
			
	<hr>
 	 Zaposleni: 	 
 	  <table border="1" >
  			<tr>
				<th>ID</th>
				<th>Ime</th>
				<th>Prezime</th>
				<th>JMBG</th>
				<th>Pozicija zaposlenog</th>
				<th>Project name</th>
				<th>Client name</th>
				<th>Team name</th>
			</tr>
		<c:forEach items="${pretraga}" var="p">
		    <tr>
		    	<td>${p.id}</td>
		    	<td>${p.firstName}</td>
		    	<td>${p.lastName}</td>
		    	<td>${p.JMBG}</td>
		    	<td>${p.position.positionName}</td>
		        <td>${p.project.projectName}</td>
		        <td>${p.project.clientName}</td>
		        <td>${p.team.teamName}</td>
		    </tr> 
		 </c:forEach>
</table>
 	  

	

</body>
</html>