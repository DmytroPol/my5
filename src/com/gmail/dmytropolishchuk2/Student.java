package com.gmail.dmytropolishchuk2;

public class Student extends Human {
	private String name;
	private String surName;
	private int specNumber;

	public Student(String name, String surName, int age, double weight, boolean sex, int specNumber) {
		super(age, weight, sex);
		if (name != null && name != "") {
			this.name = name;
		} else {
			System.out.println("Invalid input name");
			this.name = "???";
		}
		if (surName != null && surName != "") {
			this.surName = surName;
		} else {
			System.out.println("Invalid input surname");
			this.surName = "???";
		}

		this.specNumber = specNumber;
	}

	public Student() {
		super();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {

		this.name = name;

	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public int getSpecNumber() {

		return specNumber;
	}

	public void setSpecNumber(int specNumber) {

		this.specNumber = specNumber;

	}

	public void getSpecialization() {
		if (this.specNumber > 10 || this.specNumber <= 0) {
			System.out.println("Invalid input: groupNumber");
		}

	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", surName=" + surName + ", specializationNumber=" + specNumber
				+ super.toString();
	}

}
