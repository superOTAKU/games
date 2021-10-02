package rpg.backpack.impl;

import rpg.backpack.ItemLimitStrategy;
import rpg.backpack.ItemTypeId;

/**
 * 最简单的策略，每个格子限定10个物品，无论类型
 */
class DefaultItemLimitStrategy implements ItemLimitStrategy {
    @Override
    public int maxCount(ItemTypeId itemType) {
        return 10;
    }
}
