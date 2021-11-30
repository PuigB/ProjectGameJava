package Inventory.Weapons.SharedWeapon;
import Inventory.Weapons.IArme;
import Character.IPersonnage;

public class weapon implements IArme {
    String name;
    boolean isEquped;
    float durability;
    float precision;
    float damage;
    float size;
    float weight;
    float range;

    public boolean isEquipped (){
        return true;
    }

    public void repair(float percent){
        durability = 100;
    }

    public void worn(int ammount){
        durability -= ammount;
    }

    public String getName(){
        return "";
    }

    public float getUsure(){
        return durability;
    }

    public float getWeight(){
        return weight;
    }

    public float getDamage(){
        return damage;
    }

    public float getPrecision(){
        return precision;
    }

    public float getRange(){
        return range;
    }

    public void attack(IPersonnage target){
        worn(1);
    }


    public weapon(){

    }

    public weapon(float newDamage,float newDurability,boolean newIsEquiped,float newWeight,float newSize,float newPrecision){
        durability = newDurability;
        //range = newRange;
        precision = newPrecision;
        damage = newDamage;
        weight = newWeight;
        isEquped = newIsEquiped;
        size = newSize;
    }


}