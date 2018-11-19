package com.company;

import java.util.Scanner;

import com.company.core.*;


public class Controller {
    private int choice;
    Scanner scanner = new Scanner(System.in);
    Engine engine = new Engine();
    Options options = new Options();



    public void menu() {

        while (true) {
            options.welcome();
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    engine.runGame();
                    break;
                }
                case 2: {
                    options.rules();
                    break;
                }
                case 3:
                    System.out.println("KONIEC GRY");
                    break;
            }
        }
    }
}