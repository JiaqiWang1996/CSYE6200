

public class can implements ExplodableAPI{
	private int metric;
	private double weight;
	private String name;
	
	public can(int metric, double weight, String name) {
		this.metric = metric;
		this.weight = weight;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "can [metric=" + metric + ", weight=" + weight + ", name=" + name + "]";
	}


	public int getMetric() {
		return metric;
	}

	@Override
	public void setMetric(int metric) {
		this.metric = metric;
	}

	public double getWeight() {
		return weight;
	}

	@Override
	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}


	
	@Override
	public void explode() {
		System.out.println("Ping Ping Ping!");
	}
}
