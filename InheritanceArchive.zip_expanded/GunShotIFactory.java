package edu.neu.csye6200;

public class GunShotIFactory extends AbstractExplodableFactory {

	@Override
	public ExplodableAPI getObject() {
		return new GunShotI();
	}

}
