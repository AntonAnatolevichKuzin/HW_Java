package org.example;

public class Reader {

    public static void printHealth(Object object) {
        double healthPoint = (((HasHealthPoint) object).getHealthPoint()/((HasHealthPoint) object).getMaxHealthPoint())*100;
        String healthColor = getColorForValue(healthPoint);
        System.out.print("Здоровье: " + healthColor + healthPoint + "\u001B[0m ");
        }
    public static void printTirednes(Object object) {
        double tiredness = ((Tiredness) object).getTiredness();
        String tirednessColor = getColorTirednes(tiredness);
        System.out.println("Усталость: " + tirednessColor + tiredness + "\u001B[0m ");
    }

    private static String getColorForValue(double value) {
        if (value <= 24) {
            return "\u001B[30m"; // black
        } else if (value <= 50) {
            return "\u001B[31m"; // red
        } else if (value <= 100) {
            return "\u001B[32m"; // green
        } else {
            return "\u001B[0m"; // default color
        }
    }

    private static String getColorTirednes(double value) {
        if (value <= 20) {
            return "\u001B[32m";
        } else if (value <= 40) {
            return "\u001B[31m";
        } else if (value <= 50) {
            return "\u001B[30m";
        } else {
            return "\u001B[0m";
        }
    }
}
