package com.rishabh.hackthon.music.entity;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.rishabh.hackthon.music.enums.Gender;

public class Song {

	public Song() {
	}

	public Song(int id, Album album, String name, String singerName, int likes,
			Set<User> likedUsers) {
		super();
		this.id = id;
		this.album = album;
		this.name = name;
		this.singerName = singerName;
		this.likes = likes;
		this.likedUsers = likedUsers;
	}

	private int id;
	private Album album;
	private String name;
	private String singerName;
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

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Song [album=" + album + ", name=" + name + ", singerName="
				+ singerName + ", likes=" + likes + ", Male likes-"
				+ this.getMaleLikes() + ",Female likes -"
				+ this.getFeMaleLikes() + "]";
	}
	
	public Long genderLikes(Gender gender) {
		Long likes = this.getLikedUsers().stream()
				.filter(user -> user.getGender() == gender)
				.collect(Collectors.counting());
		return likes;
	}
	
	public Long getMaleLikes(){
		return genderLikes(Gender.MALE);
	}
	
	public Long getFeMaleLikes(){
		return genderLikes(Gender.FEMALE);
	}

}
