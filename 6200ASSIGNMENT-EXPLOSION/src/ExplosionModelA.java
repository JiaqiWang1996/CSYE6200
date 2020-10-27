
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExplosionModelA extends AbstractExplosionModelA {
	private List<AbstractExplosion> abstractExplosions = new ArrayList<AbstractExplosion>();
	
	public static void compareByName(List<AbstractExplosion> list) {
		Collections.sort(list, new Comparator<AbstractExplosion>() {
			@Override
			public int compare(AbstractExplosion a, AbstractExplosion b) {
				return a.getName().compareTo(b.getName());
			}
		});
	}
	
	public static void compareByMetric(List<AbstractExplosion> list) {
		Collections.sort(list, new Comparator<AbstractExplosion>() {
			@Override
			public int compare(AbstractExplosion a, AbstractExplosion b) {
				return Integer.compare(a.getMetric(), b.getMetric());
			}
		});
	}
	
	public static void compareByWeight(List<AbstractExplosion> list) {
		Collections.sort(list, new Comparator<AbstractExplosion>() {
			@Override
			public int compare(AbstractExplosion a, AbstractExplosion b) {
				return Double.compare(a.getWeight(), b.getWeight());
			}
		});
	}
	
	@Override
	public void load() {
		add(new aachen(1, 0.1, "aachen"));
		add(new ball(2, 0.2, "ball"));
		add(new bell(3, 0.3, "bell"));
	}

	@Override
	public void add(AbstractExplosion e) {
		this.abstractExplosions.add(e);
	}

	@Override
	public void explodeAll() {
		System.out.println(abstractExplosions.size() + " AbstractExplosions in AbstractExplodeModel.");
		for (AbstractExplosion AbstractExplosion : abstractExplosions) {
			AbstractExplosion.explode();
		}
	}
	
	public static void demo() {
		System.out.println("demo");
		List<AbstractExplosion> obj = new ArrayList<AbstractExplosion>();
		obj.add(new aachen(1, 0.1, "aachen"));
		obj.add(new ball(2, 0.2, "ball"));
		obj.add(new bell(3, 0.3, "bell"));
		compareByMetric(obj);
		System.out.println("Next compareByMetric ");
		for (AbstractExplosion AbstractExplosion : obj) {
			System.out.println(AbstractExplosion.toString());
		}
		System.out.println("compareByMatric is done!");
		System.out.println("Next compareBy Weight");
		compareByWeight(obj);
		for (AbstractExplosion AbstractExplosion : obj) {
			System.out.println(AbstractExplosion.toString());
		}
		System.out.println("compareByWeight is done!");
		System.out.println("Next compareByName");
		compareByName(obj);
		for (AbstractExplosion AbstractExplosion : obj) {
			System.out.println(AbstractExplosion.toString());
		}
		System.out.println("compareByName is done!");
		System.out.println("ExplosionModelA demo done!");
	}
}