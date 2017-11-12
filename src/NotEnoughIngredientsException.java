public class NotEnoughIngredientsException extends Exception {
	private final String MISSING_INGREDIENTS;

	public NotEnoughIngredientsException(String pMissingIngredients) {
		MISSING_INGREDIENTS = pMissingIngredients;
	}

	@Override
	public String getMessage() {
		return "Nicht genug " + MISSING_INGREDIENTS;
	}
}
