package nepjr.tech.api.fluids;

import gregtech.api.fluids.store.FluidStorageKey;
import nepjr.tech.api.unification.material.NTMaterialIconTypes;
import nepjr.tech.api.unification.properties.NTPropertyKey;

import static nepjr.tech.NepTech.nepId;

public final class NTFluidStorageKeys 
{
	public static final FluidStorageKey MOLTEN = new FluidStorageKey(nepId("molten"),
            NTMaterialIconTypes.molten,
            m -> "molten." + m.getName(),
            m -> {
                if (m.hasProperty(NTPropertyKey.ALLOY_BLAST)) {
                    return "nt.fluid.molten";
                }
                return "gregtech.fluid.generic";
            });
}
