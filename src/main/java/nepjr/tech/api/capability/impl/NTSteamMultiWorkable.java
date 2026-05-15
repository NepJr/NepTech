package nepjr.tech.api.capability.impl;

import org.jetbrains.annotations.NotNull;

import gregtech.api.capability.impl.SteamMultiblockRecipeLogic;
import gregtech.api.metatileentity.multiblock.ParallelLogicType;
import gregtech.api.metatileentity.multiblock.RecipeMapSteamMultiblockController;
import gregtech.api.recipes.RecipeBuilder;

public class NTSteamMultiWorkable extends SteamMultiblockRecipeLogic {
	protected final int level;
	protected final double conversionRate;

    public NTSteamMultiWorkable(RecipeMapSteamMultiblockController tileEntity, double conversionRate, int level) {
        super(tileEntity, tileEntity.recipeMap, tileEntity.getSteamFluidTank(), conversionRate);
        this.level = level;
        if (conversionRate == 0) // In the event for some reason it's zero
        	this.conversionRate = 1;
        else
        	this.conversionRate = 1 / conversionRate;
    }

    @NotNull
    @Override
    public ParallelLogicType getParallelLogicType() {
        return ParallelLogicType.APPEND_ITEMS;
    }

    @Override
    public void applyParallelBonus(@NotNull RecipeBuilder<?> builder) {
        int currentRecipeEU = builder.getEUt();
        int currentRecipeDuration = builder.getDuration() / getParallelLimit();
        if(level == 2)
        {
        	builder.EUt((int) Math.min(32.0, Math.ceil(currentRecipeEU * conversionRate)))
            .duration((int) (currentRecipeDuration));
        }
        else
        {
        	builder.EUt((int) Math.min(32.0, Math.ceil(currentRecipeEU * conversionRate / 2)))
            .duration((int) (currentRecipeDuration * 2));
        }
    }
}
