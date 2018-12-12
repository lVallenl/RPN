package services.calculation;

import static shared.CalculationUtils.calculateFunction;
import static shared.CalculationUtils.inputIsNumeric;
import static shared.CalculationUtils.inputIsOperator;

import shared.Service;

import java.util.Scanner;
import java.util.Stack;


/**
 * Main calculation {@link Service}
 *
 * @author Andrew Khilkevich
 */
public class CalculationService {

	//Commands to control calculator workflow
	private static final String QUIT = "quit";
	private static final String CLEAR = "clear";

	//Static stack
	private static Stack<Double> numbers = new Stack<>();

	/**
	 * Main method to start calculator
	 *
	 * @param args
	 */
	public static void main(String[] args) throws InvalidParamsCalculationServiceException, StackOverflowCalculationServiceException, EmptyStackCalculationServiceException, DivideByZeroCalculatiionServiceException {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine()) {
			String input = scan.nextLine();
			evaluate(input);

			if (inputIsNumeric(input) && numbers.size() >= 2) {
				throw new StackOverflowCalculationServiceException("Too many operands");
			}

			if (inputIsNumeric(input) && numbers.size() < 2) {
				try {
					numbers.push(Double.parseDouble(input));
				} catch (NumberFormatException e) {
					final String message = "Wrong data type input";
					throw new InvalidParamsCalculationServiceException(message, e);
				}
			}

			if (inputIsOperator(input) && numbers.size() <= 1) {
				throw new EmptyStackCalculationServiceException("There is less than 2 operands in stack now. Enter valid number");
			}

			if (inputIsOperator(input) && numbers.size() > 1) {
				try {
					System.out.println("Result is: " + calculate(input)); //could be changed on calculateAlternate, to see how Java 7 based implementation is works.
				} catch (NumberFormatException e) {
					final String message = "There is wrong data type input tryout";
					throw new InvalidParamsCalculationServiceException(message, e);
				}
			}
		}
	}

	private static void evaluate(String s) {
		switch (s) {
			case QUIT:
				System.exit(0);
				break;
			case CLEAR:
				numbers.clear();
				break;
			default:
				break;
		}
	}


	private static Double calculate(String input) throws DivideByZeroCalculatiionServiceException {
		long startOperation = System.currentTimeMillis();
		for (Double number : numbers) {
			switch (input) {
				case "+":
					calculateFunction(numbers, (n1, n2) -> n2 + n1);
					break;
				case "-":
					calculateFunction(numbers, (n1, n2) -> n2 - n1);
					break;
				case "*":
					calculateFunction(numbers, (n1, n2) -> n2 * n1);
					break;
				case "/":
					calculateFunction(numbers, (n1, n2) -> n2 / n1);
					break;
				default:
					break;
			}
		}
		System.out.println("Time in millis, that was spent on operation: " + (System.currentTimeMillis() - startOperation));
		return numbers.pop();
	}

	/**
	 * Method, that provides Java 7 resolving of RPN calculation, but in this case it just for show my own knowledge of
	 * alternate possibilities to SvitlaSystems's developers, so it implements prepared String data-source calculation, but
	 * just now there is no implementation to use it. I'm sure, every developer, who will check this test-task, could use
	 * it without any troubles. Also, there is time-spent-on operation included, so, this method could be compared with first
	 * method, to show fastest.
	 *
	 * @param {@link
	 * 		String} input
	 * @return
	 * @throws {@link
	 * 		DivideByZeroCalculatiionServiceException}
	 * @throws {@link
	 * 		InvalidParamsCalculationServiceException}
	 * @throws {@link
	 * 		StackOverflowCalculationServiceException}
	 * @throws {@link
	 * 		EmptyStackCalculationServiceException}
	 */
	public static Double calculateAlternate(String input) throws DivideByZeroCalculatiionServiceException, InvalidParamsCalculationServiceException, StackOverflowCalculationServiceException, EmptyStackCalculationServiceException {
		input = input.trim();
		String next;
		Scanner scan = new Scanner(input);
		long startOperation = System.currentTimeMillis();
		while (scan.hasNext()) {
			next = scan.next();

			if (inputIsOperator(next)) {
				if (numbers.size() > 1) {
					if (next.equals("+")) {
						numbers.push((Double) numbers.pop() + (Double) numbers.pop());
					} else if (next.equals("-")) {
						numbers.push(-(Double) numbers.pop() + (Double) numbers.pop());
					} else if (next.equals("*")) {
						numbers.push((Double) numbers.pop() * (Double) numbers.pop());
					} else if (next.equals("/")) {
						double first = numbers.pop();
						double second = numbers.pop();
						try {
							numbers.push(second / first);
						} catch (ArithmeticException e) {
							final String message = "Probably divide by zero tryout";
							throw new DivideByZeroCalculatiionServiceException(message, e);
						}
					}
				} else {
					throw new EmptyStackCalculationServiceException("There are 1 or less operand. Two needs, to make calculation");
				}
			} else {
				try {
					numbers.push(Double.parseDouble(next));
				} catch (NumberFormatException e) {
					final String message = "Wrong data input";
					throw new InvalidParamsCalculationServiceException(message, e);
				}
			}
		}

		if (numbers.size() > 1) {
			final String message = "Too many numbers, and no operator";
			throw new StackOverflowCalculationServiceException(message);
		}

		System.out.println("Time in millis, that was spent on operation: " + (System.currentTimeMillis() - startOperation));
		return (Double) numbers.pop();
	}
}


