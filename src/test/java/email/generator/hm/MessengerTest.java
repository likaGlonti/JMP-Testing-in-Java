package email.generator.hm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class MessengerTest {
    @Test
    public void shouldCreateMessenger() {
        Messenger messenger = mock(Messenger.class);
        Assertions.assertInstanceOf(Messenger.class, messenger);
    }

    @Test
    public void shouldCreateMailServer(){
        MailServer server = new MailServer();
        Assertions.assertInstanceOf(MailServer.class, server);
    }
}
