package com.rishabh.hackthon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rishabh.hackthon.music.enums.AgeGroup;
import com.rishabh.hackthon.music.enums.Gender;
import com.rishabh.hackthon.music.service.AlbumService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MusicAlbumApplication.class)
@WebAppConfiguration
public class MusicAlbumApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private AlbumService service;
	
	@Test
	public void getMostLikedGenreTest() {
		service.printAlbumlist();
		System.err.println("Most Liked Genre - " + service.getMostLikedGenre());
	}

	@Test
	public void getMostPopularSongTest() {
		service.printAlbumlist();
		System.err.println("Most Popular Songs - "
				+ service.getMostPopularSong());
	}
	
	@Test
	public void getMostLikedAlbumTest() {
		service.printAlbumlist();
		System.err.println("Most Popular Album - "
				+ service.getMostLikedAlbum());
	}

	@Test
	public void getPopularGenreByAgegroup() {
		service.printAlbumlist();
		System.err.println("Popular Genre for PRE_TEENS - "
				+ service.getPopularGenreByAgegroup(AgeGroup.PRE_TEENS));
		System.err.println("Popular Genre for ADULTS - "
				+ service.getPopularGenreByAgegroup(AgeGroup.ADULTS));
		System.err.println("Popular Genre for SENIORS - "
				+ service.getPopularGenreByAgegroup(AgeGroup.SENIORS));
	}
	
	@Test
	public void getTop5Country() {
		service.printAlbumlist();
		System.err.println("Top 5 Country - "
				+ service.getTop5Country());
	}
	
	@Test
	public void getPopularSongByGender() {
		service.printAlbumlist();
		System.err.println("Popular song By Male - "
				+ service.getPopularSongByGender(Gender.MALE));
		
		System.err.println("Popular song By FeMale - "
				+ service.getPopularSongByGender(Gender.FEMALE));
	}

}
