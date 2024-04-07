package net.mcreator.enemyexpansion.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.enemyexpansion.init.EnemyexpansionModMobEffects;
import net.mcreator.enemyexpansion.init.EnemyexpansionModEntities;
import net.mcreator.enemyexpansion.entity.VampireEntity;
import net.mcreator.enemyexpansion.entity.VampflyerEntity;
import net.mcreator.enemyexpansion.entity.VampbiterEntity;
import net.mcreator.enemyexpansion.entity.GoblinFearEntity;
import net.mcreator.enemyexpansion.configuration.BetterConfigConfiguration;
import net.mcreator.enemyexpansion.EnemyexpansionMod;

public class VampireHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof VampireEntity) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new GoblinFearEntity(EnemyexpansionModEntities.GOBLIN_FEAR.get(), _level);
				entityToSpawn.moveTo((x - 2), y, (z - 2), world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			VampireIgnitionProcedure.execute(world, x, y, z, entity);
			if (Math.random() < (double) BetterConfigConfiguration.VAMPIRETOFLYER.get() / 100) {
				if (world instanceof ServerLevel _serverLevelForEntitySpawn) {
					Entity _entityForSpawning = new VampflyerEntity(EnemyexpansionModEntities.VAMPFLYER.get(), _serverLevelForEntitySpawn);
					_entityForSpawning.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					{
						Entity _ent = _entityForSpawning;
						if (!_ent.level.isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level.getServer(), _ent),
											("/data merge entity @s {Health:20f}".replace("{Health:20f}", "{Health:" + ("" + (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) + "f}")));
						}
					}
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(EnemyexpansionModMobEffects.DESPAWNER.get(), 1, 0, (false), (false)));
					_entityForSpawning.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(sourceentity.getYRot() + 180)) * 1.3), 0.1, (Math.cos(Math.toRadians(sourceentity.getYRot())) * 1.3)));
					EnemyexpansionMod.queueServerWork(20, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.phantom.ambient")), SoundSource.HOSTILE, 1, 2);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.phantom.ambient")), SoundSource.HOSTILE, 1, 2, false);
							}
						}
						if (_entityForSpawning instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get(), 50, 2, (false), (true)));
					});
					if (_entityForSpawning instanceof Mob _mobForSpawning)
						_mobForSpawning.finalizeSpawn(_serverLevelForEntitySpawn, world.getCurrentDifficultyAt(_entityForSpawning.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(_entityForSpawning);
				}
			} else if (Math.random() < (double) BetterConfigConfiguration.VAMPIRETOBITER.get() / 100) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(EnemyexpansionModMobEffects.DESPAWNER.get(), 2, 0, (false), (false)));
				if (world instanceof ServerLevel _serverLevelForEntitySpawn) {
					Entity _entityForSpawning = new VampbiterEntity(EnemyexpansionModEntities.VAMPBITER.get(), _serverLevelForEntitySpawn);
					_entityForSpawning.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (_entityForSpawning instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get(), 10, 0, (false), (true)));
					if (_entityForSpawning instanceof Mob _mobForSpawning)
						_mobForSpawning.finalizeSpawn(_serverLevelForEntitySpawn, world.getCurrentDifficultyAt(_entityForSpawning.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(_entityForSpawning);
				}
			}
		} else if (entity instanceof VampflyerEntity) {
			VampireIgnitionProcedure.execute(world, x, y, z, entity);
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get());
			entity.setDeltaMovement(new Vec3((Mth.nextDouble(RandomSource.create(), -1.5, 1.5)), (Mth.nextInt(RandomSource.create(), (int) (-0.1), (int) 0.1)), (Mth.nextDouble(RandomSource.create(), -1.5, 1.5))));
			EnemyexpansionMod.queueServerWork((int) Mth.nextDouble(RandomSource.create(), 15, 25), () -> {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get(), (int) Mth.nextDouble(RandomSource.create(), 40, 80), (int) Mth.nextDouble(RandomSource.create(), 0, 2), (false), (false)));
			});
			if (Math.random() < (double) BetterConfigConfiguration.FLYERTOVAMPIRE.get() / 100) {
				if (world instanceof ServerLevel _serverLevelForEntitySpawn) {
					Entity _entityForSpawning = new VampireEntity(EnemyexpansionModEntities.VAMPIRE.get(), _serverLevelForEntitySpawn);
					_entityForSpawning.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					{
						Entity _ent = _entityForSpawning;
						if (!_ent.level.isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level.getServer(), _ent),
											("/data merge entity @s {Health:20f}".replace("{Health:20f}", "{Health:" + ("" + (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) + "f}")));
						}
					}
					if (_entityForSpawning instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 50, 0, (false), (false)));
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(EnemyexpansionModMobEffects.DESPAWNER.get(), 1, 0, (false), (false)));
					if (_entityForSpawning instanceof Mob _mobForSpawning)
						_mobForSpawning.finalizeSpawn(_serverLevelForEntitySpawn, world.getCurrentDifficultyAt(_entityForSpawning.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(_entityForSpawning);
				}
			} else if (Math.random() < (double) BetterConfigConfiguration.VAMPIRETOBITER.get() / 100) {
				if (world instanceof ServerLevel _serverLevelForEntitySpawn) {
					Entity _entityForSpawning = new VampbiterEntity(EnemyexpansionModEntities.VAMPBITER.get(), _serverLevelForEntitySpawn);
					_entityForSpawning.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (!entity.level.isClientSide())
						entity.discard();
					if (_entityForSpawning instanceof Mob _mobForSpawning)
						_mobForSpawning.finalizeSpawn(_serverLevelForEntitySpawn, world.getCurrentDifficultyAt(_entityForSpawning.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(_entityForSpawning);
				}
			}
		} else if (entity instanceof VampbiterEntity) {
			VampireIgnitionProcedure.execute(world, x, y, z, entity);
		}
	}
}
