package design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class InstagramSystemNotifier implements SystemNotifier<User> {
    private final List<User> users;

    public InstagramSystemNotifier() {
        this.users = new ArrayList<>();
    }

    private void notifyAll(Message message){
        for (User user : users) {
            user.update(message);
        }
    }

    @Override
    public void subscribe(User user) {
        users.add(user);
    }

    @Override
    public void unSubscribe(User user) {
        users.remove(user);
    }

    public void senNotification(Message message) {
        notifyAll(message);
    }
}
