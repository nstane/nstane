package design_pattern.observer;

public interface User<T> {
    void update(T t);
    public default void say(){

    }
    public static void say2() {

    }
}
