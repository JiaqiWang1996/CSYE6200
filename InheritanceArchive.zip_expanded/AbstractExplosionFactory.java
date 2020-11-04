package edu.neu.csye6200;

/**
 * API for all Explosion Factories
 * @author dpeters
 *
 */
public abstract class AbstractExplosionFactory {
	/**
	 * Get an Explosion object
	 * @return	Explosion
	 */
	public abstract Explosion getObject();
}
