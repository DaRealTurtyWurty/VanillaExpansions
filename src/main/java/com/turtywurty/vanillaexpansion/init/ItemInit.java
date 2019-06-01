package com.turtywurty.vanillaexpansion.init;

import java.util.ArrayList;
import java.util.List;

import com.turtywurty.vanillaexpansion.VanillaExpansion;
import com.turtywurty.vanillaexpansion.objects.items.ItemBase;
import com.turtywurty.vanillaexpansion.objects.items.desert.ItemSandArrow;
import com.turtywurty.vanillaexpansion.objects.items.desert.ItemSandBow;
import com.turtywurty.vanillaexpansion.objects.items.desert.ItemSandySkeletonShirt;
import com.turtywurty.vanillaexpansion.objects.items.desert.ItemSarcophagusPlacer;
import com.turtywurty.vanillaexpansion.objects.items.desert.TestItem;
import com.turtywurty.vanillaexpansion.util.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ItemInit 
{
	static CreativeTabs TAB = VanillaExpansion.VANILLAEXPANSIONTAB;
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final ArmorMaterial SANDY_SHIRT = EnumHelper.addArmorMaterial("sandy_shirt", Reference.MOD_ID + ":sandy_shirt", 999999999, new int[] {0, 0, 2, 0}, 10, SoundEvents.ITEM_ARMOR_EQIIP_ELYTRA, 0.0f);
	
	public static final Item SAND_ARROW = new ItemSandArrow("sand_arrow").setCreativeTab(TAB);
	public static final Item SAND_BOW = new ItemSandBow("sand_bow").setCreativeTab(TAB);
	public static final Item SANDY_SKELETON_SHIRT = new ItemSandySkeletonShirt("sandy_shirt", SANDY_SHIRT, 1, EntityEquipmentSlot.CHEST).setCreativeTab(TAB);
	public static final Item SARCOPHAGUS_PLACER = new ItemSarcophagusPlacer("sarcophagus").setCreativeTab(TAB);
	public static final Item MOD_LOGO = new ItemBase("mod_logo");
	//public static final Item TEST_ITEM = new TestItem("test_item");
}
