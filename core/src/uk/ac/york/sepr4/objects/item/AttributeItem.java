package uk.ac.york.sepr4.objects.item;

import lombok.Data;
import uk.ac.york.sepr4.objects.entity.Attribute;

@Data
public class AttributeItem extends Item {

    Attribute attribute;
    Integer modifier;

    public AttributeItem(Integer id, String name, String lore, Attribute attribute, Integer modifier) {
        super(id, name, lore);

        this.attribute = attribute;
        this.modifier = modifier;
    }
}
