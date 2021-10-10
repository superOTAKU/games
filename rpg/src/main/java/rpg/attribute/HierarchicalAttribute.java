package rpg.attribute;

import java.util.List;

public interface HierarchicalAttribute extends AttributeProxy {

    List<Attribute> getChildren();

    void addChild(Attribute child);

    void removeChild(AttributeId childId);

}
