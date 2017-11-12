public class Coffeemaker {
	private Hotdrink[] hotdrinks = new Hotdrink[4];
	private final float waterTankMaxSize;
	private float waterTankCurrentSize;
	private final float milkTankMaxSize;
	private float milkTankCurrentSize;
	private final float coffeeBeanContainerMaxSize;
	private float coffeeBeanContainerCurrentSize;

	public Coffeemaker(float waterTankMaxSize, float milkTankMaxSize, float coffeeBeanContainerMaxSize, Hotdrink[] hotdrinks) {
		this.waterTankMaxSize = waterTankMaxSize;
		this.milkTankMaxSize = milkTankMaxSize;
		this.coffeeBeanContainerMaxSize = coffeeBeanContainerMaxSize;
		waterTankCurrentSize = waterTankMaxSize;
		coffeeBeanContainerCurrentSize = coffeeBeanContainerMaxSize;
		milkTankCurrentSize = milkTankMaxSize;
		this.hotdrinks = hotdrinks;
	}

	public void refill() {
		waterTankCurrentSize = waterTankMaxSize;
		milkTankCurrentSize = milkTankMaxSize;
		coffeeBeanContainerCurrentSize = coffeeBeanContainerMaxSize;
	}

	public boolean getDrink(String hotdrink, boolean large) {
		Hotdrink hotdrinkToMake = getHotdrink(hotdrink);
		return getDrink(hotdrinkToMake, large);
	}

	private boolean getDrink(Hotdrink hotdrinkToMake, boolean large) {
		if (hotdrinkToMake == null)
			return false;
		float waterNeeded = hotdrinkToMake.getWaterNeeded();
		float milkNeeded = hotdrinkToMake.getMilkNeeded();
		float coffeeBeanNeeded = hotdrinkToMake.getCoffeeBeanNeeded();
		if (large) {
			waterNeeded = 2 * waterNeeded;
			milkNeeded = 2 * milkNeeded;
			coffeeBeanNeeded = 2 * coffeeBeanNeeded;
		}
		if (waterTankCurrentSize >= waterNeeded && milkTankCurrentSize >= milkNeeded && coffeeBeanContainerCurrentSize >= coffeeBeanNeeded) {
			waterTankCurrentSize -= waterNeeded;
			milkTankCurrentSize -= milkNeeded;
			coffeeBeanContainerCurrentSize -= coffeeBeanNeeded;
		}
		return false;
	}

	private Hotdrink getHotdrink(String pName) {
		for (Hotdrink hotdrink : hotdrinks) {
			if (hotdrink != null) {
				if (hotdrink.toString().equals(pName)) {
					return hotdrink;
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		String offers = "";
		for (Hotdrink hotdrink : hotdrinks) {
			if (getDrink(hotdrink, true)) {
				offers += "\n" + hotdrink.toString();
			} else if (getDrink(hotdrink, false)) {
				offers += "\n" + hotdrink.toString() + " nur Normal";
			}
		}
		if (offers.length() >= 2)
			return offers.substring(2);
		return "";
	}
}
