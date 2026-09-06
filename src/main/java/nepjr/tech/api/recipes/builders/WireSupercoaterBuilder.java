package nepjr.tech.api.recipes.builders;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.util.EnumValidationResult;
import nepjr.tech.NepTech;
import nepjr.tech.api.recipes.recipeproperties.SupercoaterPolymerProperty;
import nepjr.tech.api.recipes.recipeproperties.SupercoaterPolymerTypeProperty;
import nepjr.tech.api.recipes.recipeproperties.SupercoaterPolyphenyleneSulfideProperty;
import nepjr.tech.api.recipes.recipeproperties.SupercoaterPolyvinylChlorideProperty;

public class WireSupercoaterBuilder extends RecipeBuilder<WireSupercoaterBuilder>
{
	public WireSupercoaterBuilder() {}

    public WireSupercoaterBuilder(Recipe recipe, RecipeMap<WireSupercoaterBuilder> recipeMap) 
    {
        super(recipe, recipeMap);
    }

    public WireSupercoaterBuilder(RecipeBuilder<WireSupercoaterBuilder> recipeBuilder) 
    {
        super(recipeBuilder);
    }
    
    @Override
    public WireSupercoaterBuilder copy() 
    {
        return new WireSupercoaterBuilder(this);
    }
    
    @Override
    public boolean applyProperty(@NotNull String key, Object value) 
    {
        if (key.equals(SupercoaterPolyphenyleneSulfideProperty.KEY)) 
        {
            this.polyphenyleneSulfide(((Number) value).intValue());
            return true;
        }
        if (key.equals(SupercoaterPolyvinylChlorideProperty.KEY))
        {
        	this.polyvinylChloride(((Number) value).intValue());
        	return true;
        }
        if (key.equals(SupercoaterPolymerTypeProperty.KEY))
        {
        	this.polymer((Material) value);
        }
        if (key.equals(SupercoaterPolymerProperty.KEY))
        {
        	this.polymerAmt(((Number) value).intValue());
        }
        return super.applyProperty(key, value);
    }

    public WireSupercoaterBuilder polyphenyleneSulfide(int mb) 
    {
        if (mb < 0) 
        {
            NepTech.LOGGER.error("Polyphenylene Sulfide cannot be less than  0mb", new IllegalArgumentException());
            recipeStatus = EnumValidationResult.INVALID;
        }
        this.applyProperty(SupercoaterPolyphenyleneSulfideProperty.getInstance(), mb);
        return this;
    }

    public int getPolpyhenyleneSulfideMb() 
    {
        return this.recipePropertyStorage == null ? 0 :
                this.recipePropertyStorage.getRecipePropertyValue(SupercoaterPolyphenyleneSulfideProperty.getInstance(), 0);
    }
    
    public WireSupercoaterBuilder polyvinylChloride(int mb) 
    {
        if (mb < 0) 
        {
            NepTech.LOGGER.error("Polyvinyl Chloride cannot be less than  0mb", new IllegalArgumentException());
            recipeStatus = EnumValidationResult.INVALID;
        }
        this.applyProperty(SupercoaterPolyvinylChlorideProperty.getInstance(), mb);
        return this;
    }

    public int getPolyvinylChlorideMb() 
    {
        return this.recipePropertyStorage == null ? 0 :
                this.recipePropertyStorage.getRecipePropertyValue(SupercoaterPolyvinylChlorideProperty.getInstance(), 0);
    }
    
    public WireSupercoaterBuilder polymer(Material material)
    {
    	if(material == null)
    	{
    		NepTech.LOGGER.error("Polymer is null! Please set a polymer!", new IllegalArgumentException());
    		recipeStatus = EnumValidationResult.INVALID;
    	}
    	if(!material.hasProperty(PropertyKey.FLUID))
    	{
    		NepTech.LOGGER.error("Polymer material " + material.getName() + " does not come in a fluid!", new IllegalArgumentException());
    		recipeStatus = EnumValidationResult.INVALID;
    	}
    	this.applyProperty(SupercoaterPolymerTypeProperty.getInstance(), material);
    	return this;
    }
    
    public Material getPolymer()
    {
    	return this.recipePropertyStorage.getRecipePropertyValue(SupercoaterPolymerTypeProperty.getInstance(), null);
    }
    
    public WireSupercoaterBuilder polymerAmt(int amt)
    {
    	if (amt < 0) 
        {
            NepTech.LOGGER.error("Polymer fluid cannot be less than 0mb", new IllegalArgumentException());
            recipeStatus = EnumValidationResult.INVALID;
        }
        this.applyProperty(SupercoaterPolymerProperty.getInstance(), amt);
        return this;
    }
    
    public int getPolymerAmt() 
    {
        return this.recipePropertyStorage == null ? 0 :
                this.recipePropertyStorage.getRecipePropertyValue(SupercoaterPolymerProperty.getInstance(), 0);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append(SupercoaterPolymerTypeProperty.getInstance().getKey(), getPolymer())
                .append(SupercoaterPolymerProperty.getInstance().getKey(), getPolymerAmt())
                .append(SupercoaterPolyphenyleneSulfideProperty.getInstance().getKey(), getPolpyhenyleneSulfideMb())
                .append(SupercoaterPolyvinylChlorideProperty.getInstance().getKey(), getPolyvinylChlorideMb())
                .toString();
    }
}
