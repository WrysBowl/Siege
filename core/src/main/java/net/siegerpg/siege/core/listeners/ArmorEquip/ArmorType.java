package net.siegerpg.siege.core.listeners.ArmorEquip;

import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.CustomItemUtilsKt;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * @author Arnah
 * @since Jul 30, 2015
 */
public enum ArmorType{
    HELMET(5), CHESTPLATE(6), LEGGINGS(7), BOOTS(8);

    private final int slot;

    ArmorType(final int slot){
        this.slot = slot;
    }

    /**
     * Attempts to match the ArmorType for the specified ItemStack.
     *
     * @param itemStack The ItemStack to parse the type of.
     * @return The parsed ArmorType, or null if not found.
     */
    public static ArmorType matchType(ItemStack itemStack){
        if(ArmorListener.isAirOrNull(itemStack)) return null;
        final String type = itemStack.getType().name();
        final CustomItem customItem = CustomItemUtils.INSTANCE.getCustomItem(itemStack);
        if(type.endsWith("_HELMET") || type.endsWith("_SKULL") || type.endsWith("_HEAD") || customItem != null) return ArmorType.HELMET;
        else if(type.endsWith("_CHESTPLATE") || type.equals("ELYTRA")) return ArmorType.CHESTPLATE;
        else if(type.endsWith("_LEGGINGS")) return ArmorType.LEGGINGS;
        else if(type.endsWith("_BOOTS")) return ArmorType.BOOTS;
        else return null;
    }

    public int getSlot(){
        return this.slot;
    }
}
