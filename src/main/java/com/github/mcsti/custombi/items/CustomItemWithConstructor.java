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
    
    private final ItemsModule module;
    
    public CustomItemWithConstructor(
            ItemsModule module, int customModelData, String name, int maxStackSize, int maxDurability,
            @Nullable Material material,
            String... lores
    ) {
        this.module = module;
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
