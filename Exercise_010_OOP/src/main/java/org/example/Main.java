package org.example;

public class Main {
    public static void main(String[] args) {
//        Box<String> stringBox = new Box<>(); // не работает
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<GoldenApple> goldenAppleBox = new Box<>();

        appleBox.addFruit(new Apple(1));
//        appleBox.addFruit(new Orange(1)); // не работает
        appleBox.addFruit(new GoldenApple(4));
        System.out.println(appleBox.getWeight());


//        goldenAppleBox.addFruit(new Apple(2)); // не работает
        goldenAppleBox.addFruit(new GoldenApple(2));
        System.out.println(goldenAppleBox.getWeight());

        goldenAppleBox.moveTo(appleBox);
        System.out.println(goldenAppleBox.getWeight());
        System.out.println(appleBox.getWeight());

    }
}