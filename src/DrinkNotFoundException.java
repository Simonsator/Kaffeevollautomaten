public class DrinkNotFoundException extends Exception {
	@Override
	public String getMessage() {
		return "Der angegebene Drink existiert nicht.";
	}
}
