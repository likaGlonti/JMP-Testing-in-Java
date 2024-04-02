package email.generator.hm;

import email.generator.hm.exception.ArgumentMissingForMailGeneratorException;

import java.util.UUID;

public class EmailGenerator {
    public String replacePlaceHoldersWithProvidedValue(String name) throws ArgumentMissingForMailGeneratorException {

        if (name == null || name.isEmpty()) {
            throw new ArgumentMissingForMailGeneratorException("Arguments are missing, mail couldn't be generated");
        }
        return String.format(placeHolder, name);
    }
    public static String placeHolder = "Hello Dear %s!\nYour seat number is ...";
}
