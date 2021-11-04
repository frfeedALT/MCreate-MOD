package test.mod.idk.procedures;

import test.mod.idk.IdkMod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class GunBulletHitsLivingEntityProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				IdkMod.LOGGER.warn("Failed to load dependency entity for procedure GunBulletHitsLivingEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof ServerPlayerEntity) {
			((ServerPlayerEntity) entity).unlockRecipes(new ResourceLocation[]{new ResourceLocation("lole")});
		}
		if (entity instanceof ServerPlayerEntity) {
			((ServerPlayerEntity) entity).unlockRecipes(new ResourceLocation[]{new ResourceLocation("lolw")});
		}
	}
}
