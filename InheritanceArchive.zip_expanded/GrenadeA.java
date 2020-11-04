package edu.neu.csye6200;

/**
 * A class to model a Grenade Explosion by implementing AbstractExplosionAPI.
 * 
 * @author dpeters
 *
 */
public class GrenadeA extends AbstractExplosionAPI {
	private final static String K_GRENADE_NAME = "GrenadeI"; 
	private final static String K_GRENADE_NOISE = "SPlATTER!";
	/**
	 * A specific implementation of the AbstractExplosionAPI 
	 */
	@Override
	public void explode() {
		System.out.println(K_GRENADE_NAME + " " + K_GRENADE_NOISE);
	}
}
