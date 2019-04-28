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
<title>Evidentiranje rada</title>
</head>
<body>
	<h1>Evidentiranje rada</h1>
	<hr>
	
    <a href="/">Pocetna</a><br>
    <hr>
    
   	<form action="updateEvidencija" method="post" >

   		Zaposleni: ${evidencija.worker.firstName} ${evidencija.worker.lastName} <br>
		Ime projekta: ${evidencija.worker.project.projectName} <br>
		Trenutno vreme na projektu: ${evidencija.utrosenoVreme} <br>
		Novo vreme: <input type="number" name="utrosenoVreme" /> <br>
		
		<input type="hidden" name="evidencija_id" value="${evidencija.id}" /> 
 		 <input type="hidden" name="worker_id" value="${evidencija.worker.id}" /> 
 		 <input type="hidden" name="projekat_id" value="${evidencija.worker.project.id}" /> 
		
		<input type="submit" value="Insert" onclick="myFunction()"/> 
	</form>   
	
	
<script type="text/javascript">
	function myFunction() {	
	    alert("Evidentiranje uspesno.");
	}
</script>
	
	

	 


</body>
</html>