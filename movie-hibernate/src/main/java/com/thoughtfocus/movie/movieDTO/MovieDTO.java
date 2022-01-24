package com.thoughtfocus.movie.movieDTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="Movie_details")
public class MovieDTO implements Serializable{
	@Id
	@GenericGenerator(name="auto",strategy="increment")
	@GeneratedValue(generator="auto")
	private int id;
	private String name;
	private String language;
	private Double budget;
	private int noOfActor;
	private boolean isColor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	public int getNoOfActor() {
		return noOfActor;
	}
	public void setNoOfActor(int noOfActor) {
		this.noOfActor = noOfActor;
	}
	public boolean getIsColor() {
		return isColor;
	}
	public void setIsColor(boolean isColor) {
		this.isColor = isColor;
	}
	@Override
	public String toString() {
		return "MovieDTO [id=" + id + ", name=" + name + ", language=" + language + ", budget=" + budget
				+ ", noOfActor=" + noOfActor + ", isColor=" + isColor + "]";
	}
	
}
