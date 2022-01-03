package Fight;

import Character.Character;
import java.util.Vector;

public class Fight {
    private Character player;
    private Vector<Character> enemy;

    /***
     * Getter
     */

    public Vector<Character> enemy() {
        return this.enemy;
    }

    public Character player() {
        return this.player;
    }

    /***
     * Setter
     */

    public void addEnemy(Character enemy){
        this.enemy.add(enemy);
    }

    public void addPlayer(Character player) {
        this.player = player;
    }

    /***
     * Methods
     */

    public void nextRound()
    {
        for (Character opponent : this.enemy)
        {
            this.player.attack(opponent);
            opponent.attack(player);
        }
    }
}
