package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Person extends AbstractPerson {
	public final static String K_VERSION;
	
	/**
	 * Static Initializer (Initialization) Block
	 * 
	 * REFERENCE:
	 * https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
	 * 
	 * provides for complex initialization of
	 * class (static) member data.
	 */
	static {
		K_VERSION =  "1.0.1";
	}

	private int id;
	private int age;
	private String firstName;
	private String lastName;
	private String parentFirstName;
	private String parentLastName;
	
	
	/**
	 * Instance Initializer (Initialization) Block
	 * 
	 * REFERENCE:
	 * https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
	 * 
	 * provides for complex initialization of
	 * object instance (non-static) member data.
	 * 
	 * code residing in this block is added to every class constructor.
	 */
	{
		;	// nothing to do here
	}
	/**
	 * Default Constructor
	 * Construct a Person object setting it's state
	 * to default values.
	 */
	public Person() {
		super();
		this.init(1, 17, "Dan", "Peters", "Jim", "Peters");
	}
	/**
	 * Parameterized constructor
	 * Construct a Person object setting it's state
	 * as specified by supplied parameters
	 * 
	 * @param id				integer object ID
	 * @param age				person's age
	 * @param firstName			first name
	 * @param lastName			last name
	 * @param parentFirstName	parent's first name
	 * @param parentLastName	parents's last name
	 */
	public Person(int id, int age, String firstName, String lastName, String parentFirstName, String parentLastName) {
		super();
		this.init(id, age, firstName, lastName, parentFirstName, parentLastName);
	}
	/**
	 * construct a Person object from a CSV string:
	 *    "ID,age,firstName,lastName,parentsFirstName,parentsLastName"
	 * for example:
	 *    "1,17,Dan,Peters,Jim,Peters"
	 *    
	 * @param s		Person state CSV String data
	 */
	public Person(String csvData) {
		super();
		String[] tokens = csvData.split(",");
		int id = Conversions.stringToInt(tokens[0]);
		int age = Conversions.stringToInt(tokens[1]);
		this.init(id, age, tokens[2], tokens[3], tokens[4], tokens[5]);
	}
	/**
	 * initialize the state of this Person object
	 * in one method to avoid code duplication.
	 * 
	 * @param id				integer object ID
	 * @param age				person's age
	 * @param firstName			first name
	 * @param lastName			last name
	 * @param parentFirstName	parent's first name
	 * @param parentLastName	parents's last name
	 */
	protected final void init(int id, int age, String firstName, String lastName, String parentFirstName, String parentLastName) {
		this.id = id;
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.parentFirstName = parentFirstName;
		this.parentLastName = parentLastName;
	}
	@Override
	public int getId() {
		return id;
	}
	@Override
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public int getAge() {
		return age;
	}
	@Override
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String getFirstName() {
		return firstName;
	}
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Override
	public String getLastName() {
		return lastName;
	}
	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String getParentFirstName() {
		return parentFirstName;
	}
	@Override
	public void setParentFirstName(String parentFirstName) {
		this.parentFirstName = parentFirstName;
	}
	@Override
	public String getParentLastName() {
		return parentLastName;
	}
	@Override
	public void setParentLastName(String parentLastName) {
		this.parentLastName = parentLastName;
	}
	
	/**
	 * Comparators
	 */
	@Override
	public Comparator<AbstractPerson> personIdComparator() {
		return new Comparator<AbstractPerson>() {

			@Override
			public int compare(AbstractPerson o1, AbstractPerson o2) {
				return Integer.compare(o1.getId(), o2.getId());
			}
		};
	}
	@Override
	public Comparator<AbstractPerson> personAgeComparator() {
		return new Comparator<AbstractPerson>() {
			
			@Override
			public int compare(AbstractPerson o1, AbstractPerson o2) {
				return Double.compare(o1.getAge(), o2.getAge());
			}
		};
	}
	@Override
	public Comparator<AbstractPerson> personFirstNameComparator() {
		return new Comparator<AbstractPerson>() {
			
			@Override
			public int compare(AbstractPerson o1, AbstractPerson o2) {
				return o1.getFirstName().compareTo(o2.getFirstName());
			}
		};
	}
	@Override
	public Comparator<AbstractPerson> personLastNameComparator() {
		return new Comparator<AbstractPerson>() {
			
			@Override
			public int compare(AbstractPerson o1, AbstractPerson o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		};
	}
	/**
	 * String representation of object state
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Person [v " + K_VERSION);
		sb.append(" # ").append(id);
		sb.append(" ").append(firstName);
		sb.append(" ").append(lastName);
		sb.append(", age ").append(age);
		sb.append(", child of ").append(parentFirstName);
		sb.append(" ").append(parentLastName);

		return sb.toString();
	}

	public static void demo() {
		System.out.println("\n\t Person.demo()...");
		
		/**
		 * write a CSV file with Person data
		 */
		FileUtility fileUtil = new FileUtility();
		String fileName = "persons.txt";
		List<String> writePersonCSVData = new ArrayList<String>();
		writePersonCSVData.add("1,17,Dan,peters,Jim,Peters");
		writePersonCSVData.add("3,16,Jan,petersen,Lee,Petersen");
		writePersonCSVData.add("2,19,Sam,peterson,Albert,Peterson");

		fileUtil.writeTextFile(fileName, writePersonCSVData);
		
		/**
		 * read a CSV file with Person data
		 */
		List<Person> persons = new ArrayList<Person>(); 
		List<String> readCSVData = fileUtil.readTextFile(fileName);	
		
		/**
		 * Create Person objects using person CSV data
		 * read from CSV file
		 */
		for (String string : readCSVData) {
			persons.add(new Person(string));
		}
		
		/**
		 * Show Person state
		 */
		System.out.println(persons.size() + " Person objects in list.");
		for (Person person : persons) {
			System.out.println(person);
		}
		
		System.out.println("\n\t Person.demo()... done!");
	}
}
