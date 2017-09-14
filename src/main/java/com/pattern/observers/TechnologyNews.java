package com.designPattern.observers;

import java.util.ArrayList;

public class TechnologyNews implements News {
    private ArrayList<Subscriber> subscribers=new ArrayList<Subscriber>();
    private String technologyNews;

    @Override
    public void registerSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unregisterSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscriber() {
        for(Subscriber s:subscribers){
            s.ReceiveNews(technologyNews);
            s.showNews();
        }
    }

    public void setTechnologyNews(String technologyNews) {
        this.technologyNews = technologyNews;
        TechnologyNewsUpdate();
    }

    private void TechnologyNewsUpdate(){
        notifySubscriber();
    }
}
