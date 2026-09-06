package nepjr.tech.api.recipes.recipeproperties;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import gregtech.api.util.TextFormattingUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

public class SupercoaterPolyphenyleneSulfideProperty extends RecipeProperty<Integer>
{
	public static final String KEY = "polyphenylene_sulfide_needed";
	private static SupercoaterPolyphenyleneSulfideProperty INSTANCE;
	
	protected SupercoaterPolyphenyleneSulfideProperty() 
	{
		super(KEY, Integer.class);
	}

	public static SupercoaterPolyphenyleneSulfideProperty getInstance() 
	{
        if (INSTANCE == null) {
            INSTANCE = new SupercoaterPolyphenyleneSulfideProperty();
        }

        return INSTANCE;
    }
	
	@Override
	public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
		minecraft.fontRenderer.drawString(I18n.format("neptech.recipe.polyphenylene_sulfide_needed",
                TextFormattingUtil.formatNumbers(castValue(value))),
                x, y,
                color);
	}

}
