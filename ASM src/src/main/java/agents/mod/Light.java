package agents.mod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Light extends Block
{

	public Light(Material material) {
		super(material);
		this.setLightOpacity(5);
	}
	
	public boolean isOpaqueCube()
    {
        return false;
    }
	
}
