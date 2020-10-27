package neu.edu.csye6200;


public class SimplePersonFactory {
	enum PersonCriteria {
		Student,
		Employee
	}
	
	public Person getObject(PersonCriteria criteria) {
		if (criteria == PersonCriteria.Student) {
			return new Student();
		}
			return new Employee();
	}
}