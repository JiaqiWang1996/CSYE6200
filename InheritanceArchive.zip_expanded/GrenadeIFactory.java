package edu.neu.csye6200;

public class GrenadeIFactory extends AbstractExplodableFactory {

	@Override
	public ExplodableAPI getObject() {
		return new GrenadeI();
	}

}
