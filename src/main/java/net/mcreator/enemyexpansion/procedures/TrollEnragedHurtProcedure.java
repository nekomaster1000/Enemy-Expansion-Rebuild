package net.mcreator.enemyexpansion.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
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

import net.mcreator.enemyexpansion.init.EnemyexpansionModEntities;
import net.mcreator.enemyexpansion.entity.TrollenragedEntity;
import net.mcreator.enemyexpansion.entity.TrollEntity;
import net.mcreator.enemyexpansion.EnemyexpansionMod;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class TrollEnragedHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		TrollPetrificationProcedure.execute(world, x, y, z, entity, sourceentity);
		if (entity instanceof TrollenragedEntity) {
			if (!(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE) : false)) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 4));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0));
				if (entity instanceof TrollenragedEntity) {
					((TrollenragedEntity) entity).setAnimation("roar");
				}
				EnemyexpansionMod.queueServerWork(10, () -> {
					if (entity.isAlive()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("enemyexpansion:troll.roar")), SoundSource.HOSTILE, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("enemyexpansion:troll.roar")), SoundSource.HOSTILE, 1, 1, false);
							}
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
									.collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator instanceof TrollenragedEntity)) {
									entityiterator.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 2.5), 1.25, (Math.cos(Math.toRadians(entity.getYRot())) * 2.5)));
									if (entityiterator instanceof Mob _entity && entity instanceof LivingEntity _ent)
										_entity.setTarget(_ent);
								}
							}
						}
						if (Math.random() < 0.2) {
							EnemyexpansionMod.queueServerWork(10, () -> {
								if (entity.isAlive()) {
									if (world instanceof ServerLevel _serverLevelForEntitySpawn) {
										Entity _entityForSpawning = new TrollEntity(EnemyexpansionModEntities.TROLL.get(), _serverLevelForEntitySpawn);
										_entityForSpawning.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
										{
											Entity _ent = _entityForSpawning;
											if (!_ent.level.isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
																_ent.getDisplayName(), _ent.level.getServer(), _ent),
														("/data merge entity @s {Health:20f}".replace("{Health:20f}", "{Health:" + ("" + (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) + "f}")));
											}
										}
										if (!entity.level.isClientSide())
											entity.discard();
										if (_entityForSpawning instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
											_entity.setTarget(_ent);
										if (_entityForSpawning instanceof Mob _mobForSpawning)
											_mobForSpawning.finalizeSpawn(_serverLevelForEntitySpawn, world.getCurrentDifficultyAt(_entityForSpawning.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
										world.addFreshEntity(_entityForSpawning);
									}
								}
							});
						}
					}
				});
			}
		}
	}
}
