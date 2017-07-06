package com.demo.ksubaka.utils;

import java.util.ArrayList;

import com.demo.ksubaka.Music;
import com.google.gson.annotations.SerializedName;

/*
Because of the ways the API is created i had to create some utis classes to read and use the JSON
This is an util class who allows me to read the json return by the API
*/
public class TrackWrapper {

	@SerializedName(value="track")
	public ArrayList<Music> musicList =  new ArrayList<Music>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Music> getMusicList() {
		return musicList;
	}

	public void setMusicList(ArrayList<Music> musicList) {
		this.musicList = musicList;
	}

}
