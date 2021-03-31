package com.github.mcsti.custombi.items;

import com.github.mcsti.tuples.Pair;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemsModule {
    
    private final List<CustomItem> items;
    private final ItemListener     listener;
    
    public ItemsModule(Plugin plugin) {
        
        this.items = new ArrayList<>();
        
        this.listener = new ItemListener(this);
        Bukkit.getPluginManager().registerEvents(listener, plugin);

        loadItems(
                new CustomItemWithConstructor(this, 0, "Master Sword", 1, 1, Material.NETHERITE_SWORD, "Sorry") {
                    @Override
                    public ItemStack getItemStack(int amount) {
                        ItemStack itemStack = super.getItemStack(amount);
                        itemStack.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 500);
                        return itemStack;
                    }

                    @Override
                    public Pair<ItemStack[], Integer> getShapedCraft() {
                        return new Pair<>(
                                new ItemStack[]{
                                        null, new ItemStack(Material.NETHERITE_INGOT), null,
                                        null, new ItemStack(Material.NETHERITE_INGOT), null,
                                        null, new ItemStack(Material.NETHERITE_SWORD), null,
                                }, 1
                        );
                    }

                    @Override
                    public boolean onPlayerDrop(PlayerDropItemEvent event) {
                        event.getPlayer().sendMessage("You can't leave me :]");
                        return true;
                    }
                }
        );
    }
    
    public void loadItems(CustomItem... items) {
        this.items.addAll(Arrays.asList(items));
    }
    
    public List<CustomItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}
