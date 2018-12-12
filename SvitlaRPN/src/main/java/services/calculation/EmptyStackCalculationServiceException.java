package services.calculation;

import services.calculation.CalculationService;
import shared.ServiceException;

/**
 * Empty or not enough params in stack implementation of {@link CalculationService} exception
 *
 * @author Andrew Khilkevich
 */
public class EmptyStackCalculationServiceException extends ServiceException {

	/**
	 * Generated Serial UID
	 */
	private static final long serialVersionUID = 8901668211077493732L;

	/**
	 * Default constructor.
	 */
	public EmptyStackCalculationServiceException() {
	}

	/**
	 * Public constructor.
	 *
	 * @param message
	 * 		exception message
	 */
	public EmptyStackCalculationServiceException(final String message) {
		super(message);
	}

	/**
	 * Public constructor.
	 *
	 * @param cause
	 * 		exception cause
	 */
	public EmptyStackCalculationServiceException(final Throwable cause) {
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
	public EmptyStackCalculationServiceException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
