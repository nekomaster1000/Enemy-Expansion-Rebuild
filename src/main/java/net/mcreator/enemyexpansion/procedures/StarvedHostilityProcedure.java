package net.mcreator.enemyexpansion.procedures;

public class StarvedHostilityProcedure {
	public static boolean execute() {
		if (Math.random() < 0.025) {
			return true;
		}
		return false;
	}
}
