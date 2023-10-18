
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.enemyexpansion.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

import net.mcreator.enemyexpansion.item.WaspThoraxItem;
import net.mcreator.enemyexpansion.item.ScorpionTailItem;
import net.mcreator.enemyexpansion.item.MeatheadItem;
import net.mcreator.enemyexpansion.item.HorseheadItem;
import net.mcreator.enemyexpansion.item.HealingEyeItem;
import net.mcreator.enemyexpansion.EnemyexpansionMod;

public class EnemyexpansionModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, EnemyexpansionMod.MODID);
	public static final RegistryObject<Item> SLUGGER_SPAWN_EGG = REGISTRY.register("slugger_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.SLUGGER, -12244867, -10910598, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> SPRINTER_SPAWN_EGG = REGISTRY.register("sprinter_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.SPRINTER, -14269861, -9273797, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> MEATURE_SPAWN_EGG = REGISTRY.register("meature_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.MEATURE, -9359573, -6730933, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> EQUESTRIAN_SPAWN_EGG = REGISTRY.register("equestrian_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.EQUESTRIAN, -7359613, -4269373, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> GOBLIN_SPAWN_EGG = REGISTRY.register("goblin_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.GOBLIN, -12038042, -11433587, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> TARANTULA_SPAWN_EGG = REGISTRY.register("tarantula_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.TARANTULA, -8497616, -7373714, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> SCORPION_SPAWN_EGG = REGISTRY.register("scorpion_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.SCORPION, -11782091, -7439758, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> LADYBUG_SPAWN_EGG = REGISTRY.register("ladybug_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.LADYBUG, -7266027, -7373714, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> HEALING_EYE = REGISTRY.register("healing_eye", () -> new HealingEyeItem());
	public static final RegistryObject<Item> SCORPION_TAIL = REGISTRY.register("scorpion_tail", () -> new ScorpionTailItem());
	public static final RegistryObject<Item> MEATHEAD_HELMET = REGISTRY.register("meathead_helmet", () -> new MeatheadItem.Helmet());
	public static final RegistryObject<Item> HORSEHEAD_HELMET = REGISTRY.register("horsehead_helmet", () -> new HorseheadItem.Helmet());
	public static final RegistryObject<Item> WASP_SPAWN_EGG = REGISTRY.register("wasp_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.WASP, -1195197, -830911, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> DRONE_SPAWN_EGG = REGISTRY.register("drone_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.DRONE, -4821945, -830911, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> WASP_THORAX = REGISTRY.register("wasp_thorax", () -> new WaspThoraxItem());
	public static final RegistryObject<Item> HOUSEFLY_SPAWN_EGG = REGISTRY.register("housefly_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.HOUSEFLY, -12768729, -9948910, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> FLUTTERFLY_SPAWN_EGG = REGISTRY.register("flutterfly_spawn_egg",
			() -> new ForgeSpawnEggItem(EnemyexpansionModEntities.FLUTTERFLY, -10744820, -1506043, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
}
