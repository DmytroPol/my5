package com.gmail.dmytropolishchuk2;

import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {
		Student[] students = new Student[10];
		Student studentOne = new Student("Petro", "Mortal", 19, 87, true, 1);
		Student studentTwo = new Student("Misha", "Ivanov", 20, 65, true, 1);
		Student studentThree = new Student("Sergo", "Petrov", 21, 78, true, 1);
		Student studentFour = new Student("Oleg", "Po", 18, 88, true, 1);
		Student studentFive = new Student("Viktor", "Po", 18, 71, true, 1);
		Student studentSix = new Student("Olena", "Bush", 21, 55, false, 1);
		Student studentSeven = new Student("Anna", "Sidorova", 20, 60, false, 1);
		Student studentEight = new Student("Vasyl", "Gog", 19, 80, true, 1);
		Student studentNine = new Student("Bogdan", "Pig", 20, 75, true, 1);
		Student studentTen = new Student("Oksana", "Petrova", 18, 59, false, 1);
		Student studentEleven = new Student("John", "Walker", 19, 99, true, 1);
		studentOne.getSpecialization();
		studentOne.sexStudent();
		studentTen.sexStudent();

		students[0] = studentOne;
		students[9] = studentTwo;
		System.out.println(Arrays.toString(students));
		Group group = new Group("JavaOOP");
		try {

			group.addStudent(studentOne);
			group.addStudent(studentTwo);
			group.addStudent(studentThree);
			group.addStudent(studentFour);
			group.addStudent(studentFive);
			group.addStudent(studentSix);
			group.addStudent(studentSeven);
			group.addStudent(studentEight);
			group.addedStudent();
			group.addStudent(studentNine);
			// group.addedStudent();
			// System.out.println(group);
			// group.addStudent(studentTen);
			// group.addStudent(studentEleven);
		} catch (MyException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println(group);
		}
		group.deletStudent(studentSeven);
		System.out.println(group);
		group.searchStudents("Po");
		group.sortStudentBySurName();
		System.out.println(group);
		group.sortStudentByName();
		System.out.println(group);
		group.sortStudentByAge();
		System.out.println(group);

		try (PrintWriter a = new PrintWriter("a.txt")) {
			for (int i = 0; i < 10; i++) {
				// a.println(i);
			}
			// a.println();
			a.println(group);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR FILE WRITE");
		}
	}

	public static void saveStringToFile(String text, File file) {
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.println(text);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
