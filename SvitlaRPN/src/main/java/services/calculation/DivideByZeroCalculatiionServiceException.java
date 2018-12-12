package services.calculation;

import services.calculation.CalculationService;
import shared.ServiceException;

/**
 * Divide by zero implementation of {@link CalculationService} exception
 *
 * @author Andrew Khilkevich
 */
public class DivideByZeroCalculatiionServiceException extends ServiceException {

	/**
	 * Generated Serial UID
	 */
	private static final long serialVersionUID = 8901668211077493732L;

	/**
	 * Default constructor.
	 */
	public DivideByZeroCalculatiionServiceException() {
	}

	/**
	 * Public constructor.
	 *
	 * @param message
	 * 		exception message
	 */
	public DivideByZeroCalculatiionServiceException(final String message) {
		super(message);
	}

	/**
	 * Public constructor.
	 *
	 * @param cause
	 * 		exception cause
	 */
	public DivideByZeroCalculatiionServiceException(final Throwable cause) {
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
	public DivideByZeroCalculatiionServiceException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
