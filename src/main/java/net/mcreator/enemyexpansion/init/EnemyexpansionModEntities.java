
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.enemyexpansion.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.enemyexpansion.entity.WaspThoraxEntity;
import net.mcreator.enemyexpansion.entity.WaspEntity;
import net.mcreator.enemyexpansion.entity.TarantulaEntity;
import net.mcreator.enemyexpansion.entity.SprinterEntity;
import net.mcreator.enemyexpansion.entity.SluggerEntity;
import net.mcreator.enemyexpansion.entity.ScorpionEntity;
import net.mcreator.enemyexpansion.entity.MeatureEntity;
import net.mcreator.enemyexpansion.entity.LadybugEntity;
import net.mcreator.enemyexpansion.entity.HouseflyEntity;
import net.mcreator.enemyexpansion.entity.HealingEyeEntity;
import net.mcreator.enemyexpansion.entity.GoblinFearEntity;
import net.mcreator.enemyexpansion.entity.GoblinEntity;
import net.mcreator.enemyexpansion.entity.FlutterflyEntity;
import net.mcreator.enemyexpansion.entity.EquestrianEntity;
import net.mcreator.enemyexpansion.entity.DroneEntity;
import net.mcreator.enemyexpansion.EnemyexpansionMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnemyexpansionModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, EnemyexpansionMod.MODID);
	public static final RegistryObject<EntityType<SluggerEntity>> SLUGGER = register("slugger",
			EntityType.Builder.<SluggerEntity>of(SluggerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SluggerEntity::new)

					.sized(0.6f, 2.3f));
	public static final RegistryObject<EntityType<SprinterEntity>> SPRINTER = register("sprinter",
			EntityType.Builder.<SprinterEntity>of(SprinterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SprinterEntity::new)

					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<MeatureEntity>> MEATURE = register("meature",
			EntityType.Builder.<MeatureEntity>of(MeatureEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MeatureEntity::new)

					.sized(0.7999999999999999f, 0.7999999999999999f));
	public static final RegistryObject<EntityType<EquestrianEntity>> EQUESTRIAN = register("equestrian",
			EntityType.Builder.<EquestrianEntity>of(EquestrianEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(EquestrianEntity::new)

					.sized(1.2f, 2.5f));
	public static final RegistryObject<EntityType<GoblinEntity>> GOBLIN = register("goblin",
			EntityType.Builder.<GoblinEntity>of(GoblinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GoblinEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<GoblinFearEntity>> GOBLIN_FEAR = register("goblin_fear",
			EntityType.Builder.<GoblinFearEntity>of(GoblinFearEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(0).setUpdateInterval(3).setCustomClientFactory(GoblinFearEntity::new)

					.sized(1f, 1f));
	public static final RegistryObject<EntityType<TarantulaEntity>> TARANTULA = register("tarantula",
			EntityType.Builder.<TarantulaEntity>of(TarantulaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TarantulaEntity::new)

					.sized(1.5f, 1.1f));
	public static final RegistryObject<EntityType<ScorpionEntity>> SCORPION = register("scorpion",
			EntityType.Builder.<ScorpionEntity>of(ScorpionEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ScorpionEntity::new)

					.sized(1.5f, 1.1f));
	public static final RegistryObject<EntityType<LadybugEntity>> LADYBUG = register("ladybug",
			EntityType.Builder.<LadybugEntity>of(LadybugEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LadybugEntity::new)

					.sized(0.9f, 0.95f));
	public static final RegistryObject<EntityType<HealingEyeEntity>> HEALING_EYE = register("projectile_healing_eye",
			EntityType.Builder.<HealingEyeEntity>of(HealingEyeEntity::new, MobCategory.MISC).setCustomClientFactory(HealingEyeEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<WaspEntity>> WASP = register("wasp",
			EntityType.Builder.<WaspEntity>of(WaspEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(WaspEntity::new)

					.sized(0.45f, 1.6f));
	public static final RegistryObject<EntityType<DroneEntity>> DRONE = register("drone",
			EntityType.Builder.<DroneEntity>of(DroneEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DroneEntity::new)

					.sized(0.45f, 1.6f));
	public static final RegistryObject<EntityType<WaspThoraxEntity>> WASP_THORAX = register("projectile_wasp_thorax",
			EntityType.Builder.<WaspThoraxEntity>of(WaspThoraxEntity::new, MobCategory.MISC).setCustomClientFactory(WaspThoraxEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<HouseflyEntity>> HOUSEFLY = register("housefly",
			EntityType.Builder.<HouseflyEntity>of(HouseflyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HouseflyEntity::new)

					.sized(0.45f, 1.6f));
	public static final RegistryObject<EntityType<FlutterflyEntity>> FLUTTERFLY = register("flutterfly",
			EntityType.Builder.<FlutterflyEntity>of(FlutterflyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FlutterflyEntity::new)

					.sized(0.45f, 1.6f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			SluggerEntity.init();
			SprinterEntity.init();
			MeatureEntity.init();
			EquestrianEntity.init();
			GoblinEntity.init();
			GoblinFearEntity.init();
			TarantulaEntity.init();
			ScorpionEntity.init();
			LadybugEntity.init();
			WaspEntity.init();
			DroneEntity.init();
			HouseflyEntity.init();
			FlutterflyEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(SLUGGER.get(), SluggerEntity.createAttributes().build());
		event.put(SPRINTER.get(), SprinterEntity.createAttributes().build());
		event.put(MEATURE.get(), MeatureEntity.createAttributes().build());
		event.put(EQUESTRIAN.get(), EquestrianEntity.createAttributes().build());
		event.put(GOBLIN.get(), GoblinEntity.createAttributes().build());
		event.put(GOBLIN_FEAR.get(), GoblinFearEntity.createAttributes().build());
		event.put(TARANTULA.get(), TarantulaEntity.createAttributes().build());
		event.put(SCORPION.get(), ScorpionEntity.createAttributes().build());
		event.put(LADYBUG.get(), LadybugEntity.createAttributes().build());
		event.put(WASP.get(), WaspEntity.createAttributes().build());
		event.put(DRONE.get(), DroneEntity.createAttributes().build());
		event.put(HOUSEFLY.get(), HouseflyEntity.createAttributes().build());
		event.put(FLUTTERFLY.get(), FlutterflyEntity.createAttributes().build());
	}
}
