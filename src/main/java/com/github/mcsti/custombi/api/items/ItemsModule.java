package com.github.mcsti.custombi.api.items;

import com.github.mcsti.custombi.internal.items.CustomItem;
import org.bukkit.NamespacedKey;

import java.util.List;
import java.util.Optional;

public interface ItemsModule {
    
    /**
     * Add items to custom items list
     *
     * @param items {@link CustomItem} to load
     */
    void loadItems(CustomItem... items);
    
    /**
     * @return all loaded {@link CustomItem}
     */
    List<CustomItem> getItems();
    
    /**
     *
     * @param namespace id of the {@link CustomItem}, default format is {@code custombi:name_in_snake_lower_case}
     * @return if {@link CustomItem} exist an optionnal with the item else an empty optionnal
     */
    Optional<CustomItem> getItem(NamespacedKey namespace);
}
