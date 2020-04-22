package design_pattern.observer;

public class InstagramUser implements User<Message> {

    private final String name;
    private final InstagramSystemNotifier notifier;

    public InstagramUser(String name, InstagramSystemNotifier notifier) {
        this.name = name;
        this.notifier = notifier;
    }

    @Override
    public void update(Message o) {
        System.out.println(name+": You have a "+o.getSubject());
        System.out.println(o.getBody());
    }

    public void sendMessage(String message) {
        notifier.senNotification(new Message("System Message", message));
    }
}
