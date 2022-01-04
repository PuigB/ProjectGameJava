package Inventory.RecoveryItem;

import Inventory.Item.item_type;

public class Bandages extends RecoveryItem {

    public Bandages() {
        super(50);
        super.setType(item_type.RecoveryItem);
        super.setPrice(100);
        super.setName("Bandage");
    }

    public String getName()
    {
        return m_Name;
    }
    //actual health +50;
}
