package br.edu.insper.desagil.backend.model;

import java.util.ArrayList;
import java.util.List;

public class CollaborationTrack extends Track{
	public List<Artist> collaborators;
	
	public CollaborationTrack(Artist artist ,List<Artist> collaborators, String name, int duration) {
		super(artist, name, duration);
		this.collaborators = collaborators;
	}
	
	@Override
	public String getFullArtistName() {
		String fullName = this.getArtist().getName() + " (feat. ";
		List<String> stringList = new ArrayList<>();
		for (Artist artist : this.collaborators) {
			stringList.add(artist.getName());
		}
		String collaboratorsName = String.join(", ", stringList);
		fullName += collaboratorsName + ")";
		return fullName;
	}
}
