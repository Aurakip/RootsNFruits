package gaymeow.rootsnfruits.mixin;

import gaymeow.rootsnfruits.block.RFBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.golem.CopperGolem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Predicate;

import static net.minecraft.world.level.block.state.predicate.BlockStatePredicate.forBlock;

@Mixin(CarvedPumpkinBlock.class)
public abstract class CarvedPumpkinBlockMixin extends HorizontalDirectionalBlock {
    protected CarvedPumpkinBlockMixin(Properties properties) {
        super(properties);
    }
    @Unique
    private @Nullable BlockPattern soulGolemBase;
    @Unique
    private @Nullable BlockPattern soulGolemFull;

    @Final
    @Shadow
    private static Predicate<BlockState> PUMPKINS_PREDICATE;

    @Inject(method = "canSpawnGolem",at = @At(value = "TAIL"),cancellable = true)
    public void  canSpawnGolemMixin(final LevelReader level, final BlockPos topPos, CallbackInfoReturnable<Boolean> info){
        info.setReturnValue(this.getOrCreateSnowGolemBase().find(level, topPos) != null
                || this.getOrCreateIronGolemBase().find(level, topPos) != null
                || this.getOrCreateCopperGolemBase().find(level, topPos) != null
                || this.getOrCreateSoulGolemBase().find(level, topPos) !=null);
    }

    @Inject(method = "trySpawnGolem", at = @At("HEAD"))
    private void trySpawnGolemMixin(Level level, BlockPos topPos, CallbackInfo info){
        BlockPattern.BlockPatternMatch soulGolemMatch = this.getOrCreateSoulGolemFull().find(level, topPos);
        if (soulGolemMatch != null) {
            CopperGolem copperGolem = EntityType.COPPER_GOLEM.create(level, EntitySpawnReason.TRIGGERED);
            if (copperGolem != null) {
                spawnGolemInWorld(level, soulGolemMatch, copperGolem, soulGolemMatch.getBlock(0, 1, 0).getPos());
                return;
            }
        }
    }

    @Unique
    private BlockPattern getOrCreateSoulGolemBase() {
        if (this.soulGolemBase == null) {
            this.soulGolemBase = BlockPatternBuilder.start().aisle(" ", "#").where('#', BlockInWorld.hasState(forBlock(RFBlocks.SOUL_ROOTS))).build();
        }

        return this.soulGolemBase;
    }

    @Unique
    private BlockPattern getOrCreateSoulGolemFull() {
        if (this.soulGolemFull == null) {
            this.soulGolemFull = BlockPatternBuilder.start()
                    .aisle("^", "#")
                    .where('^', BlockInWorld.hasState(PUMPKINS_PREDICATE))
                    .where('#', BlockInWorld.hasState(forBlock(RFBlocks.SOUL_ROOTS)))
                    .build();
        }

        return this.soulGolemFull;
    }

    @Shadow
    private static void spawnGolemInWorld(final Level level, final BlockPattern.BlockPatternMatch match, final Entity golem, final BlockPos spawnPos) {}
    @Shadow
    protected abstract BlockPattern getOrCreateSnowGolemBase();
    @Shadow
    protected abstract BlockPattern getOrCreateIronGolemBase();
    @Shadow
    protected abstract BlockPattern getOrCreateCopperGolemBase();
}
