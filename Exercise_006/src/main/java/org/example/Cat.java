package org.example;

public class Cat {
    private String name;
    private int appetite;
    private volatile int satiety = 0;

    public Cat(String name){
        this(name, 10);
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;


        Thread backGroundSatietyManagment = new Thread(() -> {
            while (true) {
                if (this.satiety > 0) {
                    this.satiety -= 1;
                }
                try {
                    Thread.sleep(5 * 1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        backGroundSatietyManagment.setDaemon(true);
        backGroundSatietyManagment.start();
    }


    public void eat(Plate plate) {
        if (this.satiety == 0) {
            this.satiety = plate.decreaseFood(this.appetite);
            if (this.satiety == 0) {
                System.out.println(toString() + " не хватило еды.");
            } else {
                System.out.println(toString() + " съел " + this.appetite + " еды из тарелки.");
            }
        } else {
            System.out.println(toString() + " еще не голоден.");
        }

    }


    @Override
    public String toString() {
        return this.name + "{аппетит=" + this.appetite + ", сытность=" + this.satiety + "}";
    }

}
