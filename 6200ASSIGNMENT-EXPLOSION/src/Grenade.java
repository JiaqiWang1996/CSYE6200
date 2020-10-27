

public class Grenade extends Explosion {
	private int metric;
	private double weight;
	private String name;
	
	public Grenade(int metric, double weight, String name) {
		super(metric, weight, name);
		this.metric = metric;
		this.weight = weight;
		this.name = name;
	}

	
	public int getMetric() {
		return metric;
	}

	public void setMetric(int metric) {
		this.metric = metric;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void explode() {
		System.out.println("Pa!");
	}
}
