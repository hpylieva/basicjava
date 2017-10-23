import guessGame.Communication;
import guessGame.guessGame;
import heroesGame.CharacterFactory;
import heroesGame.Characters.Character;
import heroesGame.GameManager;
import neverUseSwitch.MailSender;

import org.fluttercode.datafactory.impl.DataFactory;

import javax.swing.*;

import static neverUseSwitch.MailSender.doWork;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int dialogResult;
        do{
            Object[] options = { "NeverUseSwitch", "GuessGame", "HeroesGame" , "Exit"};
            dialogResult =JOptionPane.showOptionDialog(null, "Pease choose which task to run", "Input",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,null, options, options[0]);

            if (dialogResult==0){
                MailSender mailSender = new MailSender();
                DataFactory dataFactory = new DataFactory();

                while (true) {
                    doWork(mailSender, dataFactory);
                    Thread.sleep(1000);
                }

            } else if (dialogResult==1) {
                guessGame game = new guessGame();
                int dialogResultLocal;
                do{
                    Integer max=Communication.askForInteger("Set the MAX number");

                    if(max != null){
                        game.play(max);
                        game.printBestScore();
                        dialogResultLocal = JOptionPane.showConfirmDialog(null,
                                "One more game?");
                    }else {
                        break;
                    }

                }while (dialogResultLocal == JOptionPane.YES_OPTION);


                JOptionPane.showMessageDialog(null, "You've finished the game.",
                        "Info", JOptionPane.INFORMATION_MESSAGE);
                game.printBestScore();
            }
            else if (dialogResult==2){
                GameManager gameManager =  new GameManager();
                CharacterFactory factory = new CharacterFactory();
                Character c1 = factory.CreateCharacter();
                Character c2 = factory.CreateCharacter();
                gameManager.fight(c1,c2);
            }

        }while (dialogResult != 3);
    }
}
