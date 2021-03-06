package com.bpteam.arcticmod.client.render;

import com.bpteam.arcticmod.common.entities.EntityWeakIceBall;
import com.bpteam.arcticmod.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderWeakIceBall extends Render<EntityWeakIceBall> {

    public RenderWeakIceBall(RenderManager renderManager) {
        super(renderManager);
    }

    @Override
    public void doRenderShadowAndFire(Entity entityIn, double x, double y, double z, float yaw, float partialTicks) {}

    @Override
    public void doRender(EntityWeakIceBall entity, double x, double y, double z, float entityYaw, float partialTicks) {
        {
            GlStateManager.pushMatrix();
            this.bindEntityTexture(entity);
            GlStateManager.translate((float) x, (float) y, (float) z);
            GlStateManager.enableRescaleNormal();
            TextureAtlasSprite textureatlassprite = Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getParticleIcon(ModItems.WEAKER_ICE_BALL);
            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferbuilder = tessellator.getBuffer();
            float f = textureatlassprite.getMinU();
            float f1 = textureatlassprite.getMaxU();
            float f2 = textureatlassprite.getMinV();
            float f3 = textureatlassprite.getMaxV();
            GlStateManager.rotate(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate((float) (this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * -this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);

            if (this.renderOutlines) {
                GlStateManager.enableColorMaterial();
                GlStateManager.enableOutlineMode(this.getTeamColor(entity));
            }

            bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
            bufferbuilder.pos(-0.5D, -0.25D, 0.0D).tex((double) f, (double) f3).normal(0.0F, 1.0F, 0.0F).endVertex();
            bufferbuilder.pos(0.5D, -0.25D, 0.0D).tex((double) f1, (double) f3).normal(0.0F, 1.0F, 0.0F).endVertex();
            bufferbuilder.pos(0.5D, 0.75D, 0.0D).tex((double) f1, (double) f2).normal(0.0F, 1.0F, 0.0F).endVertex();
            bufferbuilder.pos(-0.5D, 0.75D, 0.0D).tex((double) f, (double) f2).normal(0.0F, 1.0F, 0.0F).endVertex();
            tessellator.draw();

            if (this.renderOutlines) {
                GlStateManager.disableOutlineMode();
                GlStateManager.disableColorMaterial();
            }

            GlStateManager.disableRescaleNormal();
            GlStateManager.popMatrix();
            super.doRender(entity, x, y, z, entityYaw, partialTicks);
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWeakIceBall entity) {
        return null;
    }
}