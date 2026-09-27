package nepjr.tech.api.recipes.recipeproperties;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import gregtech.api.util.TextFormattingUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

public class OffworldMiningTierProperty extends RecipeProperty<Integer>
{
    public static final String KEY = "miner_tier";
    private static OffworldMiningTierProperty INSTANCE;

    protected OffworldMiningTierProperty()
    {
        super(KEY, Integer.class);
    }

    public static OffworldMiningTierProperty getInstance()
    {
        if (INSTANCE == null) {
            INSTANCE = new OffworldMiningTierProperty();
        }

        return INSTANCE;
    }

    @Override
    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("neptech.recipe.offworld_tier",
                        TextFormattingUtil.formatNumbers(castValue(value))),
                x, y,
                color);
    }
}
