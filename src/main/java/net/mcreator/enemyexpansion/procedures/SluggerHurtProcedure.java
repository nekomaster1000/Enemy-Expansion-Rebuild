package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.enemyexpansion.entity.SluggerEntity;
import net.mcreator.enemyexpansion.EnemyexpansionMod;

public class SluggerHurtProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!entity.isOnFire() && (sourceentity instanceof LivingEntity || sourceentity instanceof Arrow) && !(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 24, 6));
			EnemyexpansionMod.queueServerWork(10, () -> {
				if (entity instanceof SluggerEntity) {
					((SluggerEntity) entity).setAnimation("charge_used");
				}
			});
		}
	}
}
