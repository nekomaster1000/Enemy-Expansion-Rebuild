package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.enemyexpansion.init.EnemyexpansionModMobEffects;
import net.mcreator.enemyexpansion.init.EnemyexpansionModEntities;
import net.mcreator.enemyexpansion.entity.VampireEntity;
import net.mcreator.enemyexpansion.entity.VampflyerEntity;
import net.mcreator.enemyexpansion.EnemyexpansionMod;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class VampireTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnemyexpansionModMobEffects.TIMER.get()) ? _livEnt.getEffect(EnemyexpansionModMobEffects.TIMER.get()).getDuration() : 0) == 1) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnemyexpansionModMobEffects.TIMER.get()) ? _livEnt.getEffect(EnemyexpansionModMobEffects.TIMER.get()).getAmplifier() : 0) == 1) {
				if (world instanceof Level _level && !_level.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.GUNPOWDER));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
		if (entity.isInWater()) {
			if (entity.isAlive()) {
				if (world instanceof ServerLevel _serverLevelForEntitySpawn) {
					Entity _entityForSpawning = new VampflyerEntity(EnemyexpansionModEntities.VAMPFLYER.get(), _serverLevelForEntitySpawn);
					_entityForSpawning.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
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
					if (!entity.level.isClientSide())
						entity.discard();
					_entityForSpawning.setDeltaMovement(new Vec3((Mth.nextDouble(RandomSource.create(), -2, 2)), 0.5, (Mth.nextDouble(RandomSource.create(), -2, 2))));
					EnemyexpansionMod.queueServerWork(200, () -> {
						if (_entityForSpawning.isAlive()) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = new VampireEntity(EnemyexpansionModEntities.VAMPIRE.get(), _level);
								entityToSpawn.moveTo((_entityForSpawning.getX()), (_entityForSpawning.getY()), (_entityForSpawning.getZ()), 0, 0);
								entityToSpawn.setYBodyRot(0);
								entityToSpawn.setYHeadRot(0);
								entityToSpawn.setDeltaMovement(0, 0, 0);
								if (entityToSpawn instanceof Mob _mobToSpawn)
									_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
								world.addFreshEntity(entityToSpawn);
							}
							if (!_entityForSpawning.level.isClientSide())
								_entityForSpawning.discard();
						}
					});
					if (_entityForSpawning instanceof Mob _mobForSpawning)
						_mobForSpawning.finalizeSpawn(_serverLevelForEntitySpawn, world.getCurrentDifficultyAt(_entityForSpawning.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(_entityForSpawning);
				}
			}
		}
	}
}
