package rpg.attribute;

/**
 * 最基本的属性数据单元
 */
public class AttributeData implements MutableAttribute {
    private AttributeId id;
    private double hp;
    private double attack;

    @Override
    public AttributeId getId() {
        return id;
    }

    @Override
    public double getHp() {
        return hp;
    }

    @Override
    public double getAttack() {
        return attack;
    }

    @Override
    public void setId(AttributeId id) {
        this.id = id;
    }

    @Override
    public void setHp(double hp) {
        this.hp = hp;
    }

    @Override
    public void setAttack(double attack) {
        this.attack = attack;
    }

}
