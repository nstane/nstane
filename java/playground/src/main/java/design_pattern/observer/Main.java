package design_pattern.observer;

public class Main {
    public static void main(String[] args) {
        InstagramSystemNotifier notifier = new InstagramSystemNotifier();

        InstagramUser user = new InstagramUser("Narender", notifier);
        InstagramUser user2 = new InstagramUser("Akshay", notifier);
        InstagramUser user3 = new InstagramUser("Anil", notifier);

        notifier.subscribe(user);
        notifier.subscribe(user2);
        notifier.subscribe(user3);

        notifier.senNotification(new Message("Push Notification","Welcome to instagram."));

        user.sendMessage("Hey guys how are you");

    }
}
