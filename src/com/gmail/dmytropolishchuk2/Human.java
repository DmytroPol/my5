package com.gmail.dmytropolishchuk2;

public class Human {

	private int age;
	private double weight;
	private boolean sex;

	public Human(int age, double weight, boolean sex) {
		super();
		if (age <= 80 && age >= 17) {
			this.age = age;
		} else {
			System.out.println("Invalid input age");
			this.age = 0;
		}
		if (weight <= 300 && weight >= 40) {
			this.weight = weight;
		} else {
			System.out.println("Invalid input weight");
			this.weight = 0;
		}

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
