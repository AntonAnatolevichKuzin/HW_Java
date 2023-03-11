package org.example;

public class Player {
        private static long nextId = 1;

        private long id;
        private String name;
        private double damage;
        private double healthPoints;

        public Player(String name, Double damage, Double healthPoints) {
            this.id = nextId++;
            this.name = name;
            this.damage = damage;
            this.healthPoints = healthPoints;
        }

        public void attack(Player player) {
            player.healthPoints -= this.damage;
            System.out.println(this.name + " нанес " + this.damage + " урона игроку " + player.name);
            System.out.println("У "+player.name + " осталось " + player.healthPoints+" жизни!");
//            Reader.printInfo(player);
        }

        public String getName() {
            return name;
        }

        public double getHealthPoints() {
            return healthPoints;
        }


    public boolean isDead() {
        if (this.healthPoints == 0) {
            return true;
        }
        return false;
    }
}
