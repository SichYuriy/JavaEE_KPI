package com.gmail.at.sichyuriyy.lab2;

import java.util.ArrayList;

public class Main {
	
	

	public static void main(String[] args) {
		Dao dao = new Dao();
		DbConnection conn = DbConnection.getInstance();
		ArrayList<Movie> movies = dao.getAllMovies(conn.getConnection());
		for (Movie movie : movies) {
			String nameTd = "<td>" + movie.getName() + "</td>";
			String descriptionTd = "<td>" + movie.getDescription() + "</td>";
			String producerTd = "<td>" + movie.getProducer() + "</td>";
			String yearTd = "<td>" + movie.getYear() + "</td>";
			String durationTd = "<td>" + movie.getDuration() + "</td>";
			String movieRow = "<tr>" + nameTd + descriptionTd + producerTd + yearTd + durationTd + "</tr>";
			System.out.println(movieRow);
		}
		conn.close();

	}

}
