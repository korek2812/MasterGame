package com.company.core;

public class Options {

    public void rules(){

        System.out.println("Rules\nMasterMind is a number game. The computer will select a secret number with four different (unique) digits.\n"+
"The object of the game is to guess that secret number. Each guess is answered by the number of digits in the guess number that match or occur in the secret number.\n"
+"Bulls- correct number, correct position\nCows - correct number, wrong position");



    }
    public void welcome(){
        System.out.println("MasterMind!! \nDiscover the hidden number! \n\n Seelct 1 - New Game \n Select 2 - Rules \n Select 3 - Quit");
    }
}
