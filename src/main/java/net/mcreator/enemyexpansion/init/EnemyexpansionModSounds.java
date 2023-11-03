
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.enemyexpansion.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.enemyexpansion.EnemyexpansionMod;

public class EnemyexpansionModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, EnemyexpansionMod.MODID);
	public static final RegistryObject<SoundEvent> STARVED_CHOMP = REGISTRY.register("starved.chomp", () -> new SoundEvent(new ResourceLocation("enemyexpansion", "starved.chomp")));
	public static final RegistryObject<SoundEvent> TROLL_IDLE = REGISTRY.register("troll.idle", () -> new SoundEvent(new ResourceLocation("enemyexpansion", "troll.idle")));
	public static final RegistryObject<SoundEvent> TROLL_HURT = REGISTRY.register("troll.hurt", () -> new SoundEvent(new ResourceLocation("enemyexpansion", "troll.hurt")));
	public static final RegistryObject<SoundEvent> TROLL_ROAR = REGISTRY.register("troll.roar", () -> new SoundEvent(new ResourceLocation("enemyexpansion", "troll.roar")));
	public static final RegistryObject<SoundEvent> TROLL_DEATH = REGISTRY.register("troll.death", () -> new SoundEvent(new ResourceLocation("enemyexpansion", "troll.death")));
}
