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
<title>Insert title here</title>
</head>
<body>

   Povratak na pocetnu - <a href="/">Pocetna</a>
    <hr>
	
	<form action="insertZaposleni" method="post">
		Ime: <input type="text" name="ime" /> <br>
		Prezime: <input type="text" name="prezime" /> <br>
		JMBG: <input type="text" name="jmbg" /> <br>
		Pozicija zaposlenog: 
		  <input list="pozicije" name="pozicijaZaposlenog" />
		  <datalist id="pozicije">
		    <option value="JUNIOR">
		    <option value="SENIOR">
		    <option value="TEAM_LEADER">
		    <option value="PROJECT_MANAGER">
		  </datalist> <br>
		 Dodeli tim: 
		
		 <select name="tim">
		    <c:forEach items="${listaTimova}" var="tim">
		        <option value="${tim.id}"></option>
		    </c:forEach>
		</select>
		
		<!-- <th th:text="${tim.imeTima}"></th>  -->
       
		   <br>
		<input type="submit" value="Insert" /> 
		</form>

</body>
</html>