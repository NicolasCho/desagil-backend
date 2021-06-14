package br.edu.insper.desagil.backend.model;

public class Track {
	private Artist artist;
	private String name;
	private int duration;
	
	public Track (Artist artist, String name, int duration) {
		this.artist = artist;
		this.name = name;
		this.duration = duration;
	}
	
	public Artist getArtist() {
		return this.artist;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getDuration() {
		return this.duration;
	}
	
	public String getDurationString() {
		String txt = "";
		int minuto = this.duration/60;
		int resto = this.duration%60;
		txt += minuto + ":";
		if (resto < 10) {
			txt += "0" + resto;
		} else {
			txt += resto;
		}
		return txt;
	}
	
	public String getFullArtistName() {
		return this.artist.getName();
	}
	
}
