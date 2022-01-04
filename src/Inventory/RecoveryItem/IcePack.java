package Inventory.RecoveryItem;

public class IcePack extends RecoveryItem {

    public IcePack() {
        super(25);
        super.setType(item_type.RecoveryItem);
        super.setPrice(40);
        super.setName("Ice Pack");
    }

    public String getName()
    {
        return m_Name;
    }

}
