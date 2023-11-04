package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.enemyexpansion.EnemyexpansionMod;

import java.util.Iterator;

public class UseThoraxProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		EnemyexpansionMod.queueServerWork(40, () -> {
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("enemyexpansion:wasp_drone_summon"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemainingCriteria().iterator();
					while (_iterator.hasNext())
						_player.getAdvancements().award(_adv, (String) _iterator.next());
				}
			}
		});
	}
}
