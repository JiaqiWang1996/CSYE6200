
public class Explosion {
	private int metric;
	private double weight;
	private String name;
	
	public Explosion(int metric, double weight, String name) {
		this.metric = metric;
		this.weight = weight;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Explosion [metric=" + metric + ", weight=" + weight + ", name=" + name + "]";
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
	
	public void explode() {
		System.out.println("Boom");
	}
}