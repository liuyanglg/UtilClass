package com.pattern.iterator.example001;

import java.util.ArrayList;

public class KFCMenuIterator implements Iterator {
    private ArrayList<Goods> menu;
    private int position = 0;

    public KFCMenuIterator(ArrayList<Goods> menu) {
        this.menu = menu;
    }

    public boolean hasNext() {
        if (position < menu.size()) {
            return true;
        }
        return false;
    }

    public Object next() {
        return menu.get(position++);
    }
}
