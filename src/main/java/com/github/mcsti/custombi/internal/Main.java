package com.github.mcsti.custombi.internal;

import com.github.mcsti.custombi.api.items.ItemsModule;
import com.github.mcsti.custombi.internal.items.CustomItem;
import com.github.mcsti.custombi.internal.items.ItemsModuleImpl;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.stream.Collectors;

public final class Main extends JavaPlugin {
    
    private ItemsModule itemsModule;
    
    @Override
    public void onEnable() {
        itemsModule = new ItemsModuleImpl(this);
    }

    public ItemsModule getItemsModule() {
        return itemsModule;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
