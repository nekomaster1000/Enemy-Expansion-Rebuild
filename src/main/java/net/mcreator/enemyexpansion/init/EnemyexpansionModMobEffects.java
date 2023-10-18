
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.enemyexpansion.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.enemyexpansion.potion.SwiftFlightMobEffect;
import net.mcreator.enemyexpansion.EnemyexpansionMod;

public class EnemyexpansionModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, EnemyexpansionMod.MODID);
	public static final RegistryObject<MobEffect> SWIFT_FLIGHT = REGISTRY.register("swift_flight", () -> new SwiftFlightMobEffect());
}
