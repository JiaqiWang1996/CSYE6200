package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.List;

/**
 * Explosion model for managing all ExplodableAPI objects.
 * @author dpeters
 *
 */
public class ExplodableModel extends AbstractExplodableModel {
	public static final int MAJOR_REV = 1;
	public static final int MINOR_REV = 0;
	public static final String REVISION = new Integer(MAJOR_REV).toString() + "." + new Integer(MINOR_REV).toString();
	private List<ExplodableAPI> explosions;	// container of ExplodableAPI objects
	
	/**
	 * Object Initializer block
	 * executed with each class constructor
	 */
	{
		explosions = new ArrayList<ExplodableAPI>();
	}
	/**
	 * Add ExplodableAPI object to model
	 * @param e
	 */
	@Override
	public void add(ExplodableAPI e) {
		this.explosions.add(e);
	}
	
	/**
	 * Explode every ExplodableAPI object in the model
	 */
	@Override
	public void explode() {			/**
		 * loop through entire contents of container
		 * exploding each explosion object in container
		 * by using the ExplodableAPI
		 */
		System.out.println(explosions.size() + " explosions to explode.");
		for (ExplodableAPI e : explosions) {
			e.explode();
		};
	
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Explodable Model [revision " + REVISION + "]");
		
		sb.append(" ").append(explosions.size()).append(" explosions in model");
		
		return sb.toString();
	}
	/**
	 * Runnable implementation
	 */
	public void run() {
		explode();
	}
	
	/**
	 * Demonstrate the use of this class
	 */
	public static void demo() {
		System.out.println("\n\t" + ExplodableModel.class.getName() + ".demo()...");
		{
			/**
			 * Instantiate the object model
			 */
			ExplodableModel obj = new ExplodableModel();
			/**
			 * Add Explodable objects to model
			 */
			obj.add(new GunShotI());
			obj.add(new GrenadeI());
			System.out.println(obj);
			
			obj.run();	// explode all explosion
		}
		{
			/**
			 * Instantiate the object model
			 */
			ExplodableModel obj = new ExplodableModel();
			GunShotIFactory fGunShot = new GunShotIFactory();
			GrenadeIFactory fGrenade = new GrenadeIFactory();
			/**
			 * Add Explodable objects to model
			 * using GoF Factory pattern
			 */
			System.out.println("\n Use GoF Factory Design Pattern...");
			obj.add(fGunShot.getObject());
			obj.add(fGrenade.getObject());
			System.out.println(obj);
			
			obj.run();	// explode all explosion
		}
		System.out.println("\n\t" + ExplodableModel.class.getName() + ".demo()... done!");
	}
}



