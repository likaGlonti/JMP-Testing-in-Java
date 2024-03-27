package email.generator.hm;

import email.generator.hm.exception.ArgumentMissingForMailGeneratorException;

public class EmailGenerator {
    public static String replacePlaceHoldersWithProvidedValue(String name, Integer seat) throws ArgumentMissingForMailGeneratorException {
        if (name == null || name.isEmpty() || seat == null) {
            throw new ArgumentMissingForMailGeneratorException("Arguments are missing, mail couldn't be generated");
        }
        return String.format(placeHolder, name, seat);
    }
    public static String placeHolder = "Hello Dear %s!\nYour seat number is %d";
}
