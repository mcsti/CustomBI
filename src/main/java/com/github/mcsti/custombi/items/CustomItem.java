package com.github.mcsti.custombi.items;

import com.github.mcsti.tuples.Pair;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Locale;

// Event start with `on` and return boolean for cancel or not the event | Support deprecation for legacy
@SuppressWarnings({"BooleanMethodNameMustStartWithQuestion", "DeprecatedIsStillUsed"})
public interface CustomItem {

    // Attributes
    String getName();
    String[] getLores();
    int getMaxStackSize();
    int getMaxDurability();
    int getCustomModelData();
    default ItemStack getItemStack(int amount) {
        net.minecraft.server.v1_16_R3.ItemStack nms = CraftItemStack.asNMSCopy(new ItemStack(getMaterial(), amount));
        NBTTagCompound                          tag = nms.getOrCreateTag();
        tag.setString("id", getId());
        nms.setTag(tag);
        ItemStack itemStack = CraftItemStack.asBukkitCopy(nms);
    
        if (!itemStack.hasItemMeta() || itemStack.getItemMeta() == null) {
            return itemStack;
        }
        ItemMeta  itemMeta  = itemStack.getItemMeta();
        itemMeta.setCustomModelData(getCustomModelData() < 0 ? null : getCustomModelData());
        itemMeta.setDisplayName(getName());
        itemMeta.setLore(Arrays.asList(getLores()));
        itemStack.setItemMeta(itemMeta);
        
        return itemStack;
    };
    default String getId() {
        return "custombi:"+getName().replaceAll(" ", "_").toLowerCase(Locale.ROOT);
    }
    Material getMaterial();
    default Pair<ItemStack[], Integer> getUnshapedCraft() {
        return null;
    };
    default Pair<ItemStack[], Integer> getShapedCraft() {
        return null;
    };

    // Event
    /**
     * @see PlayerDropItemEvent
     * @return if the event is cancelled
     */
    default boolean onPlayerDrop(PlayerDropItemEvent event) {
        return false;
    }
    /**
     * @see ItemDespawnEvent
     * @return if the event is cancelled
     */
    default boolean onDespawn(ItemDespawnEvent event) {
        return false;
    }
    /**
     * @see ItemMergeEvent
     * @return if the event is cancelled
     */
    default boolean onMerge(ItemMergeEvent event) {
        return false;
    }
    /**
     * @see ItemSpawnEvent
     * @return if the event is cancelled
     */
    default boolean onSpawn(ItemSpawnEvent event) {
        return false;
    }
    /**
     * @see BlockDropItemEvent
     * @return if the event is cancelled
     */
    default boolean onBlockDrop(BlockDropItemEvent event) {
        return false;
    }
    /**
     * @see CraftItemEvent
     * @return if the event is cancelled
     */
    default boolean onCraft(CraftItemEvent event) {
        return false;
    }
    /**
     * @see EnchantItemEvent
     * @return if the event is cancelled
     */
    default boolean onEnchant(EnchantItemEvent event) {
        return false;
    }
    /**
     * @see EntityPickupItemEvent
     * @return if the event is cancelled
     */
    default boolean onEntityPickup(EntityPickupItemEvent event) {
        return false;
    }
    /**
     * @see EntityDropItemEvent
     * @return if the event is cancelled
     */
    default boolean onEntityDrop(EntityDropItemEvent event) {
        return false;
    }
    /**
     * @see InventoryMoveItemEvent
     * @return if the event is cancelled
     */
    default boolean onInventoryMove(InventoryMoveItemEvent event) {
        return false;
    }
    /**
     * @see InventoryPickupItemEvent
     * @return if the event is cancelled
     */
    default boolean onInventoryPickup(InventoryPickupItemEvent event) {
        return false;
    }
    /**
     * @see PlayerItemBreakEvent
     */
    default void onPlayerBreak(PlayerItemBreakEvent event) { }
    /**
     * @see PlayerItemConsumeEvent
     * @return if the event is cancelled
     */
    default boolean onPlayerConsume(PlayerItemConsumeEvent event) {
        return false;
    }
    /**
     * @see PlayerItemDamageEvent
     * @return if the event is cancelled
     */
    default boolean onPlayerDamage(PlayerItemDamageEvent event) {
        return false;
    }
    /**
     * @see PlayerItemHeldEvent
     * @return if the event is cancelled
     */
    default boolean onPlayerHeld(PlayerItemHeldEvent event) {
        return false;
    }
    /**
     * @see PlayerItemMendEvent
     * @return if the event is cancelled
     */
    default boolean onPlayerMend(PlayerItemMendEvent event) {
        return false;
    }
    /**
     * @see PlayerPickupItemEvent
     * @return if the event is cancelled
     */
    @Deprecated
    default boolean onPlayerPickup(PlayerPickupItemEvent event) {
        return false;
    }
    /**
     * @see PlayerSwapHandItemsEvent
     * @return if the event is cancelled
     */
    default boolean onPlayerSwapHand(PlayerSwapHandItemsEvent event) {
        return false;
    }
    /**
     * @see PrepareItemCraftEvent
     */
    default void onPrepareCraft(PrepareItemCraftEvent event) { }
    /**
     * @see PrepareItemEnchantEvent
     * @return if the event is cancelled
     */
    default boolean onPrepareEnchantEvent(PrepareItemEnchantEvent event) {
        return false;
    }
    /**
     * @see PlayerInteractAtEntityEvent
     * @return if the event is cancelled
     */
    default boolean onPlayerInteractAtEntity(PlayerInteractAtEntityEvent event) {
        return false;
    }
    /**
     * @see PlayerInteractEntityEvent
     * @return if the event is cancelled
     */
    default boolean onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        return false;
    }
    /**
     * @see PlayerInteractEvent
     * @return if the event is cancelled
     */
    default boolean onPlayerInteract(PlayerInteractEvent event) {
        return false;
    }
}
