package cdvj.vanillaexpansion.item.client;

import cdvj.vanillaexpansion.VanillaExpansion;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class TechArmorModel extends GeoModel<TechArmorItem> {


    @Override
    public Identifier getModelResource(TechArmorItem animatable) {
        return new Identifier(VanillaExpansion.MOD_ID, "geo/tech_armor.geo.json");
    }




    @Override
    public Identifier getTextureResource(TechArmorItem animatable) {
        return new Identifier(VanillaExpansion.MOD_ID, "textures/armor/tech_armor_lime.png");
    }

    @Override
    public Identifier getAnimationResource(TechArmorItem animatable) {
        return new Identifier(VanillaExpansion.MOD_ID, "animations/tech_armor.animation.json");
    }


}
