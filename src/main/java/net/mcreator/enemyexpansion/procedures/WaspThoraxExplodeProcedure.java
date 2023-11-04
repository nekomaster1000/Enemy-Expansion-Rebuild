package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.commands.CommandFunction;

import net.mcreator.enemyexpansion.init.EnemyexpansionModEntities;
import net.mcreator.enemyexpansion.entity.DroneEntity;
import net.mcreator.enemyexpansion.EnemyexpansionMod;

import java.util.Optional;

public class WaspThoraxExplodeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _serverLevelForEntitySpawn) {
			Entity _entityForSpawning = new DroneEntity(EnemyexpansionModEntities.DRONE.get(), _serverLevelForEntitySpawn);
			_entityForSpawning.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
			{
				Entity _ent = _entityForSpawning;
				if (!_ent.level.isClientSide() && _ent.getServer() != null) {
					Optional<CommandFunction> _fopt = _ent.getServer().getFunctions().get(new ResourceLocation("enemyexpansion:silverfriends"));
					if (_fopt.isPresent())
						_ent.getServer().getFunctions().execute(_fopt.get(), _ent.createCommandSourceStack());
				}
			}
			EnemyexpansionMod.queueServerWork(400, () -> {
				_entityForSpawning.hurt((new DamageSource("dryout")), 20);
			});
			if (_entityForSpawning instanceof Mob _mobForSpawning)
				_mobForSpawning.finalizeSpawn(_serverLevelForEntitySpawn, world.getCurrentDifficultyAt(_entityForSpawning.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
			world.addFreshEntity(_entityForSpawning);
		}
	}
}
