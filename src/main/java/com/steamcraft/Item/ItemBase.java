package com.steamcraft.Item;


import com.steamcraft.SteamCraft;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IItemBase {


public ItemBase(Item.Properties props) {

    super(props.group(SteamCraft.ITEM_GROUP));

}

}
