package edu.neu.csye6200;

/**
 * A class to model a GunShot Explosion by implementing AbstractExplosionAPI.
 * 
 * @author dpeters
 *
 */
public class GunShotA extends AbstractExplosionAPI  {
	private final static String K_GUNSHOT_NAME = "GunShotA"; 
	private final static String K_GUNSHOT_NOISE = "POW!";
	/**
	 * A specific implementation of the AbstractExplosionAPI 
	 */
	@Override
	public void explode() {
		System.out.println(K_GUNSHOT_NAME + " " + K_GUNSHOT_NOISE);
	}
}
