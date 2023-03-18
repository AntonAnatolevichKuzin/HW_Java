package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Box<T extends Fruit> {
    private List<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public void moveTo(Box<? super T> anotherBox) {
        anotherBox.fruits.addAll(fruits);
        fruits.clear();
    }

    public int getWeight() {
        int totalWeight = 0;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

}
