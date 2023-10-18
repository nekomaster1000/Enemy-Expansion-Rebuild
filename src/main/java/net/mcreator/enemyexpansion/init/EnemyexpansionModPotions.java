
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.enemyexpansion.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.enemyexpansion.EnemyexpansionMod;

public class EnemyexpansionModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, EnemyexpansionMod.MODID);
	public static final RegistryObject<Potion> SWIFT_FLIGHT_POTION = REGISTRY.register("swift_flight_potion", () -> new Potion(new MobEffectInstance(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get(), 3600, 0, false, true)));
}
