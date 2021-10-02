package rpg.backpack;

public enum ResultCode {
    OK(1, "ok"),
    SLOT_ITEM_TYPE_NOT_MATCH(2, "slot item type not match"),
    SLOT_FULL(3, "slot is full"),
    SLOT_EMPTY(4, "slot is empty"),
    SLOT_CAPACITY_NOT_ENOUGH(5, "slot capacity not enough"),
    SLOT_ITEM_NOT_ENOUGH(6, "slot item not enough"),
    ;
    private final int code;
    private final String msg;

    private ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
