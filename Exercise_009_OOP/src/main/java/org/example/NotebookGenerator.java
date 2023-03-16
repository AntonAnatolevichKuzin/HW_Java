package org.example;

import java.util.Random;

public class NotebookGenerator {
    private static final int MIN_COST = 500;
    private static final int MAX_COST = 1500;
    private static final int MIN_MEMORY = 4;
    private static final int MAX_MEMORY = 32;
    private static final int MIN_DISPLAY = 10;
    private static final int MAX_DISPLAY = 17;

    public static Notebook generateRandomNotebook() {
        Random random = new Random();
        int cost = random.nextInt(MAX_COST - MIN_COST + 1) + MIN_COST;
        int memory = random.nextInt(MAX_MEMORY / MIN_MEMORY) * MIN_MEMORY + MIN_MEMORY;
        int display = random.nextInt(MAX_DISPLAY - MIN_DISPLAY +1) + MIN_DISPLAY;
        return new Notebook(cost, memory, display);
    }
}
