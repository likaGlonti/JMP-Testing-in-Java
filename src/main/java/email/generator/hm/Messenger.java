package email.generator.hm;

import email.generator.hm.exception.ArgumentMissingForMailGeneratorException;

public class Messenger {
    private MailServer server;

    public Messenger(){}

    public Messenger(MailServer server) {
        this.server = server;
    }

    public void sendMail(EmailGenerator generator, Client client) throws ArgumentMissingForMailGeneratorException {
        server.send(client.getMail(), generator.replacePlaceHoldersWithProvidedValue(client.getMail()));
    }
}
