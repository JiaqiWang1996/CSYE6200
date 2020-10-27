package neu.edu.csye6200;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class PersonModel {

	private List<Person> persons = new ArrayList<Person>();
	
	public static void compareByLastName(List<Person> list) {
		Collections.sort(list, new Comparator<Person>() {
			@Override
			public int compare(Person a, Person b) {
				return a.getLastName().compareTo(b.getLastName());
			}
		});
	}
	
	public static void compareByAge(List<Person> list) {
		Collections.sort(list, new Comparator<Person>() {
			@Override
			public int compare(Person a, Person b) {
				return Integer.compare(a.getAge(), b.getAge());
			}
		});
	}
}

