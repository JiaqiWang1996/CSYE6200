
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExplosionModel extends AbstractExplosionModel {
	private List<Explosion> explosions = new ArrayList<Explosion>();
	
	public static void compareByName(List<Explosion> list) {
		Collections.sort(list, new Comparator<Explosion>() {
			@Override
			public int compare(Explosion a, Explosion b) {
				return a.getName().compareTo(b.getName());
			}
		});
	}
	
	public static void compareByMetric(List<Explosion> list) {
		Collections.sort(list, new Comparator<Explosion>() {
			@Override
			public int compare(Explosion a, Explosion b) {
				return Integer.compare(a.getMetric(), b.getMetric());
			}
		});
	}
	
	public static void compareByWeight(List<Explosion> list) {
		Collections.sort(list, new Comparator<Explosion>() {
			@Override
			public int compare(Explosion a, Explosion b) {
				return Double.compare(a.getWeight(), b.getWeight());
			}
		});
	}
	
	@Override
	public void load() {
		add(new aaron(300, 60, "aaron"));
		add(new GunShot(60, 1.2, "GunShot"));
		add(new Grenade(150, 36, "Grenade"));
	}

	@Override
	public void add(Explosion e) {
		this.explosions.add(e);
	}

	@Override
	public void explodeAll() {
		System.out.println(explosions.size() + " explosions in ExplosionModel.");
		for (Explosion Explosion : explosions) {
			Explosion.explode();
		}
	}
	
	public static void demo() {
		System.out.println("\n\t" + ExplosionModel.class.getName() + ".demo()...");
		List<Explosion> obj = new ArrayList<Explosion>();
		obj.add(new aaron(300,60, "aaron"));
		obj.add(new GunShot(60,1.2, "GunShot"));
		obj.add(new Grenade(150,36, "Grenade"));
		compareByMetric(obj);
		System.out.println("Next comparByName");
		for (Explosion explosion : obj) {
			System.out.println(explosion.toString());
		}
		System.out.println("compareByMetric is done");
		System.out.println("Next compareByWeight");
		compareByWeight(obj);
		for (Explosion explosion : obj) {
			System.out.println(explosion.toString());
		}
		System.out.println("compareByWeight is done");
		System.out.println("Next compareByName");
		compareByName(obj);
		for (Explosion explosion : obj) {
			System.out.println(explosion.toString());
		}
		System.out.println("compareByName is done");
		System.out.println("Explosion demo() done");
	}
}