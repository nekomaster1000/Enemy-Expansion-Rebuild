package net.mcreator.enemyexpansion.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.enemyexpansion.entity.SilverqueendefensiveEntity;
import net.mcreator.enemyexpansion.entity.SilverqueenattackingEntity;
import net.mcreator.enemyexpansion.EnemyexpansionMod;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class SilverqueenParryProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof SilverqueenattackingEntity) {
			entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(sourceentity.getYRot() + 180)) * 1.6), 0.3, (Math.cos(Math.toRadians(sourceentity.getYRot())) * 1.6)));
			if (entity instanceof SilverqueenattackingEntity) {
				((SilverqueenattackingEntity) entity).setAnimation("attack");
			}
			EnemyexpansionMod.queueServerWork(20, () -> {
				if (entity instanceof SilverqueenattackingEntity) {
					((SilverqueenattackingEntity) entity).setAnimation("empty");
				}
			});
			EnemyexpansionMod.queueServerWork(7, () -> {
				if (entity.isAlive()) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
								.collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator instanceof SilverqueenattackingEntity || entityiterator instanceof SilverqueendefensiveEntity)) {
								SpawnSilverfishProcedure.execute(world, entity);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.HOSTILE, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.HOSTILE, 1, 1, false);
									}
								}
								entityiterator.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * Mth.nextDouble(RandomSource.create(), 0.8, 1.6)), (Mth.nextDouble(RandomSource.create(), 0.6, 0.9)),
										(Math.cos(Math.toRadians(entity.getYRot())) * Mth.nextDouble(RandomSource.create(), 0.8, 1.6))));
								if (Math.random() < 0.2) {
									EnemyexpansionMod.queueServerWork(13, () -> {
										if (entity.isAlive()) {
											SilverqueenModeSwitchProcedure.execute(world, entity);
										}
									});
								} else if (Math.random() < 0.1 && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 12) {
									EnemyexpansionMod.queueServerWork(13, () -> {
										if (entity.isAlive()) {
											SilverqueenBodilessSpawnProcedure.execute(world, entity);
										}
									});
								}
							}
						}
					}
				}
			});
		}
	}
}
