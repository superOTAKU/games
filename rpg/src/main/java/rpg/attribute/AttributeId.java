package rpg.attribute;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttributeId {
    //属性层
    private AttributeLayer layer;
    //外部实体id
    private String externalId;

    public static AttributeId valueOf(AttributeLayer layer, String externalId) {
        return new AttributeId(layer, externalId);
    }

}
