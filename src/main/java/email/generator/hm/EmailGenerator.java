package email.generator.hm;

public class EmailGenerator {
    public static String replacePlaceHoldersWithProvidedValue(String name, Integer seat) {
        return String.format(placeHolder, name, seat);
    }

    public static String placeHolder = "Hello Dear %s!\nYour seat number is %d";
}
