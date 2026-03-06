public class PalindromeCheckerApp {

    /**
     * Application entry point.
     */
    public static void main(String[] args) {

        // Input string
        String input = "Level";

        // Normalize input for case-insensitive comparison
        input = input.toLowerCase();

        // Inject strategy at runtime
        PalindromeStrategy strategy = new StackStrategy();

        // Execute selected algorithm
        boolean result = strategy.check(input);

        // Display result
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
    }
}

/**
 * =============================================================
 * INTERFACE - PalindromeStrategy
 * =============================================================
 *
 * This interface defines a contract for all
 * palindrome checking algorithms.
 *
 * Any new algorithm must implement this interface
 * and provide its own validation logic.
 */
interface PalindromeStrategy {

    boolean check(String input);
}

/**
 * =============================================================
 * CLASS - StackStrategy
 * =============================================================
 *
 * This class provides a Stack based implementation
 * of the PalindromeStrategy interfoce.
 *
 * It uses LIFO behavior to reverse characters
 * and compare them with the original sequence.
 */
class StackStrategy implements PalindromeStrategy {

    /**
     * Implements palindrome validation using Stack.
     *
     * @param input String to validate
     * @return true if palindrome, false otherwise
     */
    public boolean check(String input) {

        // Create a stack to store characters
        java.util.Stack<Character> stack = new java.util.Stack<>();

        // Push each character of the input string onto the stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Compare characters by popping from the stack
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}