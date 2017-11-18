package com.gmail.dmytropolishchuk2;

public class Human {

	private int age;
	private double weight;
	private boolean sex;


	public Human(int age, double weight, boolean sex) {
		super();
		this.age = age;
		this.weight = weight;
		this.sex = sex;
		
	}

	public Human() {
		super();
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	
	

	public void sexStudent() {
		if (sex == true) {
			System.out.println("male");
		} else
			System.out.println("female");
	}

	@Override
	public String toString() {
		return ", age=" + age + ", weight=" + weight + ", sex=" + sex + "]";
	}

}
