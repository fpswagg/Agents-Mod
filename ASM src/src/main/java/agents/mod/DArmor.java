package agents.mod;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class DArmor extends ItemArmor
{

	public DArmor(ArmorMaterial material, int armor, int armorType) {
		super(material, armor, armorType);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
		if(armorType == 2)
			return "textures/models/armor/diamond_layer_2.png";
			
        return "textures/models/armor/diamond_layer_1.png";
    }
	
}
