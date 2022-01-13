import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

public class ArrayTest {

    @ParameterizedTest
    @NullAndEmptySource
    void shouldWhenArrayEmpty(int[] emptyArray) {
        Assertions.assertThrows(RuntimeException.class, () ->
                ArrayMetods.checkIsFourOrNot(emptyArray));
    }

    @Test
    void shouldWhenArrayWithOutFour() {
        Assertions.assertThrows(RuntimeException.class, () ->
                ArrayMetods.checkIsFourOrNot( new int[] {1,2,3,5}));
    }

    @ParameterizedTest
    @MethodSource("arrayParametrs")
    void shouldWhen(int[]inputArray, int[]outputArray) {
        Assertions.assertArrayEquals(outputArray, ArrayMetods.checkIsFourOrNot(inputArray));
    }

    private static Stream<Arguments> arrayParametrs() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[] {5,6,7,8,9}),
                Arguments.of(new int[] {1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[] {1, 7}),
                Arguments.of(new int[] {1, 2, 3, 4, 5, 4, 6, 7, 4, 9, 0}, new int[] {9, 0})
        );
    }
}
