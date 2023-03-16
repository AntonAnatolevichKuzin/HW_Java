package org.example;

public class Notebook {
    private int cost;
    private int memory;
    private int display;

    public Notebook(int cost, int memory, int display) {
        this.cost = cost;
        this.memory = memory;
        this.display = display;
    }

    public int getCost() {
        return cost;
    }

    public int getMemory() {
        return memory;
    }

    public int getDisplay() {
        return display;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "cost=" + cost +
                ", memory=" + memory +
                "display=" + display +
                '}';
    }
}
