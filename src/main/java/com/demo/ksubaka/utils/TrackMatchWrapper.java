package com.demo.ksubaka.utils;

import com.google.gson.annotations.SerializedName;

/*
Because of the ways the API is created i had to create some utis classes to read and use the JSON
This is an util class who allows me to read the json return by the API
*/
public class TrackMatchWrapper {
	
	@SerializedName(value="trackmatches")
	public TrackWrapper trackWrapper =  new TrackWrapper();
	
	public TrackMatchWrapper() {
	
	}
	
	public TrackWrapper getTrackWrapper() {
		return trackWrapper;
	}

	public void setTrackWrapper(TrackWrapper trackWrapper) {
		this.trackWrapper = trackWrapper;
	}

}
