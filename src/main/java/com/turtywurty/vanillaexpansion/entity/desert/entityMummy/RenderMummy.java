package com.turtywurty.vanillaexpansion.entity.desert.entityMummy;

import com.turtywurty.vanillaexpansion.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMummy extends RenderLiving<EntityMummy>
{
	private static final ResourceLocation MUMMY_TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/mummy/mummy.png");
	
	public RenderMummy(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelMummy(), 0.5F);
    }
	
	@Override
	protected ResourceLocation getEntityTexture(EntityMummy entity) 
	{
		return MUMMY_TEXTURES;
	}
}
