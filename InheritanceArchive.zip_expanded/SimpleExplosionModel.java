package edu.neu.csye6200;

public class SimpleExplosionModel extends AbstractExplosionModel {
	private Explosion oneExplosion;

	@Override
	public void add(Explosion e) {
		this.oneExplosion = e;
	}

	@Override
	public void explode() {
		this.oneExplosion.explode();
	}
	
	/**
	 * Demonstrate the use of this class
	 */
	public static void demo() {
		System.out.println("\n\t" + SimpleExplosionModel.class.getName() + ".demo()...");
		/**
		 * Instantiate the object model
		 */
		SimpleExplosionModel obj = new SimpleExplosionModel();
		/**
		 * Add Explosion objects to model
		 */
		Explosion e = new Explosion();
		obj.add(e);
		obj.explode();	// explode allExplosions
		obj.add(new Explosion());
		obj.explode();	// explode allExplosions
		obj.add(new GunShot());
		obj.explode();	// explode allExplosions
		obj.add(new Grenade());
		obj.explode();	// explode allExplosions
				
		System.out.println("\n\t" + SimpleExplosionModel.class.getName() + ".demo()... done!");
	}

}
