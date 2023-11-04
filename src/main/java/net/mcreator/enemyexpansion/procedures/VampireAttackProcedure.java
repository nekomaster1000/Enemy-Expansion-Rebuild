package net.mcreator.enemyexpansion.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
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

import net.mcreator.enemyexpansion.init.EnemyexpansionModMobEffects;
import net.mcreator.enemyexpansion.init.EnemyexpansionModEntities;
import net.mcreator.enemyexpansion.entity.VampireEntity;
import net.mcreator.enemyexpansion.entity.VampflyerEntity;
import net.mcreator.enemyexpansion.entity.GoblinFearEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class VampireAttackProcedure {
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
				if (entity instanceof Player) {
					if (world instanceof Level _lvl && _lvl.isDay()) {
						if (entity instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(EnemyexpansionModMobEffects.BITTEN.get(), 90, 0, (false), (true)));
					}
				} else {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(EnemyexpansionModMobEffects.BITTEN.get(), 200, 0, (false), (true)));
				}
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
	}
}
