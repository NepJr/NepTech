package nepjr.tech.api.unification.properties;

import gregtech.api.unification.material.properties.PropertyKey;

public final class NTPropertyKey 
{
	public static final PropertyKey<AlloyBlastProperty> ALLOY_BLAST = new PropertyKey<>("blast_alloy",
            AlloyBlastProperty.class);
	
	private NTPropertyKey() {}
}
