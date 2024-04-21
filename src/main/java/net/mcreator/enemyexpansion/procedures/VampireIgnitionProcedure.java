package net.mcreator.enemyexpansion.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.enemyexpansion.init.EnemyexpansionModMobEffects;
import net.mcreator.enemyexpansion.configuration.BetterConfigConfiguration;
import net.mcreator.enemyexpansion.EnemyexpansionMod;

public class VampireIgnitionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getMaxLocalRawBrightness(new BlockPos(x, y + 1, z)) > 13 && world.canSeeSkyFromBelowWater(new BlockPos(x, y, z))) {
			entity.setSecondsOnFire(10);
			EnemyexpansionMod.queueServerWork(50, () -> {
				if (entity.isAlive() && entity.isOnFire()) {
					if (BetterConfigConfiguration.VAMPIRESEXPLODE.get() == true) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.burn")), SoundSource.HOSTILE, 1, 2);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.burn")), SoundSource.HOSTILE, 1, 2, false);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.phantom.death")), SoundSource.HOSTILE, 1, 0);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.phantom.death")), SoundSource.HOSTILE, 1, 0, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SMALL_FLAME, (entity.getX()), (entity.getY()), (entity.getZ()), 20, 0.3, 0.3, 0.3, 1);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SQUID_INK, (entity.getX()), (entity.getY()), (entity.getZ()), 20, 0.3, 0.3, 0.3, 1);
						if (world instanceof Level _level && !_level.isClientSide())
							_level.explode(null, (entity.getX()), (entity.getY()), (entity.getZ()), 2, Explosion.BlockInteraction.NONE);
						if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
							_entity.addEffect(new MobEffectInstance(EnemyexpansionModMobEffects.TIMER.get(), 2, 1, false, false));
						if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
							_entity.addEffect(new MobEffectInstance(EnemyexpansionModMobEffects.DESPAWNER.get(), 3, 0, false, false));
					}
				}
			});
		}
		if (entity.isInWall()) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(EnemyexpansionModMobEffects.DESPAWNER.get(), 1, 0, false, false));
		}
	}
}
