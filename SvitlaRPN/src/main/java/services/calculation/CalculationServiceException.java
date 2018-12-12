package services.calculation;

import services.calculation.CalculationService;
import shared.ServiceException;

/**
 * General {@link CalculationService} exception
 *
 * @author Andrew Khilkevich
 */
public class CalculationServiceException extends ServiceException {

	/**
	 * Generated Serial UID
	 */
	private static final long serialVersionUID = 8901668211077493732L;

	/**
	 * Default constructor.
	 */
	public CalculationServiceException() {
	}

	/**
	 * Public constructor.
	 *
	 * @param message
	 * 		exception message
	 */
	public CalculationServiceException(final String message) {
		super(message);
	}

	/**
	 * Public constructor.
	 *
	 * @param cause
	 * 		exception cause
	 */
	public CalculationServiceException(final Throwable cause) {
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
	public CalculationServiceException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
