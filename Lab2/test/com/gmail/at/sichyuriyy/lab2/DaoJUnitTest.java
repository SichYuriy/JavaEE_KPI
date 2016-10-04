package com.gmail.at.sichyuriyy.lab2;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Yuriy
 */
public class DaoJUnitTest {

	private static Dao dao;

	private static final int insertId = 228;
	private final String insertName = "Film1";
	private final String insertProducer = "Producer1";
	private final int insertYear = 2016;
	private final int insertDuration = 150;
	private final String insertDescription = "Description1";

	private static final int updateId = 229;
	private final String updateNameBefore = "Film210";
	private final String updateProducerBefore = "Producer210";
	private final String updateNameAfter = "Film211";
	private final String updateProducerAfter = "Producer211";
	private final int updateYear = 2016;
	private final int updateDuration = 160;
	private final String updateDescription = "Description2";

	public DaoJUnitTest() {
		dao = new Dao();
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void afterClass() {
		Movie insertMovie = dao.getMovieById(insertId);
		Movie updateMovie = dao.getMovieById(updateId);
		dao.deleteMovie(insertMovie);
		dao.deleteMovie(updateMovie);
		
	}

	@Test
	public void InsertTest() {
		
		Movie insertMovie = new Movie();
		insertMovie.setId(insertId);
		insertMovie.setName(insertName);
		insertMovie.setProducer(insertProducer);
		insertMovie.setYear(insertYear);
		insertMovie.setDuration(insertDuration);
		insertMovie.setDescription(insertDescription);
		dao.insertMovie(insertMovie, false);
		Movie checkMovie = dao.getMovieById(insertId);
		assertEquals(insertMovie, checkMovie);
	}

	@Test
	public void UpdateTest() {
		Movie updateMovie = new Movie();
		updateMovie.setId(updateId);
		updateMovie.setName(updateNameBefore);
		updateMovie.setProducer(updateProducerBefore);
		updateMovie.setYear(updateYear);
		updateMovie.setDuration(updateDuration);
		updateMovie.setDescription(updateDescription);

		dao.insertMovie(updateMovie, false);

		updateMovie.setName(updateNameAfter);
		updateMovie.setProducer(updateProducerAfter);

		dao.updateMovie(updateMovie);

		Movie checkMovie = dao.getMovieById(updateId);

		assertEquals(updateMovie, checkMovie);
	}
}