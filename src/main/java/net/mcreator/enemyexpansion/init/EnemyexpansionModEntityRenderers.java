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
import net.mcreator.enemyexpansion.client.renderer.VampireRenderer;
import net.mcreator.enemyexpansion.client.renderer.VampflyerRenderer;
import net.mcreator.enemyexpansion.client.renderer.VampbiterRenderer;
import net.mcreator.enemyexpansion.client.renderer.TrollenragedRenderer;
import net.mcreator.enemyexpansion.client.renderer.TrollRenderer;
import net.mcreator.enemyexpansion.client.renderer.TarantulaRenderer;
import net.mcreator.enemyexpansion.client.renderer.StarvedRenderer;
import net.mcreator.enemyexpansion.client.renderer.SprinterRenderer;
import net.mcreator.enemyexpansion.client.renderer.SluggerRenderer;
import net.mcreator.enemyexpansion.client.renderer.SilverqueenbodilessRenderer;
import net.mcreator.enemyexpansion.client.renderer.SilverqueenattackingRenderer;
import net.mcreator.enemyexpansion.client.renderer.ScorpionRenderer;
import net.mcreator.enemyexpansion.client.renderer.MeatureRenderer;
import net.mcreator.enemyexpansion.client.renderer.LadybugRenderer;
import net.mcreator.enemyexpansion.client.renderer.InvisicreeperRenderer;
import net.mcreator.enemyexpansion.client.renderer.IntruderRenderer;
import net.mcreator.enemyexpansion.client.renderer.HuntsmanRenderer;
import net.mcreator.enemyexpansion.client.renderer.HouseflyRenderer;
import net.mcreator.enemyexpansion.client.renderer.GoblinRenderer;
import net.mcreator.enemyexpansion.client.renderer.GoblinFearRenderer;
import net.mcreator.enemyexpansion.client.renderer.FlutterflyRenderer;
import net.mcreator.enemyexpansion.client.renderer.FallerRenderer;
import net.mcreator.enemyexpansion.client.renderer.EquestrianRenderer;
import net.mcreator.enemyexpansion.client.renderer.DroneRenderer;
import net.mcreator.enemyexpansion.client.renderer.DirewolfRenderer;
import net.mcreator.enemyexpansion.client.renderer.CrawlerRenderer;
import net.mcreator.enemyexpansion.client.renderer.AssassinRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EnemyexpansionModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EnemyexpansionModEntities.SPRINTER.get(), SprinterRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.SLUGGER.get(), SluggerRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.MEATURE.get(), MeatureRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.EQUESTRIAN.get(), EquestrianRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.GOBLIN.get(), GoblinRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.GOBLIN_FEAR.get(), GoblinFearRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.TARANTULA.get(), TarantulaRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.SCORPION.get(), ScorpionRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.LADYBUG.get(), LadybugRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.WASP.get(), WaspRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.DRONE.get(), DroneRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.BOTFLY.get(), HouseflyRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.FLUTTERFLY.get(), FlutterflyRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.HUNTSMAN.get(), HuntsmanRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.STARVED.get(), StarvedRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.VAMPIRE.get(), VampireRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.VAMPFLYER.get(), VampflyerRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.VAMPBITER.get(), VampbiterRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.TROLL.get(), TrollRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.TROLLENRAGED.get(), TrollenragedRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.SILVERQUEEN.get(), SilverqueenattackingRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.SILVERQUEENBODILESS.get(), SilverqueenbodilessRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.DIREWOLF.get(), DirewolfRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.HEALING_EYE_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.WASP_THORAX_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.PHANTOM_EYE_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.CRAWLER.get(), CrawlerRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.INVISICREEPER.get(), InvisicreeperRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.FALLER.get(), FallerRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.INTRUDER.get(), IntruderRenderer::new);
		event.registerEntityRenderer(EnemyexpansionModEntities.ASSASSIN.get(), AssassinRenderer::new);
	}
}
