package email.generator.hm;

import email.generator.hm.exception.ArgumentMissingForMailGeneratorException;
import email.generator.hm.mock.GeneratedEmailsOutputsMock;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.mockito.Mockito.mock;

class EmailGeneratorTest {

    private EmailGenerator generator;

    @BeforeEach
    public void setUp(){
        generator = mock(EmailGenerator.class);
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    @DisplayName("should test if placeholders are replaced with provided values with Parametrized Tests")
    public void shouldTestPlaceHolders(String name) throws ArgumentMissingForMailGeneratorException {
        String expected = "Hello Dear " + name + "!" + "\n" + "Your seat number is ";
        Assertions.assertEquals(expected, generator.replacePlaceHoldersWithProvidedValue(name));
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("Lika"),
                Arguments.of("Nika"),
                Arguments.of("Eka")
        );
    }

    @TestFactory
    @DisplayName("should test if placeholders are replaced with provided values with Dynamic Tests")
    Stream<DynamicTest> shouldTestPlaceholders() {
        List<String> userData = new ArrayList<>();
        userData.add("Lika");
        userData.add("Nika");
        userData.add("Eka");


        return userData.stream().map(item -> DynamicTest.dynamicTest(EmailGenerator.placeHolder, () ->
                {
                    String generated = generator.replacePlaceHoldersWithProvidedValue(item);
                    int index = userData.indexOf(item);
                    Assertions.assertEquals(GeneratedEmailsOutputsMock.output.get(index), generated);
                }
        ));
    }

    @ParameterizedTest
    @MethodSource("providedNullOrEmptyParameters")
    @DisplayName("Throws exception if any argument is not provided")
    public void shouldThrowException(String name) {
        Assertions.assertThrows(ArgumentMissingForMailGeneratorException.class,
                () -> generator.replacePlaceHoldersWithProvidedValue(name));
    }


    private static Stream<Arguments> providedNullOrEmptyParameters() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("Eka")
        );
    }
}
