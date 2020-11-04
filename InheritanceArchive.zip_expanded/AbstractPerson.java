package edu.neu.csye6200;

import java.util.Comparator;

public abstract class AbstractPerson {
	public static Comparator<AbstractPerson> idComparator() {
		return new Comparator<AbstractPerson>() {

			@Override
			public int compare(AbstractPerson o1, AbstractPerson o2) {
				return Integer.compare(o1.getId(), o2.getId());
			}
		};
	}
	public static Comparator<AbstractPerson> ageComparator() {
		return new Comparator<AbstractPerson>() {
			
			@Override
			public int compare(AbstractPerson o1, AbstractPerson o2) {
				return Integer.compare(o1.getAge(), o2.getAge());
			}
		};
	}
	public static Comparator<AbstractPerson> firstNameComparator() {
		return new Comparator<AbstractPerson>() {
			
			@Override
			public int compare(AbstractPerson o1, AbstractPerson o2) {
				return o1.getFirstName().compareTo(o2.getFirstName());
			}
		};
	}
	public static Comparator<AbstractPerson> lastNameComparator() {
		return new Comparator<AbstractPerson>() {
			
			@Override
			public int compare(AbstractPerson o1, AbstractPerson o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		};
	}
	public abstract int getId();
	public abstract void setId(int id);
	public abstract int getAge();
	public abstract void setAge(int age);
	public abstract String getFirstName();
	public abstract void setFirstName(String firstName);
	public abstract String getLastName();
	public abstract void setLastName(String lastName);
	public abstract String getParentFirstName();
	public abstract void setParentFirstName(String parentFirstName);
	public abstract String getParentLastName();
	public abstract void setParentLastName(String parentLastName);
	/**
	 * Comparators
	 */
	public abstract Comparator<AbstractPerson> personIdComparator();
	public abstract Comparator<AbstractPerson> personAgeComparator();
	public abstract Comparator<AbstractPerson> personFirstNameComparator();
	public abstract Comparator<AbstractPerson> personLastNameComparator();
	/**
	 * Derived classes may override these Comparators to customize API
	 * @return
	 */
	public Comparator<AbstractPerson> derivedComparator1() {
		return new Comparator<AbstractPerson>() {
			
			@Override
			public int compare(AbstractPerson o1, AbstractPerson o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		};
	}
	public Comparator<AbstractPerson> derivedComparator2() {
		return new Comparator<AbstractPerson>() {
			
			@Override
			public int compare(AbstractPerson o1, AbstractPerson o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		};
	}
}
