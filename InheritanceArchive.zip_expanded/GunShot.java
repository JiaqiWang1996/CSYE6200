package edu.neu.csye6200;

/**
 * A class to model a GunShot Explosion.
 * 
 * @author dpeters
 *
 */
public class GunShot extends Explosion {
	private final static String K_GUNSHOT_NAME = "GunShot"; 
	private final static String K_GUNSHOT_NOISE = "POW!";
	/**
	 * A specific implementation of the Explosion API 
	 */
	@Override
	public void explode() {
		System.out.println(K_GUNSHOT_NAME + " " + K_GUNSHOT_NOISE);
	}
}
