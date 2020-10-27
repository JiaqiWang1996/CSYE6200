
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExplosionModel.demo();
		ExplosionModelA.demo();
		ExplodableModel.demo();
	}
}

/*demo
Next compareByMetric 
AbstractExplosion [metric=1, weight=0.1, name=aachen]
AbstractExplosion [metric=2, weight=0.2, name=ball]
AbstractExplosion [metric=3, weight=0.3, name=bell]
compareByMatric is done!
Next compareBy Weight
AbstractExplosion [metric=1, weight=0.1, name=aachen]
AbstractExplosion [metric=2, weight=0.2, name=ball]
AbstractExplosion [metric=3, weight=0.3, name=bell]
compareByWeight is done!
Next compareByName
AbstractExplosion [metric=1, weight=0.1, name=aachen]
AbstractExplosion [metric=2, weight=0.2, name=ball]
AbstractExplosion [metric=3, weight=0.3, name=bell]
compareByName is done!
ExplosionModelA demo done!

	ExplodableModel.demo()...

	ExplodableModel.compareByMetric(obj)...
aarhus [metric=50, weight=5.0, name=aarhus]
bottle [metric=100, weight=110.0, name=bottle]
can [metric=200, weight=20.0, name=can]

	ExplodableModel.compareByMetric(obj)...done!

	ExplodableModel.compareByWeight(obj)...
aarhus [metric=50, weight=5.0, name=aarhus]
can [metric=200, weight=20.0, name=can]
bottle [metric=100, weight=110.0, name=bottle]

	ExplodableModel.compareByWeight(obj)...done!

	ExplodableModel.compareByName(obj)...
aarhus [metric=50, weight=5.0, name=aarhus]
bottle [metric=100, weight=110.0, name=bottle]
can [metric=200, weight=20.0, name=can]

	ExplodableModel.compareByName(obj)...done!

	ExplodableModel.demo()...done!*/
