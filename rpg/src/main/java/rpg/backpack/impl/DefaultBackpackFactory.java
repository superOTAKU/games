package rpg.backpack.impl;

import rpg.backpack.Backpack;
import rpg.backpack.BackpackFactory;
import rpg.backpack.Slot;

import java.util.ArrayList;
import java.util.List;

public class DefaultBackpackFactory implements BackpackFactory {
    private final int initSize;

    public DefaultBackpackFactory(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("initSize must greater than zero!");
        }
        this.initSize = initSize;
    }

    @Override
    public Backpack createBackpack() {
        DefaultItemLimitStrategy strategy = new DefaultItemLimitStrategy();
        List<Slot> slots = new ArrayList<>();
        for (int i = 0; i < initSize; i++) {
            slots.add(new DefaultSlot(strategy, null, 0));
        }
        return new DefaultBackpack(slots, strategy);
    }

}
