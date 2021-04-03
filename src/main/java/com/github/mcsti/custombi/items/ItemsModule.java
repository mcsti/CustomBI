package com.github.mcsti.custombi.items;

import com.github.mcsti.custombi.Main;
import com.github.mcsti.tuples.Pair;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemsModule {
    
    private final List<CustomItem> items;
    private final ItemListener     listener;
    
    public ItemsModule(Main plugin) {
        
        this.items = new ArrayList<>();
        
        this.listener = new ItemListener(this);
        plugin.getServer().getPluginManager().registerEvents(listener, plugin);
    }
    
    public ItemListener getListener() {
        return listener;
    }
    
    public void loadItems(CustomItem... items) {
        this.items.addAll(Arrays.asList(items));
    }
    
    public List<CustomItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}
