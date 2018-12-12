package services.calculation;

import services.calculation.CalculationService;
import shared.ServiceException;

/**
 * Invalid input parameters implementation of {@link CalculationService} exception
 *
 * @author Andrew Khilkevich
 */
public class InvalidParamsCalculationServiceException extends ServiceException {

	/**
	 * Generated Serial UID
	 */
	private static final long serialVersionUID = 8901668211077493732L;

	/**
	 * Default constructor.
	 */
	public InvalidParamsCalculationServiceException() {
	}

	/**
	 * Public constructor.
	 *
	 * @param message
	 * 		exception message
	 */
	public InvalidParamsCalculationServiceException(final String message) {
		super(message);
	}

	/**
	 * Public constructor.
	 *
	 * @param cause
	 * 		exception cause
	 */
	public InvalidParamsCalculationServiceException(final Throwable cause) {
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
	public InvalidParamsCalculationServiceException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
