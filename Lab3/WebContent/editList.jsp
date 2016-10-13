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
<title></title>
</head>
<body>
	<%!private WatchListDAO dao = WatchListDAO.getInstance();
	private WatchList list;%>

	<%
		list = dao.getById(Long.parseLong(request.getParameter("id")));
	%>
	<h2><%=list.getName()%></h2>
	<table>
		<thead>
			<tr>
				<th>Film Name</th>
				<th>Producer</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<%
				List<Movie> movies = list.getMovies();
				for (Movie movie : movies) {
					String nameTd = "<td>" + movie.getTitle() + "</td>";
					Producer producer = movie.getProducer();
					String producerTd = "<td>" + producer.getFirstName() + " " + producer.getLastName() + "</td>";
					String deleteButton = "<a href=\"deleteMovieFromWatchList?listId=" + list.getId() + "&movieId="
							+ movie.getId() + "\"><button>Delete</button></a>";
					String buttonsTd = "<td>" + deleteButton + "</td>";
					String row = "<tr>" + nameTd + producerTd + buttonsTd + "</tr>";
					out.println(row);
				}
			%>
		</tbody>
	</table>
	
	<a href="index.jsp"><button>Movies</button></a>
	<a href="producers.jsp"><button>Producers</button></a>
	<a href="watchLists.jsp"><button>WatchLists</button></a>

</body>
</html>