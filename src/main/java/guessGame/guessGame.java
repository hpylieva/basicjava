package guessGame;

import javax.swing.*;
import java.util.Random;

public class guessGame {

    private double bestScore;

    public guessGame(){
        bestScore = 0;
    }

    public void play(int max){

        Random rand = new Random();
        int wantedNumber = rand.nextInt(max);
        Integer integerUserNumber = -1;
       // JFrame frame = new JFrame("Message");
        int numberOfAttempts = 0;

        do {
            //entering the number
            do
            integerUserNumber= Communication.askForInteger("Tell me a number from 0 to " + Integer.toString(max));
            while (integerUserNumber>max||integerUserNumber<0);

            JFrame frame = new JFrame("MessageDialog");


                //if(integerUserNumber>=0 && integerUserNumber<=max){
                if (integerUserNumber < wantedNumber) {
                    //JFrame frame = new JFrame("MessageDialog");
                    JOptionPane.showMessageDialog(null, "Your number is LOWER",
                            "Info", JOptionPane.INFORMATION_MESSAGE);
                    numberOfAttempts++;
                } else if (integerUserNumber > wantedNumber) {
                    JOptionPane.showMessageDialog(null, "Your number is HIGHER",
                            "Info", JOptionPane.INFORMATION_MESSAGE);
                    numberOfAttempts++;
                } else {
                    JOptionPane.showMessageDialog(null,"Your number is JUST NICE! Congratulations!",
                            "Info", JOptionPane.INFORMATION_MESSAGE);
                    numberOfAttempts++;
                }
        } while (integerUserNumber!=wantedNumber);

        float score = (float)max / numberOfAttempts;
        if(bestScore < score){
            bestScore = score;
        }

    }

    public void printBestScore(){

    JOptionPane.showMessageDialog(null, String.format("Your best score is %.2f", bestScore),
                "Info", JOptionPane.INFORMATION_MESSAGE);

    }
}
