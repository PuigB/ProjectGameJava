package Display;

import Fight.Fight;
import Character.Specialisations.Dwarf;
import Character.Specialisations.Giant;
import Character.Specialisations.Human;
import Inventory.Weapons.BasicShinGuard;
import Inventory.Weapons.BasicSyntheticGloves;
import Inventory.Weapons.BlackPandaGloves;
import Inventory.Weapons.Weapons;
import Shop.Shop;
import Log.Logger;
import java.util.Scanner;

public class Display {
    public void startGame() {
        System.out.println("Bienvenue à Boxing_project!");
    }
    public void getMenu(int userChoice) {
        /*switch (userChoice) {
            case 1:
                getShop();
                break;
            case 2:
                launchFight();
                break;
            case 3:
                getInventory();
                break;
            case 4:
                getStats();
                break;

        }*/
    }
    private void getShop(){

    }

    private void launchFight() {

    }

    private void getInventory() {

    }

    /*private void getStats(Character player) {
        String name = player.getName();
        System.out.println("""
                Name: %s
                """, player.getName());
    }*/

    public int Menu() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        int userChoice = 0;
        System.out.println("""
                Entrez la valeur correspondant à votre choix:
                   1.Acceder à la boutique
                   2.Lancer un combat
                   3.Acceder à l'inventaire
                   4.Voir les stats du personnage
                   
                Entrez votre choix:""");
        String attempt = myObj.nextLine();

        while (!verify(attempt)) {
            if (!verify(attempt)) {
                System.out.println("Veuillez entrer une valeur correcte:");
            }
            attempt = myObj.nextLine();
        }

        userChoice = Integer.parseInt(attempt);
        return userChoice;
    }

    private boolean verify(String a)
    {
        if(a.length() != 1)
        {
            return false;
        }
        if (!isNumeric(a)){
            return false;
        }
        return Integer.parseInt(a) <= 4;
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
