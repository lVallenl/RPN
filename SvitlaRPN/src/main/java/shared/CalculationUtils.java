package shared;

import java.util.Stack;
import java.util.function.BiFunction;

import services.calculation.CalculationService;

/**
 * Utils to hold some static methods of {@link CalculationService}
 *
 * @author Andrew Khilkevich
 */
public class CalculationUtils {

	public static Stack<Double> calculateFunction(Stack<Double> numbers, BiFunction<Double, Double, Double> operation) {
		try {
			numbers.push(operation.apply(numbers.pop(), numbers.pop()));
		} catch (ArithmeticException e) {
			final String message = "Divide by zero tryout in StreamAPI method";
			System.out.println(message);
		}
		return numbers;
	}

	public static boolean inputIsNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");  //true for a number with optional '-' and decimal.
	}

	public static boolean inputIsOperator(String input) {
		return (input.equals("+") || input.equals("-") || input.equals("*") || input
				.equals("/"));
	}
}
