package email.generator.hm;

import email.generator.hm.exception.ArgumentMissingForMailGeneratorException;

public class Messenger {
    private MailServer server;
    private String sentContent;

    public Messenger(){}

    public Messenger(MailServer server) {
        this.server = server;
    }

    public void sendMail(EmailGenerator generator, Client client) throws ArgumentMissingForMailGeneratorException {
        sentContent = generator.replacePlaceHoldersWithProvidedValue(client.getMail());
        server.send(client.getMail(), sentContent);
    }

    public String getContent() {
        return sentContent;
    }
}
