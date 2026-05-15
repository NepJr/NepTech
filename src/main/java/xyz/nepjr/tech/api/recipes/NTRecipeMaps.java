package xyz.nepjr.tech.api.recipes;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget.MoveType;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.core.sound.GTSoundEvents;
import stanhebben.zenscript.annotations.ZenProperty;

public class NTRecipeMaps 
{
	@ZenProperty
	public static final RecipeMap<SimpleRecipeBuilder> GREENHOUSE_RECIPES = new RecipeMap<>("greenhouse", 3, 6, 1, 0,
			new SimpleRecipeBuilder(), false)
						.setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, MoveType.HORIZONTAL)
						.setSound(GTSoundEvents.CHAINSAW_TOOL);
}
