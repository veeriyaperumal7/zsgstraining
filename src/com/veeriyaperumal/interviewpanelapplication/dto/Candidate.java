package com.veeriyaperumal.interviewpanelapplication.dto;

public class Candidate {
	private String name, qualification, role, experience;
	private int age;
	
	public Candidate() {
		
	}

	public Candidate(String name, int age, String qualification, String role, String experience) {
		this.name = name;
		this.age = age;
		this.qualification = qualification;
		this.role = role;
		this.experience = experience;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}
}