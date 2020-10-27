

public abstract class AbstractExplosionModel {
	/**
	 * load a sample batch of explosives into model
	 */
	public abstract void load();
	/**
	 * add one explosive to the model
	 * @param e
	 */
	public abstract void add(Explosion e);
	/**
	 * explode all explosives loaded into the model
	 */
	public abstract void explodeAll();
}
