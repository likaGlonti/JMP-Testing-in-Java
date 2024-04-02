package email.generator.hm;


import email.generator.hm.exception.ArgumentMissingForMailGeneratorException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileSourceReaderTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/template.csv")
    public void shouldReadFromFile(String mail) throws ArgumentMissingForMailGeneratorException {
        MailServer server = mock(MailServer.class);
        Messenger messenger = new Messenger(server);
        Client client = mock(Client.class);

        when(client.getMail()).thenReturn(mail);

        EmailGenerator generator = mock(EmailGenerator.class);
        when(generator.replacePlaceHoldersWithProvidedValue(mail)).thenReturn(EmailGenerator.placeHolder.formatted(mail));
        messenger.sendMail(generator, client);

        Assertions.assertEquals(EmailGenerator.placeHolder.formatted(mail), messenger.getContent());
    }
}
