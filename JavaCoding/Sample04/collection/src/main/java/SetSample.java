import java.util.*;

public class SetSample {
    public static void main(String[] args) {
        Set<Double> set = new TreeSet<>();
        set.add(3.0);
        set.add(4.2);
        set.add(1.2);
        for (double d: set
             ) {
            System.out.println(d);
        }

        List<Message> received = List.of(
                new Message(1, "Hello!"),
                new Message(2, "发工资了吗？"),
                new Message(2, "发工资了吗？"),
                new Message(3, "去哪吃饭？"),
                new Message(3, "去哪吃饭？"),
                new Message(4, "Bye")
        );
        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }
    }

    static List<Message> process(List<Message> received) {
        // TODO: 按sequence去除重复消息
        Set<Message> messageSet = new HashSet<>(received);
        return List.copyOf(messageSet);
    }
}

class Message {
    public final int sequence;
    public final String text;
    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return sequence == message.sequence && text.equals(message.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sequence, text);
    }
}
