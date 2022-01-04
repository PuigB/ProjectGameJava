package Display;

import Character.Character;
import Character.Specialisations.Dwarf;
import Character.Specialisations.Human;
import Character.Specialisations.Giant;
import Inventory.Item;
import Inventory.RecoveryItem.RecoveryItem;
import Inventory.Weapons.Weapons;
import Shop.Shop;
import Fight.Fight;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;
import java.util.Map;
import static Inventory.Item.item_type.RecoveryItem;
import static Inventory.Item.item_type.Weapon;
import static com.googlecode.lanterna.input.KeyType.Character;

public class Display {
    private Character m_player;

    public void startGame() {
        System.out.println("Welcome to Boxing_project!");
    }

    public void getMenu(Character player, int userChoice, Shop shop) {
        switch (userChoice) {
            case 0 -> getShop(player,shop);
            case 1 -> launchFight(m_player);
            case 2 -> {
                Item item = getInventory();
                if (item != null) {
                    getItemDetails(item);
                }
            }
            case 3 -> getStats();
            case 4 -> System.exit(1);

        }
    }

    private void getShop(Character player,Shop shop) {
        int i =1;
        Map<Integer, Item> items = new HashMap<>();
        System.out.println("Weapons:");
        for (Item weapon : shop.getShop()) {
            if (weapon.getType() == Weapon) {
                System.out.format("""
                            %d.%s   %f
                        """,i,weapon.getName(),weapon.getPrice());
                items.put(i,weapon);
            i++;
            }
        }
        System.out.println("\nRecovery Items:");
        for (Item recoveryItem : shop.getShop()) {
            if (recoveryItem.getType() == RecoveryItem) {
                System.out.format("""
                            %d.%s   %f
                        """,i,recoveryItem.getName(),recoveryItem.getPrice());
                items.put(i,recoveryItem);
                i++;
            }
        }
        int action = inputUser("""
                1.Buy item
                2.Leave shop""", 2);
        switch (action){
            case 1 -> {
                boolean response = shop.sellItem(player,items.get(inputUser("Enter item's number:", i-1)));
                if (!response) {
                    System.out.println("you don't have money for buy this item");
                }
            }
            case 2 -> {
                break;
            }
        }
    }

    public Character createCharacter() {
        int playerType = inputUser("""
                Choose a Race:
                    0.Dwarf
                    1.Human
                    2.Giant
                """,3);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your Username:");
        String username = scanner.nextLine();

        return switch (playerType) {
            case 0 -> new Dwarf(username);
            case 1 -> new Human(username);
            case 2 -> new Giant(username);
            default -> throw new IllegalStateException("Unexpected value: " + playerType);
        };
    }
    private void moove(Character player)
    {
        int userPosition = inputUser("""
                Enter :
                        0 To moove down
                        1 To moove up
                        2 To moove right
                        3 to moove left
                """,4);
        if (userPosition <  2)
        {
            switch (userPosition) {
                case 0 -> player.setX(player.getX()+1);
                case 1 -> player.setX(player.getX()-1);
            }
        } else {
            switch (userPosition) {
                case 2 -> player.setY(player.getY()+1);
                case 3 -> player.setY(player.getY()-1);
            }

        }
    }
    private void launchFight(Character player) {
        Fight fight = new Fight();
        fight.addPlayer(player);

        while (player.getHp()>0 || fight.enemy().size() != 0) {
            fight.drawBoard();
            int choice = inputUser("""
                    Enter :
                            1 To moove
                            2 To use a recovery item
                    """, 2);
            switch (choice) {
                case 1 -> moove(player);
                case 2 -> useRecoveryItem(player);

            }
            fight.nextRound();
        }
        if (player.getHp()==0){
            player.setBank(player.getBank()+50);
            player.setExperience(false);

        }
        else {
            player.setBank(player.getBank()+150);
            player.setExperience(true);
        }

        player.setLifePoint((int) player.getMaxHealth());
        fight.killAllEnemy();

    }
    private void useRecoveryItem(Character player) {
        Vector<Item> recoveryItem = player.getRecoveryItem();
        int i = 0;
        for (Item item : recoveryItem) {
            System.out.format("""
                    %d. %s
                    """, i, item.getName());
            i++;
        }

        switch (inputUser("""
                0. Use an item
                1. Keep fighting
                """, 2)) {
            case 0 -> {
                int userChoice = inputUser("""
                        Choose an item:
                        """, recoveryItem.size()-1);
                player.useRecoveryItem((Inventory.RecoveryItem.RecoveryItem) recoveryItem.get(userChoice));
            }
            case 1 ->{}
        }

    }

    private Item getInventory() {
        Vector<Item> inventory = m_player.getInventory();
        int i = 0;
        for ( Item item : inventory) {
            System.out.format("""
                    %d. Name: %s
                    """, i, item.getName());
            i++;
        }
        int userChoice = inputUser(
                "Select an item to get his detailed information (enter 0 if you don't need any information):",
                inventory.size()
        );
        if (userChoice == 0) {
            return null;
        }
        return inventory.get(userChoice-1);
    }




    private void getItemDetails(Item item) {
        String itemType = "";
        switch (item.getType()) {
            case Weapon -> itemType = "Weapon";
            case RecoveryItem -> itemType = "Recovery Item";
        }
            System.out.format("""
            Item:
                Name: %s
                Type: %s
                Masse: %d
                Level: %d
                Price: %f
                """, item.getName(), itemType, item.getMasse(), item.getLevel(), item.getPrice());
        int userChoice = inputUser("""
                
                0.Use/Equip item
                1.Go back to menu""", 2);

        switch (userChoice) {
            case 0 -> {
                if (item.getType() == Weapon){
                    m_player.setWeapons((Weapons) item);
                } else {
                    m_player.useRecoveryItem((Inventory.RecoveryItem.RecoveryItem) item);
                }
            }
            case 1 -> {
            }
        }
    }

    private void getStats() {
        System.out.format("""
        Character:
            Name: %s
            Type: %s
            Life Point: %f
            Weapons: %s
            Strength: %d
            Agility: %d
            Defense: %f
            Level: %d
            Bank: %f
        """,m_player.getName(),m_player.getType(),m_player.getHp(),m_player.getMainWeapon().getName(),m_player.getStrength(),m_player.getAgility(),m_player.getDefense(),m_player.getLvl(),m_player.getBank());
        System.out.println("Press Enter to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }


    public int Menu() {
        return inputUser("""
                Enter your choice :
                   0.Open shop
                   1.Start a match
                   2.Open inventory
                   3.Display character info
                   4.Leave Game
                   
                Enter your number :""", 4);
    }

    public int inputUser(String question, int maxChoice)  {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        int userChoice = 0;
        System.out.println(question);
        String attempt = scanner.nextLine();

        while (!verify(attempt)) {
            if (!verify(attempt) || Integer.parseInt(attempt) > maxChoice - 1 || Integer.parseInt(attempt) < 0) {
                System.out.format("Please enter a valid number between 0 and %d:", maxChoice);
            }
            attempt = scanner.nextLine();
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
        return isNumeric(a);
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public void setCharacter(Character player) {
        this.m_player = player;
    }
}
