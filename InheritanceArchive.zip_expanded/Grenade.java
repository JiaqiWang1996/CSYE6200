package edu.neu.csye6200;

/**
 * A class to model a Grenade Explosion.
 * 
 * @author dpeters
 *
 */
public class Grenade extends Explosion {
	private final static String K_GRENADE_NAME = "Grenade"; 
	private final static String K_GRENADE_NOISE = "SPlATTER!";
	/**
	 * A specific implementation of the Explosion API 
	 */
	@Override
	public void explode() {
		System.out.println(K_GRENADE_NAME + " " + K_GRENADE_NOISE);
	}
}
