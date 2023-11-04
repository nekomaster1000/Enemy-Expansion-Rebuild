package net.mcreator.enemyexpansion.procedures;

import net.mcreator.enemyexpansion.configuration.BetterConfigConfiguration;

public class IfBelowY50Procedure {
	public static boolean execute(double y) {
		if (y < (double) BetterConfigConfiguration.CAVEMOBSPAWNDEPTH.get()) {
			return true;
		}
		return false;
	}
}
