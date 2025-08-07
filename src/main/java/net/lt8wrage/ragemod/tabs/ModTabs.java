package net.lt8wrage.ragemod.tabs;

import net.lt8wrage.ragemod.RageMod;
import net.lt8wrage.ragemod.block.ModBlocks;
import net.lt8wrage.ragemod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RageMod.MODID);

    public static final Supplier<CreativeModeTab> ENDERITE_TAB = CREATIVE_MODE_TAB.register("enderite_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ENDERITE_SCRAP.get()))
                    .title(Component.translatable("creativetab.ragemod.enderite"))
                    .displayItems((ItemDisplayParameters, output) -> {
                        output.accept(ModItems.ENDERITE_SCRAP);
                        output.accept(ModItems.ENDERITE_INGOT);
                        output.accept(ModItems.ENDERITE_UPGRADE_TEMPLATE);
                        output.accept(ModBlocks.ENDERITE_BLOCK);
                    }).build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
