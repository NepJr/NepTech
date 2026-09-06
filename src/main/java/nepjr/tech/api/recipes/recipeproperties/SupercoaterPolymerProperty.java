package nepjr.tech.api.recipes.recipeproperties;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import gregtech.api.util.TextFormattingUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

public class SupercoaterPolymerProperty extends RecipeProperty<Integer>
{
	public static final String KEY = "polymer_needed";
	private static SupercoaterPolymerProperty INSTANCE;
	
	protected SupercoaterPolymerProperty() 
	{
		super(KEY, Integer.class);
	}

	public static SupercoaterPolymerProperty getInstance() 
	{
        if (INSTANCE == null) {
            INSTANCE = new SupercoaterPolymerProperty();
        }

        return INSTANCE;
    }
	
	@Override
	public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
		minecraft.fontRenderer.drawString(I18n.format("neptech.recipe.polymer_needed",
                TextFormattingUtil.formatNumbers(castValue(value))),
                x, y,
                color);
	}
}