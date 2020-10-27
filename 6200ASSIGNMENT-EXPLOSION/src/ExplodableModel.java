
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExplodableModel extends AbstractExplodableModel {
	private List<ExplodableAPI> explodableAPI = new ArrayList<ExplodableAPI>();
	
	public static void compareByName(List<ExplodableAPI> list) {
		Collections.sort(list, new Comparator<ExplodableAPI>() {
			@Override
			public int compare(ExplodableAPI a, ExplodableAPI b) {
				return a.getName().compareTo(b.getName());
			}
		});
	}
	
	public static void compareByMetric(List<ExplodableAPI> list) {
		Collections.sort(list, new Comparator<ExplodableAPI>() {
			@Override
			public int compare(ExplodableAPI a, ExplodableAPI b) {
				return Integer.compare(a.getMetric(), b.getMetric());
			}
		});
	}
	
	public static void compareByWeight(List<ExplodableAPI> list) {
		Collections.sort(list, new Comparator<ExplodableAPI>() {
			@Override
			public int compare(ExplodableAPI a, ExplodableAPI b) {
				return Double.compare(a.getWeight(), b.getWeight());
			}
		});
	}
	
	@Override
	public void load() {
		add(new aarhus(50, 5, "Basin"));
		add(new bottle(100, 10, "bottle"));
		add(new can(200, 20, "can"));
	}

	@Override
	public void add(ExplodableAPI e) {
		this.explodableAPI.add(e);
	}

	@Override
	public void explodeAll() {
		System.out.println(explodableAPI.size() + " explosions in ExplodeModel.");
		for (ExplodableAPI ExplodableAPI : explodableAPI) {
			ExplodableAPI.explode();
		}
	}
	
	public static void demo() {
		System.out.println("\n\t" + ExplodableModel.class.getName() + ".demo()...");
		List<ExplodableAPI> obj = new ArrayList<ExplodableAPI>();
		obj.add(new aarhus(50, 5, "aarhus"));
		obj.add(new bottle(100, 110, "bottle"));
		obj.add(new can(200, 20, "can"));
		compareByMetric(obj);
		System.out.println("\n\t" + ExplodableModel.class.getName() + ".compareByMetric(obj)...");
		for (ExplodableAPI ExplodableAPI : obj) {
			System.out.println(ExplodableAPI.toString());
		}
		System.out.println("\n\t" + ExplodableModel.class.getName() + ".compareByMetric(obj)...done!");
		System.out.println("\n\t" + ExplodableModel.class.getName() + ".compareByWeight(obj)...");
		compareByWeight(obj);
		for (ExplodableAPI ExplodableAPI : obj) {
			System.out.println(ExplodableAPI.toString());
		}
		System.out.println("\n\t" + ExplodableModel.class.getName() + ".compareByWeight(obj)...done!");
		System.out.println("\n\t" + ExplodableModel.class.getName() + ".compareByName(obj)...");
		compareByName(obj);
		for (ExplodableAPI ExplodableAPI : obj) {
			System.out.println(ExplodableAPI.toString());
		}
		System.out.println("\n\t" + ExplodableModel.class.getName() + ".compareByName(obj)...done!");
		System.out.println("\n\t" + ExplodableModel.class.getName() + ".demo()...done!");
	}
}
