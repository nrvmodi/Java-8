package com.rishabh.hackthon.music.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishabh.hackthon.music.database.LiveDatabase;
import com.rishabh.hackthon.music.entity.Album;
import com.rishabh.hackthon.music.entity.Song;
import com.rishabh.hackthon.music.entity.User;
import com.rishabh.hackthon.music.enums.AgeGroup;
import com.rishabh.hackthon.music.enums.Gender;
import com.rishabh.hackthon.music.enums.Genre;


@Service
public class AlbumService {
	@Autowired
	private LiveDatabase liveDatabase;
	
	public void printAlbumlist(){
		System.out.println("***********************Album*************************");
		liveDatabase.getAlbumStream().forEach(album->{
			System.err.println(album);
		});
		System.out.println("***********************Song*************************");
		liveDatabase.getAlbumStream().flatMap(album->album.getSongs().stream()).forEach(song->{
			System.err.println(song);
		});
		/*System.out.println("***********************User*************************");
		liveDatabase.getAlbumStream().flatMap(album->album.getLikedUsers().stream()).forEach(user->{
			System.err.println(user);
		});*/
	}

	public Genre getMostLikedGenre() {
		return liveDatabase.getAlbumStream()
				.max(Comparator.comparing(album -> ((Album) album).getLikes()))
				.get().getGenre();
	}

	public Song getMostPopularSong() {
		Song s = liveDatabase.getAlbumStream()
				.flatMap(album -> album.getSongs().stream())
				.max(Comparator.comparing(song -> ((Song) song).getLikes()))
				.get();
		return s;
	}
	
	public Album getMostLikedAlbum() {
		return liveDatabase.getAlbumStream()
				.max(Comparator.comparing(album -> ((Album) album).getLikes()))
				.get();
	}
	
	public Song getPopularSongByGender(Gender gender) {
		//Only for sysout
//		liveDatabase.getAlbumStream().flatMap(
//				album -> ((Album) album).getSongs().stream()).forEach(song->{
//					System.err.println("Male likes - "+song.getMaleLikes());
//					System.err.println("FeMale likes - "+song.getFeMaleLikes());
//				});
		
		Stream<Song> songStream = liveDatabase.getAlbumStream().flatMap(
				album -> ((Album) album).getSongs().stream());

		Song songByGender = songStream
				.max(Comparator.comparing(song -> ((Song) song)
						.genderLikes(gender))).get();
		return songByGender;
	}
	
	public Set<String> getTop5Country() {
		Set<String> top5Countries = liveDatabase
				.getAlbumStream()
				.flatMap(album -> ((Album) album).getLikedUsers().stream())
				.collect(
						Collectors.groupingBy(User::getCountry,
								Collectors.counting()))
				.entrySet()
				.stream()
				.sorted(Comparator.comparing(entry -> entry.getValue(),
						Collections.reverseOrder()))
				.map(entry -> entry.getKey()).limit(5)
				.collect(Collectors.toSet());

		// Only for sysout
		Map<String, Long> collect = liveDatabase
				.getAlbumStream()
				.flatMap(album -> ((Album) album).getLikedUsers().stream())
				.collect(
						Collectors.groupingBy(User::getCountry,
								Collectors.counting()));

		collect.forEach((k, v) -> System.err.println("Country-" + k + " value-"
				+ v));
		return top5Countries;
	}

	public Genre getPopularGenreByAgegroup(AgeGroup ageGroup) {
		return liveDatabase
				.getAlbumStream()
				.max(Comparator.comparing(album -> ((Album) album)
						.getGenreByAgeGroup(ageGroup))).get().getGenre();
		
		
//		Stream<User> userStream = liveDatabase.getAlbumStream().flatMap(album->((Album)album).getLikedUsers().stream());
//		liveDatabase.getAlbumStream().forEach(album->{
//			userStream.collect(Collectors.groupingBy(User::getAgeGroup)).keySet().stream().forEach(ageGroup->{
				
//				album.getLikedUsers().stream().collect(Collectors.groupingBy(ageGroup));
//				album.getLikedUsers().stream().filter(user->((User)user).getAgeGroup()==ageGroup).;
//			});
//		});
		
//		Map<Map<AgeGroup, List<User>>, List<Album>> collect = liveDatabase.getAlbumStream().collect(Collectors.groupingBy(album->((Album)album).getLikedUsers().stream().collect(Collectors.groupingBy(User::getAgeGroup))));
//		Map<AgeGroup, Set<User>> collect = liveDatabase.getAlbumStream().flatMap(album->((Album)album).getLikedUsers().stream()).collect(Collectors.groupingBy(User::getAgeGroup,Collectors.toSet()));
//		Optional<Album> albums = liveDatabase.getAlbumStream().collect(Collectors.maxBy(Comparator.comparing(album -> ((Album) album).getLikes())));
//		albums.ifPresent(System.out::println);
//		return null;
	}
}
