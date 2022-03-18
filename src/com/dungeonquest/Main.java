package com.dungeonquest;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Boolean newRound = true;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name, Hero.");
        String heroName = scanner.nextLine();

        System.out.println("How many Life Points do you have " + heroName + "?");
        int heroLP = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter the name of the monster you are facing.");
        String monster = scanner.nextLine();

        Random monsterLPRandom = new Random();
        int monsterLP = monsterLPRandom.nextInt(8 - 1 + 1) + 1;
        //For testing, want to see monster LP at the beginning.
        //System.out.println("The " + monster + " has " + monsterLP + " Life Points.");

        System.out.println("Good luck " + heroName + ". You have " + heroLP + " Life Points.");

        while (newRound) {
            System.out.println(heroName + ", choose your attack: S for 'slash', L for 'leap aside' or M for 'mighty blow'.");

            String heroAttackString;

            String[] heroAttackOptions = {"Slash", "Leap Aside", "Mighty Blow!"};

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
                    int heroChoice = new Random().nextInt(heroAttackOptions.length);
                    heroAttackString = heroAttackOptions[heroChoice];
                    System.out.println("You have been randomly assigned " + heroAttackString + "!");
            }

            String[] monsterAttackOptions = {"Slash", "Leap Aside", "Mighty Blow!"};

            int monsterChoice = new Random().nextInt(monsterAttackOptions.length);
            String monsterAttack = monsterAttackOptions[monsterChoice];

            System.out.println("The " + monster + " is deciding on his attack...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }

            System.out.println("The " + monster + " chooses " + monsterAttack + "!");
            System.out.println("--------------------------------------------------------");

            if (heroAttackString.equals(monsterAttack)) {
                System.out.println("You and the " + monster + " strike your blades together!");
                System.out.println("You take 1 damage, but the " + monster + " also takes 1 damage.");
                System.out.println("--------------------------------------------------------");
                heroLP--;
                monsterLP--;
            } else if (heroAttackString.equals("Mighty Blow!") && monsterAttack.equals("Slash")) {
                System.out.println("You smite the " + monster + "! The " + monster + " takes 2 damage!");
                System.out.println("--------------------------------------------------------");
                monsterLP = monsterLP - 2;
            } else if (heroAttackString.equals("Leap Aside") && monsterAttack.equals("Slash")) {
                System.out.println("You try to leap out of the way, but the " + monster + " slashes you across the back!");
                System.out.println("You take 1 damage.");
                System.out.println("--------------------------------------------------------");
                heroLP--;
            } else if (heroAttackString.equals("Slash") && monsterAttack.equals("Mighty Blow!")) {
                System.out.println("You raise your sword, but the " + monster + " smites your blade aside!");
                System.out.println("You take 1 damage.");
                System.out.println("--------------------------------------------------------");
                heroLP--;
            } else if (heroAttackString.equals("Slash") && monsterAttack.equals("Leap Aside")) {
                System.out.println("The " + monster + " tries to leap out of the way, but you slash him across the back!");
                System.out.println("The " + monster + " takes 1 damage.");
                System.out.println("--------------------------------------------------------");
                monsterLP--;
            } else if (heroAttackString.equals("Mighty Blow!") && monsterAttack.equals("Leap Aside")) {
                System.out.println("You swing with all your might, but the " + monster + " leaps aside!");
                System.out.println("You take 1 damage.");
                System.out.println("--------------------------------------------------------");
                heroLP--;
            } else if (heroAttackString.equals("Leap Aside") && monsterAttack.equals("Mighty Blow!")) {
                System.out.println("The " + monster + " swings mightily at you, but you leap under the blow!");
                System.out.println("The " + monster + " takes 1 damage.");
                System.out.println("--------------------------------------------------------");
                monsterLP--;
            }
            if(monsterLP <= 0) {
                System.out.println("You cleave the " + monster + " in half! You live to fight another day.");
                newRound = false;
            } else if(heroLP == 0) {
                System.out.println("The " + monster + " buries his blade into your guts.");
                System.out.println("You are dead.");
                newRound = false;
            } else {
                System.out.println("You and the " + monster + " eye each other over your crossed blades. You have " + heroLP + " LP's remaining.");
                //For testing purposes
                //System.out.println("The " + monster + " has " + monsterLP + " LP's remaining.");
                System.out.println("A new round begins!");
                System.out.println("--------------------------------------------------------");
                System.out.println(" ");
            }
        }
    }
}
