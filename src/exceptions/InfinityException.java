package exceptions;

/**
 * @author Singer Jules
 * Cette classe permet de lancer une exception lorsqu'un resultat infinie est obtenu.
 */
@SuppressWarnings("serial")
public class InfinityException extends Exception {
	/**
	 * @param s
	 */
	public InfinityException(String s) {
		super(s);
	}
}
