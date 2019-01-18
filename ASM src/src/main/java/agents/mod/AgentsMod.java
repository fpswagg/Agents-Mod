package agents.mod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiKeyBindingList.CategoryEntry;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import java.io.File;

import org.lwjgl.input.Keyboard;

import agents.mod.bread.ItemBread_Choco;
import agents.mod.client.gui.GuiHandler;
import agents.mod.commands.A49Kits;
import agents.mod.commands.A7Kits;
import agents.mod.commands.Evil1;
import agents.mod.commands.Evilneg1;
import agents.mod.commands.UNDEFINED;
import agents.mod.enders.EnderAxe;
import agents.mod.enders.EnderBow;
import agents.mod.enders.EnderChestplate;
import agents.mod.enders.EnderFood;
import agents.mod.enders.EnderHoe;
import agents.mod.enders.EnderPickaxe;
import agents.mod.enders.EnderShield;
import agents.mod.enders.EnderSword;
import agents.mod.enders.Legend;
import agents.mod.entity.EntityAgents;
import agents.mod.masks.Mask;
import agents.mod.masks.Mask1;
import agents.mod.masks.Mask2;
import agents.mod.masks.Mask3;
import agents.mod.masks.Mask4;
import agents.mod.more.ItemBlood;
import agents.mod.more.ItemFood1;
import agents.mod.more.ItemFood2;
import agents.mod.more.ItemFood3;
import agents.mod.more.KeyInputHandler;
import agents.mod.more.Keybinds;
import agents.mod.more.potions.ItemPotion1;
import agents.mod.more.potions.ItemPotion2;
import agents.mod.more.potions.ItemPotion3;
import agents.mod.proxy.CommonProxy;
import agents.mod.screenOv.RenderGuiHandler;
import agents.mod.tiles.TileBricks;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class AgentsMod
{
	@Instance(Reference.MODID)
	public static AgentsMod modInstance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static float ArmorLayer_1 = 0.2F;
	public static float ArmorLeggingLayer_1 = ArmorLayer_1 / 2;
	
	public static boolean Scroll = true;
	public static boolean Version = true;
	
	public static boolean UND;
	public static boolean Frost = false;
	public static boolean Super_Frost = false;
	public static boolean Ultra_Frost = false;
	public static boolean Burn = false;
	public static boolean Burn_Steam = false;
	public static boolean UNDEFINED = false;
	public static boolean Evil1 = false;
	public static boolean Evil2 = false;
	public static boolean Evil3 = false;
	public static boolean Normal;
	
	public static String Evil()
	{
		if(evil > 3)
		{
			evil = 3;
			return "3";
		}
		
		if(evil < 0)
		{
			evil = 0;
			return "0";
		}
		
		return evil + "";
	}
	
	public static int evil = 0;
	public static int lvl = 1;
	public static int lvl() 
	{
		if(lvl < 1) 
		{
			lvl = 1;
			return 1;
		}
		
		if(lvl > 10 && lvl < 100)
		{
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Hello"));
			return lvl;
		}
		return lvl;
	}
	
	public static boolean scrolls = false;
	public static boolean scrollred = false;
	
	public static boolean BloodedHand = false;
	
	public static boolean skin1 = true;
	public static boolean skin2 = false;
	public static boolean eye1 = true;
	public static boolean eye2 = false;
	public static boolean eye3 = false;
	public static boolean mouth1 = true;
	public static boolean mouth2 = false;
	public static boolean hair1 = true;
	public static boolean hair2 = false;
	public static boolean hair3 = false;
	public static boolean Frost_Overlay = false;
	public static boolean Super_Frost_Overlay = false;
	public static boolean Ultra_Frost_Overlay = false;
	public static boolean Burn_Overlay = false;
	public static boolean Burn_Steam_Overlay = false;
	public static boolean UNDEFINED_Overlay = false;
	public static boolean UNDEFINED_Overlay2 = false;
	public static boolean Undif() 
	{
		if(UNDEFINED != true) 
		{
			UNDEFINED_Overlay = false;
			return false;
		}
		
		if(UNDEFINED_Overlay == true)
		{
			return true;
		}
		
		return UNDEFINED_Overlay;
	}
	public static boolean Evil1_Overlay = false;
	public static boolean Evil2_Overlay = false;
	public static boolean Evil3_Overlay = false;
	
	public static int scroll0 = 1;
	
	public static int scroll() 
	{
		if(scroll0 > 9) 
		{
			scroll0 = 1;
			
			return 1;
		}
		
		if(scroll0 < 1)
		{
			scroll0 = 9;
			
			return 9;
		}
		
		return scroll0;
		
	}
	public static int scrollback()
	{
		if(scroll() == 1)
			return 9;
		return scroll() - 1;
	}
	public static int scrollfront()
	{
		if(scroll() == 9)
			return 1;
		return scroll() + 1;
	}
	public static int Burns = 0;
	public static int i;
	
	public static Item esword;
	public static Item enderaxe;
	public static Item ehoe;
	public static Item epickaxe;
	public static Item ebread;
	public static Item eshield;
	public static Item ebow;
	public static Item echest;
	public static Item gui1;
	public static Item diamond_helmet0;
	public static Item diamond_chestplate0;
	public static Item diamond_leggings0;
	public static Item diamond_boots0;
	public static Item red;
	public static Item red0;
	public static Item red1;
	public static Item burning_gold_sword;
	public static Item frost;
	public static Item sword;
	public static Item diamond0;
	public static Item frost_dust;
	public static Item magma_ingot;
	public static Item mask0;
	public static Item mask1;
	public static Item mask2;
	public static Item mask3;
	public static Item mask4;
	public static Item maskn;
	public static Item choco;
	public static Item dress1;
	public static Item dress2;
	public static Item dress3;
	public static Item dress4;
	public static Item c_uniform;
	public static Item bucket_magma;
	public static Item hoody;
	public static Item Char;
	public static Item legend;
	public static Item drumStick;
	public static Item drumStick0;
	public static Item bread0;
	public static Item bread01;
	public static Item bread02;
	public static Item bread1;
	public static Item p1;
	public static Item p2;
	public static Item p3;
	public static Item chicken0;
	public static Item blood;
	public static Block light;
	public static Block frosts;
	public static Block diamond0_ore;
	public static Block diamond_block0;
	public static Block brick0;
	
	
	public static final Item.ToolMaterial frostToolMaterial = EnumHelper.addToolMaterial("frostToolMaterial", 5, 10000, 100.0F, 6.0F, 1);
	public static final Item.ToolMaterial esrevniToolMaterial = EnumHelper.addToolMaterial("esrevniToolMaterial", 5, 10000, 100.0F, 4.5F, 1);
	public static final Item.ToolMaterial fireToolMaterial = EnumHelper.addToolMaterial("fireToolMaterial", 5, 10000, 100.0F, 10.5F, 1);
	public static final Item.ToolMaterial Undefined = EnumHelper.addToolMaterial("Undefined", 5, 10000000, 100.0F, 146.0F, 1);
	public static final Item.ToolMaterial EnderMaterial = EnumHelper.addToolMaterial("EnderMaterial", 5, 10000000, 50.0F, 10.5F, 1);
	public static final Item.ToolMaterial Ender2Material = EnumHelper.addToolMaterial("Ender2Material", 5, 10000000, 50.0F, 10.5F, 1);
	public static final ItemArmor.ArmorMaterial mask = EnumHelper.addArmorMaterial("mask", 2,new int[] {0,0,0,0}, 1);
	public static final ItemArmor.ArmorMaterial masks = EnumHelper.addArmorMaterial("masks", 2,new int[] {0,0,0,0}, 1);
	public static final ItemArmor.ArmorMaterial maske = EnumHelper.addArmorMaterial("maske", 2,new int[] {0,0,0,0}, 1);
	public static final ItemArmor.ArmorMaterial maski = EnumHelper.addArmorMaterial("maski", 2,new int[] {0,0,0,0}, 1);
	public static final ItemArmor.ArmorMaterial masko = EnumHelper.addArmorMaterial("masko", 2,new int[] {0,0,0,0}, 1);
	public static final ItemArmor.ArmorMaterial esrevniArmorMaterial = EnumHelper.addArmorMaterial("esrevniArmorMaterial", 2,new int[] {20,50,50,20}, 1);
	public static final ItemArmor.ArmorMaterial EnderArmorMaterial = EnumHelper.addArmorMaterial("EnderArmorMaterial", 2,new int[] {20,50,50,20}, 1);
	public static final ItemArmor.ArmorMaterial Hoody7 = EnumHelper.addArmorMaterial("Hoody7", 0, new int[] {0,0,0,0}, 0);
	public static final ItemArmor.ArmorMaterial cuniform = EnumHelper.addArmorMaterial("cuniform", 0, new int[] {0,0,0,0}, 0);
	public static final ItemArmor.ArmorMaterial emm = EnumHelper.addArmorMaterial("cuniform", 0, new int[] {0,0,0,0}, 0);
	
	
	public void initConfiguration(FMLInitializationEvent event) 
	{
		Configuration config = new Configuration(new File("config/AgentsMod.cfg"));
		config.load();
		
		UND = config.get("Secret", "Undefined", false).getBoolean();
		Normal = config.getBoolean("Incomplete Skin System", "General", false, "Not Complete And May Cause Bugs!!", "");
		
		config.save();
	}
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	esword = new EnderSword(Ender2Material).setUnlocalizedName("esword").setTextureName("asm:esword").setFull3D().setMaxStackSize(1).setCreativeTab(null);
    	enderaxe = new EnderAxe(Ender2Material).setUnlocalizedName("eaxe").setMaxStackSize(1).setFull3D().setCreativeTab(null);
    	ehoe = new EnderHoe(Ender2Material).setUnlocalizedName("ehoe").setTextureName("asm:ehoe").setMaxStackSize(1).setFull3D().setCreativeTab(null);
    	epickaxe = new EnderPickaxe(Ender2Material).setUnlocalizedName("epickaxe").setTextureName("asm:epickaxe").setMaxStackSize(1).setFull3D().setCreativeTab(null);
    	ebread = new EnderFood(5, 5.0F, false).setUnlocalizedName("ebread").setTextureName("asm:ebread").setCreativeTab(null);
    	eshield = new EnderShield().setUnlocalizedName("eshield").setTextureName("asm:eshield").setMaxStackSize(1).setFull3D().setCreativeTab(null);
    	ebow = new EnderBow().setUnlocalizedName("ebow").setMaxStackSize(1).setFull3D().setCreativeTab(null);
    	echest = new EnderChestplate(EnderArmorMaterial, 0, 1).setUnlocalizedName("echest").setMaxStackSize(1).setFull3D().setCreativeTab(null);
    	red = new Red(frostToolMaterial).setUnlocalizedName("Red").setFull3D().setTextureName("asm:Red").setCreativeTab(Weapons).setMaxStackSize(1).setNoRepair();
    	red0 = new Red(esrevniToolMaterial).setUnlocalizedName("Red0").setFull3D().setTextureName("asm:red0").setCreativeTab(Weapons).setMaxStackSize(1).setNoRepair();
    	red1 = new UndefinedSword(Undefined).setUnlocalizedName("Red1").setFull3D().setTextureName("asm:red1").setCreativeTab(Weapons).setMaxStackSize(1).setNoRepair();
    	diamond0 = new Frost().setUnlocalizedName("diamond0").setTextureName("diamond").setCreativeTab(Minerals);
    	sword = new Sword(ToolMaterial.IRON).setUnlocalizedName("Sword").setFull3D().setTextureName("asm:sword").setCreativeTab(Weapons).setMaxStackSize(1);
    	burning_gold_sword = new burning_gold_sword(fireToolMaterial).setUnlocalizedName("burning_gold_sword").setFull3D().setTextureName("asm:burning_gold_sword").setCreativeTab(Weapons).setMaxStackSize(1).setNoRepair();
    	frost = new Frost().setUnlocalizedName("Frost").setTextureName("asm:frost").setCreativeTab(Minerals);
    	frost_dust = new Frost().setUnlocalizedName("frost_dust").setTextureName("asm:frost_dust").setCreativeTab(Minerals);
    	magma_ingot = new Magma().setUnlocalizedName("magma_ingot").setTextureName("asm:magma_ingot").setCreativeTab(Minerals);
    	mask0 = new Mask(mask, 0, 0).setUnlocalizedName("mask0").setTextureName("asm:mask").setFull3D().setCreativeTab(Accessories);
    	mask1 = new Mask1(masks, 0, 0).setUnlocalizedName("mask1").setTextureName("asm:mask").setFull3D().setCreativeTab(Accessories);
    	mask2 = new Mask2(maske, 0, 0).setUnlocalizedName("mask2").setTextureName("asm:mask").setFull3D().setCreativeTab(Accessories);
    	mask3 = new Mask3(maski, 0, 0).setUnlocalizedName("mask3").setTextureName("asm:mask").setFull3D().setCreativeTab(Accessories);
    	mask4 = new Mask4(masko, 0, 0).setUnlocalizedName("mask4").setTextureName("asm:mask").setFull3D().setCreativeTab(Accessories);
    	dress1 = new Dress1(emm, 0, 0).setUnlocalizedName("dr1").setTextureName("asm:face").setFull3D().setCreativeTab(Dresses);
    	dress2 = new Dress1(emm, 0, 1).setUnlocalizedName("dr2").setTextureName("asm:dress").setFull3D().setCreativeTab(Dresses);
    	dress3 = new Dress1(emm, 0, 2).setUnlocalizedName("dr3").setTextureName("asm:dress1").setFull3D().setCreativeTab(Dresses);
    	dress4 = new Dress1(emm, 0, 3).setUnlocalizedName("dr4").setTextureName("asm:dress2").setFull3D().setCreativeTab(Dresses);
    	c_uniform = new CUniform(cuniform, 0, 0).setUnlocalizedName("c_uniform").setTextureName("asm:face").setFull3D().setCreativeTab(Dresses);
    	hoody = new Hoody7(Hoody7, 0, 1).setUnlocalizedName("hoody").setTextureName("asm:dress").setFull3D().setCreativeTab(Dresses);
    	choco = new ItemFood(1, 1.0F, false).setUnlocalizedName("choco").setTextureName("asm:chocolate").setFull3D().setCreativeTab(Foods);
    	drumStick = new DrumStick(1, 1.0F, true).setUnlocalizedName("drumStick").setTextureName("asm:drumstick").setCreativeTab(Foods);
    	drumStick0 = new DrumStick0(1, 0.0F, true).setUnlocalizedName("drumStick0").setTextureName("asm:drumstick0").setCreativeTab(null);
    	diamond_helmet0 = new DArmor(esrevniArmorMaterial, 0, 0).setUnlocalizedName("diamond_helmet0").setTextureName("diamond_helmet").setCreativeTab(Armors);
    	diamond_chestplate0 = new DArmor(esrevniArmorMaterial, 0, 1).setUnlocalizedName("diamond_chestplate0").setTextureName("diamond_chestplate").setCreativeTab(Armors);
    	diamond_leggings0 = new DArmor(esrevniArmorMaterial, 0, 2).setUnlocalizedName("diamond_leggings0").setTextureName("diamond_leggings").setCreativeTab(Armors);
    	diamond_boots0 = new DArmor(esrevniArmorMaterial, 0, 3).setUnlocalizedName("diamond_boots0").setTextureName("diamond_boots").setCreativeTab(Armors);
    	gui1 = new gui0().setUnlocalizedName("gui1").setTextureName("wood_pickaxe").setFull3D().setCreativeTab(Tools);
    	Char = new gui01().setUnlocalizedName("gui2").setTextureName("wood_axe").setFull3D().setCreativeTab(Tools);
    	legend = new Legend(EnderArmorMaterial, 0, 1).setUnlocalizedName("e1").setTextureName("asm:legend").setFull3D().setMaxStackSize(1).setCreativeTab(Minerals);
    	bucket_magma = new BucketMagma().setUnlocalizedName("magmab").setTextureName("bucket_lava").setCreativeTab(Minerals);
    	bread0 = new ItemFood1(5, 0.6F, false).setUnlocalizedName("bread0").setTextureName("bread").setCreativeTab(null).setMaxStackSize(1);
    	bread01 = new ItemFood2(5, 0.6F, false).setUnlocalizedName("bread01").setTextureName("bread").setCreativeTab(null).setMaxStackSize(1);
    	bread02 = new ItemFood3(5, 0.6F, false).setUnlocalizedName("bread02").setTextureName("bread").setCreativeTab(null).setMaxStackSize(1);
    	bread1 = new ItemBread_Choco(6, 1.6F, false).setUnlocalizedName("bread1").setTextureName("bread").setCreativeTab(null);
    	p1 = new ItemPotion1(0 ,0 ,false).setUnlocalizedName("p1").setTextureName("asm:potions/p1").setMaxStackSize(1).setCreativeTab(Tools);
    	p2 = new ItemPotion2(0 ,0 ,false).setUnlocalizedName("p2").setTextureName("asm:potions/p2").setMaxStackSize(1).setCreativeTab(Tools);
    	p3 = new ItemPotion3(0 ,0 ,false).setUnlocalizedName("p3").setTextureName("asm:potions/p3").setMaxStackSize(1).setCreativeTab(Tools);
    	chicken0 = new ItemFood(1, 1.0F, true).setUnlocalizedName("chicken0").setTextureName("asm:basic_chicken").setCreativeTab(Foods);
    	blood = new ItemBlood().setUnlocalizedName("blood").setTextureName("asm:blood").setCreativeTab(Accessories);
    	
    	light = new Light(Material.air).setBlockName("Light");    	
    	frosts = new Frosts(Material.packedIce).setBlockName("Frost_Block").setBlockTextureName("asm:frosts").setCreativeTab(Blocks).setResistance(20.0F).setHardness(1.0F);
    	diamond0_ore = new Frosts(Material.rock).setBlockName("Diamond_Ore0").setBlockTextureName("diamond_ore").setCreativeTab(Blocks).setResistance(20.0F).setHardness(3.0F);
    	diamond_block0 = new Frosts(Material.iron).setBlockName("Diamond_Block0").setBlockTextureName("asm:diamond_block0").setCreativeTab(Blocks).setResistance(2000.0F).setHardness(1.0F);
    	brick0 = new TileBricks(Material.rock).setBlockName("smith_castle_brick").setBlockTextureName("asm:smith_castle_brick").setCreativeTab(Blocks).setResistance(2000.0F).setHardness(3.0F);
    	
    	GameRegistry.registerItem(bread0, bread0.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(bread01, bread01.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(bread02, bread02.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(bread1, bread1.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(esword, esword.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(enderaxe, enderaxe.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(ehoe, ehoe.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(epickaxe, epickaxe.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(ebread, ebread.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(eshield, eshield.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(ebow, ebow.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(echest, echest.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(legend, legend.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(Char, Char.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(gui1, gui1.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(red, red.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(red0, red0.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(red1, red1.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(diamond0, diamond0.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(diamond_helmet0, diamond_helmet0.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(diamond_chestplate0, diamond_chestplate0.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(diamond_leggings0, diamond_leggings0.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(diamond_boots0, diamond_boots0.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(sword, sword.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(c_uniform, c_uniform.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(hoody, hoody.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(burning_gold_sword, burning_gold_sword.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(frost, frost.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(frost_dust, frost_dust.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(diamond0_ore, diamond0_ore.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(magma_ingot, magma_ingot.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(bucket_magma, bucket_magma.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(dress1, dress1.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(dress2, dress2.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(dress3, dress3.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(dress4, dress4.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(drumStick, drumStick.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(drumStick0, drumStick0.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(mask0, mask0.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(mask1, mask1.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(mask2, mask2.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(mask3, mask3.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(mask4, mask4.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(choco, choco.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(p1, p1.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(p2, p2.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(p3, p3.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(chicken0, chicken0.getUnlocalizedName().substring(5));
    	GameRegistry.registerItem(blood, blood.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(light, light.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(frosts, frosts.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(diamond_block0, diamond_block0.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(brick0, brick0.getUnlocalizedName().substring(5));
    	
    	GameRegistry.registerWorldGenerator(new Generations(), 0);
    	
    	GameRegistry.getFuelValue(new ItemStack(magma_ingot));
    	
    	GameRegistry.addRecipe(new ItemStack(frosts), new Object[] { "WW", "WW", 'W', frost});
    	GameRegistry.addRecipe(new ItemStack(diamond_block0), new Object[] { "WW", "WW", 'W', diamond0});
    	GameRegistry.addRecipe(new ItemStack(diamond0, 4), new Object[] { "W", 'W', diamond_block0});
    	GameRegistry.addRecipe(new ItemStack(frost), new Object[] { "WW", "WW", 'W', frost_dust});
    	GameRegistry.addRecipe(new ItemStack(red0), new Object[] { "X", "X", "T", 'X', diamond0, 'T', Items.stick});
    	GameRegistry.addRecipe(new ItemStack(red), new Object[] { "W", "A", 'W', red0, 'A', frost});
    	GameRegistry.addRecipe(new ItemStack(red), new Object[] { "A", "W", 'W', red0, 'A', frost});
    	GameRegistry.addRecipe(new ItemStack(red), new Object[] { "WA", 'W', red0, 'A', frost});
    	GameRegistry.addRecipe(new ItemStack(frost, 4), new Object[] { "A", 'A', frosts});
    	GameRegistry.addRecipe(new ItemStack(frost_dust, 4), new Object[] { "A", 'A', frost});
    	GameRegistry.addRecipe(new ItemStack(burning_gold_sword), new Object[] { "AB", 'A', Items.golden_sword, 'B', magma_ingot});
    	GameRegistry.addRecipe(new ItemStack(burning_gold_sword), new Object[] { "A", "B", 'A', Items.golden_sword, 'B', magma_ingot});
    	GameRegistry.addRecipe(new ItemStack(burning_gold_sword), new Object[] { "B", "A", 'A', Items.golden_sword, 'B', magma_ingot});
    	GameRegistry.addRecipe(new ItemStack(diamond_helmet0), new Object[] { "XXX", "X X", 'X', diamond0});
    	GameRegistry.addRecipe(new ItemStack(diamond_chestplate0), new Object[] { "X X", "XXX", "XXX" , 'X', diamond0});
    	GameRegistry.addRecipe(new ItemStack(diamond_leggings0), new Object[] { "XXX", "X X", "X X" , 'X', diamond0});
    	GameRegistry.addRecipe(new ItemStack(diamond_boots0), new Object[] { "X X", "X X", 'X', diamond0});
    	GameRegistry.addRecipe(new ItemStack(diamond0), new Object[] { "XXX", "X X", "XXX", 'X', Items.diamond});
    	GameRegistry.addRecipe(new ItemStack(bucket_magma), new Object[] {"A", "C", 'A', magma_ingot, 'C', Items.bucket});
    	GameRegistry.addRecipe(new ItemStack(magma_ingot), new Object[] {"A", 'A', bucket_magma});
    	GameRegistry.addRecipe(new ItemStack(legend), new Object[] {"AA", 'A', legend});
    	GameRegistry.addRecipe(new ItemStack(drumStick, 2), new Object[] {"A", 'A', Items.cooked_chicken});
    	GameRegistry.addRecipe(new ItemStack(bread0), new Object[] {"AB", 'A', Items.bread, 'B', Items.iron_sword});
    	GameRegistry.addRecipe(new ItemStack(bread01), new Object[] {"AB", 'A', Items.bread, 'B', Items.golden_sword});
    	GameRegistry.addRecipe(new ItemStack(bread02), new Object[] {"AB", 'A', Items.bread, 'B', Items.diamond_sword});
    	GameRegistry.addRecipe(new ItemStack(bread0), new Object[] {"AB", 'B', Items.bread, 'A', Items.iron_sword});
    	GameRegistry.addRecipe(new ItemStack(bread01), new Object[] {"AB", 'B', Items.bread, 'A', Items.golden_sword});
    	GameRegistry.addRecipe(new ItemStack(bread02), new Object[] {"AB", 'B', Items.bread, 'A', Items.diamond_sword});
    	GameRegistry.addRecipe(new ItemStack(bread1), new Object[] {"AB", 'A', bread0, 'B', choco});
    	GameRegistry.addRecipe(new ItemStack(bread1), new Object[] {"A", "B", 'A', bread0, 'B', choco});
    	GameRegistry.addRecipe(new ItemStack(bread1), new Object[] {"BA", 'A', bread0, 'B', choco});
    	GameRegistry.addRecipe(new ItemStack(bread1), new Object[] {"B", "A", 'A', bread0, 'B', choco});
    	GameRegistry.addRecipe(new ItemStack(bread1), new Object[] {"AB", 'A', bread01, 'B', choco});
    	GameRegistry.addRecipe(new ItemStack(bread1), new Object[] {"A", "B", 'A', bread01, 'B', choco});
    	GameRegistry.addRecipe(new ItemStack(bread1), new Object[] {"BA", 'A', bread01, 'B', choco});
    	GameRegistry.addRecipe(new ItemStack(bread1), new Object[] {"B", "A", 'A', bread01, 'B', choco});
    	GameRegistry.addRecipe(new ItemStack(bread1), new Object[] {"AB", 'A', bread02, 'B', choco});
    	GameRegistry.addRecipe(new ItemStack(bread1), new Object[] {"A", "B", 'A', bread02, 'B', choco});
    	GameRegistry.addRecipe(new ItemStack(bread1), new Object[] {"BA", 'A', bread02, 'B', choco});
    	GameRegistry.addRecipe(new ItemStack(bread1), new Object[] {"B", "A", 'A', bread02, 'B', choco});
    	
    	GameRegistry.addSmelting(Items.lava_bucket, new ItemStack(bucket_magma), 1.0F);
    	GameRegistry.addSmelting(frosts, new ItemStack(Items.water_bucket), 1.0F);
    	GameRegistry.addSmelting(Items.golden_sword, new ItemStack(burning_gold_sword), 1.0F);
    	GameRegistry.addSmelting(diamond0_ore, new ItemStack(diamond0, 2), 1.0F);
    	
    	EntityAgents.mainRegistry();
    	
    	proxy.registerRenderers();
    	proxy.registerEntities();
    	
    	Keybinds.register();
    	FMLCommonHandler.instance().bus().register(new KeyInputHandler());
    	FMLCommonHandler.instance().bus().register(new CommonHandler());
    	
    	MinecraftForge.EVENT_BUS.register(this);
    	
    	}
    
    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
    	this.initConfiguration(event);
    	NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(new RenderGuiHandler());
    }
    
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event)
    {
    	event.registerServerCommand(new A7Kits());
    	event.registerServerCommand(new A49Kits());
    	event.registerServerCommand(new Evil1());
    	event.registerServerCommand(new Evilneg1());
    	event.registerServerCommand(new UNDEFINED());
    }
    
    @SubscribeEvent
    public void playerData(LivingEvent.LivingUpdateEvent event)
    {
    	if (event.entityLiving instanceof EntityPlayer) {
    		EntityPlayer player = (EntityPlayer) event.entityLiving;
    		if (!player.getEntityData().hasKey("Test") || !player.getEntityData().getBoolean("Test"))
    			player.getEntityData().setBoolean("Test", true);
    	}
    }
    
    
    public static CreativeTabs Weapons = new CreativeTabs("Weapons") 
    {
    	@Override
    	public Item getTabIconItem() 
    	{
    		return red1;
    	}
    }.setNoTitle();
    
    public static CreativeTabs Minerals = new CreativeTabs("Minerals") 
    {
    	@Override
    	public Item getTabIconItem() 
    	{
    		return frost_dust;
    	}	
    }.setNoTitle();
    
    public static CreativeTabs Blocks = new CreativeTabs("Blocks") 
    {
    	@Override
    	public Item getTabIconItem() 
    	{
    		return Item.getItemFromBlock(brick0);
    	}
    }.setNoTitle();
    
    public static CreativeTabs Armors = new CreativeTabs("Armors") 
    {
    	@Override
    	public Item getTabIconItem() 
    	{
    		return diamond_helmet0;
    	}
    }.setNoTitle();
    
    public static CreativeTabs Foods = new CreativeTabs("Foods") 
    {
    	@Override
    	public Item getTabIconItem() 
    	{
    		return chicken0;
    	}
    }.setNoTitle();
    
    public static CreativeTabs Tools = new CreativeTabs("Tools") 
    {
    	@Override
    	public Item getTabIconItem() 
    	{
    		return gui1;
    	}
    }.setNoTitle();

    public static CreativeTabs Accessories = new CreativeTabs("Accessories") 
    {
    	@Override
    	public Item getTabIconItem() 
    	{
    		return mask1;
    	}
    	
    }.setNoTitle();
    

    public static CreativeTabs Dresses = new CreativeTabs("Dresses") 
    {
    	@Override
    	public Item getTabIconItem() 
    	{
    		return dress2;
    	}
    	
    }.setNoTitle();
    
}
