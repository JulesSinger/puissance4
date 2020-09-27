package exceptions;

/**
 * @author Singer Jules
 * Cette classe permet de lancer une exception lorsqu'on le meme nom aux deux joueurs (doublon)
 */
@SuppressWarnings("serial")
public class DoublonException extends Exception {
	
	/**
	 * @param message
	 */
	public DoublonException(String message) {
		
		super(message);
	}
}