package com.SteamCraft.Item;


import com.SteamCraft.SteamCraft;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IItemBase {


public ItemBase() {

    super(new Item.Properties().group(SteamCraft.ITEM_GROUP));

}

}
