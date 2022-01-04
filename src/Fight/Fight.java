package Fight;

import Character.Character;
import Character.Specialisations.Dwarf;
import Character.Specialisations.Giant;
import Character.Specialisations.Human;

import java.util.Vector;

public class Fight {
    private Character player;
    private Vector<Character> enemy = new Vector<>();

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

    private void setPositionEnemy() {

        for (Character m_enemy : this.enemy) {
            Vector <Character> copyEnemy = enemy;

            m_enemy.setX((int)Math.floor(Math.random()*9));
            m_enemy.setY((int)Math.floor(Math.random()*9));

        }
    }

    public void addPlayer(Character player) {
        this.player = player;
        this.player.setX((int)Math.floor(Math.random()*9));
        this.player.setY((int)Math.floor(Math.random()*9));
        
        for (int i = 0; i < (int)Math.ceil(player.getLvl()/2F); i++) {
            int enemyType = (int)Math.floor(Math.random()*3);
            this.addEnemy(switch (enemyType){
                case 1 -> new Dwarf("enemy " +i);
                case 2 -> new Giant("enemy " +i);
                default -> new Human("enemy " +i);
            });
        }
        setPositionEnemy();
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
        for (Character g : enemy) {
            System.out.format("""
                    ___________________
                    name: %s
                    life: %f
                    ___________________
                    """,g.getName(), g.getHp());
        }
        System.out.format("""
                    ___________________
                    name: %s
                    life: %f
                    ___________________
                    """,player.getName(), player.getHp());
    }

    public void drawBoard() {
        System.out.println(enemy.get(0).getX() + "" + enemy.get(0).getY());
        System.out.println(enemy.get(1).getX() + "" + enemy.get(1).getY());
        System.out.println(enemy.get(2).getX() + "" + enemy.get(2).getY());
        System.out.println("╔═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╗");
        for (int i = 0; i < 10;i++) {
            System.out.print("║");
            for (int j = 0; j < 10; j++) {
                if (i == player.getX() && j == player.getY()) {
                    System.out.print(" P ║");
                } else {
                    boolean found = false;
                    for (Character m_enemy : enemy) {
                        if (i == m_enemy.getX() && j == m_enemy.getY()) {
                            found = true;
                        }
                    }
                    if (found) {
                        System.out.print(" A ║");
                    } else {
                        System.out.print("   ║");
                    }
                }
            }
            if (i != 9) {
                System.out.println("\n╠═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
            } else {
                System.out.println("\n╚═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╝");
            }
        }
    }
}
