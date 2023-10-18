
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.enemyexpansion.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.enemyexpansion.client.renderer.WaspRenderer;
import net.mcreator.enemyexpansion.client.renderer.TarantulaRenderer;
import net.mcreator.enemyexpansion.client.renderer.SprinterRenderer;
import net.mcreator.enemyexpansion.client.renderer.SluggerRenderer;
import net.mcreator.enemyexpansion.client.renderer.ScorpionRenderer;
import net.mcreator.enemyexpansion.client.renderer.MeatureRenderer;
import net.mcreator.enemyexpansion.client.renderer.LadybugRenderer;
import net.mcreator.enemyexpansion.client.renderer.HouseflyRenderer;
import net.mcreator.enemyexpansion.client.renderer.GoblinRenderer;
import net.mcreator.enemyexpansion.client.renderer.GoblinFearRenderer;
import net.mcreator.enemyexpansion.client.renderer.FlutterflyRenderer;
import net.mcreator.enemyexpansion.client.renderer.EquestrianRenderer;
import net.mcreator.enemyexpansion.client.renderer.DroneRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EnemyexpansionModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EnemyexpansionModEntities.SLUGGER.get(), SluggerRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.SPRINTER.get(), SprinterRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.MEATURE.get(), MeatureRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.EQUESTRIAN.get(), EquestrianRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.GOBLIN.get(), GoblinRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.GOBLIN_FEAR.get(), GoblinFearRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.TARANTULA.get(), TarantulaRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.SCORPION.get(), ScorpionRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.LADYBUG.get(), LadybugRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.HEALING_EYE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.WASP.get(), WaspRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.DRONE.get(), DroneRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.WASP_THORAX.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.HOUSEFLY.get(), HouseflyRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.FLUTTERFLY.get(), FlutterflyRenderer::new);
	}
}
