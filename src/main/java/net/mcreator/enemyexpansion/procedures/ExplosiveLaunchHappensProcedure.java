package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.enemyexpansion.init.EnemyexpansionModMobEffects;
import net.mcreator.enemyexpansion.entity.IntruderEntity;
import net.mcreator.enemyexpansion.entity.FallerEntity;
import net.mcreator.enemyexpansion.entity.CrawlerEntity;
import net.mcreator.enemyexpansion.configuration.BetterConfigConfiguration;

public class ExplosiveLaunchHappensProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.25) {
			entity.setDeltaMovement(new Vec3(0,
					(0.1 * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnemyexpansionModMobEffects.EXPLOSIVE_LAUNCH.get()) ? _livEnt.getEffect(EnemyexpansionModMobEffects.EXPLOSIVE_LAUNCH.get()).getAmplifier() : 0) + 1)),
					(0.1 * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnemyexpansionModMobEffects.EXPLOSIVE_LAUNCH.get()) ? _livEnt.getEffect(EnemyexpansionModMobEffects.EXPLOSIVE_LAUNCH.get()).getAmplifier() : 0) + 1))));
		} else if (Math.random() < 0.5) {
			entity.setDeltaMovement(new Vec3(0,
					(0.1 * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnemyexpansionModMobEffects.EXPLOSIVE_LAUNCH.get()) ? _livEnt.getEffect(EnemyexpansionModMobEffects.EXPLOSIVE_LAUNCH.get()).getAmplifier() : 0) + 1)),
					((-0.1) * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnemyexpansionModMobEffects.EXPLOSIVE_LAUNCH.get()) ? _livEnt.getEffect(EnemyexpansionModMobEffects.EXPLOSIVE_LAUNCH.get()).getAmplifier() : 0) + 1))));
		} else if (Math.random() < 0.75) {
			entity.setDeltaMovement(new Vec3(
					(0.1 * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnemyexpansionModMobEffects.EXPLOSIVE_LAUNCH.get()) ? _livEnt.getEffect(EnemyexpansionModMobEffects.EXPLOSIVE_LAUNCH.get()).getAmplifier() : 0) + 1)),
					(0.1 * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnemyexpansionModMobEffects.EXPLOSIVE_LAUNCH.get()) ? _livEnt.getEffect(EnemyexpansionModMobEffects.EXPLOSIVE_LAUNCH.get()).getAmplifier() : 0) + 1)), 0));
		} else if (Math.random() < 0.99) {
			entity.setDeltaMovement(new Vec3(
					((-0.1) * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnemyexpansionModMobEffects.EXPLOSIVE_LAUNCH.get()) ? _livEnt.getEffect(EnemyexpansionModMobEffects.EXPLOSIVE_LAUNCH.get()).getAmplifier() : 0) + 1)),
					(0.1 * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnemyexpansionModMobEffects.EXPLOSIVE_LAUNCH.get()) ? _livEnt.getEffect(EnemyexpansionModMobEffects.EXPLOSIVE_LAUNCH.get()).getAmplifier() : 0) + 1)), 0));
		}
		if (entity instanceof IntruderEntity) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/summon enemyexpansion:invisicreeper ~ ~ ~ {Silent:1b,NoAI:1b,Health:1f,Fuse:1,ignited:1b,ExplosionRadius:4b,CustomName:'{\"text\":\"Intruder\"}'}");
		} else if (entity instanceof CrawlerEntity) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/summon enemyexpansion:invisicreeper ~ ~ ~ {Silent:1b,NoAI:1b,Health:1f,Fuse:1,ignited:1b,ExplosionRadius:3b,CustomName:'{\"text\":\"Crawler\"}'}");
		} else if (entity instanceof FallerEntity) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/summon enemyexpansion:invisicreeper ~ ~ ~ {Silent:1b,NoAI:1b,Health:1f,Fuse:1,ignited:1b,ExplosionRadius:2b,CustomName:'{\"text\":\"Faller\"}'}");
		} else {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/summon enemyexpansion:invisicreeper ~ ~ ~ {Silent:1b,NoAI:1b,Health:1f,Fuse:1,ignited:1b,ExplosionRadius:1b,CustomName:'{\"text\":\"Explosion\"}'}");
		}
		if (BetterConfigConfiguration.CREEPSDONTDIEEXPLODING.get() == false) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(EnemyexpansionModMobEffects.CARDIAC.get(), 1, 0));
		}
	}
}
