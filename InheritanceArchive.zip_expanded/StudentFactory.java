package edu.neu.csye6200;

public class StudentFactory extends AbstractPersonFactory {

	@Override
	public AbstractPerson getObject(String csvData) {
		return new Student(csvData);
	}

}
