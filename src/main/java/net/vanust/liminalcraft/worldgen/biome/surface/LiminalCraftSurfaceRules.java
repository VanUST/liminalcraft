package net.vanust.liminalcraft.worldgen.biome.surface;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.vanust.liminalcraft.worldgen.biome.LiminalCraftBiomes;

public class LiminalCraftSurfaceRules {
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
//    private static final SurfaceRules.RuleSource SAPPHIRE = makeStateRule(ModBlocks.SAPPHIRE_BLOCK.get());
//    private static final SurfaceRules.RuleSource RAW_SAPPHIRE = makeStateRule(ModBlocks.RAW_SAPPHIRE_BLOCK.get());


    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return SurfaceRules.sequence(
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(LiminalCraftBiomes.LEVEL_0_CORRIDORS),
//                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, RAW_SAPPHIRE)),
//                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SAPPHIRE)),


                // Default to a grass and dirt surface
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)))
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}