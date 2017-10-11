package com.pattern.iterator.example001;

public class MCDMenuIterator implements Iterator {
    private Goods[] menu;
    private int position = 0;

    public MCDMenuIterator(Goods[] menu) {
        this.menu = menu;
    }

    public boolean hasNext() {
        if (position >= menu.length || menu[position] == null) {
            return false;
        }
        return true;
    }

    public Object next() {
        return menu[position++];
    }

    public Iterator createIterator(){
        return new MCDMenuIterator(menu);
    }
}
