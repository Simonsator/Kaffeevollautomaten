public class Main {
	public static void main(String[] args) {
		Hotdrink[] hotdrink = new Hotdrink[]{new Hotdrink("feuer", 1, 1, 1), new Hotdrink("anna", 0.4f, 0.2f, 1)};
		Coffeemaker coffeemaker = new Coffeemaker(57, 56, 10, hotdrink);
		SimpleIO.output("Was moechten Sie trinken?", "Kaffeevollautomat");
		SimpleIO.output("Zur Auswahl stehen:\n" + coffeemaker.toString(), "Kaffeevollautomat");
		String auswahl = SimpleIO.getString("Eingabe des Benutzers:");
		inputJN();
	}

	private static void inputJN() {
		SimpleIO.output("Gross? (J)a/ (N)ein", "Kaffeevollautomat");
		String gross = SimpleIO.getString("Eingabe des Benutzers:").toLowerCase();
		switch (gross) {
			case "j":
				break;
			case "n":
				break;
			default:
				SimpleIO.output("Bitte geben Sie entweder j oder n ein.", "Fehler");
				inputJN();
				break;
		}
	}
}
