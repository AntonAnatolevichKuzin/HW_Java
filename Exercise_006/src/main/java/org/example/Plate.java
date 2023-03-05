package org.example;

public class Plate {
    private int food;
    public int plateVolume;

    public Plate(int food){
        this.food = food;
        this.plateVolume = food;
    }

    public int decreaseFood(int foodToDecrease){
        if (this.food >= foodToDecrease) {
            this.food = this.food - foodToDecrease;
            return foodToDecrease;
        }
        return 0;
    }


    public int remainderPlate(){return this.food;}


    public int increaseFood(int foodToIncrease){
        if(plateVolume >= this.food +  foodToIncrease) {
            this.food += foodToIncrease;
            return foodToIncrease;
        } else if (food < this.plateVolume) {
            foodToIncrease = this.plateVolume - this.food;
            food = this.plateVolume;
            return foodToIncrease;
        }
        return 0;
    }
    @Override
    public String toString() {
        return "В тарелке [" + this.food + "] еды.";
    }

}
