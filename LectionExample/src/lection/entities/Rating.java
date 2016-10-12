package lection.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: Rating
 *
 */
@Entity

public class Rating implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private double imdbRating;
	private double rottenTomatosRating;
	private double kinoPoiskRating;
	
	@OneToOne(mappedBy="rating")
	private Movie movie;

	public Rating() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}

	public double getRottenTomatosRating() {
		return rottenTomatosRating;
	}

	public void setRottenTomatosRating(double rottenTomatosRating) {
		this.rottenTomatosRating = rottenTomatosRating;
	}

	public double getKinoPoiskRating() {
		return kinoPoiskRating;
	}

	public void setKinoPoiskRating(double kinoPoiskRating) {
		this.kinoPoiskRating = kinoPoiskRating;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	
   
}
