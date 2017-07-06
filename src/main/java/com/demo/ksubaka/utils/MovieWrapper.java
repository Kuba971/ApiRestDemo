package com.demo.ksubaka.utils;

import java.util.ArrayList;

import com.demo.ksubaka.Movie;

import com.google.gson.annotations.SerializedName;

/*
Because of the ways the API is created i had to create some utis classes to read and use the JSON
This is an util class who allows me to read the json return by the API
*/
public class MovieWrapper {

	@SerializedName(value="title_popular")
	public ArrayList<Movie> movieList =  new ArrayList<Movie>();
	
	public MovieWrapper() {
	}

	public ArrayList<Movie> getMovieList() {
		return movieList;
	}


	public void setMovieList(ArrayList<Movie> movieList) {
		this.movieList = movieList;
	}
	
	public MovieWrapper(ArrayList<Movie> movieList) {
		super();
		this.movieList = movieList;
	}

	public static void main(String[] args) {

	}

}


