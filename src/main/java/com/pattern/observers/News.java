package com.designPattern.observers;

public interface News {
    void registerSubscriber(Subscriber subscriber);

    void unregisterSubscriber(Subscriber subscriber);

    void notifySubscriber();
}
