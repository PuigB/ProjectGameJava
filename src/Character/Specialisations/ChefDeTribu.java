package Character.Specialisations;

import Character.Character;

public class ChefDeTribu extends Character {

    public ChefDeTribu(String Name, String type) {
        super(Name);
        switch(type) {
            case "Human":
                super.setType("Human");
                super.setLifePoint(200);
                super.setAttack(7);
                super.setStrength(7);
                super.setAgility(6);
                super.setDefense(6);
                break;
            case "Dwarf":
                super.setType("Dwarf");
                super.setLifePoint(160);
                super.setAttack(6);
                super.setStrength(6);
                super.setAgility(10);
                super.setDefense(10);
                break;
            case "Giant":
                super.setType("Giant");
                super.setLifePoint(300);
                super.setAttack(10);
                super.setStrength(10);
                super.setAgility(2);
                super.setDefense(8);
            default:
                break;
        }
    }




}
