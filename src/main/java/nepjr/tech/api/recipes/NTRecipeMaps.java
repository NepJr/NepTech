package nepjr.tech.api.recipes;

import static gregtech.api.GTValues.IV;
import static gregtech.api.GTValues.VA;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget.MoveType;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.BlastRecipeBuilder;
import gregtech.api.recipes.builders.GasCollectorRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.core.sound.GTSoundEvents;
import net.minecraft.init.SoundEvents;
import stanhebben.zenscript.annotations.ZenProperty;

public class NTRecipeMaps 
{
	@ZenProperty
	public static final RecipeMap<SimpleRecipeBuilder> GREENHOUSE_RECIPES = new RecipeMap<>("greenhouse", 3, 6, 1, 0,
			new SimpleRecipeBuilder(), false)
						.setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, MoveType.HORIZONTAL)
						.setSound(GTSoundEvents.CHAINSAW_TOOL);
	
	@ZenProperty
	public static final RecipeMap<GasCollectorRecipeBuilder> ASTEROID_MINING = new RecipeMap<>("asteroid_mining", 3, 9, 2, 2,
			new GasCollectorRecipeBuilder(), false)
						.setProgressBar(GuiTextures.PROGRESS_BAR_FUSION, MoveType.HORIZONTAL)
						.setSound(GTSoundEvents.MINER);
	
	@ZenProperty
	public static final RecipeMap<SimpleRecipeBuilder> AUTO_SIFTER = new RecipeMap<>("auto_sifter", 1, 9, 0, 0,
			new SimpleRecipeBuilder(), false)
						.setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, MoveType.HORIZONTAL)
						.setSound(SoundEvents.BLOCK_SAND_PLACE);
	
	@ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> ELECTRIC_IMPLOSION_RECIPES = new RecipeMap<>("electric_implosion_compressor", 3,
            2, 0, 0, new SimpleRecipeBuilder().duration(200).EUt(VA[IV]), false)
                    .setSlotOverlay(false, false, true, GuiTextures.IMPLOSION_OVERLAY_1)
                    .setSlotOverlay(false, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
                    .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
                    .setSound(SoundEvents.ENTITY_GENERIC_EXPLODE);
	
	public static final RecipeMap<BlastRecipeBuilder> ALLOY_BLAST_RECIPES = new RecipeMap<>("alloy_blast_smelter", 9, 0,
            3, 1, new BlastRecipeBuilder(), false)
                    .setSlotOverlay(false, false, false, GuiTextures.FURNACE_OVERLAY_1)
                    .setSlotOverlay(false, false, true, GuiTextures.FURNACE_OVERLAY_1)
                    .setSlotOverlay(false, true, false, GuiTextures.FURNACE_OVERLAY_2)
                    .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
                    .setSlotOverlay(true, true, false, GuiTextures.FURNACE_OVERLAY_2)
                    .setSlotOverlay(true, true, true, GuiTextures.FURNACE_OVERLAY_2)
                    .setSound(GTSoundEvents.FURNACE);
}
