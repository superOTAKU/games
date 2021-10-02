package rpg.backpack.impl;

import rpg.backpack.Backpack;
import rpg.backpack.ItemLimitStrategy;
import rpg.backpack.Slot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DefaultBackpack implements Backpack {
    protected List<Slot> slots;
    protected ItemLimitStrategy itemLimitStrategy;

    DefaultBackpack(List<Slot> slots, ItemLimitStrategy itemLimitStrategy) {
        this.slots = new ArrayList<>(slots);
        this.itemLimitStrategy = itemLimitStrategy;
        this.slots.forEach(slot -> slot.setItemLimitStrategy(itemLimitStrategy));
    }

    @Override
    public Slot getSlot(int index) {
        return slots.get(index);
    }

    @Override
    public List<Slot> getSlots() {
        return Collections.unmodifiableList(slots);
    }

    @Override
    public int getSlotCount() {
        return slots.size();
    }

    @Override
    public void setSlotCount(int count) {
        if (count < this.getSlotCount()) {
            throw new IllegalArgumentException("you can just increase slot count!");
        }
        List<Slot> newSlots = new ArrayList<>(count);
        newSlots.addAll(slots);
        for (int i = slots.size(); i < count; i++) {
            newSlots.add(newSlot());
        }
        this.slots = newSlots;
    }

    @Override
    public ItemLimitStrategy getItemLimitStrategy() {
        return itemLimitStrategy;
    }

    @Override
    public void setItemLimitStrategy(ItemLimitStrategy itemLimitStrategy) {
        this.itemLimitStrategy = itemLimitStrategy;
    }

    protected Slot newSlot() {
        return new DefaultSlot(itemLimitStrategy, null, 0);
    }
}
