<%@ page import="lection.services.*"%>
<%@ page import="lection.entities.*"%>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!private MovieService movieService = new MovieService();%>

	<table>
		<thead>
			<tr>
				<th>Title</th>
				<th>Description</th>
				<th>Duration</th>
				<th>Rating</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<Movie> movies = movieService.getALlMovies();
			for (Movie movie : movies) {
				String titleTd = "<td>" + movie.getTitle() + "</td>";
				String descriptionTd = "<td>" + movie.getDescription() + "</td>";
				String durationTd = "<td>" + movie.getDuration() + "</td>";
				String ratingTd = "<td>" + movie.getRating().getImdbRating() + "</td>";
				String row = "<tr>" + titleTd + descriptionTd + durationTd + ratingTd + "</tr>";
				out.println(row);
			}
			%>
		</tbody>
		
	</table>
	<a href="addMovie.jsp"><button>Add Movie</button></a>

</body>
</html>