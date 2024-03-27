package email.generator.hm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EmailGeneratorTest {
    @Test
    public void shouldTestIfPlaceholdersAreReplacedWithProvidedValues() {
        Assertions.assertTrue(EmailGenerator.replacePlaceHoldersWithProvidedValue());
    }
}
