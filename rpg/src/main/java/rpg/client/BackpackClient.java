package rpg.client;

import rpg.backpack.Backpack;
import rpg.backpack.ItemTypeId;
import rpg.backpack.ResultCode;
import rpg.backpack.Slot;
import rpg.backpack.impl.DefaultBackpackFactory;

public class BackpackClient {
    public static void main(String[] args) {
        DefaultBackpackFactory backpackFactory = new DefaultBackpackFactory(50);
        Backpack backpack = backpackFactory.createBackpack();
        System.out.printf("backpack size is %s%n", backpack.getSlotCount());
        Slot slot = backpack.getSlot(10);
        ResultCode addItemResult = slot.addItem(ItemTypeId.of("magicBook"), 8);
        System.out.printf("add 8 magicBook to slot 10, result is %s%n", addItemResult);
        addItemResult = slot.addItem(ItemTypeId.of("diamond"), 5);
        System.out.printf("add 5 diamond to slot 10, result is %s%n", addItemResult);
        addItemResult = slot.addItem(ItemTypeId.of("magicBook"), 5);
        System.out.printf("add 5 magicBook to slot 10, result is %s%n", addItemResult);
        ResultCode reduceItemResult = slot.reduceItem(5);
        System.out.printf("reduce 5 item from slot 10, result is %s%n", reduceItemResult);
        System.out.printf("slot 10 item is %s, count is %s%n", slot.getItemType(), slot.getItemCount());
    }
}
