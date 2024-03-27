package email.generator.hm;

import email.generator.hm.mock.GeneratedEmailsOutputsMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

class EmailGeneratorTest {
    @ParameterizedTest
    @MethodSource("provideParameters")
    @DisplayName("should test if placeholders are replaced with provided values with Parametrized Tests")
    public void shouldTestPlaceHolders(String name, Integer seatInRow) {
        String expected = "Hello Dear " + name + "!" + "\n" + "Your seat number is " + seatInRow;
        Assertions.assertEquals(expected, EmailGenerator.replacePlaceHoldersWithProvidedValue(name, seatInRow));
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("Lika", 19),
                Arguments.of("Nika", 20),
                Arguments.of("Eka", 21)
        );
    }

    @TestFactory
    @DisplayName("should test if placeholders are replaced with provided values with Dynamic Tests")
    Stream<DynamicTest> shouldTestPlaceholders() {
        Map<String, Integer> userData = new HashMap<>();
        userData.put("Lika", 19);
        userData.put("Nika", 20);
        userData.put("Eka", 21);

        Set<Map.Entry<String, Integer>> entries = userData.entrySet();

        return entries.stream().map(entry -> DynamicTest.dynamicTest(EmailGenerator.placeHolder, () ->
                {
                    String generated = EmailGenerator.replacePlaceHoldersWithProvidedValue(entry.getKey(), entry.getValue());
                    Assertions.assertEquals(GeneratedEmailsOutputsMock.output.get(entry.getKey()), generated);
                }
        ));
    }
}
