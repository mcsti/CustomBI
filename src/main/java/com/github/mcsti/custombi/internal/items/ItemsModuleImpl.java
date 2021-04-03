package com.github.mcsti.custombi.internal.items;

import com.github.mcsti.custombi.internal.Main;
import com.github.mcsti.custombi.api.items.ItemsModule;
import org.bukkit.NamespacedKey;

import java.util.*;

public class ItemsModuleImpl implements ItemsModule {
    
    private final List<CustomItem> items;
    private final ItemListener     listener;
    
    public ItemsModuleImpl(Main plugin) {
        
        this.items = new ArrayList<>();
        
        this.listener = new ItemListener(this);
        plugin.getServer().getPluginManager().registerEvents(listener, plugin);
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
}
