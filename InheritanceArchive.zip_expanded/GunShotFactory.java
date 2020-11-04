package edu.neu.csye6200;

public class GunShotFactory extends AbstractExplosionFactory {

	@Override
	public Explosion getObject() {
		return new GunShot();
	}

}
