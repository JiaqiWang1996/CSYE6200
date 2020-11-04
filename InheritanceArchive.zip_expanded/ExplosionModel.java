package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.List;

/**
 * Explosion model for managing all Explosion objects.
 * @author dpeters
 *
 */
public class ExplosionModel extends AbstractExplosionModel implements Runnable {
	public static final int MAJOR_REV = 1;
	public static final int MINOR_REV = 0;
	public static final String REVISION = new Integer(MAJOR_REV).toString() + "." + new Integer(MINOR_REV).toString();
	private List<Explosion> explosions;	// container of Explosion objects
	
	/**
	 * Object Initializer block
	 * executed with each class constructor
	 */
	{
		explosions = new ArrayList<Explosion>();
	}

	/**
	 * Add Explosion object to model
	 * @param e
	 */
	@Override
	public void add(Explosion e) {
		this.explosions.add(e);
	}
	
	/**
	 * Explode all Explosion object in model
	 * @param e
	 */
	@Override
	public void explode() {			/**
		 * loop through entire contents of container
		 * exploding each Explosion object in container
		 * by using the Explosion API
		 */
		System.out.println(explosions.size() + " explosions to explode.");
		for (Explosion e : explosions) {
			e.explode();
		};
	
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("ExplosionModel [revision " + REVISION + "]");
		
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
		System.out.println("\n\t" + ExplosionModel.class.getName() + ".demo()...");
		{
			/**
			 * Instantiate the object model
			 */
			ExplosionModel obj = new ExplosionModel();
			/**
			 * Add Explosion objects to model
			 */
			Explosion e = new Explosion();
			obj.add(e);
			obj.add(new Explosion());
			obj.add(new GunShot());
			obj.add(new Grenade());
			System.out.println(obj);
			
			obj.run();	// explode allExplosions
		}
		{
			/**
			 * Instantiate the object model
			 */
			ExplosionModel obj = new ExplosionModel();
			/**
			 * Add Explosion objects to model
			 * using GoF Factory pattern
			 */
			System.out.println("\n Use GoF Factory Design Pattern...");
			Explosion e = new Explosion();
			AbstractExplosionFactory fGunShot = new GunShotFactory();
			AbstractExplosionFactory fGrenade = new GrenadeFactory();
			obj.add(e);
			obj.add(fGunShot.getObject());
			obj.add(fGrenade.getObject());
			System.out.println(obj);
			
			obj.run();	// explode allExplosions
		}
		System.out.println("\n\t" + ExplosionModel.class.getName() + ".demo()... done!");
	}
}
