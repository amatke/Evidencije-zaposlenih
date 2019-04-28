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
<title>Timovi</title>
</head>
<body>
	<h1>Timovi</h1>
	<hr>
	
    Povratak na pocetnu - <a href="/">Pocetna</a>
    <hr>
	
	<br>
	<a href="/timForm">Dodaj TIM</a><br><br>
	
	Timovi:
	 
 	  	  <table border="1" >

				<tr>
					<th>ID tima</th>
					<th>Ime tima</th>
				</tr>
				<c:forEach items="${timoviLista}" var="l">
				    <tr>
				        <td>${l.id}</td>
						<td>${l.teamName}</td>
				    </tr>
				</c:forEach>
		</table> 
	 


</body>
</html>