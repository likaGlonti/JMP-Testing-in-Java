package email.generator.hm;

import email.generator.hm.exception.ArgumentMissingForMailGeneratorException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MessengerTest {
    @Test
    public void shouldCreateMessenger() {
        Messenger messenger = new Messenger();
        Assertions.assertInstanceOf(Messenger.class, messenger);
    }

    @Test
    public void shouldCreateMailServer(){
        MailServer server = new MailServer();
        Assertions.assertInstanceOf(MailServer.class, server);
    }

    @Test
    public void shouldTestIfMailServerSendsProvidedMail() throws ArgumentMissingForMailGeneratorException {
        MailServer server = mock(MailServer.class);
        Messenger messenger = new Messenger(server);
        EmailGenerator generator = mock(EmailGenerator.class);
        Client client = mock(Client.class);

        when(client.getMail()).thenReturn(mail);
        when(generator.replacePlaceHoldersWithProvidedValue(mail)).thenReturn(message_content);

        messenger.sendMail(generator, client);
        verify(server).send(mail, message_content);
    }

    public static final String mail = "likaGlonti111@gmail.com";
    public static final String message_content = "Hello Dear Lika!\nYour seat number is 19";
}
