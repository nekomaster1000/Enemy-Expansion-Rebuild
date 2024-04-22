package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

import net.mcreator.enemyexpansion.entity.CrawlerEntity;

public class CrawlerHurtProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof CrawlerEntity) {
			entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(sourceentity.getYRot() + 180)) * 2), 0.3, (Math.cos(Math.toRadians(sourceentity.getYRot())) * 2)));
		}
	}
}
