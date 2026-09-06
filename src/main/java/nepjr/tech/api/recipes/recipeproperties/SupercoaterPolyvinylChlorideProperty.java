package nepjr.tech.api.recipes.recipeproperties;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import gregtech.api.util.TextFormattingUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

public class SupercoaterPolyvinylChlorideProperty extends RecipeProperty<Integer>
{
	public static final String KEY = "polyvinyl_chloride_needed";
	private static SupercoaterPolyvinylChlorideProperty INSTANCE;
	
	protected SupercoaterPolyvinylChlorideProperty() 
	{
		super(KEY, Integer.class);
	}

	public static SupercoaterPolyvinylChlorideProperty getInstance() 
	{
        if (INSTANCE == null) {
            INSTANCE = new SupercoaterPolyvinylChlorideProperty();
        }

        return INSTANCE;
    }
	
	@Override
	public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
		minecraft.fontRenderer.drawString(I18n.format("neptech.recipe.polyvinyl_chloride_needed",
                TextFormattingUtil.formatNumbers(castValue(value))),
                x, y,
                color);
	}

}
