package edu.neu.csye6200;

/**
 * API for an Explosion Model which loads and explodes Explosion objects.
 * 
 * @author dpeters
 *
 */
public abstract class AbstractExplosionModelA {
		/**
		 * Add one AbstractExplosionAPI object to model
		 * 
		 * @param e		Explosion object
		 */
		public abstract void add(AbstractExplosionAPI e);
		
		/**
		 * Explode all 
		 */
		public abstract void explode();

	}
