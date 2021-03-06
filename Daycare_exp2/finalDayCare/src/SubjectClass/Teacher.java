package SubjectClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teacher extends Person {
	//id, firstname, lastname, age, classroomid, teachertype, students
	private int classroomID;
	private String teacherType;	//6-12, 13-24, 25-35, 36-47, 48-59, 60 on up (L1- L6)
	private List<Integer> students = new ArrayList<>();
	
//	public Teacher() {}
	
	public Teacher(String firstName, String lastName, int age, int classroomID, String teacherType) throws IOException {
		List<Integer> a = new ArrayList<>();
		File tFile = 
				new File("./Teachers.csv");

		FileReader tFR = new FileReader(tFile);
		BufferedReader tBR = new BufferedReader(tFR);
		String tString;
		while ((tString = tBR.readLine()) != null) {
			String[] line = tString.split(",");
			a.add(Integer.parseInt(line[0]));
		}
		tBR.close();
		tFR.close();

		int j = 0;
		while (a.contains(++j)) {
			
		}
		
		this.setID(j);
		this.setClassroomID(classroomID);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAge(age);
		this.setTeacherType(teacherType);
	}
	
	public int getClassroomID() {
		return classroomID;
	}
	public void setClassroomID(int classroomID) {
		this.classroomID = classroomID;
	}
	public String getTeacherType() {
		return teacherType;
	}
	public void setTeacherType(String teacherType) {
		this.teacherType = teacherType;
	}
	public void addStudent(int i) {
		this.students.add(i);
	}
}
