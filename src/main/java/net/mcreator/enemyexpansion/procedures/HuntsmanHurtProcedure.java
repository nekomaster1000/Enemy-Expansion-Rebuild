package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class HuntsmanHurtProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(sourceentity.getYRot() + 180)) * 1.5 * 1), ((Math.sin(Math.toRadians(0 - sourceentity.getXRot())) + 0.5) * 1), (Math.cos(Math.toRadians(sourceentity.getYRot())) * 2 * 0.5)));
	}
}
