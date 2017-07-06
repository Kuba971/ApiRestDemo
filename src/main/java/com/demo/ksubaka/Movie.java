package com.demo.ksubaka;

import com.google.gson.annotations.SerializedName;

public class Movie {
	
    public String id;
    
    public String year; 
    
    public String title; 
    
    @SerializedName("title_description")
    public String producer;

    
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getProducer() {
		return producer;
	}


	public void setProducer(String producer) {
		this.producer = producer;
	}

	
	public Movie(String id, String year, String title, String producer) {
		super();
		this.id = id;
		this.year = year;
		this.title = title;
		this.producer = producer;
	}

	public Movie() {
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
