package com.company;


public class GuessStats {
    private double cows = 0;



    private double bulls = 0;
    private int min;

    public void setCows(int cows) {
        this.cows = cows;
    }

    public void setBulls(int bulls) {
        this.bulls = bulls;
    }
    public double getCows() { return cows; }
    public double getBulls() { return bulls; }


    private GuessStats() { }
    private GuessStats(Builder builder) {
        if (builder == null) {
            return;
        }
        cows = builder.cows;
        bulls = builder.bulls;
        min = builder.min;
    }

    public void checkLetters(String randomWord, String yourWord) {

        char[] tab1 = randomWord.toCharArray();
        char[] tab2 = yourWord.toCharArray();
        min = Math.min(tab1.length, tab2.length);
        for (int i = 0; i < min; i++) {
            if (tab1[i] == tab2[i]) {
                //   System.out.println("Letter  " + (i + 1) + " is correct");
                bulls++;
            }
        }
        for (int i = 0; i < min; i++) {
            for (int j = 0; j < min; j++) {
                if (tab2[i] == tab1[j] && i != j) {
                    //  System.out.println("Letter " + (i + 1) + " should be " + (j + 1) + " in a secret word");
                    cows++;
                }
            }
        }


    }




    public static class Builder {

        private double cows = 0;
        private double bulls = 0;
        private int min;

        public Builder(){};

        public Builder cows(double cows) {
            this.cows = cows;
            return this;
        }

        public Builder bulls(double bulls) {
            this.bulls = bulls;
            return this;

        }

        public Builder min(int min) {
            this.min = min;
            return this;
        }

        public GuessStats build() {
            return new GuessStats(this);

        }

    }


}
