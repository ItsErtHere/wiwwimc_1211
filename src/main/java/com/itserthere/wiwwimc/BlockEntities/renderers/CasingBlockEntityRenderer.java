package com.itserthere.wiwwimc.BlockEntities.renderers;

import com.itserthere.wiwwimc.BlockEntities.CasingBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

public class CasingBlockEntityRenderer implements BlockEntityRenderer<CasingBlockEntity> {
    public CasingBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        //
    }
    @Override
    public void render(CasingBlockEntity blockEntity, float partialTick, PoseStack poseStack,
                                               MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack stack = blockEntity.inventory.getStackInSlot(0);
        poseStack.pushPose(); poseStack.translate(0.5,0.5,0.5); poseStack.scale(1.99f,1.99f,1.99f);
        poseStack.mulPose(Axis.YP.rotationDegrees(0));
        itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED,
                getLightLevel(blockEntity.getLevel(),blockEntity.getBlockPos()),
                OverlayTexture.NO_OVERLAY, poseStack, bufferSource, blockEntity.getLevel(),1);
        poseStack.popPose();
    }
    private int getLightLevel(Level level, BlockPos pos) {
        return LightTexture.pack(level.getBrightness(LightLayer.BLOCK,pos),
                level.getBrightness(LightLayer.SKY,pos));
    }
}
