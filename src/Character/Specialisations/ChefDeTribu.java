package Character.Specialisations;

import Character.Character;
import java.util.Vector;

public class ChefDeTribu<T extends Character> {
    private T m_chef;
    private Vector<T> m_tribu;

    public ChefDeTribu(Vector<T> tribu) {
        m_chef = tribu.get(0);
        m_tribu = tribu;
    }

    public void attack(T player) {
        for (T m : m_tribu) {
            float futureDamage = m.getAttack() + m.getMainWeapon().getDamage();
            int ProbabilityStrength = (int)(Math.random() * (100. + 1));
            if (ProbabilityStrength < m.getStrength()) {
                futureDamage += 5;
            }
            player.defense(m,m.getMainWeapon(),futureDamage);
        }
    }
}
