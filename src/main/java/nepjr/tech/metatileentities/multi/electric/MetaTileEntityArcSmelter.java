package nepjr.tech.metatileentities.multi.electric;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.recipeproperties.IRecipePropertyStorage;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.blocks.BlockWireCoil.CoilType;
import nepjr.tech.client.NTTextures;
import nepjr.tech.common.blocks.BlockNTCasings.NTCasingType;
import nepjr.tech.common.blocks.NTMetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class MetaTileEntityArcSmelter extends RecipeMapMultiblockController
{
	private int parallels;
	private float processingSpeed;
	
	public MetaTileEntityArcSmelter(ResourceLocation metaTileEntityId)
	{
		super(metaTileEntityId, RecipeMaps.ARC_FURNACE_RECIPES);
		this.recipeMapWorkable = new ArcSmelterLogic(this);
	}

	@Override
	protected @NotNull BlockPattern createStructurePattern()
	{
		return FactoryBlockPattern.start()
				.aisle("CCC", "WWW", "WWW", "CCC")
				.aisle("CCC", "W W", "W W", "CMC")
				.aisle("CSC", "WWW", "WWW", "CCC")
				.where('C', states(casingState()).or(autoAbilities(true, true, true, true, true, true, false)))
				.where('W', heatingCoils())
				.where('M', abilities(MultiblockAbility.MUFFLER_HATCH).setExactLimit(1))
				.where(' ', air())
				.where('S', selfPredicate())
				.build();
	}

	@Override
	public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart)
	{
		return NTTextures.BLAST_CASING;
	}
	
	@Override
    protected @NotNull OrientedOverlayRenderer getFrontOverlay() {
        return NTTextures.ALLOY_BLAST_SMELTER_OVERLAY;
    }
	
	private IBlockState casingState()
	{
		return NTMetaBlocks.NT_CASINGS.getState(NTCasingType.HIGH_TEMPERATURE_CASING);
	}
	
	@Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced)
	{
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(TooltipHelper.RAINBOW_SLOW + I18n.format("gregtech.machine.perfect_oc"));
        tooltip.add(TextFormatting.GREEN + I18n.format("neptech.processing_speed.supercoater"));
        tooltip.add(TextFormatting.GREEN + I18n.format("neptech.parallels.supercoater"));
    }
	
	@Override
    protected void formStructure(PatternMatchContext context)
	{
        super.formStructure(context);
        Object coilType = context.get("CoilType");
        if (coilType instanceof IHeatingCoilBlockStats) 
        {
        	int tier = ((IHeatingCoilBlockStats) coilType).getTier();
            this.parallels = ((IHeatingCoilBlockStats) coilType).getLevel() * 32;
            if(tier > 0)
            {
            	this.processingSpeed = (float) (((50 * (tier + 1)) + (25 * (tier + 1)))) / 100;
            }
            else
            {
            	this.processingSpeed = 1;
            }
        } 
        else 
        {
            this.parallels = CoilType.CUPRONICKEL.getLevel() * 32;
            this.processingSpeed = 1;
        }
    }
	
	@Override
    public void invalidateStructure() 
	{
        super.invalidateStructure();
        this.parallels = 0;
        this.processingSpeed = 0;
    }

	@Override
	public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity)
	{
		return new MetaTileEntityArcSmelter(metaTileEntityId);
	}
	
	@Override
	public boolean hasMufflerMechanics()
	{
		return true;
	}
	
	public int getParallels()
	{
		return parallels * 8;
	}
	
	public float getProcessingSpeed()
	{
		return processingSpeed;
	}
	
	private class ArcSmelterLogic extends MultiblockRecipeLogic
	{
		private MetaTileEntityArcSmelter mte;
		public ArcSmelterLogic(MetaTileEntityArcSmelter tileEntity)
		{
			super(tileEntity, true);
			this.mte = tileEntity;
		}
		
		@Override
        protected void modifyOverclockPost(int[] resultOverclock, @NotNull IRecipePropertyStorage storage)
		{
            super.modifyOverclockPost(resultOverclock, storage);
            resultOverclock[1] /= mte.getProcessingSpeed(); 
            resultOverclock[1] = Math.max(1, resultOverclock[1]);
        }
		
		@Override
		public int getParallelLimit()
		{
			if(mte.getParallels() <= Integer.MAX_VALUE)
			{
				return (int) mte.getParallels();
			}
			if(mte.getParallels() > Integer.MAX_VALUE)
			{
				return Integer.MAX_VALUE;
			}
			else
			{
				return 1;
			}
		}
		
	}

}
