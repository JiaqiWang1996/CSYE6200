package edu.neu.csye6200;

public abstract class AbstractCartFactory {
	/**
	 * Return an AbstractCartFactory object from CSV string
	 * 
	 * @return				AbstractTask object
	 */
	public abstract Cart getObject();
	
	/**
	 * Return an AbstractCartFactory object from CSV string
	 * 		"id,dollars,name,description"
	 * 
	 * WHERE:
	 * 
	 * 	int id;				// cart owner id
	 * 	double dollars;		// total dollars for this cart
	 *  String name;		// cart owner name
	 *  String description;	// cart description

	 * e.g.
	 * 		""1,150.0,HDTV,32 inch HD TV""
	 * 
	 * @param csvData		CSV string data
	 * @return				AbstractTask object
	 */
	public abstract Cart getObject(String csvData);
}