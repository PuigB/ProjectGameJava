package Inventory.RecoveryItem;

import Inventory.Item;

public abstract class RecoveryItem extends Item
{
    public RecoveryItem(int regeneration) {
        m_regeneration = regeneration;
    }
    private int m_regeneration;

    public int regeneration() {
        return m_regeneration;
    }
}
