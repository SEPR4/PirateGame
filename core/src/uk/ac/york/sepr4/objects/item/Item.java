package uk.ac.york.sepr4.objects.item;

import lombok.Data;
import uk.ac.york.sepr4.objects.entity.Attribute;

@Data
public class Item {

    String name;
    String lore;
    //String sprite

    public Item (String name, String lore) {
        this.name = name;
        this.lore = lore;
    }

    public

}
