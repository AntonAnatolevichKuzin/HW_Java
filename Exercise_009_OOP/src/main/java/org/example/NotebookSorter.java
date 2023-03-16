package org.example;

import java.util.Comparator;
import java.util.List;

public class NotebookSorter {
    public static void sortByCostAscending(List<Notebook> notebooks) {
        notebooks.sort(Comparator.comparing(Notebook::getCost));
    }

    public static void sortByCostDescending(List<Notebook> notebooks) {
        notebooks.sort(Comparator.comparing(Notebook::getCost).reversed());
    }

    public static void sortByMemoryAndCostDescending(List<Notebook> notebooks) {
        notebooks.sort(Comparator.comparing(Notebook::getMemory).reversed()
                .thenComparing(Comparator.comparing(Notebook::getCost).reversed()));
    }
    public static void sortByDisplayAscending(List<Notebook> notebooks) {
        notebooks.sort(Comparator.comparing(Notebook::getDisplay));
    }

    public static void sortByDisplayDescending(List<Notebook> notebooks) {
        notebooks.sort(Comparator.comparing(Notebook::getDisplay).reversed());
    }
}
