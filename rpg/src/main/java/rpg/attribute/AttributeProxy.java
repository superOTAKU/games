package rpg.attribute;

public interface AttributeProxy extends Attribute {

    Attribute getSourceAttribute();

    void setSourceAttribute(Attribute attribute);

}
