package net.mcreator.enemyexpansion.init;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.mcreator.enemyexpansion.configuration.BetterConfigConfiguration;
import net.mcreator.enemyexpansion.EnemyexpansionMod;

@Mod.EventBusSubscriber(modid = EnemyexpansionMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnemyexpansionModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BetterConfigConfiguration.SPEC, "enemyexpansion.toml");
		});
	}
}
