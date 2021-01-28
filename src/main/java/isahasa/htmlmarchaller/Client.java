package isahasa.htmlmarchaller;

public class Client {
    
    private final Channel channel;

    public Client(Channel channel) {
        this.channel = channel;
    }

    public int writeToChannel(TextSource textSource) {
        return channel.writeByte(textSource.getPlainText().getBytes());

    }
}
