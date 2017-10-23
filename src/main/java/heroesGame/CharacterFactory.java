//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package heroesGame;

import heroesGame.Characters.Elf;
import heroesGame.Characters.Character;
import heroesGame.Characters.Hobbit;
import heroesGame.Characters.King;
import heroesGame.Characters.Knight;
import neverUseSwitch.MailSender;
import org.fluttercode.datafactory.impl.DataFactory;

import java.util.HashMap;
import java.util.Map;



public class CharacterFactory {

    private static final DataFactory dataFactory = new DataFactory();

    private enum CharacterType{
        HOBBIT(1){ public Character create(){return new Hobbit();}},
        ELF(2){ public Character create(){return new Elf();}},
        KING(3){ public Character create(){return new King();}},
        KNIGHT(4){ public Character create(){return new Knight();}};

        public abstract Character create();
        private  int value;

        CharacterType(int i) { value=i; }
        private static Map map = new HashMap<>();
        static {
            for (CharacterType type : CharacterType.values()) {
                map.put(type.value, type);
            }
        }
        public static CharacterType valueOf(int type) {
            return (CharacterType) map.get(type);
        }

        public int getValue() {
            return value;
        }
    }

    public Character CreateCharacter() {

        CharacterType newCharacter =  CharacterType.valueOf(dataFactory.getNumberBetween(1,4));
        return newCharacter.create();
    }
}
