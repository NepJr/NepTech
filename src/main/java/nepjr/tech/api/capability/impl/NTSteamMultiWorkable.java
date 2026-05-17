package nepjr.tech.api.capability.impl;

import org.jetbrains.annotations.NotNull;

import gregtech.api.GTValues;
import gregtech.api.capability.impl.SteamMultiblockRecipeLogic;
import gregtech.api.metatileentity.multiblock.ParallelLogicType;
import gregtech.api.metatileentity.multiblock.RecipeMapSteamMultiblockController;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import nepjr.tech.metatileentities.multi.steam.MetaTileEntitySteamSmelter;

public class NTSteamMultiWorkable extends SteamMultiblockRecipeLogic {
	
	protected final int level;
	protected final double conversionRate;
	protected final RecipeMapSteamMultiblockController mte;

    public NTSteamMultiWorkable(RecipeMapSteamMultiblockController tileEntity, double conversionRate, int level) {
        super(tileEntity, tileEntity.recipeMap, tileEntity.getSteamFluidTank(), conversionRate);
        this.level = level;
        this.mte = tileEntity;
        if (conversionRate == 0) // In the event for some reason it's zero
        	this.conversionRate = 1;
        else
        	this.conversionRate = 1 / conversionRate;
    }

    @Override
    public long getMaxVoltage() {
        return GTValues.V[GTValues.HV];
    }
    
    @Override
    public boolean checkRecipe(@NotNull Recipe recipe)
    {
    	return recipe.getEUt() > 32 ? false : true;
    }
    
    @NotNull
    @Override
    public ParallelLogicType getParallelLogicType() {
        return mte instanceof MetaTileEntitySteamSmelter ? // Multiply on furnace recipes causes weird issues, so we only run it on APPEND_ITEMS.
        		ParallelLogicType.APPEND_ITEMS :
        		ParallelLogicType.MULTIPLY;
    }

    @Override
    public void applyParallelBonus(@NotNull RecipeBuilder<?> builder) {
        int currentRecipeEU = builder.getEUt();
        int currentRecipeDuration = mte instanceof MetaTileEntitySteamSmelter ?
        									builder.getDuration() / getParallelLimit():
        									builder.getDuration();
        if(level == 2)
        {
        	builder.EUt((int) Math.ceil(currentRecipeEU * conversionRate))
            .duration((int) (currentRecipeDuration));
        }
        else
        {
        	builder.EUt((int) Math.ceil(currentRecipeEU * conversionRate / 2))
            .duration((int) (currentRecipeDuration * 2));
        }
    }
}
