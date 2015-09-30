package com.rishabh.hackthon.music.entity;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.rishabh.hackthon.music.enums.AgeGroup;
import com.rishabh.hackthon.music.enums.Genre;

public class Album {

	public Album(int id, String name, int year, Genre genre, Set<Song> songs,
			int likes, Set<User> likedUsers) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.genre = genre;
		this.songs = songs;
		this.likes = likes;
		this.likedUsers = likedUsers;
	}

	public Album() {
	}

	public Album(int id) {
		super();
		this.id = id;
	}

	private int id;
	private String name;
	private int year;
	private Genre genre;
	private Set<Song> songs = new TreeSet<Song>();
	private int likes = 0;
	private Set<User> likedUsers = new TreeSet<User>();

	public Set<User> getLikedUsers() {
		return likedUsers;
	}

	public void setLikedUsers(Set<User> likedUsers) {
		this.likedUsers = likedUsers;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Set<Song> getSongs() {
		return songs;
	}

	public void setSongs(Set<Song> songs) {
		this.songs = songs;
	}
	
	public Long getGenreByAgeGroup(AgeGroup agegroup) {
		Long count = this.getLikedUsers().stream()
		.filter(user -> ((User) user).getAgeGroup() == agegroup)
		.collect(Collectors.counting());
//		System.err.println("Count for agegroup-"+agegroup+" is -"+count);
		return count;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", name=" + name + ", genre=" + genre
				+ ", likes=" + likes + " songs - " + songs.size()
				+ ",PRE_TEENS - " + this.getGenreByAgeGroup(AgeGroup.PRE_TEENS)
				+ ",SENIORS - " + this.getGenreByAgeGroup(AgeGroup.SENIORS)
				+ ",ADULTS - " + this.getGenreByAgeGroup(AgeGroup.ADULTS) + "]";
	}
}
