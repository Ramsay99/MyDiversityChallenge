import util.BelowZeroException;
import util.Factorial;

import java.util.Map;
import java.util.stream.Collectors;

public final class Diversity {

    /**
     * Calculates the diversity of a string.
     *
     * @param str the input string
     * @return the diversity of the string
     * @throws BelowZeroException if the factorial calculation encounters a negative number
     */
    public static Integer calculateDiversity(String str) throws BelowZeroException {
        if (str.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> characterCount = getCharacterCount(str);
        int dividend = Factorial.factorial(str.length());
        int divisor = getDivisor(characterCount);

        return dividend / divisor;
    }

    /**
     * Calculates the divisor based on the character count map.
     *
     * @param characterCount the map containing character counts
     * @return the divisor value
     */
    private static Integer getDivisor(Map<Character, Integer> characterCount) {
        return characterCount.values().stream()
                .map(integer -> {
                    try {
                        return Factorial.factorial(integer);
                    } catch (BelowZeroException e) {
                        throw new RuntimeException(e);
                    }
                })
                .reduce(1, (integer1, integer2) -> integer1 * integer2);
    }

    /**
     * Counts the occurrences of each character in the string.
     *
     * @param str the input string
     * @return a map containing character counts
     */
    private static Map<Character, Integer> getCharacterCount(String str) {
        return str.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(
                        character -> character, Collectors.summingInt(value -> 1))
                );
    }

}
