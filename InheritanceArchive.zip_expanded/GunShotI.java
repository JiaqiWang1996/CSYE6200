package edu.neu.csye6200;

/**
 * A class to model a GunShot Explosion by implementing ExplodableAPI.
 * 
 * @author dpeters
 *
 */
public class GunShotI implements ExplodableAPI  {
	private final static String K_GUNSHOT_NAME = "GunShotI"; 
	private final static String K_GUNSHOT_NOISE = "POW!";
	/**
	 * A specific implementation of the ExplodableAPI 
	 */
	@Override
	public void explode() {
		System.out.println(K_GUNSHOT_NAME + " " + K_GUNSHOT_NOISE);
	}
}
