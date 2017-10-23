package heroesGame.Characters;

import org.fluttercode.datafactory.impl.DataFactory;

public class King extends Character{
    DataFactory dataFactory = new DataFactory();

    public King() {
        this.setPower(dataFactory.getNumberBetween(5, 15));
        this.setHp(dataFactory.getNumberBetween(5, 15));
    }

    @Override
    public void kick(Character c) {
        c.hp -= dataFactory.getNumberUpTo(this.power);
    }
}
