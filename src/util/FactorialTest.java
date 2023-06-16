package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FactorialTest {

    private static Stream<Arguments> factorialStreamSource() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 6),
                Arguments.of(4, 24),
                Arguments.of(5, 120),
                Arguments.of(6, 720)
        );
    }

    @ParameterizedTest
    @MethodSource("factorialStreamSource")
    void testFactorial(int number, int expected) throws BelowZeroException {
        Assertions.assertEquals(expected, Factorial.factorial(number));
    }

    @Test
    public void testBelowZeroException() {
        int invalidInput = -1;
        Assertions.assertThrows(BelowZeroException.class,
                () -> Factorial.factorial(invalidInput));
    }
}