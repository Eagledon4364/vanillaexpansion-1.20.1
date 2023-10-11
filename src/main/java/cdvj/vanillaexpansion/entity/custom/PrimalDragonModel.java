package cdvj.vanillaexpansion.entity.custom;

import cdvj.vanillaexpansion.entity.animations.ModAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class PrimalDragonModel<T extends PrimalDragonEntity> extends SinglePartEntityModel<T> {
	private final ModelPart primal_dragon;
	private final ModelPart head;
	public PrimalDragonModel(ModelPart root) {
		this.primal_dragon = root.getChild("primal_dragon");
		this.head = root.getChild("primal_dragon").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData primal_dragon = modelPartData.addChild("primal_dragon", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData wing2 = primal_dragon.addChild("wing2", ModelPartBuilder.create().uv(0, 196).cuboid(0.0F, -2.5F, -2.0F, 25.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(190, 208).cuboid(0.0F, -1.0F, 1.0F, 25.0F, 0.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(7.0F, -24.0F, -23.0F));

		ModelPartData extended2 = wing2.addChild("extended2", ModelPartBuilder.create(), ModelTransform.pivot(25.0F, -1.0F, -0.5F));

		ModelPartData cube_r1 = extended2.addChild("cube_r1", ModelPartBuilder.create().uv(125, 240).cuboid(-0.5F, 0.0F, 1.5F, 25.0F, 0.0F, 16.0F, new Dilation(0.0F))
		.uv(0, 221).cuboid(-0.5F, -1.5F, -1.5F, 25.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.2618F, 0.0F));

		ModelPartData tip = extended2.addChild("tip", ModelPartBuilder.create(), ModelTransform.of(24.15F, 0.0F, 6.35F, 0.0F, -0.2618F, 0.0F));

		ModelPartData cube_r2 = tip.addChild("cube_r2", ModelPartBuilder.create().uv(212, 240).cuboid(-0.85F, 0.0F, 1.9F, 14.0F, 0.0F, 16.0F, new Dilation(0.0F))
		.uv(0, 250).cuboid(-0.85F, -1.5F, -1.1F, 14.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.3491F, 0.0F));

		ModelPartData wing = primal_dragon.addChild("wing", ModelPartBuilder.create().uv(200, 2).cuboid(-25.0F, -2.5F, -2.0F, 25.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(190, 156).cuboid(-25.0F, -1.0F, 1.0F, 25.0F, 0.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.0F, -24.0F, -23.0F));

		ModelPartData extended1 = wing.addChild("extended1", ModelPartBuilder.create(), ModelTransform.pivot(-25.5F, -1.0F, -0.25F));

		ModelPartData cube_r3 = extended1.addChild("cube_r3", ModelPartBuilder.create().uv(190, 105).cuboid(-24.0F, 0.0F, 1.5F, 25.0F, 0.0F, 16.0F, new Dilation(0.0F))
		.uv(200, 27).cuboid(-24.0F, -1.5F, -1.5F, 25.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.2618F, 0.0F));

		ModelPartData wingtip = extended1.addChild("wingtip", ModelPartBuilder.create(), ModelTransform.of(-23.65F, 0.0F, 6.1F, 0.0F, 0.2618F, 0.0F));

		ModelPartData cube_r4 = wingtip.addChild("cube_r4", ModelPartBuilder.create().uv(222, 44).cuboid(-13.15F, -1.5F, -1.1F, 14.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(207, 62).cuboid(-13.15F, 0.0F, 1.9F, 14.0F, 0.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.3491F, 0.0F));

		ModelPartData leg0 = primal_dragon.addChild("leg0", ModelPartBuilder.create(), ModelTransform.pivot(-7.0F, -20.0F, 14.0F));

		ModelPartData leg0_r1 = leg0.addChild("leg0_r1", ModelPartBuilder.create().uv(150, 97).cuboid(-3.0F, -1.0F, -5.0F, 3.0F, 7.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

		ModelPartData leg0_r2 = leg0.addChild("leg0_r2", ModelPartBuilder.create().uv(73, 150).cuboid(-3.0F, 0.0F, -4.0F, 4.0F, 12.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, 0.4363F, 0.0F, 0.0873F));

		ModelPartData upper = leg0.addChild("upper", ModelPartBuilder.create().uv(123, 153).cuboid(-6.0F, 7.0F, -9.0F, 6.0F, 3.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 10.0F, 4.0F));

		ModelPartData leg0_r3 = upper.addChild("leg0_r3", ModelPartBuilder.create().uv(0, 43).cuboid(-3.0F, 2.0F, 11.0F, 0.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -10.0F, -4.0F, -0.7854F, 0.0F, 0.0F));

		ModelPartData leg0_r4 = upper.addChild("leg0_r4", ModelPartBuilder.create().uv(117, 165).cuboid(-5.0F, 7.0F, 4.0F, 4.0F, 10.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -10.0F, -4.0F, -0.3491F, 0.0F, 0.0F));

		ModelPartData body = primal_dragon.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -21.0F, -24.0F, 16.0F, 12.0F, 28.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.0F, 0.0F));

		ModelPartData body_r1 = body.addChild("body_r1", ModelPartBuilder.create().uv(42, 99).cuboid(-0.5F, 17.0F, -30.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(72, 99).cuboid(-0.5F, 15.0F, -28.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.309F, 0.0F, 0.0F));

		ModelPartData body_r2 = body.addChild("body_r2", ModelPartBuilder.create().uv(100, 54).cuboid(-0.5F, -40.0F, 10.5F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(10, 101).cuboid(-0.5F, -39.0F, 8.5F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(46, 101).cuboid(-0.5F, -37.0F, 6.5F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(76, 101).cuboid(-0.5F, -35.0F, 4.5F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(82, 101).cuboid(-0.5F, -33.0F, 2.5F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 103).cuboid(-0.5F, -30.75F, 0.25F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(6, 103).cuboid(-0.5F, -29.0F, -3.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(36, 103).cuboid(-0.5F, -27.0F, -5.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.8727F, 0.0F, 0.0F));

		ModelPartData body_r3 = body.addChild("body_r3", ModelPartBuilder.create().uv(42, 103).cuboid(-0.5F, -25.0F, -5.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(72, 103).cuboid(-0.5F, -23.0F, -8.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(76, 105).cuboid(-0.5F, -21.0F, -10.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(82, 105).cuboid(-0.5F, -19.0F, -12.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(106, 54).cuboid(-0.5F, -17.0F, -15.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(72, 107).cuboid(-0.5F, -15.0F, -17.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(104, 107).cuboid(-0.5F, -13.0F, -19.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(108, 109).cuboid(-0.5F, -11.0F, -21.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(104, 111).cuboid(-0.5F, -9.0F, -23.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 112).cuboid(-0.5F, -7.0F, -25.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(6, 112).cuboid(-0.5F, -5.0F, -27.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(112, 17).cuboid(-0.5F, -1.0F, -31.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(112, 21).cuboid(-0.5F, -3.0F, -29.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		ModelPartData body_r4 = body.addChild("body_r4", ModelPartBuilder.create().uv(76, 75).cuboid(-6.0F, -20.0F, 20.0F, 12.0F, 10.0F, 16.0F, new Dilation(0.0F))
		.uv(48, 40).cuboid(-7.0F, -21.0F, 2.0F, 14.0F, 11.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		ModelPartData body_r5 = body.addChild("body_r5", ModelPartBuilder.create().uv(57, 69).cuboid(-3.0F, -17.0F, 20.0F, 9.0F, 0.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0873F, -0.2618F, 0.0873F));

		ModelPartData body_r6 = body.addChild("body_r6", ModelPartBuilder.create().uv(95, 0).cuboid(-6.0F, -17.0F, 20.0F, 9.0F, 0.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0873F, 0.2618F, -0.0873F));

		ModelPartData body_r7 = body.addChild("body_r7", ModelPartBuilder.create().uv(0, 62).cuboid(-22.0F, -11.0F, -23.0F, 3.0F, 3.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.0873F, 0.7854F));

		ModelPartData body_r8 = body.addChild("body_r8", ModelPartBuilder.create().uv(119, 131).cuboid(19.0F, -11.0F, -23.0F, 3.0F, 3.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0873F, -0.7854F));

		ModelPartData body_r9 = body.addChild("body_r9", ModelPartBuilder.create().uv(0, 47).cuboid(-8.0F, -3.0F, -37.0F, 2.0F, 5.0F, 9.0F, new Dilation(0.0F))
		.uv(165, 49).cuboid(6.0F, -3.0F, -37.0F, 2.0F, 5.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.6109F, 0.0F, 0.0F));

		ModelPartData body_r10 = body.addChild("body_r10", ModelPartBuilder.create().uv(28, 69).cuboid(-7.0F, -13.0F, -20.0F, 14.0F, 4.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		ModelPartData body_r11 = body.addChild("body_r11", ModelPartBuilder.create().uv(0, 112).cuboid(-6.0F, -8.0F, -36.0F, 12.0F, 10.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

		ModelPartData body_r12 = body.addChild("body_r12", ModelPartBuilder.create().uv(28, 164).cuboid(2.0F, -26.0F, -18.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.3491F, 0.2618F, 0.3491F));

		ModelPartData body_r13 = body.addChild("body_r13", ModelPartBuilder.create().uv(164, 114).cuboid(-10.0F, -26.0F, -18.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.3491F, -0.2618F, -0.3491F));

		ModelPartData leg3 = primal_dragon.addChild("leg3", ModelPartBuilder.create(), ModelTransform.pivot(8.0F, -21.0F, -21.0F));

		ModelPartData leg3_r1 = leg3.addChild("leg3_r1", ModelPartBuilder.create().uv(0, 0).cuboid(5.0F, 0.0F, 7.0F, 0.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.0472F, 0.0F, 0.1745F));

		ModelPartData l31 = leg3.addChild("l31", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData li31_r1 = l31.addChild("li31_r1", ModelPartBuilder.create().uv(47, 145).cuboid(-1.0F, -1.0F, -6.0F, 5.0F, 11.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, -0.2618F));

		ModelPartData li31_r2 = l31.addChild("li31_r2", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -3.0F, -6.0F, 3.0F, 7.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		ModelPartData g4 = leg3.addChild("g4", ModelPartBuilder.create().uv(0, 18).cuboid(-2.0F, -3.0F, -2.0F, 5.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 11.0F, 0.0F));

		ModelPartData cube_r5 = g4.addChild("cube_r5", ModelPartBuilder.create().uv(0, 55).cuboid(5.0F, 8.0F, 4.0F, 0.0F, 8.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -11.0F, 0.0F, -0.5236F, 0.0F, 0.1745F));

		ModelPartData cube_r6 = g4.addChild("cube_r6", ModelPartBuilder.create().uv(166, 92).cuboid(3.0F, 8.0F, 0.0F, 5.0F, 10.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -11.0F, 0.0F, -0.2618F, 0.0F, 0.1745F));

		ModelPartData foot3 = leg3.addChild("foot3", ModelPartBuilder.create().uv(147, 17).cuboid(-3.0F, -1.0F, -8.0F, 6.0F, 3.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 19.0F, 0.0F));

		ModelPartData leg2 = primal_dragon.addChild("leg2", ModelPartBuilder.create().uv(60, 16).cuboid(-6.0F, 8.0F, -2.0F, 5.0F, 3.0F, 5.0F, new Dilation(0.0F))
		.uv(152, 0).cuboid(-5.0F, 18.0F, -8.0F, 6.0F, 3.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(-8.0F, -21.0F, -21.0F));

		ModelPartData leg2_r1 = leg2.addChild("leg2_r1", ModelPartBuilder.create().uv(15, 13).cuboid(-5.0F, 0.0F, 7.0F, 0.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.0472F, 0.0F, -0.1745F));

		ModelPartData leg2_r2 = leg2.addChild("leg2_r2", ModelPartBuilder.create().uv(0, 63).cuboid(-5.0F, 8.0F, 4.0F, 0.0F, 8.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.5236F, 0.0F, -0.1745F));

		ModelPartData leg2_r3 = leg2.addChild("leg2_r3", ModelPartBuilder.create().uv(92, 167).cuboid(-8.0F, 8.0F, 0.0F, 5.0F, 10.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, -0.1745F));

		ModelPartData leg2_r4 = leg2.addChild("leg2_r4", ModelPartBuilder.create().uv(19, 140).cuboid(-3.0F, -3.0F, -6.0F, 3.0F, 7.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		ModelPartData leg2_r5 = leg2.addChild("leg2_r5", ModelPartBuilder.create().uv(147, 58).cuboid(-4.0F, -1.0F, -6.0F, 5.0F, 11.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.2618F));

		ModelPartData leg1 = primal_dragon.addChild("leg1", ModelPartBuilder.create(), ModelTransform.pivot(7.0F, -20.0F, 14.0F));

		ModelPartData leg1_r1 = leg1.addChild("leg1_r1", ModelPartBuilder.create().uv(97, 150).cuboid(0.0F, -1.0F, -5.0F, 3.0F, 7.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

		ModelPartData leg1_r2 = leg1.addChild("leg1_r2", ModelPartBuilder.create().uv(149, 142).cuboid(-1.0F, 0.0F, -4.0F, 4.0F, 12.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.0F, 0.0F, 0.4363F, 0.0F, -0.0873F));

		ModelPartData upper2 = leg1.addChild("upper2", ModelPartBuilder.create().uv(153, 80).cuboid(0.0F, 17.0F, -5.0F, 6.0F, 3.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leg1_r3 = upper2.addChild("leg1_r3", ModelPartBuilder.create().uv(17, 0).cuboid(3.0F, 2.0F, 11.0F, 0.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		ModelPartData leg1_r4 = upper2.addChild("leg1_r4", ModelPartBuilder.create().uv(52, 164).cuboid(0.0F, 7.0F, 4.0F, 4.0F, 10.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		ModelPartData head = primal_dragon.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -27.0F, -32.0F));

		ModelPartData head_r1 = head.addChild("head_r1", ModelPartBuilder.create().uv(38, 78).cuboid(0.0F, -6.0F, -10.0F, 3.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.1745F));

		ModelPartData head_r2 = head.addChild("head_r2", ModelPartBuilder.create().uv(80, 16).cuboid(-3.0F, -6.0F, -10.0F, 3.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, -0.1745F));

		ModelPartData head_r3 = head.addChild("head_r3", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -17.0F, 3.0F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F))
		.uv(17, 0).cuboid(-0.5F, -16.0F, 1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(20, 23).cuboid(-0.5F, -14.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(60, 24).cuboid(-0.5F, -12.0F, -3.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -12.0F, -1.1345F, 0.0F, 0.0F));

		ModelPartData head_r4 = head.addChild("head_r4", ModelPartBuilder.create().uv(0, 87).cuboid(1.0F, -13.0F, 0.0F, 4.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -12.0F, -0.6109F, 0.5236F, 0.0F));

		ModelPartData head_r5 = head.addChild("head_r5", ModelPartBuilder.create().uv(36, 91).cuboid(-5.0F, -13.0F, 0.0F, 4.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -12.0F, -0.6109F, -0.5236F, 0.0F));

		ModelPartData head_r6 = head.addChild("head_r6", ModelPartBuilder.create().uv(0, 134).cuboid(-11.0F, -7.0F, 3.0F, 5.0F, 7.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -12.0F, -0.3491F, 0.2618F, 0.0F));

		ModelPartData head_r7 = head.addChild("head_r7", ModelPartBuilder.create().uv(144, 121).cuboid(6.0F, -7.0F, 3.0F, 5.0F, 7.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -12.0F, -0.3491F, -0.2618F, 0.0F));

		ModelPartData head_r8 = head.addChild("head_r8", ModelPartBuilder.create().uv(0, 158).cuboid(2.0F, -2.0F, 1.0F, 6.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -12.0F, 0.0F, 0.3491F, 0.0F));

		ModelPartData head_r9 = head.addChild("head_r9", ModelPartBuilder.create().uv(37, 123).cuboid(-5.0F, -9.0F, 4.0F, 10.0F, 11.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -12.0F, -0.3491F, 0.0F, 0.0F));

		ModelPartData head_r10 = head.addChild("head_r10", ModelPartBuilder.create().uv(36, 117).cuboid(-3.5F, -2.0F, -10.0F, 7.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -12.0F, -0.1745F, 0.0F, 0.0F));

		ModelPartData head_r11 = head.addChild("head_r11", ModelPartBuilder.create().uv(12, 61).cuboid(-0.5F, -4.0F, -10.0F, 1.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -12.0F, -0.6109F, 0.0F, 0.0F));

		ModelPartData head_r12 = head.addChild("head_r12", ModelPartBuilder.create().uv(145, 162).cuboid(-8.0F, -2.0F, 1.0F, 6.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -12.0F, 0.0F, -0.3491F, 0.0F));

		ModelPartData head_r13 = head.addChild("head_r13", ModelPartBuilder.create().uv(77, 22).cuboid(4.0F, -5.0F, 2.0F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -12.0F, 0.5236F, 0.4363F, 0.0F));

		ModelPartData head_r14 = head.addChild("head_r14", ModelPartBuilder.create().uv(92, 69).cuboid(-5.0F, -5.0F, 2.0F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -12.0F, 0.5236F, -0.4363F, 0.0F));

		ModelPartData head_r15 = head.addChild("head_r15", ModelPartBuilder.create().uv(72, 101).cuboid(-4.0F, -6.0F, -8.0F, 8.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -12.0F, 0.2618F, 0.0F, 0.0F));

		ModelPartData head_r16 = head.addChild("head_r16", ModelPartBuilder.create().uv(0, 91).cuboid(-3.0F, -5.0F, -6.0F, 10.0F, 5.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -12.0F, 0.3491F, 0.3491F, 0.2618F));

		ModelPartData head_r17 = head.addChild("head_r17", ModelPartBuilder.create().uv(36, 96).cuboid(-7.0F, -5.0F, -6.0F, 10.0F, 5.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -12.0F, 0.3491F, -0.3491F, -0.2618F));

		ModelPartData lower_jaw = head.addChild("lower_jaw", ModelPartBuilder.create().uv(116, 72).cuboid(-4.0F, 3.0F, -16.0F, 8.0F, 2.0F, 15.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -3.0F));

		ModelPartData lower_jaw_r1 = lower_jaw.addChild("lower_jaw_r1", ModelPartBuilder.create().uv(97, 54).cuboid(-7.0F, 1.0F, -5.0F, 10.0F, 3.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -9.0F, -0.0873F, -0.4363F, 0.0F));

		ModelPartData lower_jaw_r2 = lower_jaw.addChild("lower_jaw_r2", ModelPartBuilder.create().uv(0, 40).cuboid(-3.0F, -4.0F, -8.5F, 6.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -9.0F, 0.5236F, 0.0F, 0.0F));

		ModelPartData lower_jaw_r3 = lower_jaw.addChild("lower_jaw_r3", ModelPartBuilder.create().uv(112, 17).cuboid(-3.0F, 1.0F, -5.0F, 10.0F, 3.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -9.0F, -0.0873F, 0.4363F, 0.0F));

		ModelPartData tail = primal_dragon.addChild("tail", ModelPartBuilder.create().uv(79, 131).cuboid(-4.0F, -3.0F, 14.0F, 8.0F, 7.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -16.0F, 37.0F));

		ModelPartData tail_r1 = tail.addChild("tail_r1", ModelPartBuilder.create().uv(54, 91).cuboid(-0.5F, -54.5F, 31.2F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(60, 91).cuboid(-0.5F, -52.5F, 29.2F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(66, 91).cuboid(-0.5F, -50.5F, 27.2F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(10, 93).cuboid(-0.5F, -47.75F, 24.5F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(94, 54).cuboid(-0.5F, -46.0F, 22.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 95).cuboid(-0.5F, -44.0F, 19.75F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(6, 95).cuboid(-0.5F, -42.0F, 17.75F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(10, 97).cuboid(-0.5F, -40.0F, 15.5F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 12.0F, -37.0F, -0.7854F, 0.0F, 0.0F));

		ModelPartData tail_r2 = tail.addChild("tail_r2", ModelPartBuilder.create().uv(106, 109).cuboid(-5.0F, -4.0F, 0.0F, 10.0F, 8.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0436F, 0.0F, 0.0F));

		ModelPartData tailtip = tail.addChild("tailtip", ModelPartBuilder.create().uv(132, 41).cuboid(-3.0F, -2.0F, 0.0F, 6.0F, 5.0F, 12.0F, new Dilation(0.0F))
		.uv(130, 0).cuboid(-2.0F, -1.0F, 12.0F, 4.0F, 3.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 26.0F));

		ModelPartData tail_r3 = tailtip.addChild("tail_r3", ModelPartBuilder.create().uv(66, 24).cuboid(-0.5F, -63.75F, 43.25F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(34, 82).cuboid(-0.5F, -62.0F, 40.2F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(12, 87).cuboid(-0.5F, -60.0F, 38.2F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(18, 87).cuboid(-0.5F, -58.0F, 36.2F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(48, 91).cuboid(-0.5F, -56.0F, 34.2F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(46, 97).cuboid(-0.5F, -66.0F, 46.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 99).cuboid(-0.5F, -68.0F, 48.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(6, 99).cuboid(-0.5F, -70.0F, 50.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(36, 99).cuboid(-0.5F, -72.0F, 52.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 12.0F, -63.0F, -0.7854F, 0.0F, 0.0F));

		ModelPartData tail_r4 = tailtip.addChild("tail_r4", ModelPartBuilder.create().uv(0, 56).cuboid(-16.0F, 0.0F, 36.0F, 12.0F, 0.0F, 22.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -26.0F, 0.0F, 0.3491F, -0.1745F));

		ModelPartData tail_r5 = tailtip.addChild("tail_r5", ModelPartBuilder.create().uv(66, 16).cuboid(4.0F, 0.0F, 36.0F, 12.0F, 0.0F, 22.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -26.0F, 0.0F, -0.3491F, 0.1745F));
		return TexturedModelData.of(modelData, 256, 256);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		primal_dragon.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return primal_dragon;
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f);
		headPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f);

		this.head.yaw = headYaw = 0.017453291f;
		this.head.pitch = headPitch = 0.017453292f;

	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(headYaw, headPitch);

		this.animateMovement(ModAnimations.PRIMAL_DRAGON_WALK, limbAngle, limbDistance, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.PRIMAL_DRAGON_IDLE, animationProgress, 1f);

	}
}