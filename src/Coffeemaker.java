public class Coffeemaker {
	public Hotdrink[] sorts = new Hotdrink[4];
	public double maxwater;
	private double waterTankCurrentSize = 0;
	public double maxmilk;
	private double milkTankCurrentSize = 0;
	public double maxbeans;
	private double coffeeBeanContainerCurrentSize = 0;


	public void refill() {
		waterTankCurrentSize = maxwater;
		milkTankCurrentSize = maxmilk;
		coffeeBeanContainerCurrentSize = maxbeans;
	}

	public boolean getDrink(String hotdrink, boolean large) {
		Hotdrink hotdrinkToMake = getHotdrink(hotdrink);
		try {
			makeDrink(hotdrinkToMake, large);
			return true;
		} catch (NotEnoughIngredientsException e) {
			return false;
		}
	}

	private boolean enoughIngredients(Hotdrink hotdrinkToMake, boolean large) {
		if (hotdrinkToMake == null)
			return false;
		double waterNeeded = hotdrinkToMake.getWaterNeeded();
		double milkNeeded = hotdrinkToMake.getMilkNeeded();
		double coffeeBeanNeeded = hotdrinkToMake.getCoffeeBeanNeeded();
		if (large) {
			waterNeeded = 2 * waterNeeded;
			milkNeeded = 2 * milkNeeded;
			coffeeBeanNeeded = 2 * coffeeBeanNeeded;
		}
		if (waterTankCurrentSize >= waterNeeded && milkTankCurrentSize >= milkNeeded && coffeeBeanContainerCurrentSize >= coffeeBeanNeeded) {
			return true;
		}
		return false;
	}

	public void makeDrink(String pDrink, boolean pLarge) throws DrinkNotFoundException, NotEnoughIngredientsException {
		Hotdrink drink = getHotdrink(pDrink);
		if (drink == null) {
			throw new DrinkNotFoundException();
		}
		makeDrink(drink, pLarge);
	}

	private void makeDrink(Hotdrink pDrink, boolean pLarge) throws NotEnoughIngredientsException {
		double waterNeeded = pDrink.getWaterNeeded();
		double milkNeeded = pDrink.getMilkNeeded();
		double coffeeBeanNeeded = pDrink.getCoffeeBeanNeeded();
		if (pLarge) {
			waterNeeded = 2 * waterNeeded;
			milkNeeded = 2 * milkNeeded;
			coffeeBeanNeeded = 2 * coffeeBeanNeeded;
		}
		if (waterTankCurrentSize < waterNeeded) {
			throw new NotEnoughIngredientsException("Wasser");
		}
		if (milkTankCurrentSize < milkNeeded) {
			throw new NotEnoughIngredientsException("Milch");
		}
		if (coffeeBeanContainerCurrentSize < coffeeBeanNeeded) {
			throw new NotEnoughIngredientsException("Kaffee Bohnen");
		}
		waterTankCurrentSize -= waterNeeded;
		milkTankCurrentSize -= milkNeeded;
		coffeeBeanContainerCurrentSize -= coffeeBeanNeeded;
	}

	private Hotdrink getHotdrink(String pName) {
		for (Hotdrink hotdrink : sorts) {
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
		for (Hotdrink hotdrink : sorts) {
			if (hotdrink == null)
				continue;
			if (enoughIngredients(hotdrink, true)) {
				offers += "\n" + hotdrink.toString();
			} else if (enoughIngredients(hotdrink, false)) {
				offers += "\n" + hotdrink.toString() + " nur Normal";
			}
		}
		if (offers.length() >= 2)
			return offers.substring(1);
		return "";
	}
}
