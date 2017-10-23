package heroesGame.Characters;

public class Hobbit extends Character {

    public Hobbit(){super(0, 3);}

   private void toCry(){
        System.out.println("AAAAAAA! Please don't kill me. I want to live!");
    }

    @Override
    public void kick(Character c){
        toCry();
    }
}
