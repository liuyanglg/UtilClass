package com.designPattern.observers;

public class Jack implements Subscriber {
    private String news;
    @Override
    public void ReceiveNews(String news) {
        this.news= news;
    }

    @Override
    public void showNews() {
        System.out.println(this.getClass().getName()+"收到新闻："+news);
    }
}
