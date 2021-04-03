package com.github.mcsti.custombi.internal.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Constant {
    
    public static final CustomItem[] DEBUG_ITEMS = {
            new CustomItemWithConstructor(
                    0,
                    1,
                    1,
                    Material.STICK,
                    null,
                    "Drop debug"
            ) {
                @Override
                public ItemStack getItemStack(int amount) {
                    return debugTool(super.getItemStack(amount));
                }
    
                @Override
                public boolean onPlayerDrop(PlayerDropItemEvent event) {
                    Bukkit.broadcastMessage("Drop Event triggered");
                    return false;
                }
            },
            new CustomItemWithConstructor(
                    0,
                    1,
                    1,
                    Material.STICK,
                    null,
                    "Despawn debug"
            ) {
                @Override
                public ItemStack getItemStack(int amount) {
                    return debugTool(super.getItemStack(amount));
                }
    
                @Override
                public boolean onDespawn(ItemDespawnEvent event) {
                    Bukkit.broadcastMessage("Despawn event triggered");
                    return false;
                }
            },
            new CustomItemWithConstructor(
                    0,
                    1,
                    1,
                    Material.STICK,
                    null,
                    "Merge debug"
            ) {
                @Override
                public ItemStack getItemStack(int amount) {
                    return debugTool(super.getItemStack(amount));
                }
            
                @Override
                public boolean onMerge(ItemMergeEvent event) {
                    Bukkit.broadcastMessage("Merge event triggered");
                    return false;
                }
            },
            new CustomItemWithConstructor(
                    0,
                    1,
                    1,
                    Material.STICK,
                    null,
                    "Spawn debug"
            ) {
                @Override
                public ItemStack getItemStack(int amount) {
                    return debugTool(super.getItemStack(amount));
                }
            
                @Override
                public boolean onSpawn(ItemSpawnEvent event) {
                    Bukkit.broadcastMessage("Spawn event triggered");
                    return false;
                }
            },
            new CustomItemWithConstructor(
                    0,
                    1,
                    1,
                    Material.STICK,
                    null,
                    "Block drop debug"
            ) {
                @Override
                public ItemStack getItemStack(int amount) {
                    return debugTool(super.getItemStack(amount));
                }
            
                @Override
                public boolean onBlockDrop(BlockDropItemEvent event) {
                    Bukkit.broadcastMessage("Block drop event triggered");
                    return false;
                }
            },
            new CustomItemWithConstructor(
                    0,
                    1,
                    1,
                    Material.STICK,
                    null,
                    "Craft item debug"
            ) {
                @Override
                public ItemStack getItemStack(int amount) {
                    return debugTool(super.getItemStack(amount));
                }

                @Override
                public boolean onCraft(CraftItemEvent event) {
                    Bukkit.broadcastMessage("Craft item event triggered");
                    return false;
                }
            },
            new CustomItemWithConstructor(
                    0,
                    1,
                    1,
                    Material.STICK,
                    null,
                    "Enchant item debug"
            ) {
                @Override
                public ItemStack getItemStack(int amount) {
                    return debugTool(super.getItemStack(amount));
                }
    
                @Override
                public boolean onEnchant(EnchantItemEvent event) {
                    Bukkit.broadcastMessage("Enchant item event triggered");
                    return false;
                }
            },
            new CustomItemWithConstructor(
                    0,
                    1,
                    1,
                    Material.STICK,
                    null,
                    "Entity pickup item debug"
            ) {
                @Override
                public ItemStack getItemStack(int amount) {
                    return debugTool(super.getItemStack(amount));
                }
    
                @Override
                public boolean onEntityPickup(EntityPickupItemEvent event) {
                    Bukkit.broadcastMessage("Entity pickup item event triggered");
                    return false;
                }
            },
            new CustomItemWithConstructor(
                    0,
                    1,
                    1,
                    Material.STICK,
                    null,
                    "Entity drop debug"
            ) {
                @Override
                public ItemStack getItemStack(int amount) {
                    return debugTool(super.getItemStack(amount));
                }
    
                @Override
                public boolean onEntityDrop(EntityDropItemEvent event) {
                    Bukkit.broadcastMessage("Entity drop item event triggered");
                    return false;
                }
            },
            new CustomItemWithConstructor(
                    0,
                    1,
                    1,
                    Material.STICK,
                    null,
                    "Inventory move debug"
            ) {
                @Override
                public ItemStack getItemStack(int amount) {
                    return debugTool(super.getItemStack(amount));
                }
    
                @Override
                public boolean onInventoryMove(InventoryMoveItemEvent event) {
                    Bukkit.broadcastMessage("Inventory move item event triggered");
                    return false;
                }
            },
            new CustomItemWithConstructor(
                    0,
                    1,
                    1,
                    Material.STICK,
                    null,
                    "Inventory pickup debug"
            ) {
                @Override
                public ItemStack getItemStack(int amount) {
                    return debugTool(super.getItemStack(amount));
                }
    
                @Override
                public boolean onInventoryPickup(InventoryPickupItemEvent event) {
                    Bukkit.broadcastMessage("Inventory pickup item event triggered");
                    return false;
                }
            },
            new CustomItemWithConstructor(
                    0,
                    1,
                    1,
                    Material.STICK,
                    null,
                    "Player item break debug"
            ) {
                @Override
                public ItemStack getItemStack(int amount) {
                    return debugTool(super.getItemStack(amount));
                }
    
                @Override
                public void onPlayerBreak(PlayerItemBreakEvent event) {
                    Bukkit.broadcastMessage("Player item break event triggered");
                }
            },
            new CustomItemWithConstructor(
                    0,
                    1,
                    1,
                    Material.STICK,
                    null,
                    "Player item consume debug"
            ) {
                @Override
                public ItemStack getItemStack(int amount) {
                    return debugTool(super.getItemStack(amount));
                }
    
                @Override
                public boolean onPlayerConsume(PlayerItemConsumeEvent event) {
                    Bukkit.broadcastMessage("Player item consume event triggered");
                    return false;
                }
            },
            new CustomItemWithConstructor(
                    0,
                    1,
                    1,
                    Material.STICK,
                    null,
                    "Item damage debug"
            ) {
                @Override
                public ItemStack getItemStack(int amount) {
                    return debugTool(super.getItemStack(amount));
                }
    
                @Override
                public boolean onPlayerDamage(PlayerItemDamageEvent event) {
                    Bukkit.broadcastMessage("Player item damage event triggered");
                    return false;
                }
            },
            new CustomItemWithConstructor(
                    0,
                    1,
                    1,
                    Material.STICK,
                    null,
                    "Item held debug"
            ) {
                @Override
                public ItemStack getItemStack(int amount) {
                    return debugTool(super.getItemStack(amount));
                }
    
                @Override
                public boolean onPlayerHeld(PlayerItemHeldEvent event) {
                    Bukkit.broadcastMessage("Player item held event triggered");
                    return false;
                }
            },
            new CustomItemWithConstructor(
                    0,
                    1,
                    1,
                    Material.STICK,
                    null,
                    "Item meld debug"
            ) {
                @Override
                public ItemStack getItemStack(int amount) {
                    return debugTool(super.getItemStack(amount));
                }
    
                @Override
                public boolean onPlayerMend(PlayerItemMendEvent event) {
                    Bukkit.broadcastMessage("Player item mend event triggered");
                    return false;
                }
            },
            new CustomItemWithConstructor(
                    0,
                    1,
                    1,
                    Material.STICK,
                    null,
                    "Pickup debug"
            ) {
                @Override
                public ItemStack getItemStack(int amount) {
                    return debugTool(super.getItemStack(amount));
                }
    
                @Override
                public boolean onPlayerPickup(PlayerPickupItemEvent event) {
                    Bukkit.broadcastMessage("Player pickup item event triggered");
                    return false;
                }
            },
            new CustomItemWithConstructor(
                    0,
                    1,
                    1,
                    Material.STICK,
                    null,
                    "Swap hand debug"
            ) {
                @Override
                public ItemStack getItemStack(int amount) {
                    return debugTool(super.getItemStack(amount));
                }
    
                @Override
                public boolean onPlayerSwapHand(PlayerSwapHandItemsEvent event) {
                    Bukkit.broadcastMessage("player swap hand items event triggered");
                    return false;
                }
            },
            new CustomItemWithConstructor(
                    0,
                    1,
                    1,
                    Material.STICK,
                    null,
                    "Prepare craft debug"
            ) {
                @Override
                public ItemStack getItemStack(int amount) {
                    return debugTool(super.getItemStack(amount));
                }
    
                @Override
                public void onPrepareCraft(PrepareItemCraftEvent event) {
                    Bukkit.broadcastMessage("Prepare item craft event triggered");
                }
            },
            new CustomItemWithConstructor(
                    0,
                    1,
                    1,
                    Material.STICK,
                    null,
                    "Prepare enchant debug"
            ) {
                @Override
                public ItemStack getItemStack(int amount) {
                    return debugTool(super.getItemStack(amount));
                }
    
                @Override
                public boolean onPrepareEnchantEvent(PrepareItemEnchantEvent event) {
                    Bukkit.broadcastMessage("prepare item enchant event triggered");
                    return false;
                }
            },
            new CustomItemWithConstructor(
                    0,
                    1,
                    1,
                    Material.STICK,
                    null,
                    "Interact at entity debug"
            ) {
                @Override
                public ItemStack getItemStack(int amount) {
                    return debugTool(super.getItemStack(amount));
                }
    
                @Override
                public boolean onPlayerInteractAtEntity(PlayerInteractAtEntityEvent event) {
                    Bukkit.broadcastMessage("player interact at entity event triggered");
                    return false;
                }
            },
            new CustomItemWithConstructor(
                    0,
                    1,
                    1,
                    Material.STICK,
                    null,
                    "Interact entity drop debug"
            ) {
                @Override
                public ItemStack getItemStack(int amount) {
                    return debugTool(super.getItemStack(amount));
                }
    
                @Override
                public boolean onPlayerInteractEntity(PlayerInteractEntityEvent event) {
                    Bukkit.broadcastMessage("player interact entity event triggered");
                    return false;
                }
            },
            new CustomItemWithConstructor(
                    0,
                    1,
                    1,
                    Material.STICK,
                    null,
                    "player interact debug"
            ) {
                @Override
                public ItemStack getItemStack(int amount) {
                    return debugTool(super.getItemStack(amount));
                }
    
                @Override
                public boolean onPlayerInteract(PlayerInteractEvent event) {
                    Bukkit.broadcastMessage("Player interact event triggered");
                    return false;
                }
            },
    };
    
    private static ItemStack debugTool(ItemStack base) {
        base.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
        ItemMeta itemMeta = base.getItemMeta();
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        base.setItemMeta(itemMeta);
        return base;
    }
    
}
