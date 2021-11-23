package Character;

import Inventory.IWeapon;
import Inventory.Weapons.Weapons;

public interface IPersonnage {
     String getName();
     String getType();
     float getHp(); // de 0 à 100
     float getAttack();
     float getDefense();
     IWeapon getMainWeapon();
     void attack(IPersonnage target);
     void defense(IPersonnage attacker,IWeapon weapon ,float damage);
}

