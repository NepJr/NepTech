package nepjr.tech.api.recipes.recipeproperties;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import gregtech.api.unification.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

public class SupercoaterPolymerTypeProperty extends RecipeProperty<Material>
{
	public static final String KEY = "polymer_type";
	private static SupercoaterPolymerTypeProperty INSTANCE;
	
	protected SupercoaterPolymerTypeProperty() 
	{
		super(KEY, Material.class);
	}

	public static SupercoaterPolymerTypeProperty getInstance() 
	{
        if (INSTANCE == null) {
            INSTANCE = new SupercoaterPolymerTypeProperty();
        }

        return INSTANCE;
    }
	
	@Override
	public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) 
	{
		minecraft.fontRenderer.drawString(I18n.format("neptech.recipe.polymer_type", I18n.format(castValue(value).getUnlocalizedName())), x, y, color);
	}
}
