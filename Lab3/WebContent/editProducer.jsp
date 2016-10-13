<%@ page import="com.gmail.at.sichyuriyy.lab3.jpa.entities.*"%>
<%@ page import="com.gmail.at.sichyuriyy.lab3.jpa.dao.*"%>
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

	<%!private long id;
	private Producer producer;%>
	
	<%
	id = Long.parseLong(request.getParameter("id"));
	producer = ProducerDAO.getInstance().getById(id);
	%>

	<form action="updateProducer" name="postMovieForm" method="post">
		<fieldset>
			<legend>Update producer</legend>
			<input type="text" name="id" readonly value=<%=id%> hidden>
			First Name:<br> <input type="text" name="firstName" value=<%=producer.getFirstName() %>><br>
			Last Name:<br> <input type="text" name="lastName" value=<%=producer.getLastName() %>><br>
			<input type="submit" value="Submit">
		</fieldset>
	</form>

</body>
</html>