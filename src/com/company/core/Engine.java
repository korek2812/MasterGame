package com.company.core;

import com.company.Dictionary;
import com.company.GuessStats;

public class Engine {


    public void runGame() {


        Dictionary dictionary = new Dictionary.Builder()
                .randomWord("kopytko")
                .tyepedWord(" szerszeń")
                .word("slow0")
                .secretNumberString("1234")
                .index(2)
                .build();
       // System.out.println(prettyPrint(dictionary));

        GuessStats guessStats = new GuessStats.Builder()
                .bulls(0)
                .cows(0)
                .min(2)
                .build();


        dictionary.addSecretNumber();

        for (int i = 0; i < 10; i++) {
         //   System.out.println(prettyPrint(dictionary));
            dictionary.typingNumber();
            guessStats.checkLetters(dictionary.getSecretNumberString(),dictionary.getTypedWord()); //this method returned new object GuessStats
            if (!dictionary.getTypedWord().equals(dictionary.getSecretNumberString())) {
                System.out.println(prettyPrint(guessStats));
                guessStats.setCows(0);
                guessStats.setBulls(0);

            } else {
                System.out.println("You geessed the secret word!. Congratulations!");
                break;
            }
        }





    }

    private static String prettyPrint(Dictionary dictionary) {
        return String.format(
                "Random word: %s\nTyped word: %s\nWord: %s\nSecret Number: %s\nIndex: %d",
                dictionary.getRandomWord(),
                dictionary.getTypedWord(),
                dictionary.getWord(),
                dictionary.getSecretNumberString(),
                dictionary.getIndex());


    }
    private static String prettyPrint(GuessStats guessStats) {
        return String.format(
                "Bulls: %.1f\nCows: %.1f\n",
                guessStats.getBulls(),
                guessStats.getCows());


    }}
