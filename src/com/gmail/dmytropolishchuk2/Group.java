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

		int freePlace = -1; // переменная для номера ячейки свободного места
		for (int i = 0; i < students.length; i++) { // поиск свободного места
			if (students[i] == null) { // если место в группе нашлось
				freePlace = i + 1;// записываем номер ячейки
				System.out.println("Free place was found in the group " + groupName + ", cell:" + freePlace + " "
						+ Arrays.toString(students) + ". Please enter student data ");
				break;
			}
		}
		if (freePlace < 1) { // если места не нашлось
			System.out.println("The group is full");
		} else { // если нашли место
			while (true) { // для повтора попытки добавления студента если был некорректный ввод данных
				Student st = new Student();
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				try {
					System.out.println("Please enter student name (String):");
					st.setName(reader.readLine());
					System.out.println("Please enter student surname(String):");
					st.setSurName(reader.readLine());
					System.out.println("Please enter student age (int 17-80):");
					st.setAge(Integer.parseInt(reader.readLine()));
					System.out.println("Please enter student weight (double 40.0-300.0):");
					st.setWeight(Integer.parseInt(reader.readLine()));
					System.out.println("Please enter student sex (man / woman):");
					st.setSex(reader.readLine().equals("man"));
					System.out.println("Please enter student group (int 1-6):");
					st.setSpecNumber(Integer.parseInt(reader.readLine()));
					students[freePlace] = st; // добавляем на свободное место
					System.out.println("Student " + st.getSurName() + " " + st.getName() + " is added to the group: "
							+ st.getSpecNumber());
					break;
				} catch (Exception e) { // если ввели некоректные данные предлагаем попробовать еще раз
					System.out.println("Invalid enter, student is not added, try again? (y / n):");
					try {
						if (reader.readLine().equals("y")) {
							System.out.println("Please enter student data:");
						} else { // при любом вводе отличном от "y" заканчиваем попытки добавить студента
							break;
						}
					} catch (Exception x) { // любой ввод будет коректным, но reader.readLine() считается опаснм потому
											// обработаем
						System.out.println("Invalid enter");
						break;
					}
				}
			}
		}
	}

	public void sortStudentBySurName() {
		Arrays.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if (o1 != null && o2 != null) {
					return o1.getSurName().compareTo(o2.getSurName());
				}
				return 0;
			}
		});

		System.out.print("Sort by surname: ");
	}

	public void sortStudentByName() {
		Arrays.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if (o1 != null && o2 != null) {
					return o1.getName().compareTo(o2.getName());
				}
				return 0;
			}
		});
		System.out.print("Sort by name: ");
	}

	public void sortStudentByAge() {
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
		System.out.print("Sort by age: ");
	}

	public static void saveStringToFile(String text, File file) {
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.println(text);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Group " + this.groupName + Arrays.toString(students);
	}
}