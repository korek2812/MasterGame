package com.company;

import java.io.*;
import java.util.*;

public class Dictionary {

    private String randomWord;
    private String typedWord;
    private String word;
    private String secretNumberString;
    private int index;
    private int secretNumber;
    private String filePath = "FourLetterWords.txt";

    List wordsList = new ArrayList();
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);


    private Dictionary() {
    }

    private Dictionary(Builder builder) {
        if (builder == null) {
            return;
        }
        randomWord = builder.randomWord;
        typedWord = builder.typedWord;
        word = builder.word;
        index = builder.index;
        secretNumberString = builder.secretNumberString;

    }


    public void addSecretNumber() { //randomize 4 letter special  number

        char[] tablica;
        Set set = new HashSet();

        while (set.size() < 4) {

            secretNumber = random.nextInt(8999) + 1000;
            secretNumberString = "" + secretNumber;

            tablica = secretNumberString.toCharArray();
            for (char nazwaZnaku : tablica) {
                set.add(nazwaZnaku);

            }
            if (set.size() != 4) {
                //  System.out.println("set ma mniej niz 4 cyfry"+ set);
                set = new HashSet();
            }
        }
    }

    public void typingNumber() {
        System.out.println("Type a number: ");
        typedWord = scanner.next();
        char[] znaki = typedWord.toCharArray();
        Set mySet = new HashSet<>();

        while (mySet.size() != znaki.length) {
            znaki = typedWord.toCharArray();
            for (char znak : znaki) {
                mySet.add(znak);
            }
            if (mySet.size() != znaki.length) {
                System.out.println("your word isn't an isogram!! \n Type a correct word!!! ");
                System.out.println("Type a number: ");
                typedWord = scanner.next();

            }

        }

    }

    public String getRandomWord() {
        return randomWord;
    }

    public String getTypedWord() {
        return typedWord;
    }

    public String getSecretNumberString() {
        return secretNumberString;
    }

    public String getWord() {
        return word;
    }

    public int getIndex() {
        return index;
    }


    public static class Builder {

        private String randomWord;
        private String typedWord;
        private String word;
        private String secretNumberString;
        private int index;

        public Builder() {
        }

        ;

        public Builder randomWord(String randomWord) {
            this.randomWord = randomWord;
            return this;
        }

        public Builder tyepedWord(String typedWord) {
            this.typedWord = typedWord;
            return this;

        }

        public Builder word(String word) {
            this.word = word;
            return this;
        }

        public Builder secretNumberString(String secretNumberString) {
            this.secretNumberString = secretNumberString;
            return this;
        }

        public Builder index(int index) {
            this.index = index;
            return this;

        }

        public Dictionary build() {
            return new Dictionary(this);
        }


    }
}