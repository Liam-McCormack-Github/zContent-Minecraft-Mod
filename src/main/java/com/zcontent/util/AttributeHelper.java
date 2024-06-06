package com.zcontent.util;

import net.minecraft.entity.ai.attributes.IAttribute;

import java.util.UUID;

public class AttributeHelper {
    public final UUID id;
    public final String name;
    public final IAttribute attribute;

    public AttributeHelper(UUID id, String name, IAttribute attribute) {
        this.id = id;
        this.name = name;
        this.attribute = attribute;
        Reference.EnchAttributes.add(this);
    }
}
