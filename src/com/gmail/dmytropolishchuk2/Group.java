package com.gmail.dmytropolishchuk2;

import java.util.Arrays;

public class Group {
	Student[] studentArray = new Student[10];

	public Group() {
		super();
	}

	public Student[] addStudent(Student numberStudent) throws MyException {
		int n = 0;
		for (int i = 0; i < studentArray.length; i++) {

			if (studentArray[i] == null) {
				studentArray[i] = numberStudent;
				n = i + 1;
				System.out.println(numberStudent + " was added in the " + n + " cell");
				return studentArray;
			}

		}

		throw new MyException();
	}

	public Student[] deletStudent(Student numberStudent) {

		for (int i = 0; i < studentArray.length; i++) {
			if (studentArray[i] != null && studentArray[i] == numberStudent) {
				studentArray[i] = null;

				System.out.println(numberStudent + " was deleted in the " + i + " cell");

				break;
			}
		}
		return studentArray;
	}

	public Student searchStudents(String surname) {
		int n = 0;
		for (int i = 0; i < studentArray.length; i++) {
			if (studentArray[i] != null && studentArray[i].getSurName().equals(surname)) {
				n = i + 1;
				System.out.println("Student with surname " + surname + " was found in the " + n + " cell");
				
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Group [studentArray=" + Arrays.toString(studentArray) + "]";
	}

}
