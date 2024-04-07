package net.mcreator.enemyexpansion.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.enemyexpansion.init.EnemyexpansionModMobEffects;
import net.mcreator.enemyexpansion.init.EnemyexpansionModEntities;
import net.mcreator.enemyexpansion.entity.VampireEntity;
import net.mcreator.enemyexpansion.entity.VampflyerEntity;
import net.mcreator.enemyexpansion.entity.VampbiterEntity;
import net.mcreator.enemyexpansion.EnemyexpansionMod;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class VampireSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.burn")), SoundSource.HOSTILE, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.burn")), SoundSource.HOSTILE, 1, 1, false);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SMALL_FLAME, x, y, z, 20, 0.3, 0.3, 0.3, 1);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, y, z, 20, 0.3, 0.3, 0.3, 0.3);
		if (entity.isInWall()) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(EnemyexpansionModMobEffects.DESPAWNER.get(), 1, 0, (false), (false)));
		}
		VampireIgnitionProcedure.execute(world, x, y, z, entity);
		if (entity instanceof VampbiterEntity) {
			EnemyexpansionMod.queueServerWork(200, () -> {
				if (entity.isAlive()) {
					if (!entity.level.isClientSide())
						entity.discard();
					if (Math.random() < 0.5) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = new VampireEntity(EnemyexpansionModEntities.VAMPIRE.get(), _level);
							entityToSpawn.moveTo((entity.getX()), (entity.getY()), (entity.getZ()), 0, 0);
							entityToSpawn.setYBodyRot(0);
							entityToSpawn.setYHeadRot(0);
							entityToSpawn.setDeltaMovement(0, 0, 0);
							if (entityToSpawn instanceof Mob _mobToSpawn)
								_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
							world.addFreshEntity(entityToSpawn);
						}
					} else {
						if (world instanceof ServerLevel _serverLevelForEntitySpawn) {
							Entity _entityForSpawning = new VampflyerEntity(EnemyexpansionModEntities.VAMPFLYER.get(), _serverLevelForEntitySpawn);
							_entityForSpawning.moveTo((entity.getX()), (entity.getY()), (entity.getZ()), world.getRandom().nextFloat() * 360F, 0);
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(96 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
										.collect(Collectors.toList());
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof Player) {
										if (_entityForSpawning instanceof LivingEntity _entity)
											_entity.addEffect(new MobEffectInstance(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get(), 100, 3, (false), (true)));
									}
								}
							}
							if (_entityForSpawning instanceof Mob _mobForSpawning)
								_mobForSpawning.finalizeSpawn(_serverLevelForEntitySpawn, world.getCurrentDifficultyAt(_entityForSpawning.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
							world.addFreshEntity(_entityForSpawning);
						}
					}
				}
			});
		}
		if (entity instanceof VampireEntity) {
			((VampireEntity) entity).setAnimation("spawn");
		}
		if (entity instanceof VampflyerEntity) {
			((VampflyerEntity) entity).setAnimation("spawn");
		}
	}
}
