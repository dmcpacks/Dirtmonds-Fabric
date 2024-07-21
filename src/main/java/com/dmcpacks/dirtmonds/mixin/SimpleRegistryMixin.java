package com.dmcpacks.dirtmonds.mixin;


import net.minecraft.registry.SimpleRegistry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.TagKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;

@Mixin(SimpleRegistry.class)
public class SimpleRegistryMixin<T> {
    @Shadow
    private volatile Map<TagKey<T>, RegistryEntryList.Named<T>> tagToEntryList;

    @Inject(method = "populateTags", at = @At("HEAD"))
    private void bandaidFixForNullElement(Map<TagKey<T>, List<RegistryEntry<T>>> tagEntries, CallbackInfo ci) {
        this.tagToEntryList.remove(null);
    }
}