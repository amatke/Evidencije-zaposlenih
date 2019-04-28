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
<title>Projekti</title>
</head>
<body>
	<h1>Projekti</h1>
	<hr>
	
    <a href="/">Povratak na pocetnu</a>
    <hr>
    
	<br>
	<a href="/projekatForm">Dodaj PROJEKAT</a>

	<br>
	<br>
	Projekti:
 	  <table border="1" >
		<tr>
			<th>ID PROJEKTA</th>
			<th>IME PROJEKTA</th>
			<th>NARUCILAC</th>
		</tr>
			<c:forEach items="${projektiLista}" var="p">
		    <tr>
		    	<td>${p.id}</td>
			    <td>${p.projectName}</td>
			    <td>${p.clientName}</td>
		    </tr>
		</c:forEach> 
	</table>


</body>
</html>