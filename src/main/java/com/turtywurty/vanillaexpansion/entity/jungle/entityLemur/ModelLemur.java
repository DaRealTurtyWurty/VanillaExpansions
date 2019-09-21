package com.turtywurty.vanillaexpansion.entity.jungle.entityLemur;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelLemur extends ModelBase
{
	private final ModelRenderer bone;
	public ModelLemur() 
	{
		textureWidth = 32;
		textureHeight = 32;
		
		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 4, 14, 3.0F, -4.0F, -4.0F, 1, 4, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 17, 14, 3.0F, -4.0F, -3.0F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 6, 0, -4.0F, -4.0F, -3.0F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 4, 4, 3.0F, -4.0F, 3.0F, 1, 4, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 19, 3.0F, -4.0F, 2.0F, 1, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 20, 15, 3.0F, -1.0F, 2.0F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 14, -4.0F, -4.0F, -4.0F, 1, 4, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 4, -4.0F, -4.0F, 3.0F, 1, 4, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 13, 18, -4.0F, -4.0F, 2.0F, 1, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 20, 20, -4.0F, -1.0F, 2.0F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -3.0F, -6.0F, -6.0F, 6, 4, 10, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 16, 16, 3.0F, -7.0F, -5.0F, 1, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 17, 19, 2.0F, -7.0F, -5.0F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 4, 19, -3.0F, -7.0F, -5.0F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 13, 14, -4.0F, -7.0F, -5.0F, 1, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -1.0F, -4.0F, -8.0F, 2, 2, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 14, -1.0F, -5.0F, 4.0F, 2, 2, 9, 0.0F, false));
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
	{
		bone.render(f5);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
