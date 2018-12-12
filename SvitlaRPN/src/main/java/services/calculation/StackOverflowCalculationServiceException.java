package services.calculation;

import services.calculation.CalculationService;
import shared.ServiceException;

/**
 * Too many params in stack implementation of {@link CalculationService} exception
 *
 * @author Andrew Khilkevich
 */
public class StackOverflowCalculationServiceException extends ServiceException {

	/**
	 * Generated Serial UID
	 */
	private static final long serialVersionUID = 8901668211077493732L;

	/**
	 * Default constructor.
	 */
	public StackOverflowCalculationServiceException() {
	}

	/**
	 * Public constructor.
	 *
	 * @param message
	 * 		exception message
	 */
	public StackOverflowCalculationServiceException(final String message) {
		super(message);
	}

	/**
	 * Public constructor.
	 *
	 * @param cause
	 * 		exception cause
	 */
	public StackOverflowCalculationServiceException(final Throwable cause) {
		super(cause);
	}

	/**
	 * Public constructor.
	 *
	 * @param message
	 * 		exception message
	 * @param cause
	 * 		exception cause
	 */
	public StackOverflowCalculationServiceException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
