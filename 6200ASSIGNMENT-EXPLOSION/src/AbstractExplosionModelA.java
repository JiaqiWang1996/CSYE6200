

public abstract class AbstractExplosionModelA {
	/**
	 * load a sample batch of explosives into model
	 */
	public abstract void load();
	/**
	 * add one explosive to the model
	 * @param e
	 */
	public abstract void add(AbstractExplosion e);
	/**
	 * explode all explosives loaded into the model
	 */
	public abstract void explodeAll();
}