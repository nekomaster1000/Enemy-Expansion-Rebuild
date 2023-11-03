package net.mcreator.enemyexpansion.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.enemyexpansion.init.EnemyexpansionModItems;
import net.mcreator.enemyexpansion.EnemyexpansionMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SilverheadDeathProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
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
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == EnemyexpansionModItems.SILVERHEAD_HELMET.get()) {
			for (int index0 = 0; index0 < (int) (5); index0++) {
				if (world instanceof ServerLevel _serverLevelForEntitySpawn) {
					Entity _entityForSpawning = new Silverfish(EntityType.SILVERFISH, _serverLevelForEntitySpawn);
					_entityForSpawning.moveTo(x, (y + 2), z, world.getRandom().nextFloat() * 360F, 0);
					_entityForSpawning.setDeltaMovement(new Vec3((Mth.nextDouble(RandomSource.create(), -1, 1)), (Mth.nextDouble(RandomSource.create(), 0.6, 1.2)), (Mth.nextDouble(RandomSource.create(), -1, 1))));
					if (_entityForSpawning instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
						_entity.setTarget(_ent);
					EnemyexpansionMod.queueServerWork((int) Mth.nextDouble(RandomSource.create(), 160, 320), () -> {
						_entityForSpawning.hurt((new DamageSource("even_more_magic")), 20);
					});
					if (_entityForSpawning instanceof Mob _mobForSpawning)
						_mobForSpawning.finalizeSpawn(_serverLevelForEntitySpawn, world.getCurrentDifficultyAt(_entityForSpawning.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(_entityForSpawning);
				}
			}
		}
	}
}
