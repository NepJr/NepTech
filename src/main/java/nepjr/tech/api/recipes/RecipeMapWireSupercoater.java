package nepjr.tech.api.recipes;

import org.jetbrains.annotations.NotNull;

import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.ModularUI.Builder;
import gregtech.api.gui.widgets.RecipeProgressWidget;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import net.minecraftforge.items.IItemHandlerModifiable;

public class RecipeMapWireSupercoater<R extends RecipeBuilder<R>> extends RecipeMap<R> 
{

	public RecipeMapWireSupercoater(@NotNull String unlocalizedName, int maxInputs, int maxOutputs, int maxFluidInputs, int maxFluidOutputs, @NotNull R defaultRecipeBuilder, boolean isHidden) 
	{
		super(unlocalizedName, maxInputs, true, maxOutputs, true, maxFluidInputs, true, maxFluidOutputs, true, defaultRecipeBuilder, isHidden);
	}
	
	@Override
	@NotNull
    public ModularUI.Builder createJeiUITemplate(IItemHandlerModifiable importItems, IItemHandlerModifiable exportItems,
            FluidTankList importFluids, FluidTankList exportFluids, int yOffset) 
	{
		ModularUI.Builder builder = defaultBuilder(yOffset);
		builder.widget(new RecipeProgressWidget(200, 78, 23 + yOffset, 20, 20, progressBarTexture, moveType, this));
		addInventorySlotGroup(builder, importItems, importFluids, false, yOffset);
		addInventorySlotGroup(builder, exportItems, exportFluids, true, yOffset);
		if (this.specialTexture != null && this.specialTexturePosition != null) addSpecialTexture(builder);
			return builder;
	}
	
	private static Builder defaultBuilder(int yOffset) {
        return new Builder(GuiTextures.BACKGROUND, 176, 206 + yOffset);
    }

}
