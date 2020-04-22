package design_pattern.observer;

public interface SystemNotifier<T> {
    void subscribe(T t);
    void unSubscribe(T t);
}
