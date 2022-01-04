package Inventory.RecoveryItem;

public class IsraeliEmergencyBandage extends RecoveryItem {

    public IsraeliEmergencyBandage() {
        super(1000);
        super.setType(item_type.RecoveryItem);
        super.setPrice(250);
        super.setName("Israeli Emergency Bandage");
    }

    public String getName()
    {
        return m_Name;
    }
}
