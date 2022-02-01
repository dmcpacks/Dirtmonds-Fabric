package com.dmcpacks.dirtmonds.item.custom;

import com.dmcpacks.dirtmonds.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class DirtmondFinder extends Item {

    public DirtmondFinder(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        if (context.getWorld().isClient()) {
            BlockPos click = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= click.getY() + 64; i++) {
                Block below = context.getWorld().getBlockState(click.down(i)).getBlock();

                if (isDirtmond(below)) {
                    DirtmondCoords(click.down(i), player, below);
                    foundBlock = true;
                    break;
                }
            }

        if(!foundBlock) {
            player.sendMessage(new TranslatableText("item.dirtmonds.dirtmond_finder.novaluables"), false);
        }
    }
        context.getStack().damage( 1, context.getPlayer(),
                (player) -> player.sendToolBreakStatus(player.getActiveHand()));

        return super.useOnBlock(context);
    }

    private void DirtmondCoords(BlockPos blockPos, PlayerEntity player, Block dirtmond) {
        player.sendMessage(new LiteralText("Detected " + dirtmond.asItem().getName().getString()
                + " at " + "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), false);
    }

    private boolean isDirtmond(Block block) {
        return block == ModBlocks.DIRTMOND_ORE;
    }
}