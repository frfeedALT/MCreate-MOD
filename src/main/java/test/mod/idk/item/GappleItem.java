
package test.mod.idk.item;

import test.mod.idk.itemgroup.THEMDEDItemGroup;
import test.mod.idk.IdkModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import java.util.List;

@IdkModElements.ModElement.Tag
public class GappleItem extends IdkModElements.ModElement {
	@ObjectHolder("idk:gapple")
	public static final Item block = null;
	public GappleItem(IdkModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(THEMDEDItemGroup.tab).maxStackSize(64).rarity(Rarity.EPIC)
					.food((new Food.Builder()).hunger(100).saturation(100f).setAlwaysEdible().build()));
			setRegistryName("gapple");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 1;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("death"));
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = new ItemStack(Items.ENCHANTED_GOLDEN_APPLE);
			super.onItemUseFinish(itemstack, world, entity);
			if (itemstack.isEmpty()) {
				return retval;
			} else {
				if (entity instanceof PlayerEntity) {
					PlayerEntity player = (PlayerEntity) entity;
					if (!player.isCreative() && !player.inventory.addItemStackToInventory(retval))
						player.dropItem(retval, false);
				}
				return itemstack;
			}
		}
	}
}
