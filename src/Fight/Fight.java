package Fight;

import Character.Character;
import java.util.Vector;

public class Fight {
    private Character player;
    private final Vector<Character> enemy;

    public Fight(Character player) {
        this.enemy = new Vector<Character>();
        for ( int i = 0; i < 3; i++) {
            Character bot = new Character("bot " + i);
            bot.setLifePoint(100);
            this.enemy.add(bot);
        }
    }

    /***
     * Getter
     */

    public Vector<Character> getEnemy() {
        return this.enemy;
    }


    /***
     * Setter
     */


    public void addPlayer(Character player) {
        this.player = player;
    }
}
