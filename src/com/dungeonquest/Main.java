package com.dungeonquest;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hero, choose your attack: S for 'slash', L for 'leap aside' or M for 'mighty blow'.");

        String heroAttackString = "";

        String heroAttack = scanner.nextLine().toUpperCase(Locale.ROOT);
        switch (heroAttack) {
            case "S":
                heroAttackString = "Slash";
                System.out.println("You chose to Slash!");
                break;
            case "L":
                heroAttackString = "Leap Aside";
                System.out.println("You chose to Leap Aside!");
                break;
            case "M":
                heroAttackString = "Mighty Blow!";
                System.out.println("You chose the Mighty Blow!!");
                break;
            default:
                System.out.println("Please choose your attack: S for 'slash', L for 'leap aside' or M for 'mighty blow'.");
        }

        String[] monsterAttackOptions = {"Slash", "Leap Aside", "Mighty Blow!"};

        int monsterChoice = new Random().nextInt(monsterAttackOptions.length);
        String monsterAttack = monsterAttackOptions[monsterChoice];

        System.out.println("The monster is deciding on his attack...");
        try {
            Thread.sleep(4000);
        } catch(InterruptedException exception) {
            Thread.currentThread().interrupt();
        }

        System.out.println("The monster chooses " + monsterAttack + "!");

        if (heroAttackString.equals(monsterAttack)) {
            System.out.println("You and your foe strike your blades together!");
            System.out.println("You take 1 damage, but the monster also takes 1 damage.");
        } else if (heroAttackString.equals("Mighty Blow!") && monsterAttack.equals("Slash")) {
            System.out.println("You smite the monster! The monster takes 2 damage!");
        } else if (heroAttackString.equals("Leap Aside") && monsterAttack.equals("Slash")) {
            System.out.println("You try to leap out of the way, but the monster slashes you across the back!");
            System.out.println("You take 1 damage.");
        } else if (heroAttackString.equals("Slash") && monsterAttack.equals("Mighty Blow!")) {
            System.out.println("You raise your sword, but the monster smites your blade aside!");
            System.out.println("You take 1 damage.");
        } else if (heroAttackString.equals("Slash") && monsterAttack.equals("Leap Aside")) {
            System.out.println("The monster tries to leap out of the way, but you slash him across the back!");
            System.out.println("The monster takes 1 damage.");
        } else if (heroAttackString.equals("Mighty Blow!") && monsterAttack.equals("Leap Aside")) {
            System.out.println("You swing with all your might, but the monster leaps aside!");
            System.out.println("You take 1 damage.");
        } else if (heroAttackString.equals("Leap Aside") && monsterAttack.equals("Mighty Blow!")) {
            System.out.println("The monster swings mightily at you, but you leap under the blow!");
            System.out.println("The monster takes 1 damage.");
        }
    }
}
