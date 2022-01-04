package Inventory.RecoveryItem;

public class HemostaticPowder extends RecoveryItem {

    private float m_Price = 100;

    public HemostaticPowder () {
        super(75);
        super.setType(item_type.RecoveryItem);
        super.setName("Hemostatic Powder");
        super.setPrice(125);
    }
}
