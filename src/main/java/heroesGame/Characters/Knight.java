package heroesGame.Characters;

import org.fluttercode.datafactory.impl.DataFactory;

public class Knight extends King{

    DataFactory dataFactory = new DataFactory();

    public Knight() {
        this.setPower(dataFactory.getNumberBetween(2, 12));
        this.setHp(dataFactory.getNumberBetween(2, 12));
    }


}
