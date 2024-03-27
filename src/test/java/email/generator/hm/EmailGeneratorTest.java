package email.generator.hm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class EmailGeneratorTest {
    @ParameterizedTest
    @MethodSource("provideParameters")
    public void shouldTestIfPlaceholdersAreReplacedWithProvidedValues(String name, Integer seatInRow) {
        Assertions.assertTrue(EmailGenerator.replacePlaceHoldersWithProvidedValue() == "Hello Dear " + name + "your seating number is " + seatInRow);
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("Lika", 19),
                Arguments.of("Nika", 20),
                Arguments.of("Eka", 21)
        );
    }
}
