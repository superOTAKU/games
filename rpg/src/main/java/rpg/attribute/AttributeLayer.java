package rpg.attribute;

/**
 * 属性层
 */
public enum AttributeLayer {
    ROLE(1, "主角", null),
    PARTNER(2, "伙伴", ROLE),
    ROLE_EQUIP(3, "主角装备", ROLE),
    PARTNER_EQUIP(4, "伙伴装备", PARTNER),
    ;
    private Integer id;
    private String desc;
    private AttributeLayer parent;

    AttributeLayer(Integer id, String desc, AttributeLayer parent) {
        this.id = id;
        this.desc = desc;
        this.parent = parent;
    }

    public Integer getId() {
        return id;
    }

    public AttributeLayer getParent() {
        return parent;
    }
}
