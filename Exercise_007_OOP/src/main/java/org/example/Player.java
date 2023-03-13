package org.example;

public class Player implements HasHealthPoint, Tiredness{
        private static long nextId = 1;

        private long id;
        private String name;
        private double damage;
        private double healthPoints;
        private double maxHealthPoints;
        private double tiredness;


        public Player(String name, Double damage, Double healthPoints,Double tiredness) {
            this.id = nextId++;
            this.name = name;
            this.damage = damage;
            this.healthPoints = healthPoints;
            this.maxHealthPoints = healthPoints;
            this.tiredness = tiredness;

        }

        public void attack(Player player) {
            if (this.tiredness <= 50) {
                player.healthPoints -= this.damage;
                this.tiredness += 10;
                System.out.println(this.name + " нанес " + this.damage + " урона игроку " + player.name);
                System.out.print("У " + player.name + " осталось => ");
                Reader.printHealth(player);
                Reader.printTirednes(player);
            }else {
                System.out.println(this.name + "- устал!");
                this.tiredness -= 40;
                Reader.printTirednes(player);
            }
        }

        public String getName() {
            return name;
        }

    @Override
    public double getHealthPoint() {
        return this.healthPoints;
    }
    @Override
    public double getMaxHealthPoint() {
        return this.maxHealthPoints;
    }

    @Override
    public double getTiredness() {
        return this.tiredness;
    }

    public boolean isDead() {
        if (this.healthPoints <= 0) {
            return true;
        }
        return false;
    }
}
