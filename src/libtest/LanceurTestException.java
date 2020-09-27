package libtest;

/**
 * cree une classe d'Exception qui remonte sans verifier le try catch
 * 
 * @author vthomas
 */
@SuppressWarnings("serial")
class LanceurTestException extends RuntimeException {


	/**
	 * constructeur avec un message
	 * 
	 * @param s
	 *            message d'erreur
	 */
	public LanceurTestException(String s) {
		super(s);
	}

}