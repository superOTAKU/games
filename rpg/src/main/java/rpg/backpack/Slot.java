package rpg.backpack;

import java.util.Optional;

/**
 * 背包格子SPI
 */
public interface Slot {

    /**
     * 格子是否被占用
     */
    boolean isEmpty();

    /**
     * 格子是否占满
     */
    boolean isFull();

    /**
     * 当前装的物品类型，也可能没有装物品
     */
    Optional<ItemTypeId> getItemType();

    /**
     * 当前物品数量
     */
    int getItemCount();

    /**
     * 物品限制策略，包括最大物品数等，可扩展
     */
    ItemLimitStrategy getItemLimitStrategy();

    void setItemLimitStrategy(ItemLimitStrategy strategy);

    //-----------------------操作格子------------------------

    /**
     * 添加物品到格子
     * @param type 物品类型
     * @param count 物品数量
     * @return 操作结果
     */
    ResultCode addItem(ItemTypeId type, int count);

    /**
     *  从格子扣除物品
     * @param count 扣除物品数
     * @return 操作结果
     */
    ResultCode reduceItem(int count);

}
