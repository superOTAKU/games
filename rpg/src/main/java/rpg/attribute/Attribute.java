package rpg.attribute;

/**
 * 属性
 *
 * RPG属性需求：
 *  RPG中人物，装备等等...都有属性。
 *
 *  1.正常理解，属性肯定是一颗树
 *  2.难点是，经常会出现需求，需要添加Buff，Buff会影响属性的计算
 *      Buff的添加要足够灵活，能够轻松添加和移除，能够控制影响的范围
 *
 *      例子：
 *          主角完成了特殊任务，所有装备效果增益5%
 *
 *  设计模式：组合模式，装饰器模式，buff的设计着重注意
 *
 */
public interface Attribute {

    /**
     * 通过 layer + 外部标识，唯一定位attribute
     */
    AttributeId getId();

    double getHp();

    double getAttack();

}
