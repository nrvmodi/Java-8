package com.rishabh.hackthon.music.entity;

import com.rishabh.hackthon.music.enums.AgeGroup;
import com.rishabh.hackthon.music.enums.Gender;

public class User {

	public User() {
	}

	public User(String userName, AgeGroup ageGroup, String country,
			Gender gender) {
		super();
		this.userName = userName;
		this.ageGroup = ageGroup;
		this.country = country;
		this.gender = gender;
	}

	private String userName;
	private AgeGroup ageGroup;
	private String country;
	private Gender gender;

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public AgeGroup getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(AgeGroup ageGroup) {
		this.ageGroup = ageGroup;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", ageGroup=" + ageGroup
				+ ", country=" + country + ", gender=" + gender + "]";
	}
}
