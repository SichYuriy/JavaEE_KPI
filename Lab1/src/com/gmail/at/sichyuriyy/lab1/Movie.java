package com.gmail.at.sichyuriyy.lab1;

/**
 *
 * @author Yuriy
 */
public class Movie {
    
    private int id;
    private int duration;
    private int year;
    private String description;
    private String producer;
    private String name;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the producer
     */
    public String getProducer() {
        return producer;
    }

    /**
     * @param producer the producer to set
     */
    public void setProducer(String producer) {
        this.producer = producer;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public boolean equals(Object o) {
        Movie movie;
        if (o instanceof Movie) {
            movie = (Movie) o;
        } else {
            return false;
        }
        
        if (this.id == movie.id
                && this.name.equals(movie.name)
                && this.producer.equals(movie.producer)
                && this.year == movie.year
                && this.duration == movie.duration
                && this.description.equals(movie.description)) {
            return true;
        } else {
            return false;
        }
    }
    
}
