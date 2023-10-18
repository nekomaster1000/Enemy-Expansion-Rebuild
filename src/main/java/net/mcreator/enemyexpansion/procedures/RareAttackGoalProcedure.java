package net.mcreator.enemyexpansion.procedures;

public class RareAttackGoalProcedure {
	public static boolean execute() {
		if (Math.random() < 0.005) {
			return true;
		}
		return false;
	}
}
