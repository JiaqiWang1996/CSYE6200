package edu.neu.csye6200;

public abstract class Person{
	int id;
	int age;
	String firstName;
	String lastName;
	
	
	public Person() {}
	
	public Person(int id,int age,String firstName,String lastName) {
		this.id=id;
		this.age=age;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}