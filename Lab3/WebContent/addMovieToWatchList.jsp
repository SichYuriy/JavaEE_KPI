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
	<%!WatchListDAO watchListDAO = WatchListDAO.getInstance();%>
	<%!private Movie movie; %>
	<%
	long id = Long.parseLong(request.getParameter("id"));
	movie = movieDAO.getById(id);
	%>
	<form action="addMovieToWatchList" name="postMovieForm" method="post">
		<fieldset>
			<legend>Add movie to watchList</legend>
			<input type="text" name="movieId" value=<%= movie.getId()%> readonly hidden>
			title:<br> <input type="text" name="title" value=<%=movie.getTitle() %> readonly><br>
			producer:<br> <select name="watchListId">
				<%
					List<WatchList> lists = watchListDAO.getAll();
					for (WatchList list : lists) {
						out.println("<option value=\"" + list.getId() + "\">" + list.getName() + "</option>");
					}
				%>

			</select><br> 
			
			<input type="submit" value="Submit">
		</fieldset>
	</form>

</body>
</html>