package br.edu.insper.desagil.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrackTest {
	private Artist artist;
	@BeforeEach
	void setUp() {
		artist = new Artist("Anitta");
	}

	@Test
	void testZeroSeconds() {
		Track track = new Track (artist, "qualquer coisa", 0);
		assertEquals("0:00", track.getDurationString());
	}

	@Test
	void testFiveSeconds() {
		Track track = new Track (artist, "qualquer coisa", 5);
		assertEquals("0:05", track.getDurationString());
	}

	@Test
	void testTwentyFiveSeconds() {
		Track track = new Track (artist, "qualquer coisa", 25);
		assertEquals("0:25", track.getDurationString());
	}

	@Test
	void testOneMinuteZeroSeconds() {
		Track track = new Track (artist, "qualquer coisa", 60);
		assertEquals("1:00", track.getDurationString());
	}

	@Test
	void testOneMinuteFiveSeconds() {
		Track track = new Track (artist, "qualquer coisa", 65);
		assertEquals("1:05", track.getDurationString());
	}

	@Test
	void testOneMinuteTwentyFiveSeconds() {
		Track track = new Track (artist, "qualquer coisa", 85);
		assertEquals("1:25", track.getDurationString());
	}

	@Test
	void testTwoMinutesZeroSeconds() {
		Track track = new Track (artist, "qualquer coisa", 120);
		assertEquals("2:00", track.getDurationString());
	}

	@Test
	void testTwoMinutesFiveSeconds() {
		Track track = new Track (artist, "qualquer coisa", 125);
		assertEquals("2:05", track.getDurationString());
	}

	@Test
	void testTwoMinutesTwentyFiveSeconds() {
		Track track = new Track (artist, "qualquer coisa", 145);
		assertEquals("2:25", track.getDurationString());
	}

	@Test
	void testOneCollaborator() {
		Artist becky = new Artist("Becky G");
		List<Artist> collabList = new ArrayList<>();
		collabList.add(becky);
		CollaborationTrack collab = new CollaborationTrack(artist, collabList, "qualquer coisa 2", 60);
		assertEquals("Anitta (feat. Becky G)", collab.getFullArtistName());
	}

	@Test
	void testTwoCollaborators() {
		Artist ludmilla = new Artist("Ludmilla");
		Artist snoop = new Artist("Snoop Dog");
		List<Artist> collabList = new ArrayList<>();
		collabList.add(ludmilla);
		collabList.add(snoop);
		
		CollaborationTrack collab = new CollaborationTrack(artist, collabList, "qualquer coisa 3", 60);
		assertEquals("Anitta (feat. Ludmilla, Snoop Dog)", collab.getFullArtistName());
	}
}
