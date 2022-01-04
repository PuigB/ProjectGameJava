package Inventory.RecoveryItem;

public class Oranges extends RecoveryItem {

    public Oranges() {
        super(15);
        super.setType(item_type.RecoveryItem);
        super.setPrice(20);
        super.setName("Orange");
    }

    public void addHealth(int health) {

    }

    public String getName()
    {
        return m_Name;
    }
}
