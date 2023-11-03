package net.mcreator.enemyexpansion.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
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
import net.mcreator.enemyexpansion.EnemyexpansionMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class VampireHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof VampireEntity || sourceentity instanceof VampflyerEntity) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.phantom.bite")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.phantom.bite")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
			if (!(entity instanceof LivingEntity _livEnt ? _livEnt.isBlocking() : false)) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 40, 0, (false), (true)));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(EnemyexpansionModMobEffects.BITTEN.get(), 200, 0, (false), (true)));
				if (sourceentity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 0, (false), (false)));
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new GoblinFearEntity(EnemyexpansionModEntities.GOBLIN_FEAR.get(), _level);
					entityToSpawn.moveTo((x - 2), y, (z - 2), world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			}
			if (entity instanceof Villager) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 0, (false), (true)));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(EnemyexpansionModMobEffects.BITTEN.get(), 200, 0, (false), (true)));
			}
		} else if (entity instanceof VampireEntity || entity instanceof VampflyerEntity) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new GoblinFearEntity(EnemyexpansionModEntities.GOBLIN_FEAR.get(), _level);
				entityToSpawn.moveTo((x - 2), y, (z - 2), world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			VampireIgnitionProcedure.execute(world, x, y, z, entity);
		}
		if (entity instanceof VampireEntity) {
			if (Math.random() < 0.2) {
				EnemyexpansionMod.queueServerWork(1, () -> {
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
						if (!entity.level.isClientSide())
							entity.discard();
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
				});
			} else if (Math.random() < 0.1) {
				EnemyexpansionMod.queueServerWork(2, () -> {
					if (world instanceof ServerLevel _serverLevelForEntitySpawn) {
						Entity _entityForSpawning = new VampbiterEntity(EnemyexpansionModEntities.VAMPBITER.get(), _serverLevelForEntitySpawn);
						_entityForSpawning.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (!entity.level.isClientSide())
							entity.discard();
						if (_entityForSpawning instanceof Mob _mobForSpawning)
							_mobForSpawning.finalizeSpawn(_serverLevelForEntitySpawn, world.getCurrentDifficultyAt(_entityForSpawning.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(_entityForSpawning);
					}
				});
			}
		} else if (entity instanceof VampflyerEntity) {
			if (Math.random() < 0.2) {
				EnemyexpansionMod.queueServerWork(1, () -> {
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
							_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 30, 0, (false), (false)));
						if (!entity.level.isClientSide())
							entity.discard();
						if (_entityForSpawning instanceof Mob _mobForSpawning)
							_mobForSpawning.finalizeSpawn(_serverLevelForEntitySpawn, world.getCurrentDifficultyAt(_entityForSpawning.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(_entityForSpawning);
					}
				});
			} else if (Math.random() < 0.1) {
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
		}
	}
}
