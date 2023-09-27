package cdvj.vanillaexpansion.item.client;

import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class TechArmorRenderer extends GeoArmorRenderer<TechArmorItem> {
    public TechArmorRenderer() {
        super(new TechArmorModel());
    }
}
