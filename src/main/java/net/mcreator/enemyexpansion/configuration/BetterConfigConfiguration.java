package net.mcreator.enemyexpansion.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class BetterConfigConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Double> CAVEMOBSPAWNDEPTH;
	public static final ForgeConfigSpec.ConfigValue<Double> VAMPIRETOFLYER;
	public static final ForgeConfigSpec.ConfigValue<Double> FLYERTOVAMPIRE;
	public static final ForgeConfigSpec.ConfigValue<Double> VAMPIRETOBITER;
	public static final ForgeConfigSpec.ConfigValue<Double> TROLLBECOMESENRAGED;
	public static final ForgeConfigSpec.ConfigValue<Double> ENRAGEDBECOMESTROLL;
	public static final ForgeConfigSpec.ConfigValue<Boolean> VAMPIRESEXPLODE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> TROLLSPETRIFY;
	public static final ForgeConfigSpec.ConfigValue<Double> SPAWNFLIESONDEATH;
	public static final ForgeConfigSpec.ConfigValue<Double> PHANTOMEYE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> OVERTIMEFORALL;
	static {
		BUILDER.push("mobs");
		CAVEMOBSPAWNDEPTH = BUILDER.comment("Range: -64 to 318").define("Topmost Y-level at which Cave Mobs can spawn", (double) 50);
		VAMPIRETOFLYER = BUILDER.comment("Range: 0 to 100 (Percent)").define("Chance Vampires will start flying when hurt", (double) 20);
		FLYERTOVAMPIRE = BUILDER.comment("Range: 0 to 100 (Percent)").define("Chance Vampires will stop flying when hurt", (double) 30);
		VAMPIRETOBITER = BUILDER.comment("Range: 0 to 100 (Percent)").define("Chance Vampire will turn into a Biter, regenerating it's health", (double) 10);
		TROLLBECOMESENRAGED = BUILDER.comment("Range: 0 to 100 (Percent)").define("Chance Troll will become enraged when hurt", (double) 20);
		ENRAGEDBECOMESTROLL = BUILDER.comment("Range: 0 to 100 (Percent)").define("Chance Troll will calm down from rage when hurt", (double) 20);
		BUILDER.pop();
		BUILDER.push("extra death conditions");
		VAMPIRESEXPLODE = BUILDER.define("Vampires explode from burning", true);
		TROLLSPETRIFY = BUILDER.define("Trolls petrify when hurt under sunlight", true);
		SPAWNFLIESONDEATH = BUILDER.comment("Range: 0 to 100 (Percent)").define("Chance Botflies will spawn from a slain Zombie", (double) 5);
		PHANTOMEYE = BUILDER.comment("Range: 0 to 100 (Percent)").define("Chance Phantoms drop their Eyes", (double) 15);
		BUILDER.pop();
		BUILDER.push("experimental");
		OVERTIMEFORALL = BUILDER.comment("All hostile mobs get faster the longer they look at you, like Intruders.").define("Overtime for All", false);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
