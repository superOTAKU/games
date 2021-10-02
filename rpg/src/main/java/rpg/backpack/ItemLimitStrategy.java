package rpg.backpack;

/**
 *  SPI 限制物品数的策略
 */
public interface ItemLimitStrategy {

    int maxCount(ItemTypeId itemType);

}
