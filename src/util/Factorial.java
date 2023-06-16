package util;

public final class Factorial {
    public static int factorial(int n) throws BelowZeroException {
        if (n < 0) {
            throw new BelowZeroException("The factorial function is typically defined for non-negative integers." +
                    " Therefore, the factorial of a negative number" +
                    " is not defined in standard mathematics.");
        } else if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
