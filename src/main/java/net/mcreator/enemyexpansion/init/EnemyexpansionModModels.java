
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.enemyexpansion.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.enemyexpansion.client.model.Modelmeathead;
import net.mcreator.enemyexpansion.client.model.Modelhorsehead;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class EnemyexpansionModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelhorsehead.LAYER_LOCATION, Modelhorsehead::createBodyLayer);
		event.registerLayerDefinition(Modelmeathead.LAYER_LOCATION, Modelmeathead::createBodyLayer);
	}
}
