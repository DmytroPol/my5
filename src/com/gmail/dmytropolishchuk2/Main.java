package com.gmail.dmytropolishchuk2;

import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {

		Student student1 = new Student("Dmytro", "Polishchuk", 29, 67, true, 1);
		Student student2 = new Student("Ivan", "Petrenko", 21, 70, true, 2);
		Group group = new Group("Java1");
		try {
			group.addD(student1);
			group.addD(student2);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Error in the student group->" + e.getMessage());
		} finally {
			group.toScreen();
		}

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
		Group group1 = new Group("JavaOOP");
		try {

			group1.addStudent(studentOne);
			group1.addStudent(studentTwo);
			group1.addStudent(studentThree);
			group1.addStudent(studentFour);
			group1.addStudent(studentFive);
			group1.addStudent(studentSix);
			group1.addStudent(studentSeven);
			group1.addStudent(studentEight);
			group1.addedStudent();
			group1.addStudent(studentNine);
			try (PrintWriter a = new PrintWriter("a.txt")) {
				for (int i = 0; i < 1; i++) {

					a.println(group1);
				}
			} catch (FileNotFoundException e) {
				System.out.println("ERROR FILE WRITE");
			}
			// group.addedStudent();
			// System.out.println(group);
			// group.addStudent(studentTen);
			// group.addStudent(studentEleven);
		} catch (MyException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println(group1);
		}
		group1.deletStudent(studentSeven);
		System.out.println(group1);
		group1.searchStudents("Po");
		group1.sortStudentBySurName();
		System.out.println(group1);
		group1.sortStudentByName();
		System.out.println(group1);
		group1.sortStudentByAge();
		System.out.println(group1);

	}

	public static void saveStringToFile(String text, File file) {
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.println(text);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
