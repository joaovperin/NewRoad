/*
 * NewRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.test.prototype;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

/**
 * Descrição da classe.
 */
public class Item {

    public final int maxPrefixes = 84;
    public static int potionDelay = 3600;
    public boolean questItem;
    public static int[] headType = new int[169];
    public static int[] bodyType = new int[175];
    public static int[] legType = new int[110];
    public boolean flame;
    public boolean mech;
    public boolean wet;
    public boolean honeyWet;
    public byte wetCount;
    public boolean lavaWet;
    public Vector2f position;
    public Vector2f velocity;
    public int width;
    public int height;
    public boolean active;
    public int noGrabDelay;
    public boolean beingGrabbed;
    public int spawnTime;
    public int tileWand = -1;
    public boolean wornArmor;
    public byte dye;
    public int fishingPole = 1;
    public int bait;
    public static int manaGrabRange = 300;
    public static int lifeGrabRange = 250;
    public short makeNPC;
    public short hairDye = -1;
    public byte paint;
    public int ownIgnore = -1;
    public int ownTime;
    public int keepTime;
    public int type;
    public String name;
    public int holdStyle;
    public int useStyle;
    public boolean channel;
    public boolean accessory;
    public int useAnimation;
    public int useTime;
    public int stack;
    public int maxStack;
    public int pick;
    public int axe;
    public int hammer;
    public int tileBoost;
    public int createTile = -1;
    public int createWall = -1;
    public int placeStyle;
    public int damage;
    public float knockBack;
    public int healLife;
    public int healMana;
    public boolean potion;
    public boolean consumable;
    public boolean autoReuse;
    public boolean useTurn;
    public Color color;
    public int alpha;
    public float scale = 1f;
    public int useSound;
    public int defense;
    public int headSlot = -1;
    public int bodySlot = -1;
    public int legSlot = -1;
//		public sbyte handOnSlot = -1;
//		public sbyte handOffSlot = -1;
//		public sbyte backSlot = -1;
//		public sbyte frontSlot = -1;
//		public sbyte shoeSlot = -1;
//		public sbyte waistSlot = -1;
//		public sbyte wingSlot = -1;
//		public sbyte shieldSlot = -1;
//		public sbyte neckSlot = -1;
//		public sbyte faceSlot = -1;
//		public sbyte balloonSlot = -1;
    public String toolTip;
    public String toolTip2;
    public int owner = 255;
    public int rare;
    public int shoot;
    public float shootSpeed;
    public int ammo;
    public boolean notAmmo;
    public int useAmmo;
    public int lifeRegen;
    public int manaIncrease;
    public boolean buyOnce;
    public int mana;
    public boolean noUseGraphic;
    public boolean noMelee;
    public int release;
    public int value;
    public boolean buy;
    public boolean social;
    public boolean vanity;
    public boolean material;
    public boolean noWet;
    public int buffType;
    public int buffTime;
    public int mountType = -1;
    public boolean cartTrack;
    public boolean uniqueStack;
    public int netID;
    public int crit;
    public byte prefix;
    public boolean melee;
    public boolean magic;
    public boolean ranged;
    public boolean summon;
    public int reuseDelay;

    @Override
    public String toString() {
        return String.format("{{Name: \"{0}\" NetID: {1} Stack: {2}", this.name, this.netID, this.stack);
    }

    public void SetDefaults(String ItemName) {
        this.name = "";
        boolean flag = false;
        if ("Gold Pickaxe".equals(ItemName)) {
//				this.SetDefaults(1, false);
            this.color = new Color(210, 190, 0, 100);
            this.useTime = 17;
            this.pick = 55;
            this.useAnimation = 20;
            this.scale = 1.05f;
            this.damage = 6;
            this.value = 10000;
            this.toolTip = "Can mine Meteorite";
            this.netID = -1;
        } else {
        }
    }

    public Rectangle getRect() {
        return new Rectangle(this.position.x, this.position.y, this.width, this.height);
    }

    public void SetDefaults1(int type)
		{
			if (type == 1)
			{
				this.name = "Iron Pickaxe";
				this.color = new Color(160, 145, 130, 110);
				this.useStyle = 1;
				this.useTurn = true;
				this.useAnimation = 20;
				this.useTime = 13;
				this.autoReuse = true;
				this.width = 24;
				this.height = 28;
				this.damage = 5;
				this.pick = 40;
				this.useSound = 1;
				this.knockBack = 2f;
				this.value = 2000;
				this.melee = true;
			}
			else
			{
				if (type == 2)
				{
					this.name = "Dirt Block";
					this.useStyle = 1;
					this.useTurn = true;
					this.useAnimation = 15;
					this.useTime = 10;
					this.autoReuse = true;
					this.maxStack = 999;
					this.consumable = true;
					this.createTile = 0;
					this.width = 12;
					this.height = 12;
				}
                        }
                }

    public void SetDefaults(int Type, boolean noMatCheck)
		{
//			if (Main.netMode == 1 || Main.netMode == 2)
//			{
//				this.owner = 255;
//			}
//			else
			{
//				this.owner = Main.myPlayer;
			}
			this.questItem = false;
			this.fishingPole = 0;
			this.bait = 0;
			this.hairDye = -1;
			this.makeNPC = 0;
			this.dye = 0;
			this.paint = 0;
			this.tileWand = -1;
			this.notAmmo = false;
			this.netID = 0;
			this.prefix = 0;
			this.crit = 0;
			this.mech = false;
			this.flame = false;
			this.reuseDelay = 0;
			this.melee = false;
			this.magic = false;
			this.ranged = false;
			this.summon = false;
			this.placeStyle = 0;
			this.buffTime = 0;
			this.buffType = 0;
			this.mountType = -1;
			this.cartTrack = false;
			this.material = false;
			this.noWet = false;
			this.vanity = false;
			this.mana = 0;
			this.wet = false;
			this.wetCount = 0;
			this.lavaWet = false;
			this.channel = false;
			this.manaIncrease = 0;
			this.release = 0;
			this.noMelee = false;
			this.noUseGraphic = false;
			this.lifeRegen = 0;
			this.shootSpeed = 0f;
			this.active = true;
			this.alpha = 0;
			this.ammo = 0;
			this.useAmmo = 0;
			this.autoReuse = false;
			this.accessory = false;
			this.axe = 0;
			this.healMana = 0;
			this.bodySlot = -1;
			this.legSlot = -1;
			this.headSlot = -1;
			this.potion = false;
//			this.color = default(Color);
			this.consumable = false;
			this.createTile = -1;
			this.createWall = -1;
			this.damage = -1;
			this.defense = 0;
			this.hammer = 0;
			this.healLife = 0;
			this.holdStyle = 0;
			this.knockBack = 0f;
			this.maxStack = 1;
			this.pick = 0;
			this.rare = 0;
			this.scale = 1f;
			this.shoot = 0;
			this.stack = 1;
			this.toolTip = null;
			this.toolTip2 = null;
			this.tileBoost = 0;
			this.type = Type;
			this.useStyle = 0;
			this.useSound = 0;
			this.useTime = 100;
			this.useAnimation = 100;
			this.value = 0;
			this.useTurn = false;
			this.buy = false;
//			this.handOnSlot = -1;
//			this.handOffSlot = -1;
//			this.backSlot = -1;
//			this.frontSlot = -1;
//			this.shoeSlot = -1;
//			this.waistSlot = -1;
//			this.wingSlot = -1;
//			this.shieldSlot = -1;
//			this.neckSlot = -1;
//			this.faceSlot = -1;
//			this.balloonSlot = -1;
			this.uniqueStack = false;
			if (this.type >= 2749)
			{
				this.type = 0;
			}
			if (this.type == 0)
			{
				this.netID = 0;
				this.name = "";
				this.stack = 0;
			}
			else
			{
				if (this.type <= 1000)
				{
					this.SetDefaults1(this.type);
				}
				else
				{
					if (this.type <= 2001)
					{
//						this.SetDefaults2(this.type);
					}
					else
					{
//						this.SetDefaults3(this.type);
					}
				}
			}
			if (this.dye > 0)
			{
				this.maxStack = 99;
			}
			this.netID = this.type;
			if (!noMatCheck)
			{
//				this.checkMat();
			}
//			this.name = Lang.itemName(this.netID, false);
//			this.CheckTip();
		}

    public Color GetColor(Color newColor)
		{
			int num = (int)(this.color.r - (255 - newColor.r));
			int num2 = (int)(this.color.g - (255 - newColor.g));
			int num3 = (int)(this.color.b - (255 - newColor.b));
			int num4 = (int)(this.color.a - (255 - newColor.a));
			if (num < 0)
			{
				num = 0;
			}
			if (num > 255)
			{
				num = 255;
			}
			if (num2 < 0)
			{
				num2 = 0;
			}
			if (num2 > 255)
			{
				num2 = 255;
			}
			if (num3 < 0)
			{
				num3 = 0;
			}
			if (num3 > 255)
			{
				num3 = 255;
			}
			if (num4 < 0)
			{
				num4 = 0;
			}
			if (num4 > 255)
			{
				num4 = 255;
			}
			return new Color(num, num2, num3, num4);
		}

}
