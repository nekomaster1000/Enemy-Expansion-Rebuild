package net.mcreator.enemyexpansion.procedures;

public class MeaturePanicProcedure {
	public static boolean execute() {
		if (Math.random() < 0.2) {
			return true;
		}
		return false;
	}
}
