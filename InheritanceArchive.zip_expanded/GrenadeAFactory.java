package edu.neu.csye6200;

public class GrenadeAFactory extends AbstractAExplosionFactory {

	@Override
	public AbstractExplosionAPI getObject() {
		return new GrenadeA();
	}

}
