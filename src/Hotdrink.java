public class Hotdrink {
	public String name;
	public double water;
	public double milk;
	public double beans;

	@Override
	public String toString() {
		return name;
	}

	public double getWaterNeeded() {
		return water;
	}

	public double getMilkNeeded() {
		return milk;
	}

	public double getCoffeeBeanNeeded() {
		return beans;
	}
}
