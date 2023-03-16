package org.example;

import java.util.List;

public class TableFormater {
    public static void printNotebooks(List<Notebook> notebooks) {
        System.out.println("╔═══════════════╦════════════════════╦═══════════════╗");
        System.out.println("║    Стоимость  ║ Оперативная память ║    Дисплей    ║");
        System.out.println("╠═══════════════╬════════════════════╦═══════════════╣");
        for (Notebook notebook : notebooks) {
            System.out.printf("║%15d║%20d║%15d║%n", notebook.getCost(), notebook.getMemory(), notebook.getDisplay());
        }
        System.out.println("╚═══════════════╩════════════════════╩═══════════════╝");
    }
}
