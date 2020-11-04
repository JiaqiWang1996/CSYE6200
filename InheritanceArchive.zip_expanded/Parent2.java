package edu.neu.csye6200;

public class Parent2 {
	private String title = "Parent";
	private String name = "Jim";

	{
		this.name = "James";
	}
	public Parent2() {
		super();
	}

	public Parent2(String title, String name) {
		super();
		this.title = title;
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name + " the " + title;
	}
}
