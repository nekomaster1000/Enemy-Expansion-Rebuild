
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.enemyexpansion.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.enemyexpansion.block.TrollStatueBlock;
import net.mcreator.enemyexpansion.EnemyexpansionMod;

public class EnemyexpansionModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, EnemyexpansionMod.MODID);
	public static final RegistryObject<Block> TROLL_STATUE = REGISTRY.register("troll_statue", () -> new TrollStatueBlock());
}
