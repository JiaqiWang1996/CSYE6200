package edu.neu.csye6200;

/**
 * API for all Explodable Factories
 * @author dpeters
 *
 */
public abstract class AbstractExplodableFactory {
	/**
	 * Get an AbstractExplosionAPI object
	 * @return	AbstractExplosionAPI
	 */
	public abstract ExplodableAPI getObject();
}
