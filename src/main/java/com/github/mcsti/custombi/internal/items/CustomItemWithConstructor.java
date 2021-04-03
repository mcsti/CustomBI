package com.github.mcsti.custombi.internal.items;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;

import javax.annotation.Nullable;
import java.util.Locale;

public abstract class CustomItemWithConstructor implements CustomItem {
    
    private final String name;
    private final String[] lores;
    private final int maxStackSize;
    private final int maxDurability;
    private final int customModelData;
    @Nullable private final Material material;
    @Nullable private final NamespacedKey namespace;
    
    public CustomItemWithConstructor(
            int customModelData, int maxStackSize, int maxDurability, @Nullable Material material,
            @Nullable NamespacedKey namespace,
            String name,
            String... lores
    ) {
        this.customModelData = customModelData;
        this.maxStackSize = maxStackSize;
        this.maxDurability = maxDurability;
        this.material = material;
        this.namespace = namespace;
        this.name = name;
        this.lores = lores;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public NamespacedKey getNamespace() {
        return namespace != null ? namespace : NamespacedKey
                .fromString("custombi:"+getName().replaceAll(" ", "_").toLowerCase(Locale.ROOT));
    }
    
    @Override
    public String[] getLores() {
        return lores;
    }
    
    @Override
    public int getMaxStackSize() {
        return maxStackSize;
    }
    
    @Override
    public int getMaxDurability() {
        return maxDurability;
    }
    
    @Nullable
    @Override
    public Material getMaterial() {
        return material;
    }
    
    @Override
    public int getCustomModelData() {
        return customModelData;
    }
}
