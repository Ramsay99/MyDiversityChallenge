import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.BelowZeroException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiversityTest {


    private static Stream<Arguments> calcDiversityStreamSource() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of(" ", 1),
                Arguments.of("   ", 1),
                Arguments.of("a", 1),
                Arguments.of("aaa", 1),
                Arguments.of("ab", 2),
                Arguments.of("aab", 3),
                Arguments.of("abb", 3),
                Arguments.of("aabb", 6),
                Arguments.of("aaabb", 10),
                Arguments.of("aaabbb", 20),
                Arguments.of("abc", 6),
                Arguments.of("abcf", 24),
                Arguments.of("abcfg", 120),
                Arguments.of("aabbcc", 90),
                Arguments.of("abbccc", 60),
                Arguments.of("aaabbc", 60),
                Arguments.of("abcaba", 60),
                Arguments.of("123456789", 362880)
        );
    }

    @ParameterizedTest
    @MethodSource("calcDiversityStreamSource")
    void calcDiversityMethod(String str, int expectedNum) throws BelowZeroException {
        int actualNum = Diversity.calculateDiversity(str);
        assertEquals(expectedNum, actualNum);
    }
}