package com.company;

import java.util.Random;
import java.util.Scanner;

class Player {
    int point = 0;
    int[] deck = new int[50];
}
class Computer {
    int point = 0;
    int[] deck = new int[50];
}
class Game {
    static Player player = new Player();
    static Computer computer = new Computer();
    static  String[] acts = {"Sum", "Swk"};
    static  String act;
    static  specialCard Card = new specialCard();
    static Scanner in = new Scanner(System.in);
    static String input;
    public static void run() {
        draw(player.deck);
        draw(computer.deck);
        for (int i = 0; i < 50-1; i+=2) {
            dropCard(i);
            act = dropSpecialCard();
            useSpecialCard(act, player.deck[i], player.deck[i+1]);
        }
    }

    private static void draw(int[] deck) {
        int[] arr = new int[50];
        int rand, len;
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        len = arr.length;
        while (len != 1) {
            rand = random.nextInt(len);
            if (rand == len - 1) deck[arr.length - len] = arr[len - 1];
            else deck[arr.length - len] = arr[rand];
            for (int j = 0; j < len - 1; j++) {
                if (j >= rand) {
                    arr[j] = arr[j + 1];
                }
            }
            len--;
        }
        deck[arr.length - len] = arr[0];
//
    }
    private static void dropCard(int i) {
            System.out.println("////////////////////////");
            System.out.println("[ " + player.deck[i]+" ] "+" [ "+player.deck[i+1]+" ]");
            System.out.println("--------------------------");
            System.out.println("[ " + computer.deck[i]+" ] "+" [ "+computer.deck[i+1]+" ]");
            System.out.println("////////////////////////");
    }
    private  static String dropSpecialCard() {
        Random random = new Random();
        int rand = random.nextInt(acts.length);
        return acts[rand];
    }
    private  static  void useSpecialCard(String _act, int val1, int val2) {
        if ( _act.equals("Sum")) {
            //TODO Card.sum(val1, val2);
        }

    }
}
class specialCard {
     public static void sum() {
         //TODO
     }
}
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}
//