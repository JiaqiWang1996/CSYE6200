package edu.neu.csye6200;
import java.util.ArrayList;
import java.util.List;

/**
 * Explosion model for managing all AbstractExplosionAPI objects.
 * @author dpeters
 *
 */
public class ExplosionModelA extends AbstractExplosionModelA {
	public static final int MAJOR_REV = 1;
	public static final int MINOR_REV = 0;
	public static final String REVISION = new Integer(MAJOR_REV).toString() + "." + new Integer(MINOR_REV).toString();
	private List<AbstractExplosionAPI> explosions;	// container of AbstractExplosionAPI objects
	
	/**
	 * Object Initializer block
	 * executed with each class constructor
	 */
	{
		explosions = new ArrayList<AbstractExplosionAPI>();
	}
	/**
	 * Add AbstractExplosionAPI object to model
	 * @param e
	 */
	@Override
	public void add(AbstractExplosionAPI e) {
		this.explosions.add(e);
	}
	
	/**
	 * Explode every AbstractExplosionAPI object in the model
	 */
	@Override
	public void explode() {			/**
		 * loop through entire contents of container
		 * exploding each Explosion object in container
		 * by using the Explosion API
		 */
		System.out.println(explosions.size() + " explosions to explode.");
		for (AbstractExplosionAPI e : explosions) {
			e.explode();
		};
	
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("ExplosionModelA [revision " + REVISION + "]");
		
		sb.append(" ").append(explosions.size()).append(" explosions in model").append("\n");
		
		for (AbstractExplosionAPI e : explosions) {
			sb.append("\n").append(e.toString());
		}
		
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
		System.out.println("\n\t" + ExplosionModelA.class.getName() + ".demo()...");
		{
			/**
			 * Instantiate the object model
			 */
			ExplosionModelA obj = new ExplosionModelA();
			/**
			 * Add AbstractExplosionAPI objects to model
			 */
			obj.add(new GunShotA());
			obj.add(new GrenadeA());
			System.out.println(obj);
			
			obj.run();	// explode all explosion
			System.out.println("Show ExplosionModelA state: " + obj);
		}
		{
			/**
			 * Instantiate the object model
			 */
			ExplosionModelA obj = new ExplosionModelA();
			GunShotAFactory fGunShot = new GunShotAFactory();
			GrenadeAFactory fGrenade = new GrenadeAFactory();
			/**
			 * Add AbstractExplosionAPI objects to model
			 * using GoF Factory pattern
			 */
			System.out.println("\n Use GoF Factory Design Pattern...");
			obj.add(fGunShot.getObject());
			obj.add(fGrenade.getObject());
			System.out.println(obj);
			
			obj.run();	// explode all explosion
			System.out.println("Show ExplosionModelA state: " + obj);
		}
		
		
		System.out.println("\n\t" + ExplosionModelA.class.getName() + ".demo()... done!");
	}
}



