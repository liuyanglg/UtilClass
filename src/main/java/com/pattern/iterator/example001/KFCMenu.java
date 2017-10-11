package com.pattern.iterator.example001;

import java.util.ArrayList;

public class KFCMenu {
    private ArrayList<Goods> menu;

    public KFCMenu() {
        if (null == menu) {
            menu = new ArrayList<Goods>();
        }
    }

    public void add(Goods goods){
        menu.add(goods);
    }
//    public void remove(Goods goods){
//        menu.remove(goods);
//    }

    public Iterator createIterator(){
        return new KFCMenuIterator(menu);
    }
}
