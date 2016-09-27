package com.gmail.at.sichyuriyy.lab2;

import java.sql.Connection;
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

	private final String selectAllMoviesStatement = "SELECT * FROM movies;";
	private final String selectByIdStatement = "SELECT * FROM movies WHERE id=";
	private final String selectByNameStatement = "SELECT * FORM movies WHERE name=";
	private final String updateSetStatement = "UPDATE movies SET ";
	private final String updateWhereStatement = "WHERE id=";
	private final String deleteStatement = "DELETE FROM movies WHERE id=";
	private final String insertAutoStatement = "INSERT INTO movies(name, " + "producer, year, duration, description)"
			+ "VALUES ";
	private final String insertIdStatement = "INSERT INTO movies(id, name, " + "producer, year, duration, description)"
			+ "VALUES ";

	public Movie getMovieById(Connection conn, int id) {
		try (Statement statement = conn.createStatement()) {
			ResultSet rs = statement.executeQuery(selectByIdStatement + id + ";");
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

	public ArrayList<Movie> getMoviesByName(Connection conn, String name) {
		ArrayList<Movie> movies = new ArrayList<>();
		try (Statement statement = conn.createStatement()) {
			ResultSet rs = statement.executeQuery(selectByNameStatement + name);
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
		} catch (SQLException e) {
			System.out.println(e.toString());

		}
		return movies;

	}

	public ArrayList<Movie> getAllMovies(Connection conn) {
		ArrayList<Movie> movies = new ArrayList<>();
		try (Statement statement = conn.createStatement()) {
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

	public void updateMovie(Connection conn, Movie movie) {
		try (Statement statement = conn.createStatement()) {
			statement.executeUpdate(updateSetStatement + "name='" + movie.getName() + "', " + "producer='"
					+ movie.getProducer() + "', " + "year=" + movie.getYear() + ", " + "duration=" + movie.getDuration()
					+ ", " + "description='" + movie.getDescription() + "' " + updateWhereStatement + movie.getId()
					+ ";");

		} catch (SQLException ex) {
			Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void deleteMovie(Connection conn, Movie movie) {
		try (Statement statement = conn.createStatement()) {
			statement.executeUpdate(deleteStatement + movie.getId() + ";");
		} catch (SQLException ex) {
			Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void insertMovie(Connection conn, Movie movie, boolean autoIncrement) {
		try (Statement statement = conn.createStatement()) {
			String insertStatement;
			String id;
			if (autoIncrement) {
				insertStatement = insertAutoStatement;
				id = "";
			} else {
				insertStatement = insertIdStatement;
				id = "" + movie.getId() + ",";
			}
			statement.executeUpdate(insertStatement + "(" + id + "'" + movie.getName() + "'," + "'"
					+ movie.getProducer() + "'," + movie.getYear() + "," + movie.getDuration() + "," + "'"
					+ movie.getDescription() + "'" + ");");
		} catch (SQLException ex) {
			Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}