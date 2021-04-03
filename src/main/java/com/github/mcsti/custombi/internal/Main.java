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
        getCommand("items").setExecutor((commandSender, command, s, args) -> {
            if (!(commandSender instanceof Player)) {
                return false;
            }
            for (CustomItem customItem : itemsModule.getItems().stream()
                                                    .filter(item -> item.getNamespace().toString().equalsIgnoreCase(args[0]))
                                                    .collect(Collectors.toList())) {
                ((Player) commandSender).getInventory().addItem(customItem.getItemStack(1));
            }
            return true;
        });
        getCommand("items").setTabCompleter((commandSender, command, s, args) -> itemsModule.getItems()
                                                                                            .stream()
                                                                                            .map(CustomItem::getNamespace)
                                                                                            .map(NamespacedKey::toString)
                                                                                            .collect(Collectors.toList()));
    }

    public ItemsModule getItemsModule() {
        return itemsModule;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
