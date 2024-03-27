package email.generator.hm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class EmailGeneratorTest {
    @ParameterizedTest
    @MethodSource("provideParameters")
    @DisplayName("should test if placeholders are replaced with provided values with Parametrized Tests")
    public void shouldTestPlaceHolders(String name, Integer seatInRow) {
        String expected = "Hello Dear " + name +"!" + "\n" + "Your seat number is " + seatInRow;
        Assertions.assertEquals(expected, EmailGenerator.replacePlaceHoldersWithProvidedValue(name, seatInRow));
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("Lika", 19),
                Arguments.of("Nika", 20),
                Arguments.of("Eka", 21)
        );
    }
}
