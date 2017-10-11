package com.pattern.iterator.example001;

public class TestIterator {

    private KFCMenu kfcMenu;
    private MCDMenu mcdMenu;

    public void initMenu() {
        kfcMenu = new KFCMenu();
        mcdMenu = new MCDMenu();
        for (int i = 0; i < 5; i++) {
            Goods goods = new Goods();
            goods.setName("KFC菜品" + (i + 1));
            goods.setPrice(0.5 + i);
            goods.setDescription(goods.getName() + "so delicious");
            goods.setType("素");
            kfcMenu.add(goods);
        }

        for (int i = 0; i < 3; i++) {
            Goods goods = new Goods();
            goods.setName("MCD菜品" + (i + 1));
            goods.setPrice(0.6 + i);
            goods.setDescription(goods.getName() + "so delicious too");
            goods.setType("荤");
            mcdMenu.add(goods);
        }
    }

    public void showMenu(){
        Iterator iterator = null;
        System.out.println("----------------kfc menu---------------");
        iterator = kfcMenu.createIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("----------------mcd menu---------------");
        iterator = mcdMenu.createIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        TestIterator test = new TestIterator();
        test.initMenu();
        test.showMenu();
    }
}
