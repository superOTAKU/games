package rpg.attribute;

/**
 * 可变的属性
 */
public interface MutableAttribute extends Attribute {

    void setId(AttributeId id);

    void setHp(double hp);

    void setAttack(double attack);

}
