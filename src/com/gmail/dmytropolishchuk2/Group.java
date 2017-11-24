package com.gmail.dmytropolishchuk2;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Group {
	private String groupName = "?";
	private Student[] students = new Student[10];

	public Group() {
		super();
	}

	public Group(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Student[] addStudent(Student numberStudent) throws MyException {
		int n = 0;
		for (int i = 0; i < students.length; i++) {

			if (students[i] == null) {
				students[i] = numberStudent;
				n = i + 1;
				System.out.println(numberStudent + " was added in the " + n + " cell");

				return students;
			}
		}
		throw new MyException();

	}

	public Student[] deletStudent(Student numberStudent) {

		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i] == numberStudent) {
				students[i] = null;

				System.out.println(numberStudent + " was deleted in the " + i + " cell");

				break;
			}
		}
		return students;
	}

	public Student searchStudents(String surname) {
		int n = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getSurName().equals(surname)) {
				n = i + 1;
				System.out.println("Student with surname " + surname + " was found in the " + n + " cell");

			}
		}
		return null;
	}

	public void addedStudent() {

		int freePlace = -1; // ���������� ��� ������ ������ ���������� �����
		for (int i = 0; i < students.length; i++) { // ����� ���������� �����
			if (students[i] == null) { // ���� ����� � ������ �������
				freePlace = i + 1;// ���������� ����� ������
				System.out.println("Free place was found in the group, in the  " + groupName + " cell:" + freePlace
						+ " " + Arrays.toString(students) + ". Please enter student data ");
				break;
			}
		}
		if (freePlace < 1) { // ���� ����� �� �������
			System.out.println("The group is full");
		} else { // ���� ����� �����
			while (true) { // ��� ������� ������� ���������� �������� ���� ��� ������������ ���� ������
				Student st = new Student();
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				try {
					System.out.println("Please enter student name (String):");
					st.setName(reader.readLine());
					System.out.println("Please enter student surname(String):");
					st.setSurName(reader.readLine());
					System.out.println("Please enter student age (int 17-100):");
					st.setAge(Integer.parseInt(reader.readLine()));
					System.out.println("Please enter student weight (double 40.0-300.0):");
					st.setWeight(Integer.parseInt(reader.readLine()));
					System.out.println("Please enter student sex (man / woman):");
					st.setSex(reader.readLine().equals("man"));
					System.out.println("Please enter student group (int 1-6):");
					st.setSpecNumber(Integer.parseInt(reader.readLine()));
					students[freePlace] = st; // ��������� �� ��������� �����
					System.out.println("Student " + st.getSurName() + " is added to the group: " + st.getSpecNumber());
					break;
				} catch (Exception e) { // ���� ����� ����������� ������ ���������� ����������� ��� ���
					System.out.println("Invalid enter, student is not added, try again? (y / n):");
					try {
						if (reader.readLine().equals("y")) {
							System.out.println("Please enter student data:");
						} else { // ��� ����� ����� �������� �� "y" ����������� ������� �������� ��������
							break;
						}
					} catch (Exception x) { // ����� ���� ����� ���������, �� reader.readLine() ��������� ������ ������
											// ����������
						System.out.println("Invalid enter");
						break;
					}
				}
			}
		}
	}

	public void sortStudentBySurName() {
		shiftN();
		for (int i = students.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (students[j] != null && students[j + 1] != null) {
					if (students[j].getSurName().compareTo(students[j + 1].getSurName()) > 0) {
						Student tmp = students[j];
						students[j] = students[j + 1];
						students[j + 1] = tmp;
					}
				}

			}
		}
	}

	private void shiftN() {
		for (int i = 0; i < students.length; i++) {
			if (null == students[i]) {
				for (int j = students.length - 1; j > i; j--) {
					if (students[j] != null) {
						Student temp = students[j];
						students[j] = students[i];
						students[i] = temp;
						break;
					}
				}
			}
		}
	}

	public void sortStudentByName() {
		shiftN();
		Arrays.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if (o1 != null && o2 != null) {
					return o1.getName().compareTo(o2.getName());
				}
				return 0;
			}
		});
	}

	public void sortStudentByAge() {
		shiftN();
		Arrays.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if (o1 != null && o2 != null) {
					Integer a = o1.getAge();
					Integer b = o2.getAge();
					return (a.compareTo(b));
				}
				return 0;
			}
		});
	}

	@Override
	public String toString() {
		return "Group " + this.groupName + Arrays.toString(students);
	}
}