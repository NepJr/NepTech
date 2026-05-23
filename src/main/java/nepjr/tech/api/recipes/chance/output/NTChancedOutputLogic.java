package nepjr.tech.api.recipes.chance.output;

import java.util.Collections;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import gregtech.api.GTValues;
import gregtech.api.recipes.chance.boost.ChanceBoostFunction;
import gregtech.api.recipes.chance.output.ChancedOutput;
import gregtech.api.recipes.chance.output.ChancedOutputLogic;

public interface NTChancedOutputLogic 
{
	/*
	 * Chanced Output Logic where it returns one item in the list of chanced outputs. 
	 */
	ChancedOutputLogic SINGLEITEM = new ChancedOutputLogic() {

        @Override
        public @Nullable @Unmodifiable <I,
                T extends ChancedOutput<I>> List<@NotNull T> roll(@NotNull @Unmodifiable List<@NotNull T> chancedEntries,
                                                                  @NotNull ChanceBoostFunction boostFunction,
                                                                  int baseTier, int machineTier) {
        	int index = GTValues.RNG.nextInt(chancedEntries.size());
            return Collections.singletonList(chancedEntries.get(index));
        }

        @Override
        public @NotNull String getTranslationKey() {
            return "neptech.chance_logic.single_item";
        }

        @Override
        public String toString() {
            return "ChancedOutputLogic{SINGLEITEM}";
        }
    };
}
