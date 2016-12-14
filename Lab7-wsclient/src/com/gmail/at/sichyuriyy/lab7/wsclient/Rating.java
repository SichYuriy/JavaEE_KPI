
package com.gmail.at.sichyuriyy.lab7.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rating complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rating">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="imdbRating" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="kinoPoiskRating" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="rottenTomatosRating" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rating", propOrder = {
    "id",
    "imdbRating",
    "kinoPoiskRating",
    "rottenTomatosRating"
})
public class Rating {

    protected long id;
    protected double imdbRating;
    protected double kinoPoiskRating;
    protected double rottenTomatosRating;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the imdbRating property.
     * 
     */
    public double getImdbRating() {
        return imdbRating;
    }

    /**
     * Sets the value of the imdbRating property.
     * 
     */
    public void setImdbRating(double value) {
        this.imdbRating = value;
    }

    /**
     * Gets the value of the kinoPoiskRating property.
     * 
     */
    public double getKinoPoiskRating() {
        return kinoPoiskRating;
    }

    /**
     * Sets the value of the kinoPoiskRating property.
     * 
     */
    public void setKinoPoiskRating(double value) {
        this.kinoPoiskRating = value;
    }

    /**
     * Gets the value of the rottenTomatosRating property.
     * 
     */
    public double getRottenTomatosRating() {
        return rottenTomatosRating;
    }

    /**
     * Sets the value of the rottenTomatosRating property.
     * 
     */
    public void setRottenTomatosRating(double value) {
        this.rottenTomatosRating = value;
    }

}
