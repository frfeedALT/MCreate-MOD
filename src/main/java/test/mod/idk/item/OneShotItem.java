
package test.mod.idk.item;

import test.mod.idk.itemgroup.THEMDEDItemGroup;
import test.mod.idk.IdkModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.block.Blocks;

@IdkModElements.ModElement.Tag
public class OneShotItem extends IdkModElements.ModElement {
	@ObjectHolder("idk:one_shot")
	public static final Item block = null;
	public OneShotItem(IdkModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 111999;
			}

			public float getEfficiency() {
				return 99999f;
			}

			public float getAttackDamage() {
				return 99997f;
			}

			public int getHarvestLevel() {
				return 99999;
			}

			public int getEnchantability() {
				return 99999;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Blocks.DIRT));
			}
		}, 1, 96f, new Item.Properties().group(THEMDEDItemGroup.tab).isImmuneToFire()) {
		}.setRegistryName("one_shot"));
	}
}
