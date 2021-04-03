package com.github.mcsti.custombi;

import com.github.mcsti.custombi.items.CustomItem;
import com.github.mcsti.custombi.items.ItemsModule;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

import java.io.File;
import java.util.stream.Collectors;

public final class Main extends JavaPlugin {
    
    private ItemsModule itemsModule;
    
    @Override
    public void onEnable() {
        itemsModule = new ItemsModule(this);
        getCommand("items").setExecutor((commandSender, command, s, args) -> {
            if (!(commandSender instanceof Player)) {
                return false;
            }
            for (CustomItem customItem : itemsModule.getItems().stream()
                                                    .filter(item -> item.getId().equalsIgnoreCase(args[0]))
                                                    .collect(Collectors.toList())) {
                ((Player) commandSender).getInventory().addItem(customItem.getItemStack(1));
            }
            return true;
        });
        getCommand("items").setTabCompleter((commandSender, command, s, args) -> itemsModule.getItems()
                                                                                            .stream()
                                                                                            .map(CustomItem::getId)
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
