package com.github.mcsti.custombi.items;

import com.github.mcsti.tuples.Pair;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ItemListener implements Listener {
    
    private final ItemsModule module;
    
    public ItemListener(ItemsModule module) {
        this.module = module;
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onItemDespawn(ItemDespawnEvent event) {
        getCustomItemStream(event.getEntity().getItemStack())
                .forEach(customItem -> event.setCancelled(customItem.onDespawn(event)));
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onItemMerge(ItemMergeEvent event) {
        getCustomItemStream(event.getEntity().getItemStack())
                .forEach(customItem -> event.setCancelled(customItem.onMerge(event)));
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onItemSpawn(ItemSpawnEvent event) {
        getCustomItemStream(event.getEntity().getItemStack())
                .forEach(customItem -> event.setCancelled(customItem.onSpawn(event)));
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onBlockDropItem(BlockDropItemEvent event) {
        for (Item item : event.getItems()) {
            getCustomItemStream(item.getItemStack())
                    .forEach(customItem -> event.setCancelled(customItem.onBlockDrop(event)));
        }
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onCraftItem(CraftItemEvent event) {
        getCustomItemStream(event.getRecipe().getResult())
                .forEach(customItem -> event.setCancelled(customItem.onCraft(event)));
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onEnchantItem(EnchantItemEvent event) {
        getCustomItemStream(event.getItem())
                .forEach(customItem -> event.setCancelled(customItem.onEnchant(event)));
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onEntityPickupItem(EntityPickupItemEvent event) {
        getCustomItemStream(event.getItem().getItemStack())
                .forEach(customItem -> event.setCancelled(customItem.onEntityPickup(event)));
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        getCustomItemStream(event.getItemDrop().getItemStack())
                .forEach(customItem -> event.setCancelled(customItem.onPlayerDrop(event)));
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onEntityDropItem(EntityDropItemEvent event) {
        getCustomItemStream(event.getItemDrop().getItemStack())
                .forEach(customItem -> event.setCancelled(customItem.onEntityDrop(event)));
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onInventoryMoveItem(InventoryMoveItemEvent event) {
        getCustomItemStream(event.getItem())
                .forEach(customItem -> event.setCancelled(customItem.onInventoryMove(event)));
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onInventoryPickupItem(InventoryPickupItemEvent event) {
        getCustomItemStream(event.getItem().getItemStack())
                .forEach(customItem -> event.setCancelled(customItem.onInventoryPickup(event)));
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onPlayerItemBreak(PlayerItemBreakEvent event) {
        getCustomItemStream(event.getBrokenItem())
                .forEach(customItem -> customItem.onPlayerBreak(event));
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onPlayerItemConsume(PlayerItemConsumeEvent event) {
        getCustomItemStream(event.getItem())
                .forEach(customItem -> event.setCancelled(customItem.onPlayerConsume(event)));
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onPlayerItemDamage(PlayerItemDamageEvent event) {
        getCustomItemStream(event.getItem())
                .forEach(customItem -> event.setCancelled(customItem.onPlayerDamage(event)));
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        getCustomItemStream(event.getPlayer().getItemOnCursor())
                .forEach(customItem -> event.setCancelled(customItem.onPlayerHeld(event)));
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onPlayerItemMend(PlayerItemMendEvent event) {
        getCustomItemStream(event.getItem())
                .forEach(customItem -> event.setCancelled(customItem.onPlayerMend(event)));
    }
    
    @SuppressWarnings("deprecation") // Support deprecation, will be removed in the future
    @EventHandler(ignoreCancelled = true)
    public void onPlayerPickupItem(PlayerPickupItemEvent event) {
        getCustomItemStream(event.getItem().getItemStack())
                .forEach(customItem -> event.setCancelled(customItem.onPlayerPickup(event)));
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onPlayerSwapHandItems(PlayerSwapHandItemsEvent event) {
        getCustomItemStream(event.getMainHandItem())
                .forEach(customItem -> event.setCancelled(customItem.onPlayerSwapHand(event)));
        getCustomItemStream(event.getOffHandItem())
                .forEach(customItem -> event.setCancelled(customItem.onPlayerSwapHand(event)));
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onPrepareItemCraft(PrepareItemCraftEvent event) {
        List<CustomItem> remainingItems = null;
        ItemStack last = null;
        for (CustomItem item : remainingItems == null || remainingItems.isEmpty() ? module.getItems() : remainingItems) {
            List<CustomItem> list = new ArrayList<>();
            for (ItemStack itemStack : event.getInventory().getMatrix()) {
                if (item.getUnshapedCraft() != null) {
                    for (ItemStack stack : item.getUnshapedCraft().getLeft()) {
                        if (itemStack != null && stack != null && itemStack.isSimilar(stack)) {
                            list.add(item);
                            last = item.getItemStack(item.getUnshapedCraft().getRight());
                        }
                    }
                }
            }
            if (item.getShapedCraft() != null) {
                boolean good = true;
                for (int i = 0; i < item.getShapedCraft().getLeft().length && good; i++) {
                    ItemStack itemStack = event.getInventory().getMatrix()[i] != null ? event.getInventory().getMatrix()[i] : new ItemStack(Material.AIR);
                    ItemStack stack = item.getShapedCraft().getLeft()[i] != null ? item.getShapedCraft().getLeft()[i] : new ItemStack(Material.AIR);
                    good = itemStack.isSimilar(stack);
                }
                if (good) {
                    list.add(item);
                    last = item.getItemStack(item.getShapedCraft().getRight());
                }
            }
            remainingItems = list;
        }
        if (last != null) {
            event.getInventory().setResult(last);
        }

        if (event.getRecipe() == null) {
            return;
        }
        getCustomItemStream(event.getRecipe().getResult())
                .forEach(customItem -> customItem.onPrepareCraft(event));
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onPrepareItemEnchant(PrepareItemEnchantEvent event) {
        getCustomItemStream(event.getItem())
                .forEach(customItem -> event.setCancelled(customItem.onPrepareEnchantEvent(event)));
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent event) {
        PlayerInventory inventory = event.getPlayer().getInventory();
        if (inventory.getItemInMainHand().getType() == Material.AIR && inventory.getItemInOffHand().getType() == Material.AIR) {
            return;
        }
        getCustomItemStream(inventory.getItemInMainHand().getType() != Material.AIR ? inventory.getItemInMainHand() : inventory.getItemInOffHand())
                .forEach(customItem -> event.setCancelled(customItem.onPlayerInteractAtEntity(event)));
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        PlayerInventory inventory = event.getPlayer().getInventory();
        if (inventory.getItemInMainHand().getType() == Material.AIR && inventory.getItemInOffHand().getType() == Material.AIR) {
            return;
        }
        getCustomItemStream(inventory.getItemInMainHand().getType() != Material.AIR ? inventory.getItemInMainHand() : inventory.getItemInOffHand())
                .forEach(customItem -> event.setCancelled(customItem.onPlayerInteractEntity(event)));
    }
    
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        PlayerInventory inventory = event.getPlayer().getInventory();
        if (inventory.getItemInMainHand().getType() == Material.AIR && inventory.getItemInOffHand().getType() == Material.AIR) {
            return;
        }
        getCustomItemStream(inventory.getItemInMainHand().getType() != Material.AIR ? inventory.getItemInMainHand() : inventory.getItemInOffHand())
                .forEach(customItem -> event.setCancelled(customItem.onPlayerInteract(event)));
    }
    
    private Stream<CustomItem> getCustomItemStream(ItemStack itemStack) {
        return module.getItems().stream()
                                   .filter(custom -> custom.getId().equals(getCustomItemId(itemStack)));
                                   // .map(CustomItemStack::getCustomItem);
    }
    
    private String getCustomItemId(ItemStack item) {
        net.minecraft.server.v1_16_R3.ItemStack nms = CraftItemStack.asNMSCopy(item);
        return nms.hasTag() &&
                nms.getTag() != null &&
                nms.getTag().hasKey("id") ?
                nms.getTag().getString("id") :
                "";
    }
}
