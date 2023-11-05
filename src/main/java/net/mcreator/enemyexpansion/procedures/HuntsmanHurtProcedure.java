package net.mcreator.enemyexpansion.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.enemyexpansion.entity.HuntsmanEntity;
import net.mcreator.enemyexpansion.EnemyexpansionMod;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class HuntsmanHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator instanceof HuntsmanEntity)) {
					if (entity instanceof HuntsmanEntity) {
						((HuntsmanEntity) entity).setAnimation("punch");
					}
					EnemyexpansionMod.queueServerWork(9, () -> {
						if (entity instanceof HuntsmanEntity) {
							((HuntsmanEntity) entity).setAnimation("empty");
						}
						if (entity.isAlive()) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.crit")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.crit")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
							entityiterator.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1.3), 0.3, (Math.cos(Math.toRadians(entity.getYRot())) * 1.3)));
							entityiterator.hurt((new DamageSource("mob")), 2);
						}
					});
				}
			}
		}
		EnemyexpansionMod.queueServerWork(20, () -> {
			if (entity.isAlive() && entity.isOnGround()) {
				entity.setDeltaMovement(new Vec3((Mth.nextDouble(RandomSource.create(), -0.6, 0.6)), (Mth.nextDouble(RandomSource.create(), 0.2, 0.6)), (Mth.nextDouble(RandomSource.create(), -0.6, 0.6))));
			}
			if (Math.random() < 0.2) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(Items.ARROW);
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				if (entity instanceof HuntsmanEntity animatable)
					animatable.setTexture("huntsman_bowless");
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 0, (false), (true)));
				EnemyexpansionMod.queueServerWork(60, () -> {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Items.BOW);
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (entity instanceof HuntsmanEntity animatable)
						animatable.setTexture("huntsman");
				});
			}
			if (Math.random() < 0.2) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BOW) {
					EnemyexpansionMod.queueServerWork(30, () -> {
						if (entity.isAlive() && sourceentity.isAlive()) {
							for (int index0 = 0; index0 < (int) (5); index0++) {
								{
									Entity _shootFrom = entity;
									Level projectileLevel = _shootFrom.level;
									if (!projectileLevel.isClientSide()) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, float damage, int knockback) {
												AbstractArrow entityToSpawn = new Arrow(EntityType.ARROW, level);
												entityToSpawn.setBaseDamage(damage);
												entityToSpawn.setKnockback(knockback);
												entityToSpawn.setCritArrow(true);
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, 5, 1);
										_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
										_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.2),
												(float) Mth.nextDouble(RandomSource.create(), 1, 50));
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
								}
							}
						}
					});
				}
			}
		});
	}
}
