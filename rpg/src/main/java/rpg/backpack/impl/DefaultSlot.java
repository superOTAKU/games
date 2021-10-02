package rpg.backpack.impl;

import rpg.backpack.ItemLimitStrategy;
import rpg.backpack.ItemTypeId;
import rpg.backpack.ResultCode;
import rpg.backpack.Slot;

import java.util.Objects;
import java.util.Optional;

class DefaultSlot implements Slot {
    private ItemTypeId type;
    private int count;
    private ItemLimitStrategy strategy;

    DefaultSlot(ItemLimitStrategy strategy, ItemTypeId type, int count) {
        this.strategy = Objects.requireNonNull(strategy);
        this.type = type;
        this.count = count;
    }

    @Override
    public boolean isEmpty() {
        return type == null;
    }

    @Override
    public boolean isFull() {
        if (isEmpty()) {
            return false;
        }
        return getItemLimitStrategy().maxCount(type) == count;
    }

    @Override
    public Optional<ItemTypeId> getItemType() {
        return Optional.ofNullable(type);
    }

    @Override
    public int getItemCount() {
        return count;
    }

    @Override
    public ItemLimitStrategy getItemLimitStrategy() {
        return strategy;
    }

    @Override
    public void setItemLimitStrategy(ItemLimitStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public ResultCode addItem(ItemTypeId type, int count) {
        if (count <= 0) {
            //离大普的异常直接抛出
            throw new IllegalArgumentException("count must greater than 0");
        }
        if (this.type != null) {
            if (!this.type.equals(type)) {
                return ResultCode.SLOT_ITEM_TYPE_NOT_MATCH;
            }
        }
        if (isFull()) {
            return ResultCode.SLOT_FULL;
        }
        int maxCount = strategy.maxCount(type);
        if (this.count + count > maxCount) {
            return ResultCode.SLOT_CAPACITY_NOT_ENOUGH;
        }
        this.count += count;
        if (this.type == null) {
            this.type = type;
        }
        return ResultCode.OK;
    }

    @Override
    public ResultCode reduceItem(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("count must greater than 0");
        }
        if (isEmpty()) {
            return ResultCode.SLOT_EMPTY;
        }
        if (this.count < count) {
            return ResultCode.SLOT_ITEM_NOT_ENOUGH;
        }
        this.count -= count;
        if (this.count == 0) {
            this.type = null;
        }
        return ResultCode.OK;
    }

}
