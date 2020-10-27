package edu.neu.csye6200;


public abstract class AbstractItemFactory {
	/**
	 * Return an AbstractItem object from CSV string
	 * 
	 * @return				AbstractItem object
	 */
	public abstract AbstractItem getObject();
	/**
	 * Return an AbstractItem object from CSV string
	 * 		"id,price,name,description"
	 * 
	 * WHERE:
	 * 
	 * 	int id;				// item id
	 * 	double price;		// item price
	 *  String name;		// item name
	 *  String description;	// item description
	 *  
	 * e.g.
	 * 		"77,150.0,HDTV,32 inch HD TV"
	 * 
	 * @param csvData		CSV string data
	 * @return				AbstractItem object
	 */
	public abstract AbstractItem getObject(String csvData);
//	/**
//	 * Return an AbstractItem object from CSV string
//	 * 
//	 * @param id			item ID
//	 * @param price			price required to purchase task
//	 * @param name			name of item
//	 * @param description	description of item
//	 * @return				AbstractItem object
//	 */
//	public abstract AbstractTask getObject(int id, int price, String name, String description);

}