/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.enemyexpansion.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.enemyexpansion.potion.TimerMobEffect;
import net.mcreator.enemyexpansion.potion.SwiftFlightMobEffect;
import net.mcreator.enemyexpansion.potion.SandstormMobEffect;
import net.mcreator.enemyexpansion.potion.OvertimeMobEffect;
import net.mcreator.enemyexpansion.potion.MorphlockedMobEffect;
import net.mcreator.enemyexpansion.potion.MetamorphosisMobEffect;
import net.mcreator.enemyexpansion.potion.ExplosiveLaunchMobEffect;
import net.mcreator.enemyexpansion.potion.DespawnerMobEffect;
import net.mcreator.enemyexpansion.potion.CardiacMobEffect;
import net.mcreator.enemyexpansion.potion.BittenMobEffect;
import net.mcreator.enemyexpansion.EnemyexpansionMod;

public class EnemyexpansionModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, EnemyexpansionMod.MODID);
	public static final RegistryObject<MobEffect> SWIFT_FLIGHT = REGISTRY.register("swift_flight", () -> new SwiftFlightMobEffect());
	public static final RegistryObject<MobEffect> BITTEN = REGISTRY.register("bitten", () -> new BittenMobEffect());
	public static final RegistryObject<MobEffect> DESPAWNER = REGISTRY.register("despawner", () -> new DespawnerMobEffect());
	public static final RegistryObject<MobEffect> TIMER = REGISTRY.register("timer", () -> new TimerMobEffect());
	public static final RegistryObject<MobEffect> CARDIAC = REGISTRY.register("cardiac", () -> new CardiacMobEffect());
	public static final RegistryObject<MobEffect> SANDSTORM = REGISTRY.register("sandstorm", () -> new SandstormMobEffect());
	public static final RegistryObject<MobEffect> EXPLOSIVE_LAUNCH = REGISTRY.register("explosive_launch", () -> new ExplosiveLaunchMobEffect());
	public static final RegistryObject<MobEffect> OVERTIME = REGISTRY.register("overtime", () -> new OvertimeMobEffect());
	public static final RegistryObject<MobEffect> METAMORPHOSIS = REGISTRY.register("metamorphosis", () -> new MetamorphosisMobEffect());
	public static final RegistryObject<MobEffect> MORPHLOCKED = REGISTRY.register("morphlocked", () -> new MorphlockedMobEffect());
}
