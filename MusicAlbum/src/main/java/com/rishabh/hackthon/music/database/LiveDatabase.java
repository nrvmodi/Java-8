package com.rishabh.hackthon.music.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.rishabh.hackthon.music.entity.Album;
import com.rishabh.hackthon.music.entity.Song;
import com.rishabh.hackthon.music.entity.User;
import com.rishabh.hackthon.music.enums.AgeGroup;
import com.rishabh.hackthon.music.enums.Gender;
import com.rishabh.hackthon.music.enums.Genre;




@Component
public class LiveDatabase {

	private Set<Album> albums = new HashSet<>();
	List<String> countries = new ArrayList<String>(Arrays.asList("INDIA",
			"AUSTRAILA", "US", "CANADA", "CHINA", "NEPAL", "BERMA", "BUTAN"));
	
	
	
	public Set<Album> getAlbums() {
		return albums;
	}
	
	public Stream<Album> getAlbumStream(){
		return albums.stream();
	}

	public static void main(String[] args) {
		LiveDatabase db = new LiveDatabase();
		db.createInMemoryRecords();
	}
	
	public String getRandomCountry(){
		Random random = new Random();
		return countries.get(random.nextInt(8));
	}
	
	public AgeGroup getRandomAgeGroup(){
		Random random = new Random();
		return Arrays.asList(AgeGroup.values()).get(random.nextInt(4));
	}
	
	public Gender getRandomGender(){
		Random random = new Random();
		return Arrays.asList(Gender.values()).get(random.nextInt(2));
	}
	
	public Genre getRandomGenre(){
		Random random = new Random();
		return Arrays.asList(Genre.values()).get(random.nextInt(3));
	}

	@PostConstruct
	public void createInMemoryRecords() {
		Random random = new Random();
		int albumSize= 5;
		int songSize= 10;
		int userSize= 50;
		IntStream albumRandomStream = random.ints(2, albumSize);

		Set<Song> songs = new HashSet<Song>();
		Set<User> songLikedUsers = new HashSet<User>();
		Set<User> albumLikedUsers = new HashSet<User>();
		
		albumRandomStream
				.boxed()
				.limit(random.nextInt(albumSize))
				.forEach(
						albumId -> {
							IntStream songRandomStream = random.ints(5, songSize);
							IntStream songLikedUsersRandomStream = random.ints(5, userSize);
							IntStream albumLikedUsersRandomStream = random.ints(5, userSize);
							songLikedUsersRandomStream.boxed().limit(random.nextInt(userSize)).forEach(userId->{
								songLikedUsers.add(new User("Username_"+userId, getRandomAgeGroup(), getRandomCountry(),getRandomGender()));
							});
							albumLikedUsersRandomStream.boxed().limit(random.nextInt(userSize)).forEach(userId->{
								albumLikedUsers.add(new User("Username_"+userId, getRandomAgeGroup(),getRandomCountry(),getRandomGender()));
							});
							songRandomStream.limit(random.nextInt(songSize)).forEach(songId -> {
								songs.add(new Song(songId, new Album(albumId), "Songname_" + songId, "Singername_" + songId,songLikedUsers.size(),songLikedUsers));
							});
							Album album = new Album(albumId, "AlbumName_" + albumId, albumId,getRandomGenre(), songs,albumLikedUsers.size(), albumLikedUsers);
//							System.out.println(album);
							albums.add(album);
						});
	}
}
