package nepjr.tech.api.recipes.builders;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.EnumValidationResult;
import nepjr.tech.NepTech;
import nepjr.tech.api.recipes.recipeproperties.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

public class OffworldMiningBuilder extends RecipeBuilder<OffworldMiningBuilder>
{

    public OffworldMiningBuilder() {}

    public OffworldMiningBuilder(Recipe recipe, RecipeMap<OffworldMiningBuilder> recipeMap)
    {
        super(recipe, recipeMap);
    }

    public OffworldMiningBuilder(RecipeBuilder<OffworldMiningBuilder> recipeBuilder)
    {
        super(recipeBuilder);
    }

    @Override
    public OffworldMiningBuilder copy()
    {
        return new OffworldMiningBuilder(this);
    }

    @Override
    public boolean applyProperty(@NotNull String key, Object value)
    {
        if (key.equals(OffworldMiningTierProperty.KEY))
        {
            this.minerTier(((Number) value).intValue());
            return true;
        }
        return super.applyProperty(key, value);
    }

    public OffworldMiningBuilder minerTier(int tier)
    {
        if (tier < 0)
        {
            NepTech.LOGGER.error("Miner tier cannot be less than  0", new IllegalArgumentException());
            recipeStatus = EnumValidationResult.INVALID;
        }
        this.applyProperty(OffworldMiningTierProperty.getInstance(), tier);
        return this;
    }

    public int getMinerTier()
    {
        return this.recipePropertyStorage == null ? 0 :
                this.recipePropertyStorage.getRecipePropertyValue(OffworldMiningTierProperty.getInstance(), 0);
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append(OffworldMiningTierProperty.getInstance().getKey(), getMinerTier())
                .toString();
    }
}
