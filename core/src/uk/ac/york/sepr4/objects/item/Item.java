package uk.ac.york.sepr4.objects.item;

import lombok.Data;

@Data
public abstract class Item {

    String name;
    String lore;
    //String sprite

    public Item (String name, String lore) {
        this.name = name;
        this.lore = lore;
    }

}
