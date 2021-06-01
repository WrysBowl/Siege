package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.implemented.armor.boots.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.*;
import net.siegerpg.siege.core.listeners.ArmorEquip.ArmorEquipEvent;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class SpecialArmorAbilities implements Listener {
    @EventHandler
    public void armorChange(ArmorEquipEvent e) {
        for (PotionEffect effect : e.getPlayer().getActivePotionEffects()) {
            e.getPlayer().removePotionEffect(effect.getType());
        }
        Objects.requireNonNull(e.getPlayer().getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE)).setBaseValue(0.0);
        ItemStack[] armor = e.getPlayer().getInventory().getArmorContents();
        ArrayList<ItemStack> newArmorContents = new ArrayList<>(Arrays.asList(armor));
        newArmorContents.remove(e.getOldArmorPiece());
        newArmorContents.add(e.getNewArmorPiece());

        if (isSlimeSet(newArmorContents)) {
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 99999, 1));
        } else if (isBoneSet(newArmorContents)) {
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999, 0));
        } else if (isIronSet(newArmorContents)) {
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999, 1));
        } else if (isMagmaSet(newArmorContents)) {
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 99999, 1));
        }
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player)) return;
        Player player = ((Player) e.getDamager()).getPlayer();
        if (player == null) return;
        if (isBeePants(player.getInventory().getLeggings())) {
            ((LivingEntity)e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20, 1));
        }
    }

    @EventHandler
    public void onDamaged(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        Player player = ((Player) e.getEntity()).getPlayer();
        if (player == null) return;
        ItemStack item = player.getInventory().getChestplate();
        CustomItem cusItem = CustomItemUtils.INSTANCE.getCustomItem(item);
        if (cusItem == null) return;
        if (cusItem.getLevelRequirement() == null) return;
        if (cusItem.getLevelRequirement() > player.getLevel()) return;
        if (Utils.randTest(10.0)) {
            if (isGrieferChestplate(player.getInventory().getChestplate())) {
                for (LivingEntity entity : player.getLocation().getNearbyLivingEntities(4.0)) {
                    if (entity instanceof Player) {
                        if (!e.getEntity().equals(entity)) continue;
                    }
                    entity.damage(50.0, player);
                    entity.playEffect(EntityEffect.HURT_EXPLOSION);
                    player.playSound(entity.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0f, 1.0f);
                }
            }
        }
    }

    private boolean isBeePants(ItemStack armorPiece) {
        CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(armorPiece);
        return item instanceof BeePants;
    }

    private boolean isGrieferChestplate(ItemStack armorPiece) {
        CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(armorPiece);
        return item instanceof GrieferChestplate;
    }

    private boolean isSlimeSet(ArrayList<ItemStack> armorPieces) {
        int badCheckMethod = 0;
        for (ItemStack armorPiece : armorPieces) {
            CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(armorPiece);
            if (item instanceof SlimyHelmet) {
                badCheckMethod += 1;
            } else if (item instanceof SlimyChestplate) {
                badCheckMethod += 1;
            } else if (item instanceof SlimyLeggings) {
                badCheckMethod += 1;
            } else if (item instanceof SlimyBoots) {
                badCheckMethod += 1;
            }
        }
        return badCheckMethod == 4;
    }

    private boolean isBoneSet(ArrayList<ItemStack> armorPieces) {
        int badCheckMethod = 0;
        for (ItemStack armorPiece : armorPieces) {
            CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(armorPiece);
            if (item instanceof BoneHelmet) {
                badCheckMethod += 1;
            } else if (item instanceof BoneChestplate) {
                badCheckMethod += 1;
            } else if (item instanceof BoneLeggings) {
                badCheckMethod += 1;
            } else if (item instanceof BoneBoots) {
                badCheckMethod += 1;
            }
        }
        return badCheckMethod == 4;
    }

    private boolean isIronSet(ArrayList<ItemStack> armorPieces) {
        int badCheckMethod = 0;
        for (ItemStack armorPiece : armorPieces) {
            CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(armorPiece);
            if (item instanceof IronHelmet) {
                badCheckMethod += 1;
            } else if (item instanceof IronChestplate) {
                badCheckMethod += 1;
            } else if (item instanceof IronLeggings) {
                badCheckMethod += 1;
            } else if (item instanceof IronBoots) {
                badCheckMethod += 1;
            }
        }
        return badCheckMethod == 4;
    }

    private boolean isStrawSet(ArrayList<ItemStack> armorPieces) {
        int badCheckMethod = 0;
        for (ItemStack armorPiece : armorPieces) {
            CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(armorPiece);
            if (item instanceof StrawHelmet) {
                badCheckMethod += 1;
            } else if (item instanceof StrawChestplate) {
                badCheckMethod += 1;
            } else if (item instanceof StrawLeggings) {
                badCheckMethod += 1;
            } else if (item instanceof StrawBoots) {
                badCheckMethod += 1;
            }
        }
        return badCheckMethod == 4;
    }

    private boolean isMagmaSet(ArrayList<ItemStack> armorPieces) {
        int badCheckMethod = 0;
        for (ItemStack armorPiece : armorPieces) {
            CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(armorPiece);
            if (item instanceof MagmaHelmet) {
                badCheckMethod += 1;
            } else if (item instanceof MagmaChestplate) {
                badCheckMethod += 1;
            } else if (item instanceof MagmaLeggings) {
                badCheckMethod += 1;
            } else if (item instanceof MagmaBoots) {
                badCheckMethod += 1;
            }
        }
        return badCheckMethod == 4;
    }
}
