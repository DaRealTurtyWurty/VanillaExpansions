package com.turtywurty.vanillaexpansion.damageSource;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;

public class DamageSourceSpikeTrap extends EntityDamageSource
{
	public DamageSourceSpikeTrap(final String damageName, final Entity entity) 
	{
	    super(damageName, entity);
	    setDifficultyScaled();
	    setDamageBypassesArmor();
	  }
}
