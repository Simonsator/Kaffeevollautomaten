public class Hotdrink {
	private String name;
	private float waterNeeded;
	private float milkNeeded;
	private float coffeeBeanNeeded;

	public Hotdrink(String pName, float pWaterNeeded, float pCoffeeBeanNeeded, float pMilkNeeded) {
		name = pName;
		waterNeeded = pWaterNeeded;
		coffeeBeanNeeded = pCoffeeBeanNeeded;
		milkNeeded = pMilkNeeded;
	}

	@Override
	public String toString() {
		return name;
	}

	public float getWaterNeeded() {
		return waterNeeded;
	}

	public float getMilkNeeded() {
		return milkNeeded;
	}

	public float getCoffeeBeanNeeded() {
		return coffeeBeanNeeded;
	}
}
