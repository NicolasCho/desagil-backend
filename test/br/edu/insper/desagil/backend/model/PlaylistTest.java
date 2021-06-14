package br.edu.insper.desagil.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlaylistTest {
	private static double DELTA = 0.000001;
	private Playlist playlist;

	@BeforeEach
	void setUp() {
		playlist = new Playlist(12);
	}

	@Test
	void testRoundDownToZero() {
		playlist.putRating("pedro", 1);
		playlist.putRating("paulo", 2);
		playlist.putRating("jão", 3);
		playlist.putRating("otávio", 3);
		assertEquals(2.0, playlist.averageRatings(), DELTA);
	}

	@Test
	void testRoundUpToHalf() {
		playlist.putRating("pedro", 1);
		playlist.putRating("paulo", 2);
		playlist.putRating("jão", 1);
		assertEquals(1.5, playlist.averageRatings(), DELTA);
	}

	@Test
	void testRoundDownToHalf() {
		playlist.putRating("pedro", 1);
		playlist.putRating("paulo", 2);
		playlist.putRating("jão", 2);
		assertEquals(1.5, playlist.averageRatings(), DELTA);
	}

	@Test
	void testRoundUpToOne() {
		playlist.putRating("pedro", 1);
		playlist.putRating("paulo", 1);
		playlist.putRating("jão", 2);
		playlist.putRating("otávio", 3);
		assertEquals(2.0, playlist.averageRatings(), DELTA);
	}
}
