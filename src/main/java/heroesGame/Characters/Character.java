package heroesGame.Characters;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class Character {

    int power;
    int hp;

    public abstract void kick(Character c);

    public boolean isAlive() {
        return this.hp > 0;
    }

    @Override
    public String toString() {
        return "{Power: "+getPower()+"; HP: "+getHp()+"}";
    }


}
