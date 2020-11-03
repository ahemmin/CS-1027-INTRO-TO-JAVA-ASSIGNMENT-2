/** Class extends RuntimeException to allow for EmptyStackException
 * 
 * @author Hemming
 *
 */
public class EmptyStackException extends RuntimeException {
	
/** EmptyStackException becomes a subclass of RuntimeException
 * 
 * @param message Chosen error message
 */
	
public EmptyStackException(String message) {
	super(message);
}

}
