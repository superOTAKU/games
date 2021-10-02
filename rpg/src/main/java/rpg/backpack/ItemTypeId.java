package rpg.backpack;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemTypeId {
    private final String id;

    public static ItemTypeId of(String id) {
        return new ItemTypeId(id);
    }
}
