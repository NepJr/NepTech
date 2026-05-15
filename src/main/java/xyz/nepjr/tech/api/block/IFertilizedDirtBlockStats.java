package xyz.nepjr.tech.api.block;

import org.jetbrains.annotations.NotNull;

public interface IFertilizedDirtBlockStats 
{
	 /**
     * @return The Unique Name of the Fertilized Dirt
     */
    @NotNull
    String getName();

    /**
     * @return the tier of the dirt, used for parallels calculation
     */
    int getTier();

    /**
     * @return the time discount
     */
    float getDiscount();
}
