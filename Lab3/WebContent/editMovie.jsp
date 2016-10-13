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
<title>Insert title here</title>
</head>
<body>
	<%!MovieDAO movieDAO = MovieDAO.getInstance();%>
	<%!ProducerDAO producerDao = ProducerDAO.getInstance();%>
	<%!private Movie movie; %>
	<%
	long id = Long.parseLong(request.getParameter("id"));
	movie = movieDAO.getById(id);
	%>
	<form action="updateMovie" name="postMovieForm" method="post">
		<fieldset>
			<legend>Add movie</legend>
			<input type="text" name="id" value=<%= movie.getId()%> readonly hidden>
			title:<br> <input type="text" name="title" value=<%=movie.getTitle() %>><br>
			description:<br> <input type="text" name="description" value=<%=movie.getDescription() %>><br>
			duration:<br> <input type="text" name="duration" value=<%=movie.getDuration() %>><br>
			year:<br> <input type="text" name="year" value=<%=movie.getYear() %>><br>
			producer:<br> <select name="producerId">
				<%
					List<Producer> producers = producerDao.getAll();
					for (Producer producer : producers) {
						out.println("<option value=\"" + producer.getId() + "\">" + producer.getFirstName() + " "
								+ producer.getLastName() + "</option>");
					}
				%>

			</select><br> 
			imdbRating:<br> <input type="text" name="imdbRating" value=<%=movie.getRating().getImdbRating() %>><br>
			kinoPoiskRating:<br> <input type="text" name="kinoPoiskRating" value=<%=movie.getRating().getKinoPoiskRating() %>><br>
			rottenTomatosRating:<br> <input type="text"
				name="rottenTomatosRating" value=<%=movie.getRating().getRottenTomatosRating() %>><br> 
			<input type="submit" value="Submit">
		</fieldset>
	</form>

</body>
</html>