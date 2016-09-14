/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.at.sichyuriyy.lab1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Yuriy
 */
public class DaoJUnitTest {
    
    private static DbConnection conn;
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
        conn = new DbConnection(); 
    }
    
    @AfterClass
    public static void afterClass() {
        Movie insertMovie = dao.getMovieById(conn.getConnection(), insertId);
        Movie updateMovie = dao.getMovieById(conn.getConnection(), updateId);
        dao.deleteMovie(conn.getConnection(), insertMovie);
        dao.deleteMovie(conn.getConnection(), updateMovie);
        conn.close();
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
        dao.insertMovie(conn.getConnection(), insertMovie, false);
        Movie checkMovie = dao.getMovieById(conn.getConnection(), insertId);
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
        
        dao.insertMovie(conn.getConnection(), updateMovie, false);
        
        updateMovie.setName(updateNameAfter);
        updateMovie.setProducer(updateProducerAfter);
        
        dao.updateMovie(conn.getConnection(), updateMovie);
        
        Movie checkMovie = dao.getMovieById(conn.getConnection(), updateId);
        
        assertEquals(updateMovie, checkMovie);
    }
}
