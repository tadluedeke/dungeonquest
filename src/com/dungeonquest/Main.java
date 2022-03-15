package com.dungeonquest;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hero, choose your attack: S for 'slash', L for 'leap aside' or M for 'mighty blow'.");

        String heroAttack = scanner.nextLine().toUpperCase(Locale.ROOT);
        switch (heroAttack) {
            case "S":
                System.out.println("You chose to Slash!");
                break;
            case "L":
                System.out.println("You chose to Leap Aside!");
                break;
            case "M":
                System.out.println("You chose the Mighty Blow!!");
                break;
            default:
                System.out.println("Please choose your attack: S for 'slash', L for 'leap aside' or M for 'mighty blow'.");
        }

        String[] monsterAttackOptions = {"Slash", "Leap Aside", "Mighty Blow!"};

        int attack = new Random().nextInt(monsterAttackOptions.length);

        System.out.println("The monster is deciding on his attack...");
        try {
            Thread.sleep(4000);
        } catch(InterruptedException exception) {
            Thread.currentThread().interrupt();
        }

        System.out.println("The monster chooses %s!", attack);

    }
    public static
}
