package edu.neu.csye6200;

public class GrenadeFactory extends AbstractExplosionFactory {

	@Override
	public Explosion getObject() {
		return new Grenade();
	}

}
