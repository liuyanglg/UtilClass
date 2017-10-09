package com.pattern.observers;

public interface News {
    void registerSubscriber(Subscriber subscriber);

    void unregisterSubscriber(Subscriber subscriber);

    void notifySubscriber();
}
