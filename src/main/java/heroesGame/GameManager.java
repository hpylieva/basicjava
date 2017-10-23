package heroesGame;

import heroesGame.Characters.Character;

public class GameManager {

    public GameManager(){};
    public void fight(Character c1, Character c2){
        System.out.println("Welcome to the Heroes Game!");
        System.out.println("<Player A> is " + c1.getClass().getSimpleName() );
        System.out.println("<Player B> is " + c2.getClass().getSimpleName());

        while(c1.isAlive() && c2.isAlive()) {
            c1.kick(c2);
            System.out.println("Player A kicks Player B. State of Player B now is" + c2.toString());
            if (!c2.isAlive()) {
                System.out.println("Player B has died... Player A is a WINNER!");
                return;
            }

            c2.kick(c1);
            System.out.println("Player B kicked Player A. State of Player A now is" + c1.toString());
        }

        System.out.println("Player A has died... Player B is a WINNER!");

    }


}
