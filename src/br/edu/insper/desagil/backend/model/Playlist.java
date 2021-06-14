package br.edu.insper.desagil.backend.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Playlist {
	private int id;
	private List<Track> tracks;
	private Map<String,Integer> ratings;
	
	public Playlist(int id) {
		this.id = id;
		this.tracks = new ArrayList<>();
		this.ratings = new HashMap<>();
	}
	
	public int getId() {
		return this.id;
	}
	
	public List<Track> getTracks(){
		return this.tracks;
	}
	
	public Map<String, Integer> getRatings(){
		return this.ratings;
	}
	
	public void addTrack(Track track) {
		this.tracks.add(track);
	}
	
	public void putRating(String name, int rating) {
		ratings.put(name, rating);
	}
	
	public double averageRatings() {
		int sum = 0;
		for (int rating : this.ratings.values()) {
			sum += rating;
		}
		double average = (double)sum/this.ratings.size();
		
		int intAverage = (int)average;
		double fracAverage = average - intAverage;
		
		if (fracAverage < 0.26) {
			fracAverage = 0.0;
		} else if (fracAverage >= 0.26 && fracAverage < 0.74) {
			fracAverage = 0.5;
		} else {
			fracAverage = 1.0;
		}
		
		double result = (double)intAverage + fracAverage;
		return result;
	}
	
}
