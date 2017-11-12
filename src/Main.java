public class Main {

	public static void main(String[] args) {
		Coffeemaker bean_to_cup = new Coffeemaker();

		bean_to_cup.maxwater = 2.;

		bean_to_cup.maxmilk = 0.75;

		bean_to_cup.maxbeans = 1.0;

		bean_to_cup.sorts = new Hotdrink[3];

		String[] names = {"Latte Macchiato", "Milchkaffee", "Espresso"};

		double[] waterArray = {0.2, 0.2, 0.05};

		double[] milkArray = {0.3, 0.1, 0.0};

		double[] beansArray = {0.04, 0.05, 0.01};

		for (int i = 0; i < 3; i++) {

			bean_to_cup.sorts[i] = new Hotdrink();

			bean_to_cup.sorts[i].name = names[i];

			bean_to_cup.sorts[i].water = waterArray[i];

			bean_to_cup.sorts[i].milk = milkArray[i];

			bean_to_cup.sorts[i].beans = beansArray[i];

		}

		bean_to_cup.refill();

		simuliere(bean_to_cup);
	}


	private static void simuliere(Coffeemaker pCoffeeMaker) {
		boolean shouldRun = true;
		while (shouldRun) {
			SimpleIO.output("Was moechten Sie trinken?", "Kaffeevollautomat");
			SimpleIO.output("Zur Auswahl stehen:\n" + pCoffeeMaker.toString(), "Kaffeevollautomat");
			String choice = SimpleIO.getString("Eingabe des Benutzers:");
			try {
				pCoffeeMaker.makeDrink(choice, inputJN());
				SimpleIO.output("Hier ist Ihr " + choice, "Ihre Bestellung");
			} catch (Exception e) {
				SimpleIO.output(e.getMessage(), "Error");
				shouldRun = false;
			}
		}
	}

	private static boolean inputJN() {
		SimpleIO.output("Gross? (J)a/ (N)ein", "Kaffeevollautomat");
		String gross = SimpleIO.getString("Eingabe des Benutzers:").toLowerCase();
		switch (gross) {
			case "j":
				return true;
			case "n":
				return false;
			default:
				SimpleIO.output("Bitte geben Sie entweder j oder n ein.", "Fehler");
				return inputJN();
		}
	}
}
