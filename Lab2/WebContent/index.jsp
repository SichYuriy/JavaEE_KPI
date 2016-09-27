<%@ page import="com.gmail.at.sichyuriyy.lab2.*"%>
<%@ page import="java.util.ArrayList"%>
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

	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Producer</th>
				<th>Year</th>
				<th>Duration(minutes)</th>
			</tr>
		<thead>
		<tbody>
			<%
				Dao dao = new Dao();
				DbConnection conn = DbConnection.getInstance();
				System.out.println(conn.getConnection());
				ArrayList<Movie> movies = dao.getAllMovies(conn.getConnection());
				for (Movie movie : movies) {
					String nameTd = "<td>" + movie.getName() + "</td>";
					String descriptionTd = "<td>" + movie.getDescription() + "</td>";
					String producerTd = "<td>" + movie.getProducer() + "</td>";
					String yearTd = "<td>" + movie.getYear() + "</td>";
					String durationTd = "<td>" + movie.getDuration() + "</td>";
					String movieRow = "<tr>" + nameTd + descriptionTd + producerTd + yearTd + durationTd + "</tr>";
					out.println(movieRow);
				}
				
			%>
		</tbody>
	</table>
	<a href="insertMovie.html"><button>Add movie</button></a>

</body>
</html>