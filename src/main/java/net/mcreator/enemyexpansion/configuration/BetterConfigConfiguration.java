package net.mcreator.enemyexpansion.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class BetterConfigConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Double> CAVEMOBSPAWNDEPTH;
	public static final ForgeConfigSpec.ConfigValue<Double> SPAWNFLIESONDEATH;
	static {
		BUILDER.push("mobSpawning");
		CAVEMOBSPAWNDEPTH = BUILDER.comment("Range: -64 to 318").define("Topmost Y-level at which Cave Mobs can spawn", (double) 50);
		SPAWNFLIESONDEATH = BUILDER.comment("Range: 0 to 100 (Percent)").define("Chance Houseflies will spawn from a slain Zombie", (double) 5);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
