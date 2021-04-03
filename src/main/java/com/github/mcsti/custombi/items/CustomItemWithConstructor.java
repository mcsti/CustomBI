package com.github.mcsti.custombi.items;

import org.bukkit.Material;

import javax.annotation.Nullable;

public abstract class CustomItemWithConstructor implements CustomItem {
    
    private final String name;
    private final String[] lores;
    private final int maxStackSize;
    private final int maxDurability;
    private final int customModelData;
    @Nullable
    private final Material material;
    
    public CustomItemWithConstructor(
            int customModelData, int maxStackSize, int maxDurability, @Nullable Material material,
            String name,
            String... lores
    ) {
        this.customModelData = customModelData;
        this.name = name;
        this.maxStackSize = maxStackSize;
        this.maxDurability = maxDurability;
        this.material = material;
        this.lores = lores;
    }
    
    @Override
    public String getName() {
        return name;
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
