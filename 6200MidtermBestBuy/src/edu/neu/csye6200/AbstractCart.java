package edu.neu.csye6200;

/**
 * API for each shopping cart to implement
 * 
 * @author dpeters
 *
 */
public abstract class AbstractCart {
	private int id;					// cart owner id
	private double totalDollars;	// total dollars for all items in this cart
	private String name;			// cart owner name
	private String description;		// cart description
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getTotalDollars() {
		return totalDollars;
	}
	public void setTotalDollars(double dollars) {
		this.totalDollars = dollars;
	}
	/**
	 * Add Item and increase total dollars
	 * @param t Item object to add
	 */
	public abstract void add(AbstractItem t);
	/**
	 * Clear (remove) all Item objects and set total dollars to zero
	 */
	public abstract void clear();
	
	/**
	 * Remove one Item object and decrease total dollars
	 * @param itemName	name of Item to remove
	 */
	public abstract void remove(String taskName);
	
	/**
	 * Remove one Item object and decrease total dollars
	 * @param 	Item object to remove
	 */
	public abstract void remove(AbstractItem task);

	/**
	 * Show state of Cart
	 * 
	 * (including total dollars and all Item objects)
	 */
	public abstract void show();
}