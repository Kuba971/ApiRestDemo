package com.demo.ksubaka;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.demo.ksubaka.utils.MovieWrapper;
import com.demo.ksubaka.utils.MusicWrapper;
import com.demo.ksubaka.utils.TrackMatchWrapper;
import com.demo.ksubaka.utils.TrackWrapper;
import com.google.gson.Gson;

public class Demo {

	@Test
	public static void main(String[] args) {
		// If there is many arguments, we put them at the index 1 of the tab
		if (args.length >= 2) {
			for (int i = 2; i < args.length; i++) {
				args[1] = args[1] + " " + args[i];
			}
		}
		boolean movieBoolean = false;
		boolean musicBoolean = false;
		
		String uri = null;
		if (args[0].equals("movie")) {
			
			uri = "http://www.imdb.com/xml/find?json=1&q=" + args[1];
			movieBoolean = true;
		} else if (args[0].equals("music")) {
			
			uri = "http://ws.audioscrobbler.com/2.0/?method=track.search&track=" + args[1]
					+ "&api_key=a84bbc8a9465104a6e419491199fc7aa&format=json";
			musicBoolean = true;
		} else {
			System.out.println("You choose a bad API.");
		}
		if (uri != null) {
			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(uri, String.class);
			Gson gson = new Gson();
			if (movieBoolean) {
				// We use the movie wrapper to adapt our class to the JSON form
				MovieWrapper movieWrapper = gson.fromJson(result, MovieWrapper.class);
				ArrayList<Movie> movieList = new ArrayList<Movie>();
				movieList = movieWrapper.getMovieList();
				for (Movie movie : movieList) {
					// We are taking the result other than the movie type
					if (!movie.getProducer().contains("TV") && !movie.getProducer().contains("series")
							&& !movie.getProducer().contains("game") && !movie.getProducer().contains("documentary") && !movie.getProducer().contains("video")) {
						String[] yearPart = movie.getProducer().split(",");
						movie.setYear(yearPart[0]);
						if (movie.getProducer().contains("<a")) {
							movie.setProducer(movie.getProducer().substring(movie.getProducer().indexOf(">") + 1,
								movie.getProducer().indexOf("</")));}
						System.out.println(movie.getTitle() + ", " + movie.getYear() + ", " + movie.getProducer());
					}
				}
			} else if (musicBoolean) {
				// We use couple of music wrapper to adapt our class to the JSON form
				MusicWrapper musicWrapper = gson.fromJson(result, MusicWrapper.class);
				TrackMatchWrapper trackMatchWrapper = new TrackMatchWrapper();
				TrackWrapper trackWrapper = new TrackWrapper();
				ArrayList<Music> musicList = new ArrayList<Music>();
				trackMatchWrapper = musicWrapper.getTrackMatcheWrapper();
				trackWrapper = trackMatchWrapper.getTrackWrapper();
				musicList = trackWrapper.getMusicList();
				for (Music music : musicList) {
					System.out.println(music.getName() + ", " + music.getArtist());
				}
			}
		}
	}
}
