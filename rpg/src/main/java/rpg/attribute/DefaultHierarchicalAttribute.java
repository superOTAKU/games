package rpg.attribute;

import java.util.*;

public class DefaultHierarchicalAttribute implements HierarchicalAttribute {
    protected Attribute source;
    protected Map<AttributeId, Attribute> childrenMap = new LinkedHashMap<>();


    @Override
    public AttributeId getId() {
        return source.getId();
    }

    @Override
    public double getHp() {
        double hp = source.getHp();
        for (var child : childrenMap.values()) {
            hp += child.getHp();
        }
        return hp;
    }

    @Override
    public double getAttack() {
        double attack = source.getAttack();
        for (var child : childrenMap.values()) {
            attack += child.getAttack();
        }
        return attack;
    }

    @Override
    public List<Attribute> getChildren() {
        return new ArrayList<>(childrenMap.values());
    }

    @Override
    public void addChild(Attribute child) {
        childrenMap.put(child.getId(), child);
    }

    @Override
    public void removeChild(AttributeId childId) {
        childrenMap.remove(childId);
    }

    @Override
    public Attribute getSourceAttribute() {
        return source;
    }

    @Override
    public void setSourceAttribute(Attribute attribute) {
        this.source = attribute;
    }
}
