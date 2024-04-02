package email.generator.hm;

public class Messenger {
    private MailServer server;

    public Messenger(){}

    public Messenger(MailServer server) {
        this.server = server;
    }

    public void sendMail() {
        server.send();
    }
}
