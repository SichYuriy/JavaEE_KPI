package com.gmail.at.sichyuriyy.lab2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yuriy
 */
public class Dao {

	private final String selectAllMoviesStatement = "SELECT * FROM movies";
	private final String selectByIdStatement = "SELECT * FROM movies WHERE id=?";
	private final String selectByNameStatement = "SELECT * FORM movies WHERE name=?";

	private final String updateStatement = "UPDATE movies "
			+ "SET name=?, producer=?, year=?, duration=?, description=? " + "WHERE id=?";
	private final String deleteStatement = "DELETE FROM movies " + "WHERE id=?";
	private final String insertAutoStatement = "INSERT INTO movies(name, producer, year, duration, description)"
			+ "VALUES (?, ?, ?, ?, ?)";
	private final String insertIdStatement = "INSERT INTO movies(name, producer, year, duration, description, id)"
			+ "VALUES (?, ?, ?, ?, ?, ?)";

	public ArrayList<Movie> getAllMovies() {

		ArrayList<Movie> movies = new ArrayList<>();
		try (Connection conn = ConnectionManager.getInastance().getConnection();
				Statement statement = conn.createStatement()) {
			ResultSet rs = statement.executeQuery(selectAllMoviesStatement);
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setId(rs.getInt("id"));
				movie.setName(rs.getString("name"));
				movie.setProducer(rs.getString("producer"));
				movie.setYear(rs.getInt("year"));
				movie.setDuration(rs.getInt("duration"));
				movie.setDescription(rs.getString("description"));
				movies.add(movie);
			}
		} catch (SQLException ex) {
			Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return movies;
	}

	public Movie getMovieById(int id) {
		try (Connection conn = ConnectionManager.getInastance().getConnection();
				PreparedStatement statement = conn.prepareStatement(selectByIdStatement)) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			Movie movie = null;
			if (rs.next()) {
				movie = new Movie();
				movie.setId(rs.getInt("id"));
				movie.setName(rs.getString("name"));
				movie.setProducer(rs.getString("producer"));
				movie.setYear(rs.getInt("year"));
				movie.setDuration(rs.getInt("duration"));
				movie.setDescription(rs.getString("description"));
			}
			return movie;
		} catch (SQLException e) {
			System.out.println(e.toString());

		}
		return null;
	}

	public ArrayList<Movie> getMoviesByName(String name) {

		try (Connection conn = ConnectionManager.getInastance().getConnection();
				PreparedStatement statement = conn.prepareStatement(selectByNameStatement)) {
			statement.setString(1, name);
			ResultSet rs = statement.executeQuery();
			ArrayList<Movie> movies = new ArrayList<>();
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setId(rs.getInt("id"));
				movie.setName(rs.getString("name"));
				movie.setProducer(rs.getString("producer"));
				movie.setYear(rs.getInt("year"));
				movie.setDuration(rs.getInt("duration"));
				movie.setDescription(rs.getString("description"));
				movies.add(movie);
			}
			return movies;
		} catch (SQLException e) {
			System.out.println(e.toString());

		}
		return null;

	}

	public void updateMovie(Movie movie) {

		try (Connection conn = ConnectionManager.getInastance().getConnection();
				PreparedStatement statement = conn.prepareStatement(updateStatement)) {

			statement.setString(1, movie.getName());
			statement.setString(2, movie.getProducer());
			statement.setInt(3, movie.getYear());
			statement.setInt(4, movie.getDuration());
			statement.setString(5, movie.getDescription());
			statement.setInt(6, movie.getId());

			statement.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void deleteMovie(Movie movie) {

		try (Connection conn = ConnectionManager.getInastance().getConnection();
				PreparedStatement statement = conn.prepareStatement(deleteStatement)) {
			statement.setInt(1, movie.getId());
			statement.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void insertMovie(Movie movie, boolean autoIncrement) {

		String insertStatement = autoIncrement ? insertAutoStatement : insertIdStatement;

		try (Connection conn = ConnectionManager.getInastance().getConnection();
				PreparedStatement statement = conn.prepareStatement(insertStatement)) {
			statement.setString(1, movie.getName());
			statement.setString(2, movie.getProducer());
			statement.setInt(3, movie.getYear());
			statement.setInt(4, movie.getDuration());
			statement.setString(5, movie.getDescription());
			if (!autoIncrement) {
				statement.setInt(6, movie.getId());
			}

			statement.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
