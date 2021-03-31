package com.github.mcsti.custombi;

import com.github.mcsti.custombi.items.CustomItem;
import com.github.mcsti.custombi.items.ItemsModule;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

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
                                                    .filter(item -> item.getName().equalsIgnoreCase(args[0]))
                                                    .collect(Collectors.toList())) {
                ((Player) commandSender).getInventory().addItem(customItem.getItemStack(1));
            }
            return true;
        });
    }
    
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
