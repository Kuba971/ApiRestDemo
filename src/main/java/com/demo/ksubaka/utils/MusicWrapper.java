package com.demo.ksubaka.utils;

import com.google.gson.annotations.SerializedName;

/*
Because of the ways the API is created i had to create some utis classes to read and use the JSON
This is an util class who allows me to read the json return by the API
*/
public class MusicWrapper {

	@SerializedName(value="results")
	public TrackMatchWrapper trackMatcheWrapper =  new TrackMatchWrapper();
	
	public MusicWrapper() {
	
	}
	
	public TrackMatchWrapper getTrackMatcheWrapper() {
		return trackMatcheWrapper;
	}

	public void setTrackMatcheWrapper(TrackMatchWrapper trackMatcheWrapper) {
		this.trackMatcheWrapper = trackMatcheWrapper;
	}

	public static void main(String[] args) {

	}

}
