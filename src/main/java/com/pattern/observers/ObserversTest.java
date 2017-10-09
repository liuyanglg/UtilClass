package com.pattern.observers;

public class ObserversTest {
    public static void main(String[] args) {
        TechnologyNews technologyNews = new TechnologyNews();
        Jack jack = new Jack();
        technologyNews.registerSubscriber(jack);
        technologyNews.registerSubscriber(new Subscriber() {
            String news;
            @Override
            public void ReceiveNews(String news) {
                this.news = news;
            }

            @Override
            public void showNews() {
                System.out.println(Subscriber.class.getName()+"收到新闻："+news);
            }
        });
        technologyNews.setTechnologyNews("iphone8 13号发布！");
        technologyNews.setTechnologyNews("note8 12号发布！");
        technologyNews.notifySubscriber();
    }
}
