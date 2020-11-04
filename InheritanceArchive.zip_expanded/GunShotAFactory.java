package edu.neu.csye6200;

public class GunShotAFactory extends AbstractAExplosionFactory {

	@Override
	public AbstractExplosionAPI getObject() {
		return new GunShotA();
	}

}
