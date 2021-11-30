package Inventory.Weapons;

import Character.IPersonnage;

public interface IArme {
        boolean isEquipped();
        void repair(float percent);
        String getName();
        float getUsure();
        float getWeight();
        float getDamage();
        float getPrecision();
        float getRange();
        void attack(IPersonnage target);
}