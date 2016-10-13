<%@ page import="com.gmail.at.sichyuriyy.lab3.jpa.dao.*" %>
<%@ page import="com.gmail.at.sichyuriyy.lab3.jpa.entities.*" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Producers</title>
</head>
<body>

	<table>
		<thead>
			<tr>
				<th>FirstName</th>
				<th>LastName</th>
				<th></th>
			</tr>
		<thead>
		<tbody>
			<%
				ProducerDAO dao = ProducerDAO.getInstance();
				List<Producer> producers = dao.getAll();
				for (Producer producer : producers) {
					String firstNameTd = "<td>" + producer.getFirstName() + "</td>";
					String lastNameTd = "<td>" + producer.getLastName() + "</td>";
					String editButton = "<a href=\"editProducer.jsp?id=" + producer.getId() +"\"><button>Edit</Button></a>";
					String deleteButton = "<a href=deleteProducer?id=" + producer.getId() +"><button>Delete</Button></a>";
					String buttonsTd = "<td>" + editButton + "</td>";
					String movieRow = "<tr>" + firstNameTd + lastNameTd + buttonsTd + "</tr>";
					out.println(movieRow);
				}
			%>
		</tbody>
	</table>
	
	<a href="addProducer.html"><button>Add producer</button></a>
	<br>
	<a href="index.jsp"><button>Movies</button></a>
	<a href="producers.jsp"><button>Producers</button></a>
	<a href="watchLists.jsp"><button>WatchLists</button></a>
	

</body>
</html>