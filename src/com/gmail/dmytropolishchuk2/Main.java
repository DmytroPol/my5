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

//		File file = new File(".txt");
//		PrintWriter pw = new PrintWriter(System.out, true);
//		try {
//			file.createNewFile();
//		} catch (IOException e) {
//			pw.println("Error, textTwo was not copied!");
//		}

		// int[][]array= new int[5][12];
		// for (int i=0;i<array.length;i++) {
		// for (int j=0; j<array[i].length;j++){
		// array[i][j]= (int)(10000+Math.random()*10000);
		// }
		// }
		// String[]lastNames=new String[] {"Ivanov","Petrov","Sidorov", "Lucashenko",
		// "Poroshenko"};
		// Student studentOne = new Student("Petro", "Mortal", 19, 87, true, 1);
		// StringBuilder sb = new StringBuilder();
		// for(int i=0; i < lastNames.length;i++) {
		// sb.append(lastNames[i]).append("\t");
		// for(int j=0; j < array[i].length;j++) {
		// sb.append(array [i][j]).append("\t");
		// }
		// sb.append(System.lineSeparator());
		// }
		// saveStringToFile(sb.toString(),file);
		// }
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
