package guessGame;


import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        guessGame game = new guessGame();
        int dialogResult;
        do{
        Integer max=Communication.askForInteger("Set the MAX number");

            if(max != null){
                game.play(max);
                game.printBestScore();
                dialogResult = JOptionPane.showConfirmDialog(null,
                        "One more game?");
            }else {
                break;
            }

        }while (dialogResult == JOptionPane.YES_OPTION);


        JOptionPane.showMessageDialog(null, "You've finished the game.",
                "Info", JOptionPane.INFORMATION_MESSAGE);
        game.printBestScore();
    }
}
