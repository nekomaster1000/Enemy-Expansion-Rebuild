
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
import net.mcreator.enemyexpansion.item.TrollfaceItem;
import net.mcreator.enemyexpansion.item.TrollMolarItem;
import net.mcreator.enemyexpansion.item.SilverheadItem;
import net.mcreator.enemyexpansion.item.ScorpionTailItem;
import net.mcreator.enemyexpansion.item.PhantomEyeItem;
import net.mcreator.enemyexpansion.item.PhantasmItem;
import net.mcreator.enemyexpansion.item.MeatheadItem;
import net.mcreator.enemyexpansion.item.HorseheadItem;
import net.mcreator.enemyexpansion.item.HealingEyeItem;
import net.mcreator.enemyexpansion.item.HeadbiterItem;
import net.mcreator.enemyexpansion.item.DeathstickItem;
import net.mcreator.enemyexpansion.item.BottledFlutterflyItem;
import net.mcreator.enemyexpansion.EnemyexpansionMod;

public class EnemyexpansionModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, EnemyexpansionMod.MODID);
	public static final RegistryObject<Item> SPRINTER_SPAWN_EGG = REGISTRY.register("sprinter_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.SPRINTER, -14269861, -9273797, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> SLUGGER_SPAWN_EGG = REGISTRY.register("slugger_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.SLUGGER, -12244867, -10910598, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> MEATURE_SPAWN_EGG = REGISTRY.register("meature_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.MEATURE, -9359573, -6730933, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> EQUESTRIAN_SPAWN_EGG = REGISTRY.register("equestrian_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.EQUESTRIAN, -7359613, -4269373, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> GOBLIN_SPAWN_EGG = REGISTRY.register("goblin_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.GOBLIN, -12038042, -11433587, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> TARANTULA_SPAWN_EGG = REGISTRY.register("tarantula_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.TARANTULA, -8497616, -7373714, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> SCORPION_SPAWN_EGG = REGISTRY.register("scorpion_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.SCORPION, -11782091, -7439758, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> LADYBUG_SPAWN_EGG = REGISTRY.register("ladybug_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.LADYBUG, -7266027, -7373714, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> SCORPION_TAIL = REGISTRY.register("scorpion_tail", () -> new ScorpionTailItem());
	public static final RegistryObject<Item> MEATHEAD_HELMET = REGISTRY.register("meathead_helmet", () -> new MeatheadItem.Helmet());
	public static final RegistryObject<Item> HORSEHEAD_HELMET = REGISTRY.register("horsehead_helmet", () -> new HorseheadItem.Helmet());
	public static final RegistryObject<Item> WASP_SPAWN_EGG = REGISTRY.register("wasp_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.WASP, -1195197, -830911, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> DRONE_SPAWN_EGG = REGISTRY.register("drone_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.DRONE, -4821945, -830911, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> BOTFLY_SPAWN_EGG = REGISTRY.register("botfly_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.BOTFLY, -12768729, -9948910, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> FLUTTERFLY_SPAWN_EGG = REGISTRY.register("flutterfly_spawn_egg",
			() -> new ForgeSpawnEggItem(EnemyexpansionModEntities.FLUTTERFLY, -10744820, -1506043, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> HUNTSMAN_SPAWN_EGG = REGISTRY.register("huntsman_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.HUNTSMAN, -8038858, -3421751, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> STARVED_SPAWN_EGG = REGISTRY.register("starved_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.STARVED, -6914974, -3949911, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> VAMPIRE_SPAWN_EGG = REGISTRY.register("vampire_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.VAMPIRE, -12699048, -9014373, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> VAMPFLYER_SPAWN_EGG = REGISTRY.register("vampflyer_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.VAMPFLYER, -13883323, -9014373, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> VAMPBITER_SPAWN_EGG = REGISTRY.register("vampbiter_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.VAMPBITER, -14475213, -9014373, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> HEADBITER_HELMET = REGISTRY.register("headbiter_helmet", () -> new HeadbiterItem.Helmet());
	public static final RegistryObject<Item> TROLL_SPAWN_EGG = REGISTRY.register("troll_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.TROLL, -2172995, -2902212, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> TROLLENRAGED_SPAWN_EGG = REGISTRY.register("trollenraged_spawn_egg",
			() -> new ForgeSpawnEggItem(EnemyexpansionModEntities.TROLLENRAGED, -4020081, -2902212, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> BOTTLED_FLUTTERFLY = REGISTRY.register("bottled_flutterfly", () -> new BottledFlutterflyItem());
	public static final RegistryObject<Item> SILVERQUEEN_SPAWN_EGG = REGISTRY.register("silverqueen_spawn_egg",
			() -> new ForgeSpawnEggItem(EnemyexpansionModEntities.SILVERQUEEN, -12434878, -5921371, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> SILVERQUEENBODILESS_SPAWN_EGG = REGISTRY.register("silverqueenbodiless_spawn_egg",
			() -> new ForgeSpawnEggItem(EnemyexpansionModEntities.SILVERQUEENBODILESS, -14342875, -5921371, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> SILVERHEAD_HELMET = REGISTRY.register("silverhead_helmet", () -> new SilverheadItem.Helmet());
	public static final RegistryObject<Item> PHANTASM_HELMET = REGISTRY.register("phantasm_helmet", () -> new PhantasmItem.Helmet());
	public static final RegistryObject<Item> PHANTASM_CHESTPLATE = REGISTRY.register("phantasm_chestplate", () -> new PhantasmItem.Chestplate());
	public static final RegistryObject<Item> PHANTASM_LEGGINGS = REGISTRY.register("phantasm_leggings", () -> new PhantasmItem.Leggings());
	public static final RegistryObject<Item> PHANTASM_BOOTS = REGISTRY.register("phantasm_boots", () -> new PhantasmItem.Boots());
	public static final RegistryObject<Item> TROLLFACE = REGISTRY.register("trollface", () -> new TrollfaceItem());
	public static final RegistryObject<Item> TROLL_MOLAR = REGISTRY.register("troll_molar", () -> new TrollMolarItem());
	public static final RegistryObject<Item> DEATHSTICK = REGISTRY.register("deathstick", () -> new DeathstickItem());
	public static final RegistryObject<Item> DIREWOLF_SPAWN_EGG = REGISTRY.register("direwolf_spawn_egg", () -> new ForgeSpawnEggItem(EnemyexpansionModEntities.DIREWOLF, -9541525, -11844283, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> HEALING_EYE = REGISTRY.register("healing_eye", () -> new HealingEyeItem());
	public static final RegistryObject<Item> WASP_THORAX = REGISTRY.register("wasp_thorax", () -> new WaspThoraxItem());
	public static final RegistryObject<Item> PHANTOM_EYE = REGISTRY.register("phantom_eye", () -> new PhantomEyeItem());
	// Start of user code block custom items
	// End of user code block custom items
}
