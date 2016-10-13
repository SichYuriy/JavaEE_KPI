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
<title>watchLists</title>
</head>
<body>
	<%!private WatchListDAO dao = WatchListDAO.getInstance();%>

	<table>
		<thead>
			<tr>
				<th>List name</th>
				<th></th>
			</tr>
		<thead>
		<tbody>
			<%
				List<WatchList> lists = dao.getAll();
				for (WatchList list : lists) {
					String nameTd = "<td>" + list.getName() + "</td>";
					String editButton = "<a href=\"editList.jsp?id=" + list.getId() + "\"><button>View</button></a>";
					String deleteButton = "<a href=\"deleteWatchList?id=" + list.getId() + "\"><button>Delete</button></a>";
					String buttonsTd = "<td>" + editButton + deleteButton + "</td>";
					String row = "<tr>" + nameTd + buttonsTd + "</tr>";
					out.println(row);

				}
			%>

		</tbody>
	</table>
	<a href="addWatchList.html"><button>New WatchList</button></a>
	<br>
	
	<a href="index.jsp"><button>Movies</button></a>
	<a href="producers.jsp"><button>Producers</button></a>
	<a href="watchLists.jsp"><button>WatchLists</button></a>

</body>
</html>