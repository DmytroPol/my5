package com.gmail.dmytropolishchuk2;

public class Student extends Human  {
	private String name;
	private String surName;
	private int groupNumber;

	public Student(String name, String surName, int age, double weight, boolean sex, int groupNumber) {
		super(age, weight, sex);
		this.name = name;
		this.surName = surName;
		this.groupNumber = groupNumber;
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

	public int getGroupNumber() {

		return groupNumber;
	}

	public void setGroupNumber(int groupNumber) {

		this.groupNumber = groupNumber;

	}

	public void getGroup() {
		if (this.groupNumber > 10 || this.groupNumber <= 0) {
			System.out.println("Invalid input: groupNumber");
		}

	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", surName=" + surName + ", groupNumber=" + groupNumber + super.toString();
	}
	
}
