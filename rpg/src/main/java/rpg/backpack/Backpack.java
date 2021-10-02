package rpg.backpack;

import java.util.List;

/**
 * 背包SPI
 *
 * RPG背包的需求：
 * 1. 背包有很多格子
 * 2. 格子可以装物品
 * 3. 格子对每种物品有对应的存放策略，比如一个格子可存放物品A 50个，只能存放物品B 10个
 */
public interface Backpack {

    /**
     * 获取对应位置的格子
     * @param index 格子下标
     * @return 格子
     */
    Slot getSlot(int index);

    /**
     * 获取所有的格子
     */
    List<Slot> getSlots();

    /**
     * 获取总格子数
     */
    int getSlotCount();

    /**
     * 设置新的格子数，比如扩容
     */
    void setSlotCount(int count);

    ItemLimitStrategy getItemLimitStrategy();

    void setItemLimitStrategy(ItemLimitStrategy itemLimitStrategy);

}
