package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class MeatureKillsProcedure {
	public static void execute(LevelAccessor world, Entity sourceentity) {
		if (sourceentity == null)
			return;
		String max_health = "";
		String attribute_command = "";
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) < 50) {
			max_health = new java.text.DecimalFormat("##.##").format((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) + 1);
			attribute_command = "/attribute @s minecraft:generic.max_health base set (max_health)".replace("(max_health)", max_health);
			{
				Entity _ent = sourceentity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), attribute_command);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.HEART, (sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), 5, 3, 3, 3, 1);
			max_health = new java.text.DecimalFormat("##.##").format(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) < 30) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0, (false), (false)));
			if (sourceentity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 0, (false), (true)));
			if (sourceentity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 0, (false), (false)));
			if (sourceentity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 10, 0, (false), (false)));
		} else {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 1, (false), (false)));
			if (sourceentity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1, (false), (true)));
			if (sourceentity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 1, (false), (false)));
			if (sourceentity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 10, 1, (false), (false)));
		}
	}
}
