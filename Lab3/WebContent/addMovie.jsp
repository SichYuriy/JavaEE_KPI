<%@ page import="com.gmail.at.sichyuriyy.lab3.jpa.dao.*"%>
<%@ page import="com.gmail.at.sichyuriyy.lab3.jpa.entities.*"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add movie</title>
</head>
<body>
<%! ProducerDAO producerDao = ProducerDAO.getInstance(); %>
	<form action="createMovie" name="postMovieForm" method="post">
		<fieldset>
			<legend>Add movie</legend>
			title:<br> <input type="text" name="title"><br>
			description:<br> <input type="text" name="description"><br>
			duration:<br> <input type="text" name="duration"><br>
			year:<br> <input type="text" name="year"><br> 
			producer:<br>
			<select name="producerId">
  			<% 
  			List<Producer> producers = producerDao.getAll();
  			for (Producer producer : producers) {
  				out.println("<option value=\"" + producer.getId() + "\">" 
  						+ producer.getFirstName() + " " + producer.getLastName() + "</option>");
  			}
  			%>
  			
			</select><br>
			imdbRating:<br> <input type="text" name="imdbRating"><br> 
			kinoPoiskRating:<br> <input type="text" name="kinoPoiskRating"><br> 
			rottenTomatosRating:<br> <input type="text" name="rottenTomatosRating"><br> 
			<input type="submit" value="Submit">
		</fieldset>
	</form>



</body>
</html>