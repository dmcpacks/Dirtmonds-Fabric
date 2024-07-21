package com.dmcpacks.dirtmonds.item.custom;

import com.dmcpacks.dirtmonds.config.ModConfigs;
import com.dmcpacks.dirtmonds.item.ModArmorMaterial;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.minecraft.item.tooltip.TooltipType;

import java.util.List;

public class ModArmorItem extends ArmorItem {
    protected final Type type;
    protected final RegistryEntry<ArmorMaterial> material;

    public ModArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Item.Settings settings) {
        super(material, type, settings);
        this.material = material;
        this.type = type;
    }

    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) entity;
                if (ModConfigs.fullsetbonus) {
                    if (hasFullSuitOfArmorOn(player)) {
                        if (hasCorrectArmorOn(ModArmorMaterial.DIRTMOND.value(), player)) {
                            player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 0, 1));
                        }
                    }
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }
    @Override
    public void appendTooltip(ItemStack itemStack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(ModConfigs.fullsetbonus) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Text.translatable("tooltip.dirtmonds.dirtmond_armor_shift"));
            } else {
                tooltip.add(Text.translatable("tooltip.dirtmonds.dirtmond_armor"));
            }
        }
    }
    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        ArmorItem boots = ((ArmorItem)player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmorStack(1).getItem());
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial().value() == material
                && breastplate.getMaterial().value() == material
                && leggings.getMaterial().value() == material
                && boots.getMaterial().value() == material;
    }
}
