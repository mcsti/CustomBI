package com.github.mcsti.custombi.internal.items;

import com.github.mcsti.custombi.internal.Main;
import com.github.mcsti.custombi.api.items.ItemsModule;
import org.bukkit.NamespacedKey;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;
import java.util.stream.Collectors;

public class ItemsModuleImpl implements ItemsModule {
    
    private final List<CustomItem> items;
    private final ItemListener     listener;
    
    public ItemsModuleImpl(Main plugin) {
        
        this.items = new ArrayList<>();
        
        this.listener = new ItemListener(this);
        plugin.getServer().getPluginManager().registerEvents(listener, plugin);
        setupCommand(plugin);
    }
    
    @Override
    public void loadItems(CustomItem... items) {
        this.items.addAll(Arrays.asList(items));
    }
    
    @Override
    public List<CustomItem> getItems() {
        return Collections.unmodifiableList(items);
    }
    
    @Override
    public Optional<CustomItem> getItem(NamespacedKey namespace) {
        return getItems()
                .stream()
                .filter(item -> item.getNamespace().equals(namespace))
                .findFirst();
    }
    
    private void setupCommand(JavaPlugin plugin) {
        PluginCommand command = plugin.getCommand("items");
        if (command == null) {
            return;
        }
        command.setExecutor((commandSender, cmd, s, args) -> {
            if (!(commandSender instanceof Player)) {
                return false;
            }
            for (CustomItem customItem : getItems().stream()
                                                   .filter(item -> item.getNamespace().toString().equalsIgnoreCase(args[0]))
                                                   .collect(Collectors.toList())) {
                ((Player) commandSender).getInventory().addItem(customItem.getItemStack(1));
            }
            return true;
        });
        command.setTabCompleter((commandSender, cmd, s, args) -> getItems()
                .stream()
                .map(CustomItem::getNamespace)
                .map(NamespacedKey::toString)
                .collect(Collectors.toList()));
    }
}
