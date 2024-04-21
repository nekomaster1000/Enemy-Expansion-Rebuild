package net.mcreator.enemyexpansion.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.enemyexpansion.init.EnemyexpansionModEntities;
import net.mcreator.enemyexpansion.entity.GoblinFearEntity;
import net.mcreator.enemyexpansion.entity.GoblinEntity;
import net.mcreator.enemyexpansion.EnemyexpansionMod;

public class GoblinHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof Player) {
			if (Math.random() < 0.1) {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 50000, 0, false, false));
			}
			if (Math.random() < 0.25 || (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 6) {
				if (!(entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(MobEffects.WEAKNESS))) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new GoblinFearEntity(EnemyexpansionModEntities.GOBLIN_FEAR.get(), _level);
						entityToSpawn.moveTo((x - 2), y, (z - 2), world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						_level.addFreshEntity(entityToSpawn);
					}
					if (entity instanceof GoblinEntity animatable)
						animatable.setTexture("goblin_thief_panicked");
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.screech")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.screech")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
					if (entity instanceof GoblinEntity) {
						((GoblinEntity) entity).setAnimation("sprint");
					}
					if (!(entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(MobEffects.UNLUCK))) {
						if (world instanceof ServerLevel _level)
							_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 2));
					}
					EnemyexpansionMod.queueServerWork(50, () -> {
						if (entity instanceof GoblinEntity animatable)
							animatable.setTexture("goblin_thief");
					});
				}
			}
			if (entity instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(MobEffects.WEAKNESS)) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.witch.hurt")), SoundSource.HOSTILE, 1, 0);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.witch.hurt")), SoundSource.HOSTILE, 1, 0, false);
					}
				}
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 0, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 4, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 4, false, false));
				if (entity instanceof GoblinEntity) {
					((GoblinEntity) entity).setAnimation("transforming");
				}
				EnemyexpansionMod.queueServerWork(80, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.screech")), SoundSource.HOSTILE, 1, 0);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.screech")), SoundSource.HOSTILE, 1, 0, false);
						}
					}
				});
				EnemyexpansionMod.queueServerWork(100, () -> {
					if (entity.isAlive()) {
					}
				});
			}
		}
	}
}
