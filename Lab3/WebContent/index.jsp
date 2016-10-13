<%@ page import="com.gmail.at.sichyuriyy.lab3.jpa.entities.*"%>
<%@ page import="com.gmail.at.sichyuriyy.lab3.jpa.dao.*"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movies</title>
</head>
<body>

	<table>
		<thead>
			<tr>
				<th>Title</th>
				<th>Description</th>
				<th>Producer</th>
				<th>Year</th>
				<th>Duration(minutes)</th>
				<th>Rating</th>
				<th></th>
				<th></th>
			</tr>
		<thead>
		<tbody>
			<%
				MovieDAO dao = MovieDAO.getInstance();
				List<Movie> movies = dao.getAll();
				for (Movie movie : movies) {
					String nameTd = "<td>" + movie.getTitle() + "</td>";
					String descriptionTd = "<td>" + movie.getDescription() + "</td>";
					Producer producer = movie.getProducer();
					String producerTd = "<td>" + producer.getFirstName() + " " + producer.getLastName() + "</td>";
					String yearTd = "<td>" + movie.getYear() + "</td>";
					String durationTd = "<td>" + movie.getDuration() + "</td>";
					Rating rating = movie.getRating();
					String ratingTd = "<td>" + rating.getImdbRating() + "/" + rating.getKinoPoiskRating() + "/"
							+ rating.getRottenTomatosRating() + "</td>";
					String editButton = "<a href=editMovie.jsp?id=" + movie.getId() + "><button>Edit</Button></a>";
					String deleteButton = "<a href=deleteMovie?id=" + movie.getId() + "><button>Delete</Button></a>";

					String buttonsTd = "<td>" + editButton + deleteButton + "</td>";

					String addToListButton = "<a href=addMovieToWatchList.jsp?id=" + movie.getId() + "><button>+</button></a>";
					String addTd = "<td>" + addToListButton + "</td>";
					String movieRow = "<tr>" + nameTd + descriptionTd + producerTd + yearTd + durationTd + ratingTd
							+ buttonsTd + addTd + "</tr>";
					out.println(movieRow);
				}
			%>
		</tbody>
	</table>
	<a href="addMovie.jsp"><button>add Movie</button></a>
	<br>
	<a href="index.jsp"><button>Movies</button></a>
	<a href="producers.jsp"><button>Producers</button></a>
	<a href="watchLists.jsp"><button>WatchLists</button></a>

</body>
</html>