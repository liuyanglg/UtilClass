package com.pattern.iterator.example001;

public class MCDMenu {
    private static final int MAX_ITEM = 6;
    private int cursor = 0;
    private Goods[] menu;

    public MCDMenu() {
        if (null == menu) {
            menu = new Goods[MAX_ITEM];
        }
    }

    public void add(Goods goods) {
        if (cursor < MAX_ITEM)
            menu[cursor++] = goods;
    }

    public Iterator createIterator(){
        return new MCDMenuIterator(menu);
    }
}
