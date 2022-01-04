package Fight;

import java.util.Random;
import Character.Character;
import Character.Specialisations.ChefDeTribu;
import Character.Specialisations.Dwarf;
import Character.Specialisations.Giant;
import Character.Specialisations.Human;

import java.util.Vector;

public class Fight {
    private Character player;
    private Vector<Character> enemy = new Vector<Character>();
    private ChefDeTribu<Character> tribu;
    private boolean asTribu = false;

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
            System.out.println(m_enemy);
            int Y = 1;
            int X = 1;
            boolean valid = true;
            do {
                Y = (int)Math.floor(Math.random()*9);
                X = (int)Math.floor(Math.random()*9);
                for (Character temps : this.enemy) {
                    if (temps.getX() == X && temps.getY() == Y) {
                        valid = false;
                        break;
                    }
                }
                if (player.getX() == X && player.getY() == Y) {
                    valid = false;
                }
            } while (!valid);
            m_enemy.setX(X);
            m_enemy.setY(Y);
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

        if ((int)Math.floor(Math.random()*5) == 1) {
       //if (true) {
            System.out.println("you're up against a tribe chief care he is dangerous");
            this.asTribu = true;
            this.tribu = new ChefDeTribu<Character>(enemy);
        }
        setPositionEnemy();
    }

    /***
     * Methods
     */

    public void nextRound()
    {
        Vector <Character> cimetary = new Vector<>();

        if (asTribu) {
            tribu.attack(this.player);
        }
        for (Character opponent : this.enemy)
        {
            this.player.attack(opponent);
            if (!asTribu) {
                opponent.attack(player);
            }
        }


        for (Character g : enemy) {

            if (g.getHp() <= 0) {
               cimetary.add(g);
            } else {
                System.out.format("""
                    ___________________
                    name: %s
                    life: %f
                    ___________________
                    """,g.getName(), g.getHp());
            }
        }
        for (Character dead : cimetary) {
            enemy.remove(dead);
        }
        System.out.format("""
                    ___________________
                    name: %s
                    life: %f
                    ___________________
                    """,player.getName(), player.getHp());
    }

    public void drawBoard() {
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
