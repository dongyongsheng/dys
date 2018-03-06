package util;

/**
 * Class implementing an <tt>IllegalAddressException</tt>. This exception is
 * thrown when a non-existant spot in the process image was addressed.
 * <p>
 * Note that this is a runtime exception, as it is similar to the
 * <tt>IndexOutOfBoundsException</tt>
 */
@SuppressWarnings("serial")
public class IllegalAddressException
		extends RuntimeException {

	/**
	 * Constructs a new <tt>IllegalAddressException</tt>.
	 */
	public IllegalAddressException() {
	}//constructor()

	/**
	 * Constructs a new <tt>IllegalAddressException</tt> with the given message.
	 * 
	 * @param message
	 *            a message as <tt>String</tt>.
	 */
	public IllegalAddressException(String message) {
		super(message);
	}//constructor(String)

}//class IllegalAddressException
