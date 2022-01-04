package Inventory.RecoveryItem;

import Inventory.Item;

public abstract class RecoveryItem extends Item
{
    public RecoveryItem(float regeneration) {
        m_regeneration = regeneration;
    }
    private float m_regeneration;

    public float regeneration() {
        return m_regeneration;
    }
}
