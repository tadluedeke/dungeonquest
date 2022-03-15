package com.dungeonquest;

import java.io.Console;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("Hero, choose your attack: S for 'slash', L for 'leap aside' or M for 'mighty blow'.");
        String heroAttack = console.readLine("Hero, choose your attack: S for 'slash', L for 'leap aside' or M for 'mighty blow'.");
        System.out.println("The monster is deciding on his attack...");
        try {
            Thread.sleep(5000);
        } catch(InterruptedException exception) {
            Thread.currentThread().interrupt();
        }

    }
}
