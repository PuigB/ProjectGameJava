package Character;

import Inventory.Weapons.*;

public interface IPersonnage {
    String getName();

    String getType();

    float getHp();

    float getAttack();

    void attack(IPersonnage target);

    void defense(IPersonnage attacker, IArme weapon, float damage);

    float getDefense();

    IArme getMainWeapon();
}
